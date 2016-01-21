package com.geopista.ui.plugin.mobile;

import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.geopista.app.AppContext;
import com.geopista.server.administradorCartografia.AdministradorCartografiaClient;
import com.geopista.ui.dialogs.beans.ExtractionProject;
import com.geopista.ui.dialogs.mobile.MobileModifyPanel01;
import com.geopista.ui.dialogs.mobile.MobilePluginI18NResource;
import com.geopista.ui.images.IconLoader;
import com.geopista.ui.plugin.GeopistaAbstractSaveMapPlugIn;
import com.geopista.ui.plugin.mobile.util.MobileUtils;
import com.geopista.ui.wizard.WizardDialog;
import com.geopista.ui.wizard.WizardPanel;
import com.geopista.util.GeopistaUtil;
import com.geostaf.ui.plugin.generate.GraticuleCreatorEngine;
import com.vividsolutions.jump.I18N;
import com.vividsolutions.jump.task.TaskMonitor;
import com.vividsolutions.jump.util.Blackboard;
import com.vividsolutions.jump.workbench.WorkbenchContext;
import com.vividsolutions.jump.workbench.model.Layer;
import com.vividsolutions.jump.workbench.model.LayerManager;
import com.vividsolutions.jump.workbench.plugin.EnableCheckFactory;
import com.vividsolutions.jump.workbench.plugin.MultiEnableCheck;
import com.vividsolutions.jump.workbench.plugin.PlugInContext;
import com.vividsolutions.jump.workbench.ui.plugin.FeatureInstaller;
import com.geopista.ui.dialogs.global.Constants;
import com.geopista.editor.WorkbenchGuiComponent;

public class MobileModifyPlugin extends GeopistaAbstractSaveMapPlugIn{
	
    private static final Log logger = LogFactory.getLog(MobileModifyPlugin.class);
    private Blackboard blackboard = Constants.APLICACION.getBlackboard();
    public static final String PluginMobileExtracti18n = "PluginMobileExtracti18n";
	
	/**
	 * Inicializaci�n del plugin para cargarlo desde el fichero workbench.properties
	 */
	public void initialize(PlugInContext context) throws Exception {
		//para internacionalizaci�n
	    Locale currentLocale = I18N.getLocaleAsObject();        
	    ResourceBundle bundle = ResourceBundle.getBundle("com.geopista.ui.plugin.mobile.language.PluginMobileExtracti18n",currentLocale);      
	    I18N.plugInsResourceBundle.put(PluginMobileExtracti18n,bundle);
		
	    FeatureInstaller featureInstaller = new FeatureInstaller(context.getWorkbenchContext());
	      
	    EnableCheckFactory checkFactory = context.getCheckFactory();
        featureInstaller.addMainMenuItem(this,
                new String[] { "Tools", MobilePluginI18NResource.GEOPISTAConfiguration_proyectMovil }, I18N.get(PluginMobileExtracti18n,MobilePluginI18NResource.MobileModifyPlugin_text),
                false, null,
                new MultiEnableCheck().add(
                    checkFactory.createWindowWithLayerNamePanelMustBeActiveCheck())
                    .add(checkFactory.createAdminUserCheck())
                   );
        
    	((WorkbenchGuiComponent) context.getWorkbenchContext().getIWorkbench().getGuiComponent()).getToolBar("Movilidad").addPlugIn(this.getIcon(),
				this,
				createEnableCheck(context.getWorkbenchContext()),
				context.getWorkbenchContext());		
	}
	
    public String getName()
    {
        return I18N.get(PluginMobileExtracti18n,MobilePluginI18NResource.MobileModifyPlugin_text);
    }
    
	public ImageIcon getIcon() {
		return IconLoader.icon("/com/geopista/ui/images/movilidad_borrar.png");
	}
    
    public static MultiEnableCheck createEnableCheck(
			WorkbenchContext workbenchContext) {
		EnableCheckFactory checkFactory = new EnableCheckFactory(
				workbenchContext);
		return new MultiEnableCheck()
				.add(checkFactory.createWindowWithLayerNamePanelMustBeActiveCheck());
	}
    public boolean execute(PlugInContext context) throws Exception
    {
        reportNothingToUndoYet(context);
        
        //limpiamos lo que haya podido quedar de ejecuciones anteriores
        emptyBlackboard();

        WizardDialog d = new WizardDialog(GeopistaUtil.getFrame(context
                .getWorkbenchGuiComponent()), Constants.APLICACION.getI18nString("ExtractDialogGestionar"),
                context.getErrorHandler());
        d.init(new WizardPanel[] {
        		new MobileModifyPanel01("MobileModifyPanel01", null, context),
        		});

        d.setSize(520, 650);
        d.setLocation(10, 20);
        d.setVisible(true);        
        
        if (!d.wasFinishPressed())
        {
        	LayerManager layerManager = context.getLayerManager();
        	if (layerManager!=null){
	            Layer graticuleLayer = layerManager.getLayer(GraticuleCreatorEngine.getGraticuleName());
	            //si existe una cuadr�cula la borramos
	            if(graticuleLayer!=null){
	            	layerManager.remove(graticuleLayer);
	            }
	            
        	}
            return false;
        }

        return true;

    }
    
    /**
     * Borra lo que haya utilizado del blackboard en sus anteriores ejecuciones
     */
    private void emptyBlackboard() {
		blackboard.remove(MobileModifyPanel01.SELECTED_EXTRACT_PROJECT);
	}
    
    /*
     * Se ejecuta una vez finalizado el interfaz despues de pasar por todas las pantallas.
     * (non-Javadoc)
     * @see com.vividsolutions.jump.workbench.plugin.ThreadedPlugIn#run(com.vividsolutions.jump.task.TaskMonitor, com.vividsolutions.jump.workbench.plugin.PlugInContext)
     */
    public void run(TaskMonitor monitor, PlugInContext context) throws Exception
    {
    	try {
	    	monitor.report(I18N.get(PluginMobileExtracti18n,MobilePluginI18NResource.MobileModifyPanel01_deletingProy));
	    	
	    	ExtractionProject eProject =  (ExtractionProject) blackboard.get(MobileModifyPanel01.SELECTED_EXTRACT_PROJECT);
	    		    	

	    	//guardamos la informacion en base de datos
	    	final String sUrlPrefix = Constants.APLICACION.getString("geopista.conexion.servidor");
	      	AdministradorCartografiaClient administradorCartografiaClient = new AdministradorCartografiaClient(
	                     sUrlPrefix + "AdministradorCartografiaServlet");
	      	administradorCartografiaClient.deleteExtractProject(eProject);  
	      	
	    	//Borramos los datos subidos al servidor.
	    	httpDeleteProject(Constants.URL_DELETE_TOMCAT, eProject);

	    	
	    	String dirBase = Constants.APLICACION.getUserPreference(AppContext.PREFERENCES_DATA_PATH_KEY, AppContext.DEFAULT_DATA_PATH, true);
	    	dirBase+=File.separator+"maps";
	    	
	    	String projectName=eProject.getNombreProyecto();	    	
	    	String idProyecto=eProject.getIdProyecto();

	        String dirMapName = projectName + "." + idProyecto;
	        File dirBaseMake = new File(dirBase, dirMapName);
	        if (dirBaseMake.exists()){
	        	MobileUtils.deleteDir(dirBaseMake);
	        	logger.info("Borrando fichero local:"+dirBaseMake);
	        }
	      		    
		}finally {
	      	//borramos la cuadr�cula
	    	LayerManager layerManager = context.getLayerManager();
	        Layer graticuleLayer = layerManager.getLayer(GraticuleCreatorEngine.getGraticuleName());
	        if(graticuleLayer!=null){
	        	layerManager.remove(graticuleLayer);
	        }
		}
    }
    
    private void httpDeleteProject(String url, ExtractionProject eProject) throws Exception {
    	PostMethod method=null;
		try {
			HttpClient client = new HttpClient();
			client.getParams().setParameter("http.connection.timeout",new Integer(8000));
			method = new PostMethod(url);
			method.addParameter("PROJECT_ID",eProject.getIdProyecto());
			method.addParameter("PROJECT_NAME",eProject.getNombreProyecto());
			
		    int statusCode1 = client.executeMethod(method);
		    logger.info("statusLine>>> " + method.getStatusLine() + " || statusCode>>> "+statusCode1);
		   
		} catch (Exception e) {
			logger.error("No se ha podido eliminar el proyecto. " + e, e);
			throw e;
		}
		finally{
			if (method!=null)
				method.releaseConnection();
		}
	}

}

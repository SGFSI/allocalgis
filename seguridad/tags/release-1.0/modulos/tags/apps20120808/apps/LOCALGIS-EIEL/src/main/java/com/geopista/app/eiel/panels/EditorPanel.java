package com.geopista.app.eiel.panels;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Collection;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import com.geopista.app.AppContext;
import com.geopista.security.GeopistaPermission;
import com.vividsolutions.jump.workbench.ui.InputChangedListener;

public class EditorPanel extends JPanel
{

	private boolean acceso;
	private GeopistaEditorPanel geopistaEditorPanel = null;

	AppContext aplicacion = (AppContext) AppContext.getApplicationContext();

	public EditorPanel()
	{
		try
		{
			jbInit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public JPanel getGeopistaEditorPanel(){

		if (geopistaEditorPanel == null){		  
			geopistaEditorPanel = new GeopistaEditorPanel();
		}	  
		return geopistaEditorPanel;
	}



	private void jbInit() throws Exception
	{

		GeopistaPermission geopistaPerm = new GeopistaPermission("LocalGIS.edicion.EIEL");
		acceso = aplicacion.checkPermission(geopistaPerm,"EIEL");

		this.setLayout(new GridBagLayout());

		this.add(getGeopistaEditorPanel(), 
				new GridBagConstraints(0, 0, 1, 1, 1, 1,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));

		AppContext.getApplicationContext().getBlackboard().put("GeopistaEditor", getGeopistaEditorPanel());

	}


	/**
	 * Tip: Delegate to an InputChangedFirer.
	 * @param listener a party to notify when the input changes (usually the
	 * WizardDialog, which needs to know when to update the enabled state of
	 * the buttons.
	 */
	public void add(InputChangedListener listener)
	{

	}

	public void remove(InputChangedListener listener)
	{

	}


	public String getTitle()
	{
		return "";
	}

	public String getID()
	{
		return "1";
	}

	public String getInstructions()
	{
		return "";
	}

	public boolean isInputValid()
	{
		Collection lista = null;
		lista = geopistaEditorPanel.getEditor().getLayerViewPanel().getSelectionManager().getFeaturesWithSelectedItems(
				geopistaEditorPanel.getEditor().getLayerManager().getLayer("parcelas"));
		if (lista.size()==1)
			if (acceso) {
				return true;
			}
			else{
				return false;
			}

		else

			return false;
	}
}

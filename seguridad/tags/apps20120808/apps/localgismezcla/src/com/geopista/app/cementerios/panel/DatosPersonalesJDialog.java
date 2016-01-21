/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DefuncionJDialog.java
 *
 * Created on 17-mar-2011, 16:02:23
 */

package com.geopista.app.cementerios.panel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.geopista.app.AppContext;
import com.geopista.app.cementerios.Constantes;
import com.geopista.protocol.cementerios.PersonaBean;
import com.geopista.util.ApplicationContext;

/**
 *
 * @author yraton
 */
public class DatosPersonalesJDialog extends javax.swing.JDialog {

	private String operacion;
	private String tipo;
    private ApplicationContext aplicacion;
    private javax.swing.JFrame desktop;
    
//    private BloqueBean bloque;
    private PersonaBean persona ;
    
	private BotoneraAceptarCancelarJPanel botoneraAceptarCancelarJPanel;

    private ArrayList actionListeners= new ArrayList();
    private String locale;

	
    /** Creates new form BloqueJDialog */
    public DatosPersonalesJDialog (JFrame desktop, String locale, String operacion,String tipo) throws Exception{
    	super(desktop);
        this.desktop= desktop;
        this.locale= locale;
        this.operacion= operacion;
        this.tipo=tipo;
        inicializar();
    }

    /** Creates new form BloqueJDialog */
    public DatosPersonalesJDialog(JFrame desktop, String locale) throws Exception{
        super(desktop);
        this.desktop= desktop;
        this.locale= locale;
        inicializar();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   
    private void inicializar() {

       	this.aplicacion = (AppContext) AppContext.getApplicationContext();
        getContentPane().setLayout(new BorderLayout());
        renombrarComponentes();
        setModal(true);

        desktop = new javax.swing.JFrame();
    	
        jTextField2 = new javax.swing.JTextField();
        DatosPersonalesJPanel = new javax.swing.JPanel();
        DatosGeneralesComunesJPanel = new javax.swing.JPanel();
        entidadJLabel = new javax.swing.JLabel();
        cementerioJLabel = new javax.swing.JLabel();
        jEntidadtField = new javax.swing.JTextField();
        jCementeriotField = new javax.swing.JTextField();
        DatosJPanel = new javax.swing.JPanel();
        DNIJLabel = new javax.swing.JLabel();
        DatosDifuntoJTextField = new javax.swing.JTextField();
        NombreJLabel = new javax.swing.JLabel();
        NombreJTextField = new javax.swing.JTextField();
        domicilioFiscalJLabel = new javax.swing.JLabel();
        domicilioFiscalJTextField = new javax.swing.JTextField();
        apellidosJLabel = new javax.swing.JLabel();
        apellidosJTextField = new javax.swing.JTextField();
        DomicilioPostalJLabel = new javax.swing.JLabel();
        domicilioPostalJTextField = new javax.swing.JTextField();
        Pesta�aDatosPersonalesJPanel = new javax.swing.JPanel();
        Pesta�aDatosPerJTabbedPane = new javax.swing.JTabbedPane();
        DomiciliosJPanel = new javax.swing.JPanel();
        DomiciliosJScrollPane = new javax.swing.JScrollPane();
        DomiciliosJTable = new javax.swing.JTable();
        informacionJPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        informacionJTextArea = new javax.swing.JTextArea();
        DPersonaFisicaJPanel = new javax.swing.JPanel();
        fallecidoJCheckBox = new javax.swing.JCheckBox();
        fNacimientoJLabel = new javax.swing.JLabel();
        fNacimientoJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        fFallecimientoJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fFallecimientoJTextField1 = new javax.swing.JTextField();
        DFallecimientoJPanel = new javax.swing.JPanel();
        causaFundamentalJLabel = new javax.swing.JLabel();
        causaFundamentalJTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        causaInmediataJTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lugarDefuncionJTextField = new javax.swing.JTextField();

        jTextField2.setText("jTextField2");
        
        
        botoneraAceptarCancelarJPanel= new BotoneraAceptarCancelarJPanel();
        botoneraAceptarCancelarJPanel.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(ActionEvent e){
  				botoneraAceptarCancelarJPanel_actionPerformed();
  			}
  		});

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        
          //800x 500
        setSize(870, 670);


//        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        DatosPersonalesJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DatosGeneralesComunesJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        DatosGeneralesComunesJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        entidadJLabel.setText("Entidad");
        DatosGeneralesComunesJPanel.add(entidadJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        cementerioJLabel.setText("Cementerio");
        DatosGeneralesComunesJPanel.add(cementerioJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jEntidadtField.setText("entidad");
        jEntidadtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEntidadtFieldActionPerformed(evt);
            }
        });
        DatosGeneralesComunesJPanel.add(jEntidadtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 780, -1));

        jCementeriotField.setText("cementerio");
        DatosGeneralesComunesJPanel.add(jCementeriotField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 780, -1));

        DatosPersonalesJPanel.add(DatosGeneralesComunesJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 880, 70));

        DatosJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        DatosJPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        DNIJLabel.setText("DNI/NIF");

        DatosDifuntoJTextField.setText("DNI");

        NombreJLabel.setText("Nombre");

        NombreJTextField.setText("Nombre");

        domicilioFiscalJLabel.setText("Domicilio Fiscal ");

        domicilioFiscalJTextField.setText("domicilio");

        apellidosJLabel.setText("Apellidos");

        DomicilioPostalJLabel.setText("Domicilio Postal");

        domicilioPostalJTextField.setText("domicilio");

        javax.swing.GroupLayout DatosJPanelLayout = new javax.swing.GroupLayout(DatosJPanel);
        DatosJPanel.setLayout(DatosJPanelLayout);
        DatosJPanelLayout.setHorizontalGroup(
            DatosJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatosJPanelLayout.createSequentialGroup()
                .addGroup(DatosJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DatosJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(DatosJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DomicilioPostalJLabel)
                            .addComponent(domicilioFiscalJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DatosJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(domicilioPostalJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                            .addComponent(domicilioFiscalJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)))
                    .addGroup(DatosJPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(DNIJLabel)
                        .addGap(5, 5, 5)
                        .addComponent(DatosDifuntoJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(NombreJLabel)
                        .addGap(12, 12, 12)
                        .addComponent(NombreJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(apellidosJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apellidosJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        DatosJPanelLayout.setVerticalGroup(
            DatosJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatosJPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(DatosJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DatosJPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(DNIJLabel))
                    .addComponent(DatosDifuntoJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DatosJPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(NombreJLabel))
                    .addGroup(DatosJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NombreJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(apellidosJLabel)
                        .addComponent(apellidosJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DatosJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(domicilioFiscalJLabel)
                    .addComponent(domicilioFiscalJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DatosJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DomicilioPostalJLabel)
                    .addComponent(domicilioPostalJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );

        DatosPersonalesJPanel.add(DatosJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 880, 120));

        Pesta�aDatosPersonalesJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        Pesta�aDatosPersonalesJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DomiciliosJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Direccion", "Poblacion", "Municipio", "Provincia"
            }
        ));
        DomiciliosJScrollPane.setViewportView(DomiciliosJTable);

        javax.swing.GroupLayout DomiciliosJPanelLayout = new javax.swing.GroupLayout(DomiciliosJPanel);
        DomiciliosJPanel.setLayout(DomiciliosJPanelLayout);
        DomiciliosJPanelLayout.setHorizontalGroup(
            DomiciliosJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DomiciliosJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DomiciliosJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        DomiciliosJPanelLayout.setVerticalGroup(
            DomiciliosJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DomiciliosJPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(DomiciliosJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Pesta�aDatosPerJTabbedPane.addTab("Domicilios", DomiciliosJPanel);

        informacionJTextArea.setColumns(20);
        informacionJTextArea.setRows(5);
        jScrollPane3.setViewportView(informacionJTextArea);

        javax.swing.GroupLayout informacionJPanelLayout = new javax.swing.GroupLayout(informacionJPanel);
        informacionJPanel.setLayout(informacionJPanelLayout);
        informacionJPanelLayout.setHorizontalGroup(
            informacionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
        );
        informacionJPanelLayout.setVerticalGroup(
            informacionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        Pesta�aDatosPerJTabbedPane.addTab("Informacion", informacionJPanel);

        Pesta�aDatosPersonalesJPanel.add(Pesta�aDatosPerJTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 850, 140));

        DatosPersonalesJPanel.add(Pesta�aDatosPersonalesJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 880, 180));

        DPersonaFisicaJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        fallecidoJCheckBox.setText("Fallecido");
        fallecidoJCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fallecidoJCheckBoxActionPerformed(evt);
            }
        });

        fNacimientoJLabel.setText("Fecha Nacimiento");

        jLabel1.setText("Fecha Fallecimiento");

        fFallecimientoJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fFallecimientoJTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Ref. Fallecimiento");

        fFallecimientoJTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fFallecimientoJTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DPersonaFisicaJPanelLayout = new javax.swing.GroupLayout(DPersonaFisicaJPanel);
        DPersonaFisicaJPanel.setLayout(DPersonaFisicaJPanelLayout);
        DPersonaFisicaJPanelLayout.setHorizontalGroup(
            DPersonaFisicaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DPersonaFisicaJPanelLayout.createSequentialGroup()
                .addGroup(DPersonaFisicaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(DPersonaFisicaJPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(fallecidoJCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(DPersonaFisicaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(DPersonaFisicaJPanelLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(fNacimientoJLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DPersonaFisicaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fNacimientoJTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(fFallecimientoJTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(fFallecimientoJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addContainerGap())
        );
        DPersonaFisicaJPanelLayout.setVerticalGroup(
            DPersonaFisicaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DPersonaFisicaJPanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(DPersonaFisicaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fNacimientoJLabel)
                    .addComponent(fNacimientoJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(DPersonaFisicaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DPersonaFisicaJPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fallecidoJCheckBox))
                    .addGroup(DPersonaFisicaJPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(DPersonaFisicaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(fFallecimientoJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DPersonaFisicaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(fFallecimientoJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DatosPersonalesJPanel.add(DPersonaFisicaJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 410, 110));

        DFallecimientoJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        causaFundamentalJLabel.setText("Causa Fundamental");

        jLabel5.setText("Causa Inmediata");

        jLabel6.setText("Lugar defunción");

        javax.swing.GroupLayout DFallecimientoJPanelLayout = new javax.swing.GroupLayout(DFallecimientoJPanel);
        DFallecimientoJPanel.setLayout(DFallecimientoJPanelLayout);
        DFallecimientoJPanelLayout.setHorizontalGroup(
            DFallecimientoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DFallecimientoJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DFallecimientoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(causaFundamentalJLabel))
                .addGap(18, 18, 18)
                .addGroup(DFallecimientoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(causaInmediataJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(causaFundamentalJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(lugarDefuncionJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                .addContainerGap())
        );
        DFallecimientoJPanelLayout.setVerticalGroup(
            DFallecimientoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DFallecimientoJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DFallecimientoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(causaFundamentalJLabel)
                    .addComponent(causaFundamentalJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DFallecimientoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(causaInmediataJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DFallecimientoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lugarDefuncionJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DatosPersonalesJPanel.add(DFallecimientoJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 440, 110));

        getContentPane().add(DatosPersonalesJPanel, java.awt.BorderLayout.CENTER);
        
        getContentPane().add(botoneraAceptarCancelarJPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jEntidadtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEntidadtFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jEntidadtFieldActionPerformed

    private void fallecidoJCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fallecidoJCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fallecidoJCheckBoxActionPerformed

    private void fFallecimientoJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fFallecimientoJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fFallecimientoJTextFieldActionPerformed

    private void fFallecimientoJTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fFallecimientoJTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fFallecimientoJTextField1ActionPerformed

    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DatosPersonalesJDialog dialog = new DatosPersonalesJDialog(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
    
    
    public void addActionListener(ActionListener l) {
        this.actionListeners.add(l);
    }

    public void removeActionListener(ActionListener l) {
        this.actionListeners.remove(l);
    }

    
    private void fireActionPerformed() {
        for (Iterator i = actionListeners.iterator(); i.hasNext();) {
            ActionListener l = (ActionListener) i.next();
            l.actionPerformed(new ActionEvent(this, 0, null));
        }
    }


    public void renombrarComponentes(){
//        try{datosGeneralesComunesJPanel.setBorder(new javax.swing.border.TitledBorder(aplicacion.getI18nString("cementerio.datosGenerales.tag1")));}catch(Exception e){}
    }

    
	/**
	 * M�todo que carga en el panel los datos generales del bloque
	 * @param bloque a cargar en el panel
	 */
	public void load(PersonaBean personaElem, boolean editable) {
		if (personaElem == null)
			return;
		
		jCementeriotField.setText(personaElem.getNombre() != null ?  personaElem.getNombre() : "");
		jEntidadtField.setText(personaElem.getEntidad() != null ?  personaElem.getEntidad() : "");
		
    	setPersona(personaElem);
        if(operacion == null) return;
		        
        DatosGeneralesComunesJPanel.setEnabled(editable);
        DPersonaFisicaJPanel.setEnabled(editable);
//        documentosJPanel.setEnabled(editable);
//       if ((unidadEnterramiento.getTipo_unidad()!=null) && (unidadEnterramiento.getTipo_unidad().equalsIgnoreCase(Const.PATRON_UENTERRAMIENTO)))
//		        	//datosGenerales1JPanel.load(unidadEnterramiento);
//        	datosUnidadEnterramientoJPanel.load(unidadEnterramiento, true);

		        /** cargamos las observaciones */
//		        observacionesJPanel.load(unidadEnterramiento);
//		        observacionesJPanel.setOperacion(operacion);

//		        mejorasJPanel.load(unidadEnterramiento);
//		        mejorasJPanel.setOperacion(operacion);
//		        refCatastralesJPanel.load(unidadEnterramiento);
//		        refCatastralesJPanel.setOperacion(operacion);
//		        usosFuncionalesJPanel.load(unidadEnterramiento);
//		        usosFuncionalesJPanel.setOperacion(operacion);
//		        documentosJPanel.load(unidadEnterramiento);
//		    }
		
		
	}

    
    
    /* M�todo que abre una ventana de confirmacion sobre la operacion que se esta llevando a cabo
    */
   private boolean confirmOption(){
       int ok= -1;
       ok= JOptionPane.showConfirmDialog(this, aplicacion.getI18nString("cementerio.optionpane.tag1"), aplicacion.getI18nString("cementerio.optionpane.tag2"), JOptionPane.YES_NO_OPTION);
       if (ok == JOptionPane.NO_OPTION){
           return false;
       }
       return true;
   }

   private void exitForm(java.awt.event.WindowEvent evt) {
	   setPersona(null);
       fireActionPerformed();
   }
 
   
    public void botoneraAceptarCancelarJPanel_actionPerformed(){
        if((!botoneraAceptarCancelarJPanel.aceptarPressed()) ||
           (botoneraAceptarCancelarJPanel.aceptarPressed() && operacion.equalsIgnoreCase(Constantes.OPERACION_MODIFICAR)?!confirmOption():false)){
            persona= null;
        	//System.out.println("es aceptar");
        }
        else{
        	System.out.println("voy biennn");
        }
        fireActionPerformed();
    }
    
    
    public PersonaBean getPersona() {
		return persona;
	}

	public void setPersona(PersonaBean persona) {
		this.persona = persona;
	}







	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DFallecimientoJPanel;
    private javax.swing.JLabel DNIJLabel;
    private javax.swing.JPanel DPersonaFisicaJPanel;
    private javax.swing.JTextField DatosDifuntoJTextField;
    private javax.swing.JPanel DatosGeneralesComunesJPanel;
    private javax.swing.JPanel DatosJPanel;
    private javax.swing.JPanel DatosPersonalesJPanel;
    private javax.swing.JLabel DomicilioPostalJLabel;
    private javax.swing.JPanel DomiciliosJPanel;
    private javax.swing.JScrollPane DomiciliosJScrollPane;
    private javax.swing.JTable DomiciliosJTable;
    private javax.swing.JLabel NombreJLabel;
    private javax.swing.JTextField NombreJTextField;
    private javax.swing.JTabbedPane Pesta�aDatosPerJTabbedPane;
    private javax.swing.JPanel Pesta�aDatosPersonalesJPanel;
    private javax.swing.JLabel apellidosJLabel;
    private javax.swing.JTextField apellidosJTextField;
    private javax.swing.JLabel causaFundamentalJLabel;
    private javax.swing.JTextField causaFundamentalJTextField;
    private javax.swing.JTextField causaInmediataJTextField;
    private javax.swing.JLabel cementerioJLabel;
    private javax.swing.JLabel domicilioFiscalJLabel;
    private javax.swing.JTextField domicilioFiscalJTextField;
    private javax.swing.JTextField domicilioPostalJTextField;
    private javax.swing.JLabel entidadJLabel;
    private javax.swing.JTextField fFallecimientoJTextField;
    private javax.swing.JTextField fFallecimientoJTextField1;
    private javax.swing.JLabel fNacimientoJLabel;
    private javax.swing.JTextField fNacimientoJTextField;
    private javax.swing.JCheckBox fallecidoJCheckBox;
    private javax.swing.JPanel informacionJPanel;
    private javax.swing.JTextArea informacionJTextArea;
    private javax.swing.JTextField jCementeriotField;
    private javax.swing.JTextField jEntidadtField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField lugarDefuncionJTextField;
    // End of variables declaration//GEN-END:variables

}
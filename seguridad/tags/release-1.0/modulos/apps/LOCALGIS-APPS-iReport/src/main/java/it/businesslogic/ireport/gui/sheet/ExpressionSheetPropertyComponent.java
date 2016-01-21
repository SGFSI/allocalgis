/*
 * Copyright (C) 2005 - 2007 JasperSoft Corporation.  All rights reserved. 
 * http://www.jaspersoft.com.
 *
 * Unless you have purchased a commercial license agreement from JasperSoft,
 * the following license terms apply:
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 as published by
 * the Free Software Foundation.
 *
 * This program is distributed WITHOUT ANY WARRANTY; and without the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see http://www.gnu.org/licenses/gpl.txt
 * or write to:
 *
 * Free Software Foundation, Inc.,
 * 59 Temple Place - Suite 330,
 * Boston, MA  USA  02111-1307
 *
 *
 *
 *
 * ExpressionSheetPropertyComponent.java
 * 
 * Created on 15 agosto 2005, 13.32
 *
 */

package it.businesslogic.ireport.gui.sheet;

import it.businesslogic.ireport.ExpressionContext;
import it.businesslogic.ireport.gui.MainFrame;
import it.businesslogic.ireport.util.I18n;

/**
 *
 * @author  Administrator
 */
public class ExpressionSheetPropertyComponent extends javax.swing.JPanel {
    
    String expression = "";
    
    private ExpressionContext expressionContext = new ExpressionContext();
    
    private boolean init = false;
    
    private boolean plainTextEditor = false;   
     
    /**
     * Show a text without changing the real expression stored
     */
    public void setText(String fakeExpression)
    {
        setInit(true);
        jTextArea1.setText(fakeExpression);
        jTextArea1.setCaretPosition(0);
        setInit(false);
    }
       
    public void setExpression(String expression)
    {
        this.expression = expression;
        setInit(true);
        jTextArea1.setText(expression);
        jTextArea1.setCaretPosition(0);
        setInit(false);
    }
    
    public String getExpression()
    {
        return expression;
    }
    
    /** Creates new form ExpressionSheetPanel */
    public ExpressionSheetPropertyComponent() {
        initComponents();
        
        jTextArea1.getDocument().addDocumentListener( new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent evt) {
                try {
                   actionPerformed( evt.getDocument().getText(0,  evt.getDocument().getLength() ));
                } catch (Exception ex){}
            }
            public void insertUpdate(javax.swing.event.DocumentEvent evt) {
                try {
                    actionPerformed( evt.getDocument().getText(0,  evt.getDocument().getLength() ));
                } catch (Exception ex){}
            }
            public void removeUpdate(javax.swing.event.DocumentEvent evt) {
                try {
                    actionPerformed( evt.getDocument().getText(0,  evt.getDocument().getLength() ));
                } catch (Exception ex){}
            }
        });
        
        applyI18n();
         
    }
    
    public void actionPerformed(String newText)
    {
        if (isInit()) return;
        expression = newText;
        java.awt.event.ActionEvent event = new java.awt.event.ActionEvent(this,0,expression);
        fireActionListenerActionPerformed(event);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(false);
        jTextArea1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane1, gridBagConstraints);

        jButton1.setText("...");
        jButton1.setMaximumSize(new java.awt.Dimension(19, 10));
        jButton1.setMinimumSize(new java.awt.Dimension(19, 10));
        jButton1.setPreferredSize(new java.awt.Dimension(19, 10));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        add(jButton1, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (isPlainTextEditor())
        {
            PlainTextDialog ptd = new PlainTextDialog(MainFrame.getMainInstance(), true);
            ptd.setText( expression );
            ptd.setVisible(true);
            if (ptd.getDialogResult() == javax.swing.JOptionPane.OK_OPTION)
            {
                setInit(true);
                setExpression( ptd.getText() );
                //jTextArea1.setText( ptd.getText() );
                //jTextArea1.setCaretPosition(0);
                setInit(false);
                actionPerformed( ptd.getText());
            }
        }
        else
        {
            // We show the expression editor...
            it.businesslogic.ireport.gui.ExpressionEditor ed = new it.businesslogic.ireport.gui.ExpressionEditor();
            ed.setSubDataset( it.businesslogic.ireport.gui.MainFrame.getMainInstance().getActiveReportFrame().getReport() );
            ed.setExpression( expression );

            ed.setExpressionContext( getExpressionContext() );

            ed.setVisible(true);
            if (ed.getDialogResult() == javax.swing.JOptionPane.OK_OPTION)
            {
                setInit(true);
                setExpression( ed.getExpression() );
                //jTextArea1.setText(  );
                //jTextArea1.setCaretPosition(0);
                setInit(false);
                actionPerformed( ed.getExpression());
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextArea1;
    // End of variables declaration//GEN-END:variables

    /**
     * Utility field used by event firing mechanism.
     */
    private javax.swing.event.EventListenerList listenerList =  null;

    /**
     * Registers ActionListener to receive events.
     * @param listener The listener to register.
     */
    public synchronized void addActionListener(java.awt.event.ActionListener listener) {

        if (listenerList == null ) {
            listenerList = new javax.swing.event.EventListenerList();
        }
        listenerList.add (java.awt.event.ActionListener.class, listener);
    }

    /**
     * Removes ActionListener from the list of listeners.
     * @param listener The listener to remove.
     */
    public synchronized void removeActionListener(java.awt.event.ActionListener listener) {

        listenerList.remove (java.awt.event.ActionListener.class, listener);
    }

    /**
     * Notifies all registered listeners about the event.
     * 
     * @param event The event to be fired
     */
    private void fireActionListenerActionPerformed(java.awt.event.ActionEvent event) {

        if (listenerList == null) return;
        Object[] listeners = listenerList.getListenerList ();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i]==java.awt.event.ActionListener.class) {
                ((java.awt.event.ActionListener)listeners[i+1]).actionPerformed (event);
            }
        }
    }

    public boolean isInit() {
        return init;
    }

    public void setInit(boolean init) {
        this.init = init;
    }

    public ExpressionContext getExpressionContext() {
        return expressionContext;
    }

    public void setExpressionContext(ExpressionContext expressionContext) {
        this.expressionContext = expressionContext;
    }

    public boolean isPlainTextEditor() {
        return plainTextEditor;
    }

    public void setPlainTextEditor(boolean plainTextEditor) {
        this.plainTextEditor = plainTextEditor;
    }

    
    
    public void applyI18n(){
                // Start autogenerated code ----------------------
                jButton1.setText(I18n.getString("expressionSheetPropertyComponent.button1","..."));
                // End autogenerated code ----------------------
    }
}
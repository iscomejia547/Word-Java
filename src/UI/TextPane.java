/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author jf_me
 */
public class TextPane extends javax.swing.JPanel {

    /**
     * Creates new form TextPane
     */
    public TextPane() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        texteditor = new javax.swing.JScrollPane();
        texteditorarea = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        texteditorarea.setColumns(20);
        texteditorarea.setRows(5);
        texteditor.setViewportView(texteditorarea);

        add(texteditor, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public void setText(String text){
        this.texteditorarea.setText(text);
    }
    public String getText(){
        return this.texteditorarea.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane texteditor;
    private javax.swing.JTextArea texteditorarea;
    // End of variables declaration//GEN-END:variables
}

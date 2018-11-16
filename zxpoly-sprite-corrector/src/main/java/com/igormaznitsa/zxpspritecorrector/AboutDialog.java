package com.igormaznitsa.zxpspritecorrector;

import javax.swing.JFrame;

public final class AboutDialog extends javax.swing.JDialog {

  private static final long serialVersionUID = 4732416792603520083L;

  public AboutDialog(final JFrame parent) {
    super(parent, true);
    initComponents();

    this.jTextArea1.setText(this.jTextArea1.getText().replace("${project.version}", "2.0-SNAPSHOT"));

    this.setLocationRelativeTo(null);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jToggleButton1 = new javax.swing.JToggleButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("About");

    jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/igormaznitsa/zxpspritecorrector/icons/cross.png"))); // NOI18N
    jToggleButton1.setText("Close");
    jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jToggleButton1ActionPerformed(evt);
      }
    });

    jTextArea1.setEditable(false);
    jTextArea1.setColumns(20);
    jTextArea1.setFont(jTextArea1.getFont().deriveFont(jTextArea1.getFont().getSize()+3f));
    jTextArea1.setLineWrap(true);
    jTextArea1.setRows(5);
    jTextArea1.setText("The ZX-Poly sprite corrector v. ${project.version}\n--------------------------------------\n(C) 2008-2017 Igor Maznitsa (igor.maznitsa@igormaznitsa.com)\n\n  The utility allows to load a Hobeta file and find sprites inside of opened binary block. Found sprites can be colorized with the editor and the result can be saved as separated Hobeta files.\n--------------------------------------\nSome icons from http://www.fatcow.com/free-icons");
    jTextArea1.setWrapStyleWord(true);
    jScrollPane1.setViewportView(jTextArea1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
          .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jToggleButton1)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
      dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JToggleButton jToggleButton1;
  // End of variables declaration//GEN-END:variables
}

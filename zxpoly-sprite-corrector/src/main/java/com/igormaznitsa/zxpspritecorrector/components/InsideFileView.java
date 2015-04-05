/*
 * Copyright (C) 2014 Raydac Research Group Ltd.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.igormaznitsa.zxpspritecorrector.components;

import com.igormaznitsa.zxpspritecorrector.files.AbstractFilePlugin;
import com.igormaznitsa.zxpspritecorrector.files.Info;
import java.awt.Component;
import java.beans.*;
import java.io.File;
import java.util.List;
import javax.swing.*;

public class InsideFileView extends javax.swing.JPanel implements PropertyChangeListener {

  private static final long serialVersionUID = -3736184888649683739L;

  private final JFileChooser chooser;
  private final DefaultListModel<String> listModel = new DefaultListModel<String>();

  public InsideFileView(final JFileChooser chooser) {
    super();
    initComponents();
    this.chooser = chooser;
    this.chooser.addPropertyChangeListener(this);
    this.listFiles.setModel(listModel);
    
    final JPanel thePanel = this; 
    
    this.listFiles.setCellRenderer(new ListCellRenderer() {
      private final JTextArea renderer = new JTextArea();
      
      @Override
      public Component getListCellRendererComponent(final JList list, final Object value, final int index, final boolean isSelected, final boolean cellHasFocus) {
        renderer.setFont(list.getFont());
        renderer.setBackground(list.getBackground());
        renderer.setForeground(list.getForeground());
        renderer.setOpaque(false);
        renderer.setWrapStyleWord(false);
        renderer.setLineWrap(false);
        renderer.setEditable(false);
        renderer.setText(value.toString());
        renderer.setBorder(null);
        
        thePanel.revalidate();
        thePanel.repaint();
        
        return renderer;
      }
    });
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    listFiles = new javax.swing.JList();

    setLayout(new java.awt.BorderLayout());

    listFiles.setFont(new java.awt.Font("Courier New", 0, 10)); // NOI18N
    listFiles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    listFiles.setEnabled(false);
    jScrollPane1.setViewportView(listFiles);

    add(jScrollPane1, java.awt.BorderLayout.CENTER);
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JList listFiles;
  // End of variables declaration//GEN-END:variables

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    final String changeName = evt.getPropertyName();
    if (changeName.equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)) {
      final File file = (File) evt.getNewValue();
      this.listModel.clear();
      if (file != null) {
        final AbstractFilePlugin plugin = (AbstractFilePlugin) this.chooser.getFileFilter();

        if (plugin.doesImportContainInsideFileList()) {

          final List<Info> info = plugin.getImportingContainerFileList(file);

          if (info == null) {
            this.listModel.addElement("   Wrong format   ");
          }
          else {
              for (final Info s : info) {
                this.listModel.addElement(s.toString());
              }
          }
        }else{
          final String fileReference = plugin.getImportingFileInfo(file);
          if (fileReference == null){
            this.listModel.addElement("   Wrong format   ");
          }else{
            this.listModel.addElement(fileReference);
          }
        }
      }
    }
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

 import dao.IDao;
import entities.Salle;
 import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Lachgar
 */
public class SalleForm extends javax.swing.JInternalFrame {

    IDao<Salle> dao = null;
    DefaultTableModel model = null;

    /**
     * Creates new form SalleForm
     */
    private int selectedId; // Separate variable to store the selected ID

    public void load(){
        try {
 
            model.setRowCount(0);
         List<Salle> salleList = dao.findAll();
        if (salleList != null) {
            for (Salle s : salleList) {
                model.addRow(new Object[]{
                    s.getId(),
                    s.getRef(),
                    s.getEtage()
                });
            }
        }
        } catch (RemoteException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public SalleForm() {
        initComponents();
        try {
            dao = (IDao<Salle>) Naming.lookup("rmi://localhost:1099/daosalle");
        } catch (NotBoundException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        model = (DefaultTableModel) listSalles.getModel();
        
        
        // Attach a ListSelectionListener to the JTable
        listSalles.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = listSalles.getSelectedRow();
                    if (selectedRow != -1) {
                        // Get the data from the selected row
                        selectedId = (int) model.getValueAt(selectedRow, 0);
                        String ref = (String) model.getValueAt(selectedRow, 1);
                        int etage = (int) model.getValueAt(selectedRow, 2);
               

                        // Set the values in the input fields
                        txtRef.setText(ref);
                        txtRef1.setText(ref);
                     }
                }
            }
        });
        
        
        
        load();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
        CodeLabel1 = new javax.swing.JLabel();
        txtRef = new javax.swing.JTextField();
        txtRef1 = new javax.swing.JTextField();
        CodeLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bnAdd = new javax.swing.JButton();
        bnUpdate = new javax.swing.JButton();
        bnDelete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSalles = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestion Salles");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        CodeLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CodeLabel1.setText("Reference");

        CodeLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CodeLabel2.setText("Etage");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CodeLabel1)
                    .addComponent(CodeLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRef, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRef1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CodeLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRef1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CodeLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CodeLabel1.getAccessibleContext().setAccessibleName("Code:");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        bnAdd.setBackground(new java.awt.Color(255, 255, 255));
        bnAdd.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        bnAdd.setText("Ajouter");
        bnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnAddActionPerformed(evt);
            }
        });

        bnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        bnUpdate.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        bnUpdate.setText("Modifier");
        bnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnUpdateActionPerformed(evt);
            }
        });

        bnDelete.setBackground(new java.awt.Color(255, 255, 255));
        bnDelete.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        bnDelete.setText("Supprimer");
        bnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(bnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(bnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(bnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Liste des salles"));

        listSalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Reference", "Etage"
            }
        ));
        jScrollPane1.setViewportView(listSalles);
        if (listSalles.getColumnModel().getColumnCount() > 0) {
            listSalles.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnAddActionPerformed
        try {
            // TODO add your handling code here:
            String ref = txtRef.getText().toString();
            int etage=Integer.parseInt(txtRef1.getText().toString());
            dao.create(new Salle(ref,etage));
            load();
        } catch (RemoteException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bnAddActionPerformed

    private void bnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnUpdateActionPerformed
        // TODO add your handling code here:
          try {
           String ref = txtRef.getText().toString();
            int etage=Integer.parseInt(txtRef1.getText().toString());
            int id =selectedId;
            
            //2-step two get the current salle
            Salle m = dao.findById(id);
            
            //3-step three set the desired values to the current salle
              m.setRef(ref);
              m.setEtage(etage);
            
            //4-final step to update the salle by the new values
            dao.update(m);
            load();
        } catch (RemoteException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bnUpdateActionPerformed

    private void bnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnDeleteActionPerformed
        // TODO add your handling code here:
          try {
            // TODO add your handling code here:
            //step one get the current id
            int id =selectedId;
            
            //2-step two get the current salle
            Salle m = dao.findById(id);
  
            //2-final step to delete the salle 
            dao.delete(m);
            load();
        } catch (RemoteException ex) {
            Logger.getLogger(SalleForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CodeLabel1;
    private javax.swing.JLabel CodeLabel2;
    private javax.swing.JButton bnAdd;
    private javax.swing.JButton bnDelete;
    private javax.swing.JButton bnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTable listSalles;
    private javax.swing.JTextField txtRef;
    private javax.swing.JTextField txtRef1;
    // End of variables declaration//GEN-END:variables
}

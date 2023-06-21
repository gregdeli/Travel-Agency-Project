package classes;

import static classes.Login.conn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Offers extends javax.swing.JFrame {

   
    public Offers() throws SQLException {
       initComponents();
       table_load();
       table_load2();
       
    }
    PreparedStatement pst;
 
    public void table_load() throws SQLException {
      Statement st = conn.createStatement();
      String table_sql = "SELECT offer_id,offer_trip_start_date , offer_trip_end_date ,Price_per_Person ,offer_dst_id from offers";
      ResultSet rs = st.executeQuery(table_sql);
      
      while(rs.next()){
          
          String offer_id = String.valueOf(rs.getInt("offer_id"));
          String offer_trip_start_date = rs.getString("offer_trip_start_date");
          String offer_trip_end_date=  rs.getString("offer_trip_end_date");
          String Price_per_Person = String.valueOf(rs.getInt("Price_per_Person"));
          String offer_dst_id= String.valueOf(rs.getInt("offer_dst_id"));
     
          String tbData[] = {offer_id,offer_trip_start_date , offer_trip_end_date, Price_per_Person ,offer_dst_id};
          
          DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel();
          tblModel.addRow(tbData); 
      }
    }
    
      public void table_load2() throws SQLException {
      Statement st = conn.createStatement();
      String table_sql = "SELECT dst_id , dst_name, dst_dscr , dst_rtype FROM destination";
      ResultSet rs = st.executeQuery(table_sql);
      
      while(rs.next()){
          
          String dst_id= String.valueOf(rs.getInt("dst_id"));
          String dst_name= rs.getString("dst_name");
          String dst_dscr = rs.getString("dst_dscr");
          String dst_rtype = rs.getString("dst_rtype");
 
          String tbData[] = {dst_name, dst_dscr , dst_rtype, dst_id};

          DefaultTableModel tblModel = (DefaultTableModel)jTable2.getModel();
          tblModel.addRow(tbData); 
      }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        StartDateField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        StartEndField = new javax.swing.JTextField();
        LnameField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        PriceField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        ExitButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        DeleteButton1 = new javax.swing.JButton();
        UpdateButton2 = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        SearchField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Offers");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Offers", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel5.setText("End Date");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel7.setText("Price");

        StartDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartDateFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel8.setText("Destination ID");

        StartEndField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartEndFieldActionPerformed(evt);
            }
        });

        LnameField.setEditable(false);
        LnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LnameFieldActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel9.setText("Start Date");

        PriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StartDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(StartEndField, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(LnameField, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(PriceField, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StartDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel9))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(StartEndField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(LnameField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Offer ID", "Trip Start Date", "Trip End Date", "Price", "Destination ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Destinatio Name", "Discriber", "Type", "Destination ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        ExitButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        ClearButton.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        DeleteButton1.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        DeleteButton1.setText("Delete");
        DeleteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButton1ActionPerformed(evt);
            }
        });

        UpdateButton2.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        UpdateButton2.setText("Update");
        UpdateButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButton2ActionPerformed(evt);
            }
        });

        SaveButton.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 22))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel13.setText("Offer ID");

        SearchField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchField1ActionPerformed(evt);
            }
        });
        SearchField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(UpdateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(DeleteButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StartDateFieldActionPerformed

    private void StartEndFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartEndFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StartEndFieldActionPerformed

    private void LnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LnameFieldActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        int selectedRowIndex = jTable2.getSelectedRow();
         StartDateField.setText(model.getValueAt(selectedRowIndex ,1 ).toString());
         StartEndField.setText(model.getValueAt(selectedRowIndex ,2 ).toString());
         LnameField.setText(model.getValueAt(selectedRowIndex ,3 ).toString());

    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();
        SearchField1.setText(model.getValueAt(selectedRowIndex ,0 ).toString());
        StartDateField.setText(model.getValueAt(selectedRowIndex ,1 ).toString());
        StartEndField.setText(model.getValueAt(selectedRowIndex ,2 ).toString());
        PriceField.setText(model.getValueAt(selectedRowIndex ,3 ).toString()); 
        LnameField.setText(model.getValueAt(selectedRowIndex ,4 ).toString());
    
    }//GEN-LAST:event_jTable1MouseClicked

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed

            StartDateField.setText("");
            StartEndField.setText("");
            PriceField.setText("");
            LnameField.setText("");
            SearchField1.setText("");
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void DeleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButton1ActionPerformed
         String search1 ;

         search1 = SearchField1.getText();
 
        try{

            pst= conn.prepareStatement("delete from offers WHERE offer_id =?");
            pst.setString(1, search1);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "Record Deleted!!");
                   jTable1.setModel(new DefaultTableModel(null , new String[]{"Offer ID","Trip Start Date","Trip End Date","Price", "Destination ID"}));
            table_load();
            StartDateField.setText("");
            StartEndField.setText("");
            PriceField.setText("");
            LnameField.setText("");
            SearchField1.setText("");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_DeleteButton1ActionPerformed

    private void UpdateButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButton2ActionPerformed

        String offer_trip_start_date ,offer_trip_end_date ,Price_per_Person ,offer_dst_id ;
        
        offer_trip_start_date = StartDateField.getText();
        offer_trip_end_date  = StartEndField.getText();
        Price_per_Person =PriceField.getText();
        offer_dst_id =  LnameField.getText();
        String sr1 = SearchField1.getText();
      
        
        try{
    
            pst= conn.prepareStatement("update offers set offer_trip_start_date=? , offer_trip_end_date=? , Price_per_Person =?, offer_dst_id = ? WHERE offer_id =?");
            pst.setString(1,offer_trip_start_date);
            pst.setString(2,offer_trip_end_date);
            pst.setString(3,Price_per_Person);
            pst.setString(4,offer_dst_id);
            pst.setString(5,sr1);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "Record Updated!!");
                       jTable1.setModel(new DefaultTableModel(null , new String[]{"Offer ID","Trip Start Date","Trip End Date","Price", "Destination ID"}));
            table_load();
            StartDateField.setText("");
            StartEndField.setText("");
            PriceField.setText("");
            LnameField.setText("");
            SearchField1.setText("");
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_UpdateButton2ActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
  
        String offer_trip_start_date ,offer_trip_end_date ,Price_per_Person ,offer_dst_id ;
         
        offer_trip_start_date = StartDateField.getText();
        offer_trip_end_date  = StartEndField.getText();
        Price_per_Person =PriceField.getText();
        offer_dst_id =  LnameField.getText();
        try{
          
            pst= conn.prepareCall("insert into offers (offer_trip_start_date,offer_trip_end_date,Price_per_Person,offer_dst_id )values(?,?,?,?)");
            pst.setString(1,offer_trip_start_date);
            pst.setString(2,offer_trip_end_date);
            pst.setString(3,Price_per_Person);
            pst.setString(4,offer_dst_id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "Record Updated!!");
                 jTable1.setModel(new DefaultTableModel(null , new String[]{"Offer ID","Trip Start Date","Trip End Date","Price", "Destination ID"}));
            table_load();
            StartDateField.setText("");
            StartEndField.setText("");
            PriceField.setText("");
            LnameField.setText("");
            SearchField1.setText("");
         
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void SearchField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchField1ActionPerformed

    private void SearchField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchField1KeyReleased

    }//GEN-LAST:event_SearchField1KeyReleased

    private void PriceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PriceFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Offers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Offers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Offers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Offers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            
                try {
                    new Offers().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Offers.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton DeleteButton1;
    private javax.swing.JButton ExitButton;
    private javax.swing.JTextField LnameField;
    private javax.swing.JTextField PriceField;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField SearchField1;
    private javax.swing.JTextField StartDateField;
    private javax.swing.JTextField StartEndField;
    private javax.swing.JButton UpdateButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}

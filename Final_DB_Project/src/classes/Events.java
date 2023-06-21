package classes;

import static classes.Login.conn;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Events extends javax.swing.JFrame {

  
    public Events() throws SQLException {
        initComponents();
         table_load();
         table_load2();
        
    }

    PreparedStatement pst;
    CallableStatement cs;
    
    public void table_load() throws SQLException {
      Statement st = conn.createStatement();
      String table_sql = "SELECT ev_tr_id , ev_start , ev_end ,ev_descr FROM event";
      ResultSet rs = st.executeQuery(table_sql);
      
      while(rs.next()){
          
          String id = rs.getString("ev_tr_id");
          String start = rs.getString("ev_start");
          String end = rs.getString("ev_end");
          String des =  rs.getString("ev_descr");
        
          
          String tbData[] = {id , start, end , des };
          
          DefaultTableModel tblModel = (DefaultTableModel)jTable2.getModel();
          tblModel.addRow(tbData); 
      }
    }
    
      public void table_load2() throws SQLException {
      Statement st = conn.createStatement();
      String table_sql = "SELECT tr_id, tr_departure , tr_return ,tr_br_code FROM trip";
      ResultSet rs = st.executeQuery(table_sql);
      
      while(rs.next()){
          
          String tr_id = rs.getString("tr_id");
          String tr_departure= rs.getString("tr_departure");
          String tr_return = rs.getString("tr_return");
          String tr_br_code = String.valueOf(rs.getInt("tr_br_code"));
        
          
          String tbData[] = {tr_id, tr_departure, tr_return , tr_br_code };
          
          DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel();
          tblModel.addRow(tbData); 
      }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        EndField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        DiscriberField = new javax.swing.JTextField();
        StartField = new javax.swing.JTextField();
        CodeField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        SearchField1 = new javax.swing.JTextField();
        SearchField2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        SaveButton = new javax.swing.JButton();
        UpdateButton2 = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText(" Events");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Trip", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel10.setText("Event  Start");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel11.setText("Event End");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel7.setText("Discriber");

        EndField.setText("YYY-MM-DD HH:MM:SS");
        EndField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel8.setText("Trip Code");

        DiscriberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiscriberFieldActionPerformed(evt);
            }
        });

        StartField.setText("YYY-MM-DD HH:MM:SS");
        StartField.setToolTipText("");
        StartField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartFieldActionPerformed(evt);
            }
        });

        CodeField.setEditable(false);
        CodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodeFieldActionPerformed(evt);
            }
        });
        CodeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CodeFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DiscriberField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(StartField, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                    .addComponent(EndField)
                    .addComponent(CodeField))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(StartField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(EndField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(DiscriberField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(CodeField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Trip ID", "Departure", "Return", "Branch Code"
            }
        ));
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
                "Trip ID", "Event Start", "Event End", "Discriber"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 22))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel13.setText("ID Number");

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

        SearchField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchField2ActionPerformed(evt);
            }
        });
        SearchField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchField2KeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel14.setText("Event Start");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchField2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(SearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap())
        );

        SaveButton.setFont(new java.awt.Font("Segoe UI", 0, 27)); // NOI18N
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        UpdateButton2.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        UpdateButton2.setText("Update");
        UpdateButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButton2ActionPerformed(evt);
            }
        });

        DeleteButton.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        ClearButton.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        ExitButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UpdateButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DeleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(UpdateButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ClearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EndFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EndFieldActionPerformed

    private void DiscriberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiscriberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiscriberFieldActionPerformed

    private void StartFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StartFieldActionPerformed

    private void CodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodeFieldActionPerformed

    private void CodeFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodeFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_CodeFieldKeyReleased

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed

        String ev_tr_id ,ev_start , ev_end ,ev_descr ;

        ev_start = StartField.getText();
        ev_end  = EndField.getText();
        ev_descr= DiscriberField.getText();
        ev_tr_id = CodeField.getText();

        try{

            cs= conn.prepareCall("insert into event (ev_tr_id,ev_start,ev_end,ev_descr)values(?,?,?,?)");
            cs.setString(1,ev_tr_id );
            cs.setString(2,ev_start);
            cs.setString(3,ev_end);
            cs.setString(4,ev_descr);
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null , "Record Addedd!!");
            jTable2.setModel(new DefaultTableModel(null , new String[]{"Trip ID","Event Start","Event End","Discriber"}));
            table_load();
            StartField.setText("");
            EndField.setText("");
            DiscriberField.setText("");
            CodeField.setText("");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void UpdateButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButton2ActionPerformed

        String ev_tr_id ,ev_start , ev_end ,ev_descr ,search1 ,search2 ;

        ev_start = StartField.getText();
        ev_end  = EndField.getText();
        ev_descr= DiscriberField.getText();
        ev_tr_id = CodeField.getText();
        search1 = SearchField1.getText();
        search2 = SearchField2.getText();

        try{

            pst= conn.prepareStatement("update event set ev_tr_id =? ,ev_start=? , ev_end=?, ev_descr=? WHERE ev_tr_id =? and ev_start =?");
            pst.setString(1,ev_tr_id);
            pst.setString(2,ev_start);
            pst.setString(3,ev_end);
            pst.setString(4,ev_descr);
            pst.setString(5,search1);
            pst.setString(6,search2);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "Record upadted!");
            jTable2.setModel(new DefaultTableModel(null , new String[]{"Trip ID","Event Start","Event End","Discriber"}));
            table_load();
            StartField.setText("");
            EndField.setText("");
            DiscriberField.setText("");
            CodeField.setText("");
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_UpdateButton2ActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        String search1 , search2;

        search1 = SearchField1.getText();
        search2 = SearchField2.getText();

        try{

            pst= conn.prepareStatement("delete from event WHERE ev_tr_id =? and ev_start=? ");
            pst.setString(1, search1);
            pst.setString(2, search2);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "Record Deleted!!");
            jTable2.setModel(new DefaultTableModel(null , new String[]{"Trip ID","Event Start","Event End","Discriber"}));
            table_load();
            StartField.setText("");
            EndField.setText("");
            DiscriberField.setText("");
            CodeField.setText("");
            SearchField1.setText("");
            SearchField2.setText("");
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed

            StartField.setText("");
            EndField.setText("");
            DiscriberField.setText("");
            CodeField.setText("");
            SearchField1.setText("");
            SearchField2.setText("");
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void SearchField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchField1ActionPerformed

    private void SearchField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchField1KeyReleased

        
    }//GEN-LAST:event_SearchField1KeyReleased

    private void SearchField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchField2ActionPerformed

    private void SearchField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchField2KeyReleased
        
        try{

            String sr1 = SearchField1.getText();
            String sr2 = SearchField2.getText();

            pst = conn.prepareStatement("SELECT ev_tr_id , ev_start, ev_end, ev_descr FROM event WHERE ev_tr_id =? and ev_start =?");
            pst.setString(1 , sr1);
            pst.setString(2 , sr2);
            ResultSet rs = pst.executeQuery();

            if(rs.next() == true)
            {
                String ev_tr_id  = rs.getString(1);
                String ev_start = rs.getString(2);
                String ev_end = rs.getString(3);
                String ev_descr = rs.getString(4);
         
                StartField.setText(ev_tr_id);
                EndField.setText(ev_start);
                DiscriberField.setText(ev_end);
                CodeField.setText( ev_descr);

            }else{

                StartField.setText("");
                EndField.setText("");
                DiscriberField.setText("");
                CodeField.setText("");
                SearchField1.setText("");
                SearchField2.setText("");
            }

        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_SearchField2KeyReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        int selectedRowIndex = jTable2.getSelectedRow();
        SearchField1.setText(model.getValueAt(selectedRowIndex ,0 ).toString());
        StartField.setText(model.getValueAt(selectedRowIndex ,1 ).toString());
        EndField.setText(model.getValueAt(selectedRowIndex ,2 ).toString());
        DiscriberField.setText(model.getValueAt(selectedRowIndex ,3 ).toString());
        SearchField2.setText(model.getValueAt(selectedRowIndex ,1 ).toString());

    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();
        CodeField.setText(model.getValueAt(selectedRowIndex ,0 ).toString());
  
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(Events.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Events.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Events.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Events.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Events().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Events.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearButton;
    private javax.swing.JTextField CodeField;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField DiscriberField;
    private javax.swing.JTextField EndField;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField SearchField1;
    private javax.swing.JTextField SearchField2;
    private javax.swing.JTextField StartField;
    private javax.swing.JButton UpdateButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}

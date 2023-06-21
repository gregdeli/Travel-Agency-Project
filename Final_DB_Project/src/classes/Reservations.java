package classes;

import static classes.Login.conn;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Reservations extends javax.swing.JFrame {

   
    public Reservations() throws SQLException {
        initComponents();
        table_load();
        table_load2();
       
    }

    PreparedStatement pst;
 
    
    public void table_load() throws SQLException {
      Statement st = conn.createStatement();
      String table_sql = "SELECT res_tr_id , res_seatnum ,res_name ,res_lname,res_isadult FROM reservation";
      ResultSet rs = st.executeQuery(table_sql);
      
      while(rs.next()){
          
          String res_tr_id = String.valueOf(rs.getInt("res_tr_id"));
          String res_seatnum= String.valueOf(rs.getInt("res_seatnum"));
          String res_name = rs.getString("res_name");
          String res_lname=  rs.getString("res_lname");
          String res_isadult =  rs.getString("res_isadult");
    
        
          
          String tbData[] = {res_tr_id , res_seatnum, res_name ,res_lname ,res_isadult};
          
          DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel();
          tblModel.addRow(tbData); 
      }
    }
    
      public void table_load2() throws SQLException {
      Statement st = conn.createStatement();
      String table_sql = "SELECT tr_id ,tr_departure, tr_return ,dst_name from trip INNER JOIN travel_to ON tr_id = to_tr_id INNER JOIN destination ON to_dst_id = dst_id";
      ResultSet rs = st.executeQuery(table_sql);
      
      while(rs.next()){
          
          String tr_id= String.valueOf(rs.getInt("tr_id"));
          String tr_departure= rs.getString("tr_departure");
          String tr_return= rs.getString("tr_return");
          String dst_nam= rs.getString("dst_name");
 
          String tbData[] = {tr_id, dst_nam, tr_departure,tr_return};

          DefaultTableModel tblModel = (DefaultTableModel)jTable2.getModel();
          tblModel.addRow(tbData); 
      }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SeatNumberField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        NameField = new javax.swing.JTextField();
        DestinationIDField = new javax.swing.JTextField();
        LnameField = new javax.swing.JTextField();
        TypeBox = new javax.swing.JComboBox<>();
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
        SearchField2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Reservation");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Destination", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel4.setText("Trip ID");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel5.setText("Seat Number");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel6.setText("Adult / Minor");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel7.setText("Name");

        SeatNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeatNumberFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel8.setText("Laname");

        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });

        DestinationIDField.setEditable(false);

        LnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LnameFieldActionPerformed(evt);
            }
        });

        TypeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADULT", "MINOR" }));
        TypeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NameField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TypeBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 273, Short.MAX_VALUE)
                    .addComponent(SeatNumberField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DestinationIDField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LnameField))
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(DestinationIDField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(SeatNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TypeBox, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(NameField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(LnameField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Trip ID", "Seat Number", "Name", "Last Name", " Is Adult "
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
                "Trip ID", "Name", "Departure", "Return"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
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
        jLabel13.setText("Trip ID");

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
        jLabel14.setText("SeatNumber");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SearchField1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(SearchField2))
                .addGap(0, 0, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(UpdateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(DeleteButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SeatNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeatNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeatNumberFieldActionPerformed

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameFieldActionPerformed

    private void LnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LnameFieldActionPerformed

    private void TypeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TypeBoxActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        int selectedRowIndex = jTable2.getSelectedRow();
         DestinationIDField.setText(model.getValueAt(selectedRowIndex ,0 ).toString());

    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();
        DestinationIDField.setText(model.getValueAt(selectedRowIndex ,0 ).toString());
        SeatNumberField.setText(model.getValueAt(selectedRowIndex ,1 ).toString());
        String type = model.getValueAt(selectedRowIndex ,4 ).toString();
        NameField.setText(model.getValueAt(selectedRowIndex ,2 ).toString());
        LnameField.setText(model.getValueAt(selectedRowIndex ,3 ).toString());
        SearchField1.setText(model.getValueAt(selectedRowIndex ,0 ).toString());
        SearchField2.setText(model.getValueAt(selectedRowIndex ,1 ).toString());
        
        for (int i = 0 ; i < TypeBox.getItemCount(); i++){
                    if(TypeBox.getItemAt(i).toString().equalsIgnoreCase( type)){
                        TypeBox.setSelectedIndex(i);
                    }
                }

 
    }//GEN-LAST:event_jTable1MouseClicked

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed

          DestinationIDField.setText("");
            SeatNumberField.setText("");
            NameField.setText("");
            LnameField.setText("");
            SearchField1.setText("");
            SearchField1.setText("");
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void DeleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButton1ActionPerformed
         String search1, search2 ;

         search1 = SearchField1.getText();
        search2 = SearchField2.getText();
 

        try{

            pst= conn.prepareStatement("delete from reservation WHERE res_tr_id =? and res_seatnum =?");
            pst.setString(1, search1);
            pst.setString(2, search2);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "Record Deleted!!");
            jTable1.setModel(new DefaultTableModel(null , new String[]{"Trip ID","Seat Number","Name","Last Name","IS Adult"}));
            table_load();
             DestinationIDField.setText("");
            SeatNumberField.setText("");
            NameField.setText("");
            LnameField.setText("");
            SearchField1.setText("");
            SearchField1.setText("");
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_DeleteButton1ActionPerformed

    private void UpdateButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButton2ActionPerformed

        String res_tr_id ,res_seatnum ,res_name ,res_lname,res_isadult ,search1 , search2 ;
        String tr_maxseats = null;
        res_tr_id = DestinationIDField.getText();
        res_seatnum  = SeatNumberField.getText();
        res_isadult = TypeBox.getSelectedItem().toString();TypeBox.getSelectedItem().toString();
        res_name=   NameField.getText();
        res_lname =  LnameField.getText();
        search1 = SearchField1.getText();
        search2 = SearchField2.getText();
        String sr1 = SearchField1.getText();
      
        
        try{
                pst = conn.prepareStatement("SELECT tr_maxseats from trip WHERE tr_id =?");
                pst.setString(1 , sr1);
                ResultSet rs = pst.executeQuery();
                  if(rs.next() == true)
                   {
                       tr_maxseats  = rs.getString(1);
                   }

               if ( Integer.valueOf(res_seatnum) >  Integer.valueOf(tr_maxseats) ){
                     JOptionPane.showMessageDialog(null , "Seat Number Bigger than the availables");
               }
            pst= conn.prepareStatement("update reservation set res_tr_id=? , res_seatnum=? , res_name =?, res_lname = ? , res_isadult =? WHERE res_tr_id =? and res_seatnum =?");
            pst.setString(1,res_tr_id);
            pst.setString(2,res_seatnum);
            pst.setString(3,res_name);
            pst.setString(4,res_lname);
            pst.setString(5, res_isadult);
            pst.setString(6,search1);
            pst.setString(7,search2);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "Record Updated!!");
            jTable1.setModel(new DefaultTableModel(null , new String[]{"Trip ID","Seat Number","Name","Last Name","IS Adult"}));
            table_load();
            DestinationIDField.setText("");
            SeatNumberField.setText("");
            NameField.setText("");
            LnameField.setText("");
            SearchField1.setText("");
            SearchField1.setText("");
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_UpdateButton2ActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed

        String res_tr_id , res_seatnum ,res_name ,res_lname,res_isadult  ;
         String tr_maxseats = null;
        res_tr_id = DestinationIDField.getText();
        res_seatnum  = SeatNumberField.getText();
        res_isadult = TypeBox.getSelectedItem().toString();TypeBox.getSelectedItem().toString();
        res_name=   NameField.getText();
        res_lname =  LnameField.getText();
         String sr1 = DestinationIDField.getText();
     

        try{
            
            
               pst = conn.prepareStatement("SELECT tr_maxseats from trip WHERE tr_id =?");
                pst.setString(1 , sr1);
                ResultSet rs = pst.executeQuery();
                  if(rs.next() == true)
                   {
                       tr_maxseats  = rs.getString(1);
                   }

               if ( Integer.valueOf(res_seatnum) >  Integer.valueOf(tr_maxseats) ){
                     JOptionPane.showMessageDialog(null , "Seat Number Bigger than the availables");
               }
            

            pst= conn.prepareCall("insert into reservation (res_tr_id,res_seatnum,res_name,res_lname,res_isadult )values(?,?,?,?,?)");
            pst.setString(1,res_tr_id);
            pst.setString(2,res_seatnum);
            pst.setString(3,res_name);
            pst.setString(4,res_lname);
            pst.setString(5,res_isadult);
            pst.executeUpdate();
         
            JOptionPane.showMessageDialog(null , "Record Addedd!!");
            jTable1.setModel(new DefaultTableModel(null , new String[]{"Trip ID","Seat Number","Name","Last Name","IS Adult"}));
            table_load();
            DestinationIDField.setText("");
            SeatNumberField.setText("");
            NameField.setText("");
            LnameField.setText("");
            SearchField1.setText("");
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

    private void SearchField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchField2ActionPerformed

    private void SearchField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchField2KeyReleased

        try{

            String sr1 = SearchField1.getText();
            String sr2 = SearchField2.getText();

            pst = conn.prepareStatement("SELECT ev_tr_id , ev_start, ev_end, ev_descr FROM reservation WHERE ev_tr_id =? and ev_start =?");
            pst.setString(1 , sr1);
            pst.setString(2 , sr2);
            ResultSet rs = pst.executeQuery();

            if(rs.next() == true)
            {
                String res_tr_id  = rs.getString(1);
                String res_seatnum = rs.getString(2);
                String res_name= rs.getString(3);
                String res_lname = rs.getString(4);
                String res_isadult = rs.getString(5);

            DestinationIDField.setText(res_tr_id);
            SeatNumberField.setText(res_seatnum);
            NameField.setText(res_name);
            LnameField.setText(res_lname);
             for (int i = 0 ; i < TypeBox.getItemCount(); i++){
                  if(TypeBox.getItemAt(i).toString().equalsIgnoreCase(res_isadult)){
                   TypeBox.setSelectedIndex(i); 
                   }
                }
            

            }else{

             DestinationIDField.setText("");
            SeatNumberField.setText("");
            NameField.setText("");
            LnameField.setText("");
            SearchField1.setText("");
            SearchField1.setText("");
            }

        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_SearchField2KeyReleased

    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            
                try {
                    new Reservations().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Reservations.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton DeleteButton1;
    private javax.swing.JTextField DestinationIDField;
    private javax.swing.JButton ExitButton;
    private javax.swing.JTextField LnameField;
    private javax.swing.JTextField NameField;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField SearchField1;
    private javax.swing.JTextField SearchField2;
    private javax.swing.JTextField SeatNumberField;
    private javax.swing.JComboBox<String> TypeBox;
    private javax.swing.JButton UpdateButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}

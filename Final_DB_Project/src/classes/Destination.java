package classes;

import static classes.Login.conn;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Destination extends javax.swing.JFrame {

   
    public Destination() throws SQLException {
        initComponents();
        table_load();
        table_load2();
       
    }

    PreparedStatement pst;
 
    
    public void table_load() throws SQLException {
      Statement st = conn.createStatement();
      String table_sql = "SELECT dst_id , dst_name ,dst_dscr ,dst_rtype,dst_language,dst_location FROM destination";
      ResultSet rs = st.executeQuery(table_sql);
      
      while(rs.next()){
          
          String dst_id = String.valueOf(rs.getInt("dst_id"));
          String dst_name= rs.getString("dst_name");
          String dst_dscr = rs.getString("dst_dscr");
          String dst_rtype =  rs.getString("dst_rtype");
          String dst_language =  rs.getString("dst_language");
          String dst_location=  String.valueOf(rs.getInt("dst_location"));
        
          
          String tbData[] = {dst_id , dst_name, dst_dscr , dst_rtype ,dst_language,dst_location};
          
          DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel();
          tblModel.addRow(tbData); 
      }
    }
    
      public void table_load2() throws SQLException {
      Statement st = conn.createStatement();
      String table_sql = "SELECT dst_id , dst_name FROM destination";
      ResultSet rs = st.executeQuery(table_sql);
      
      while(rs.next()){
          
          String dst_id= String.valueOf(rs.getInt("dst_id"));
          String dst_name= rs.getString("dst_name");
 
          String tbData[] = {dst_id , dst_name };

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
        DiscriptionField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        LanguageField = new javax.swing.JTextField();
        NameField = new javax.swing.JTextField();
        LocationField = new javax.swing.JTextField();
        TypeBox = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        SearchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        ExitButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        DeleteButton1 = new javax.swing.JButton();
        UpdateButton2 = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Destination");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Destination", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel5.setText("Discription");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel6.setText("Type");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel7.setText("Language");

        DiscriptionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiscriptionFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel8.setText("Location");

        LanguageField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LanguageFieldActionPerformed(evt);
            }
        });

        LocationField.setEditable(false);
        LocationField.setText("0");
        LocationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocationFieldActionPerformed(evt);
            }
        });

        TypeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LOCAL", "ABROAD" }));
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LocationField)
                    .addComponent(NameField)
                    .addComponent(DiscriptionField)
                    .addComponent(LanguageField)
                    .addComponent(TypeBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(NameField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(DiscriptionField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TypeBox, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(LanguageField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(LocationField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 22))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel10.setText("Destination ID");

        SearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFieldActionPerformed(evt);
            }
        });
        SearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Destination ID", "Name", "Discription", "Type", "Language", "Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
                "Destination ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UpdateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DeleteButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UpdateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DiscriptionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiscriptionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiscriptionFieldActionPerformed

    private void LanguageFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LanguageFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LanguageFieldActionPerformed

    private void LocationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocationFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LocationFieldActionPerformed

    private void TypeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TypeBoxActionPerformed

    private void SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchFieldActionPerformed

    private void SearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFieldKeyReleased

        try{

            String wrk_AT = SearchField.getText();

            pst = conn.prepareStatement("Select dst_name ,dst_dscr ,dst_rtype,dst_language,dst_location FROM destination WHERE dst_id = ?");
            pst.setString(1 , wrk_AT);
            ResultSet rs = pst.executeQuery();

            if(rs.next() == true)
            {

                String dst_name = rs.getString(1);
                String dst_dscr  = rs.getString(2);
                String dst_rtype= rs.getString(3);
                String dst_language = rs.getString(4);
                String dst_location  = rs.getString(5);
          
                NameField.setText(dst_name);
                DiscriptionField.setText( dst_dscr);
                LanguageField.setText(dst_language);
                LocationField.setText(dst_location);
               
                for (int i = 0 ; i < TypeBox.getItemCount(); i++){
                    if(TypeBox.getItemAt(i).equalsIgnoreCase( dst_rtype)){
                        TypeBox.setSelectedIndex(i);
                    }
                }
             
            }else{

                NameField.setText("");
                DiscriptionField.setText("");
                LanguageField.setText("");
                LocationField.setText("0");
                NameField.requestFocus();
            }

        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_SearchFieldKeyReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        int selectedRowIndex = jTable2.getSelectedRow();
         LocationField.setText(model.getValueAt(selectedRowIndex ,0 ).toString());

    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();
        SearchField.setText(model.getValueAt(selectedRowIndex ,0 ).toString());
        NameField.setText(model.getValueAt(selectedRowIndex ,1 ).toString());
        DiscriptionField.setText(model.getValueAt(selectedRowIndex ,2 ).toString());
        String type = model.getValueAt(selectedRowIndex ,3 ).toString();
        LanguageField.setText(model.getValueAt(selectedRowIndex ,4 ).toString());
        String dst_location = model.getValueAt(selectedRowIndex ,5 ).toString();
        
        if ("0".equals(dst_location) ){
            LocationField.setText("0");
           }else if (!"0".equals(dst_location)){
            LocationField.setText(dst_location);
           }
        
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

         NameField.setText("");
         DiscriptionField.setText("");
         LanguageField.setText("");
         LocationField.setText("");
         SearchField.setText("0");
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void DeleteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButton1ActionPerformed
         String search1 ;

        search1 =  SearchField.getText();
 

        try{

            pst= conn.prepareStatement("delete from destination WHERE dst_id =? ");
            pst.setString(1, search1);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "Record Deleted!!");
            jTable1.setModel(new DefaultTableModel(null , new String[]{"Destination ID","Name","Discription","Type","Language","Location"}));
            jTable2.setModel(new DefaultTableModel(null , new String[]{"Destination ID","Name"}));
            table_load();
            table_load2();
            NameField.setText("");
            DiscriptionField.setText("");
            LanguageField.setText("");
            LocationField.setText("0");
            SearchField.setText("");
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_DeleteButton1ActionPerformed

    private void UpdateButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButton2ActionPerformed

        String dst_name ,dst_dscr ,dst_rtype ,dst_language,dst_location ,search1;

        dst_name =NameField.getText();
        dst_dscr  = DiscriptionField.getText();
        dst_rtype = TypeBox.getSelectedItem().toString();TypeBox.getSelectedItem().toString();
        dst_language=   LanguageField.getText();
        dst_location =  LocationField.getText();
        search1 = SearchField.getText();

        try{

            if ("0".equals(dst_location) ){
             pst= conn.prepareStatement("update destination set dst_name=? , dst_dscr =?, dst_rtype = ? , dst_language = ? WHERE  dst_id =?");
            pst.setString(1,dst_name);
            pst.setString(2,dst_dscr);
            pst.setString(3,dst_rtype);
            pst.setString(4,dst_language);
            pst.setString(5,search1);
            pst.executeUpdate();
           }else if (!"0".equals(dst_location)){
            pst= conn.prepareStatement("update destination set dst_name=? , dst_dscr =?, dst_rtype = ? , dst_language = ? ,dst_location = ? WHERE  dst_id =?");
            pst.setString(1,dst_name);
            pst.setString(2,dst_dscr);
            pst.setString(3,dst_rtype);
            pst.setString(4,dst_language);
            pst.setString(5, dst_location);
            pst.setString(6,search1);
            pst.executeUpdate();
           }
  
            JOptionPane.showMessageDialog(null , "Record Updated!!");
           jTable1.setModel(new DefaultTableModel(null , new String[]{"Destination ID","Name","Discription","Type","Language","Location"}));
            jTable2.setModel(new DefaultTableModel(null , new String[]{"Destination ID","Name"}));
            table_load();
            table_load2();
            NameField.setText("");
            DiscriptionField.setText("");
            LanguageField.setText("");
            LocationField.setText("0");
            SearchField.setText("");
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_UpdateButton2ActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed

        String dst_name ,dst_dscr ,dst_rtype ,dst_language,dst_location ;

        dst_name =NameField.getText();
        dst_dscr  = DiscriptionField.getText();
        dst_rtype = TypeBox.getSelectedItem().toString();TypeBox.getSelectedItem().toString();
        dst_language=   LanguageField.getText();
        dst_location =  LocationField.getText();
 

        try{

            if ("0".equals(dst_location) ){
            pst= conn.prepareCall("insert into destination (dst_name,dst_dscr,dst_rtype,dst_language )values(?,?,?,?)");
            pst.setString(1,dst_name);
            pst.setString(2,dst_dscr);
            pst.setString(3,dst_rtype);
            pst.setString(4,dst_language);
            pst.executeUpdate();
            }else if (!"0".equals(dst_location)){
             pst= conn.prepareCall("insert into destination (dst_name,dst_dscr,dst_rtype,dst_language ,dst_location)values(?,?,?,?,?)");
            pst.setString(1,dst_name);
            pst.setString(2,dst_dscr);
            pst.setString(3,dst_rtype);
            pst.setString(4,dst_language);
            pst.setString(5,dst_location);
            pst.executeUpdate();
            }
            JOptionPane.showMessageDialog(null , "Record Addedd!!");
            jTable1.setModel(new DefaultTableModel(null , new String[]{"Destination ID","Name","Discription","Type","Language","Location"}));
            jTable2.setModel(new DefaultTableModel(null , new String[]{"Destination ID","Name"}));
            table_load();
            table_load2();
            NameField.setText("");
            DiscriptionField.setText("");
            LanguageField.setText("");
            LocationField.setText("0");
            SearchField.setText("");
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Destination.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Destination.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Destination.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Destination.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            
                try {
                    new Destination().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Destination.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton DeleteButton1;
    private javax.swing.JTextField DiscriptionField;
    private javax.swing.JButton ExitButton;
    private javax.swing.JTextField LanguageField;
    private javax.swing.JTextField LocationField;
    private javax.swing.JTextField NameField;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField SearchField;
    private javax.swing.JComboBox<String> TypeBox;
    private javax.swing.JButton UpdateButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}

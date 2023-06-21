package classes;

import static classes.Login.conn;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Branches extends javax.swing.JFrame {

    /**
     * Creates new form Branches
     */
    public Branches() throws SQLException {
        initComponents();
        table_load();
        table_load2();
    }
    
    PreparedStatement pst;
    
    public void table_load() throws SQLException {
      Statement st = conn.createStatement();
      String table_sql = "SELECT br_code , br_street , br_num , br_city FROM branch ";
      ResultSet rs = st.executeQuery(table_sql);
      
      while(rs.next()){
          
          String br_code = String.valueOf(rs.getInt("br_code"));
          String br_street= rs.getString("br_street");
          String br_num = String.valueOf(rs.getInt("br_num"));
          String br_city = rs.getString("br_city");

          String tbData[] = {br_code , br_street, br_num , br_city };
          
          DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel();
          tblModel.addRow(tbData); 
      }
    }
    
    public void table_load2() throws SQLException {
      Statement st = conn.createStatement();
      String table_sql = "SELECT ph_br_code, ph_number FROM phones  ";
      ResultSet rs = st.executeQuery(table_sql);
      
      while(rs.next()){
          
          String br_code = String.valueOf(rs.getInt("ph_br_code"));
          String ph_number = rs.getString("ph_number");
          
          String tbData[] = {br_code ,ph_number};
          
          DefaultTableModel tblModel = (DefaultTableModel)jTable2.getModel();
          tblModel.addRow(tbData); 
      }
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        StreetField = new javax.swing.JTextField();
        NumberField = new javax.swing.JTextField();
        CityField = new javax.swing.JTextField();
        PhoneField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SearchField = new javax.swing.JTextField();
        NewPhoneField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        ClearButton = new javax.swing.JToggleButton();
        ExitButton = new javax.swing.JToggleButton();
        DeleteButton = new javax.swing.JToggleButton();
        SaveButton = new javax.swing.JToggleButton();
        UpdateButton = new javax.swing.JToggleButton();
        AddPhoneButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Branches");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Branch", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 28))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setText("Street Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel3.setText("Phone");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel4.setText("Street Number");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel5.setText("City");

        StreetField.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StreetField, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(NumberField)
                    .addComponent(CityField)
                    .addComponent(PhoneField))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StreetField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(NumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CityField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(PhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search / Add Phone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel6.setText("New Phone");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel7.setText("Branch Code");

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

        NewPhoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewPhoneFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NewPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(NewPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Branch Code", "Street Name", "Street Number", "City"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
                "Branch Code", "Phone"
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

        ClearButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
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

        DeleteButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        SaveButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        UpdateButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        AddPhoneButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        AddPhoneButton.setText("Add Phone");
        AddPhoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPhoneButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddPhoneButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AddPhoneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewPhoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewPhoneFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewPhoneFieldActionPerformed

    private void SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchFieldActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();
        SearchField.setText(model.getValueAt(selectedRowIndex ,0 ).toString());
        StreetField.setText(model.getValueAt(selectedRowIndex ,1 ).toString());
        NumberField.setText(model.getValueAt(selectedRowIndex ,2 ).toString());
        CityField.setText(model.getValueAt(selectedRowIndex ,3 ).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        int selectedRowIndex = jTable2.getSelectedRow();
        SearchField.setText(model.getValueAt(selectedRowIndex ,0 ).toString());
        NewPhoneField.setText(model.getValueAt(selectedRowIndex ,1).toString());
        PhoneField.setText(model.getValueAt(selectedRowIndex ,1).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        SearchField.setText("");
        StreetField.setText("");
        NumberField.setText("");
        CityField.setText("");
        NewPhoneField.setText("");
        PhoneField.setText("");
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        String srid;

        srid = SearchField.getText();

        try{
            pst= conn.prepareStatement("delete from branch WHERE br_code =?");
            pst.setString(1,srid);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "Record Deleted!!");
            jTable1.setModel(new DefaultTableModel(null , new String[]{"Branch Code", "Street Name","Street Number","City"}));
            jTable2.setModel(new DefaultTableModel(null , new String[]{"Branch Code", "Phones"}));
            table_load();
            table_load2();
            SearchField.setText("");
            StreetField.setText("");
            NumberField.setText("");
            CityField.setText("");
            NewPhoneField.setText("");
            PhoneField.setText("");
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
         
        String   br_street , br_num , br_city , ph_number;

          br_street= StreetField.getText();
          br_num = NumberField.getText();
          br_city = CityField.getText();
          ph_number = PhoneField.getText();
          String br_code = null;
          
          try{

            pst= conn.prepareStatement("insert into branch(br_street,br_num,br_city)values(?,?,?)");
            pst.setString(1, br_street);
            pst.setString(2,  br_num);
            pst.setString(3,br_city);
            pst.executeUpdate();
            Statement st = conn.createStatement();
            String table_sql = "SELECT br_code FROM branch ";
            ResultSet rs = st.executeQuery(table_sql);
            while(rs.next()){
             br_code = String.valueOf(rs.getInt("br_code"));
           
            }
            
            pst= conn.prepareStatement("insert into phones (ph_br_code,ph_number)values(?,?)");
            pst.setString(1,br_code);
            pst.setString(2,ph_number);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null , "Record Addedd!!");
            jTable1.setModel(new DefaultTableModel(null , new String[]{"Branch Code", "Street Name","Street Number","City"}));
            jTable2.setModel(new DefaultTableModel(null , new String[]{"Branch Code", "Phones"}));
            table_load();
            table_load2();
            SearchField.setText("");
            StreetField.setText("");
            NumberField.setText("");
            CityField.setText("");
            NewPhoneField.setText("");
            PhoneField.setText("");
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
          
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
         
        String   br_street , br_num , br_city , ph_number ,sear , search_phone;

          br_street= StreetField.getText();
          br_num = NumberField.getText();
          br_city = CityField.getText();
          sear = SearchField.getText();
          ph_number = PhoneField.getText();
          search_phone = NewPhoneField.getText();
          
           try{
            pst= conn.prepareStatement("update branch set  br_street = ? , br_num = ? , br_city = ? WHERE br_code =?");
            pst.setString(1,br_street);
            pst.setString(2,br_num);
            pst.setString(3,br_city);
            pst.setString(4,sear);
            pst.executeUpdate();
            pst= conn.prepareStatement("update phones set ph_number=?  WHERE ph_br_code =? AND ph_number=?");
            pst.setString(1,ph_number);
            pst.setString(2,sear);
            pst.setString(3,search_phone);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "Record Update!!");
            jTable1.setModel(new DefaultTableModel(null , new String[]{"Branch Code", "Street Name","Street Number","City"}));
            jTable2.setModel(new DefaultTableModel(null , new String[]{"Branch Code", "Phones"}));
            table_load();
            table_load2();
            SearchField.setText("");
            StreetField.setText("");
            NumberField.setText("");
            CityField.setText("");
            NewPhoneField.setText("");
            PhoneField.setText("");
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
          
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void SearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFieldKeyReleased
        try{

            String  br_code = SearchField.getText();
            
            pst = conn.prepareStatement("SELECT br_code , br_street , br_num , br_city ,ph_number FROM branch INNER JOIN phones ON br_code = ph_br_code WHERE br_code = ?");
            pst.setString(1 , br_code);
            ResultSet rs = pst.executeQuery();
            
             pst = conn.prepareStatement("SELECT br_code , br_street , br_num , br_city  FROM branch WHERE br_code = ?");
             pst.setString(1 , br_code);
             ResultSet rs1  = pst.executeQuery();
           

            if(rs.next() == true )
            {
                String code = rs.getString(1);
                String street = rs.getString(2);
                String num = rs.getString(3);
                String city = rs.getString(4);
                String phone = rs.getString(5);
                SearchField.setText(code);
                StreetField.setText(street);
                NumberField.setText(num);
                CityField.setText(city);
                PhoneField.setText(phone);
                NewPhoneField.setText(phone);

            }else if (rs1.next() == true){ 

                String code = rs1.getString(1);
                String street = rs1.getString(2);
                String num = rs1.getString(3);
                String city = rs1.getString(4);
                SearchField.setText(code);
                StreetField.setText(street);
                NumberField.setText(num);
                CityField.setText(city);
                NewPhoneField.setText("");
                 PhoneField.setText("");
            }else
            {
             SearchField.setText("");
             StreetField.setText("");
             NumberField.setText("");
             CityField.setText("");
             NewPhoneField.setText("");
            PhoneField.setText("");
            }
         
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_SearchFieldKeyReleased

    private void AddPhoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPhoneButtonActionPerformed
         String   br_code, ph_number;

          ph_number = NewPhoneField.getText();
          br_code = SearchField.getText();
          
          try{

      
            
            pst= conn.prepareStatement("insert into phones (ph_br_code,ph_number)values(?,?)");
            pst.setString(1,br_code);
            pst.setString(2,ph_number);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null , "Phone Addedd!!");
            jTable1.setModel(new DefaultTableModel(null , new String[]{"Branch Code", "Street Name","Street Number","City"}));
            jTable2.setModel(new DefaultTableModel(null , new String[]{"Branch Code", "Phones"}));
            table_load();
            table_load2();
            SearchField.setText("");
            StreetField.setText("");
            NumberField.setText("");
            CityField.setText("");
            NewPhoneField.setText("");
            PhoneField.setText("");
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_AddPhoneButtonActionPerformed

   
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
            java.util.logging.Logger.getLogger(Branches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Branches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Branches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Branches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Branches().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Branches.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton AddPhoneButton;
    private javax.swing.JTextField CityField;
    private javax.swing.JToggleButton ClearButton;
    private javax.swing.JToggleButton DeleteButton;
    private javax.swing.JToggleButton ExitButton;
    private javax.swing.JTextField NewPhoneField;
    private javax.swing.JTextField NumberField;
    private javax.swing.JTextField PhoneField;
    private javax.swing.JToggleButton SaveButton;
    private javax.swing.JTextField SearchField;
    private javax.swing.JTextField StreetField;
    private javax.swing.JToggleButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

    private boolean notNull(ResultSet rs1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

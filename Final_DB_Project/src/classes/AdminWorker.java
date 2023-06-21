package classes;


import static classes.Login.conn;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class AdminWorker extends javax.swing.JFrame {


    public AdminWorker() throws SQLException {
        initComponents();
        table_load();
        table_load_Branches();
    }
    
    PreparedStatement pst;
    CallableStatement cs;
 
    
    public void table_load() throws SQLException {
      Statement st = conn.createStatement();
      String table_sql = "SELECT wrk_AT , wrk_name,wrk_lname,wrk_salary,wrk_br_code,adm_type,adm_diploma FROM worker INNER JOIN manages ON  mng_adm_AT = wrk_AT INNER JOIN admin ON adm_AT =  wrk_AT";
      ResultSet rs = st.executeQuery(table_sql);
      
      while(rs.next()){
          
          String at = rs.getString("wrk_AT");
          String name = rs.getString("wrk_name");
          String laname = rs.getString("wrk_lname");
          String salary = String.valueOf(rs.getFloat("wrk_salary"));
          String br_code = String.valueOf(rs.getInt("wrk_br_code"));
          String type = rs.getString("adm_type");
          String diploma = rs.getString("adm_diploma");
          
          String tbData[] = {at , name, laname , salary , br_code , diploma , type };
          
          DefaultTableModel tblModel = (DefaultTableModel)jTable2.getModel();
          tblModel.addRow(tbData); 
      }
    }
    
    public void table_load_Branches() throws SQLException {
      Statement st = conn.createStatement();
      String table_sql = "SELECT br_code FROM branch";
      ResultSet rs = st.executeQuery(table_sql);
      
      while(rs.next()){
          
          String br = rs.getString("br_code"); 
          String tbData[] = {br};
          DefaultTableModel tblModel = (DefaultTableModel)jTable4.getModel();
          tblModel.addRow(tbData); 
      }
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jToggleButton1 = new javax.swing.JToggleButton();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        LastNameField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        SalaryField = new javax.swing.JTextField();
        NameField = new javax.swing.JTextField();
        IdField = new javax.swing.JTextField();
        BranchField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        RoleBox = new javax.swing.JComboBox<>();
        DiplomaField = new javax.swing.JTextField();
        SaveButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        SearchField = new javax.swing.JTextField();
        DeleteButton = new javax.swing.JButton();
        UpdateButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();

        jLabel2.setText("jLabel2");

        jToggleButton1.setText("jToggleButton1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Admin Worker");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Worker", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel5.setText("Last Name");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel6.setText("ID Number");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel7.setText("Salary");

        LastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel8.setText("Branch Code");

        SalaryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalaryFieldActionPerformed(evt);
            }
        });

        IdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdFieldActionPerformed(evt);
            }
        });

        BranchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BranchFieldActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel9.setText("Diploma");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel11.setText("Role");

        RoleBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LOGISTICS", "ADMINISTRATIVE", "ACCOUNTING" }));
        RoleBox.setSelectedItem(jTable2);
        RoleBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoleBoxActionPerformed(evt);
            }
        });

        DiplomaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiplomaFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NameField)
                    .addComponent(IdField)
                    .addComponent(SalaryField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BranchField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DiplomaField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(RoleBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 350, Short.MAX_VALUE)
                    .addComponent(LastNameField))
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(NameField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(LastNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(IdField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(SalaryField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(BranchField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(DiplomaField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RoleBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        SaveButton.setFont(new java.awt.Font("Segoe UI", 0, 27)); // NOI18N
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 22))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel10.setText("ID Number");

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        DeleteButton.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        UpdateButton2.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        UpdateButton2.setText("Update");
        UpdateButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButton2ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Worker AT", "Name", "Last Name", "Salary", "Branch Code", "Diploma", "Admin Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        jTable4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Branches"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(UpdateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addGap(26, 26, 26))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UpdateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SaveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        
        String name , lname , id , salary , brcode ,diploma , role ;
        
        name = NameField.getText();
        lname =LastNameField.getText();
        id = IdField.getText();
        salary = SalaryField.getText();
        brcode = BranchField.getText();
        diploma = DiplomaField.getText();
        role = RoleBox.getSelectedItem().toString();
        
        try{
          
            pst= conn.prepareStatement("insert into worker(wrk_AT,wrk_name,wrk_lname,wrk_salary,wrk_br_code)values(?,?,?,?,?)");
            pst.setString(1,id);
            pst.setString(2,name);
            pst.setString(3,lname);
            pst.setString(4,salary);
            pst.setString(5,brcode);
            pst.executeUpdate();
            pst= conn.prepareStatement("insert into admin (adm_AT,adm_type,adm_diploma)values(?,?,?)");
            pst.setString(1,id);
            pst.setString(2,role);
            pst.setString(3,diploma);
            pst.executeUpdate();
            pst= conn.prepareStatement("insert into manages (mng_adm_AT,mng_br_code)values(?,?)");
            pst.setString(1,id);
            pst.setString(2,brcode);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "Record Addedd!!");
            jTable2.setModel(new DefaultTableModel(null , new String[]{"Worker AT", "Name","Last Name","Salary","Branch Code","Admin Type","Diploma"}));
            table_load();
            NameField.setText("");
            LastNameField.setText("");
            IdField.setText("");
            SalaryField.setText("");
            BranchField.setText("");
            DiplomaField.setText("");
            NameField.requestFocus();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }

    }//GEN-LAST:event_SaveButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
       
            NameField.setText("");
            LastNameField.setText("");
            IdField.setText("");
            SalaryField.setText("");
            BranchField.setText(""); 
            DiplomaField.setText("");
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchFieldActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

      DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
      int selectedRowIndex = jTable2.getSelectedRow(); 
      IdField.setText(model.getValueAt(selectedRowIndex ,0 ).toString()); 
      NameField.setText(model.getValueAt(selectedRowIndex ,1 ).toString());
      LastNameField.setText(model.getValueAt(selectedRowIndex ,2 ).toString()); 
      SalaryField.setText(model.getValueAt(selectedRowIndex ,3 ).toString()); 
      BranchField.setText(model.getValueAt(selectedRowIndex ,4 ).toString()); 
      DiplomaField.setText(model.getValueAt(selectedRowIndex ,5).toString()); 
      String combosub = model.getValueAt(selectedRowIndex ,6).toString(); 
      for (int i = 0 ; i < RoleBox.getItemCount(); i++){
         if(RoleBox.getItemAt(i).toString().equalsIgnoreCase(combosub)){
         RoleBox.setSelectedIndex(i); 
          }
      }
      SearchField.setText(model.getValueAt(selectedRowIndex ,0 ).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void UpdateButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButton2ActionPerformed
        
        String name , lname , id , salary , brcode ,srid ,diploma ,role;
        
        name = NameField.getText();
        lname =LastNameField.getText();
        id = IdField.getText();
        salary = SalaryField.getText();
        brcode = BranchField.getText();
        srid = SearchField.getText();
        diploma = DiplomaField.getText();
        role = RoleBox.getSelectedItem().toString();
        
        try{
          
            pst= conn.prepareStatement("update worker set wrk_AT=? ,wrk_name=? ,wrk_lname=? ,wrk_salary=?, wrk_br_code=? WHERE wrk_AT =?");
            pst.setString(1,id);
            pst.setString(2,name);
            pst.setString(3,lname);
            pst.setString(4,salary);
            pst.setString(5,brcode);
            pst.setString(6,srid);
            pst.executeUpdate();
            pst= conn.prepareStatement("update admin set adm_type =? ,adm_diploma = ? WHERE adm_AT =?");
            pst.setString(1,role);
            pst.setString(2,diploma);
            pst.setString(3,srid);
            pst.executeUpdate();
            pst= conn.prepareStatement("update manages set mng_br_code = ? WHERE mng_adm_AT =?");
            pst.setString(1,brcode);
            pst.setString(2,srid);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "Record Update!!");
            jTable2.setModel(new DefaultTableModel(null , new String[]{"Worker AT", "Name","Last Name","Salary","Branch Code","Admin Type","Diploma"}));
            table_load();
            NameField.setText("");
            LastNameField.setText("");
            IdField.setText("");
            SalaryField.setText("");
            BranchField.setText(""); 
            DiplomaField.setText(""); 
            NameField.requestFocus();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_UpdateButton2ActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
      DefaultTableModel model = (DefaultTableModel)jTable4.getModel();
      int selectedRowIndex = jTable4.getSelectedRow(); 
      BranchField.setText(model.getValueAt(selectedRowIndex ,0 ).toString()); 
    }//GEN-LAST:event_jTable4MouseClicked

    private void SearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFieldKeyReleased
        
        try{
        
             String wrk_AT = SearchField.getText();
             
             pst = conn.prepareStatement("SELECT wrk_AT , wrk_name,wrk_lname,wrk_salary,wrk_br_code,adm_type,adm_diploma FROM worker INNER JOIN manages ON  mng_adm_AT = wrk_AT INNER JOIN admin ON adm_AT =  wrk_AT WHERE wrk_AT = ?");
             pst.setString(1 , wrk_AT);
             ResultSet rs = pst.executeQuery();
             
             if(rs.next() == true)
             {
                String AT = rs.getString(1);
                String name = rs.getString(2);
                String lname = rs.getString(3);
                String salary = rs.getString(4);
                String code = rs.getString(5);
                String type = rs.getString(6);
                String diploma = rs.getString(7);
                
                NameField.setText(name);
                LastNameField.setText(lname);
                IdField.setText(AT);
                SalaryField.setText(salary);
                BranchField.setText(code);
                DiplomaField.setText(diploma); 
                for (int i = 0 ; i < RoleBox.getItemCount(); i++){
                   if(RoleBox.getItemAt(i).toString().equalsIgnoreCase(type)){
                    RoleBox.setSelectedIndex(i); 
                   }
                 }  
                }else{
             
                NameField.setText("");
                LastNameField.setText("");
                IdField.setText("");
                SalaryField.setText("");
                BranchField.setText("");
                DiplomaField.setText(""); 
           
              }
    
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_SearchFieldKeyReleased

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        String name , lname;

        name = NameField.getText();
        lname = LastNameField.getText();

        try{

            cs= conn.prepareCall("{ call delete_worker(?,?) }");
            cs.setString(1,name);
            cs.setString(2,lname);
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null , "Record Deleted!!");
            jTable2.setModel(new DefaultTableModel(null , new String[]{"Worker AT", "Name","Last Name","Salary","Branch Code","Admin Type","Diploma"}));
            table_load();
            NameField.setText("");
            LastNameField.setText("");
            IdField.setText("");
            SalaryField.setText("");
            BranchField.setText(""); 
            DiplomaField.setText(""); 
            SearchField.setText("");
            NameField.requestFocus();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void RoleBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoleBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoleBoxActionPerformed

    private void BranchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BranchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BranchFieldActionPerformed

    private void IdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdFieldActionPerformed

    private void SalaryFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaryFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalaryFieldActionPerformed

    private void LastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameFieldActionPerformed

    private void DiplomaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiplomaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiplomaFieldActionPerformed

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
            java.util.logging.Logger.getLogger(AdminWorker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminWorker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminWorker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminWorker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AdminWorker().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AdminWorker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BranchField;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField DiplomaField;
    private javax.swing.JButton ExitButton;
    private javax.swing.JTextField IdField;
    private javax.swing.JTextField LastNameField;
    private javax.swing.JTextField NameField;
    private javax.swing.JComboBox<String> RoleBox;
    private javax.swing.JTextField SalaryField;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField SearchField;
    private javax.swing.JButton UpdateButton2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}

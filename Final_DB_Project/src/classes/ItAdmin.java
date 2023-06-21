
package classes;

import static classes.Login.conn;
import static classes.Login.login;
import static classes.Menu.menu;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ItAdmin extends javax.swing.JFrame {
    
    //private Connection conn;
    private DefaultTableModel tmodel;
    private DefaultTableModel branch_tmodel;
    
    
    public ItAdmin() {
        initComponents();
        tmodel = (DefaultTableModel) jTable.getModel();
        branch_tmodel = (DefaultTableModel) jTable.getModel();
        selectAll();
        tableLoadBranches();
    }

    private void selectAll(){
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT wrk_AT,wrk_name,wrk_lname,wrk_salary,wrk_br_code, " +
                                            "it_password,it_start_date,it_end_date,Insert_priv FROM worker " +
                                            "INNER JOIN it_admin ON it_at = wrk_AT " +
                                            "INNER JOIN mysql.db ON wrk_lname = User");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            Object[] row;
            while (rs.next()) {
                row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getString(i);
                }
                tmodel.addRow(row);
            }
            
            rs.close();
            stmt.close();
            
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void tableLoadBranches(){
        try {
            Statement st = conn.createStatement();
            String table_sql = "SELECT br_code FROM branch";
            ResultSet rs = st.executeQuery(table_sql);
            
            while(rs.next()){
                
                String br = rs.getString("br_code");
                String tbData[] = {br};
                DefaultTableModel tblModel = (DefaultTableModel)jTable4.getModel();
                tblModel.addRow(tbData);
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  
    private int insertItAdmin() throws SQLException{
        try {
            boolean userCreated = createUser();
            if(userCreated==false){
                return 1;
            }
            
            String sql = "INSERT INTO worker(wrk_AT,wrk_name,wrk_lname,wrk_salary,wrk_br_code)"
                        + "VALUES(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,idField.getText());
            stmt.setString(2,nameField.getText());
            stmt.setString(3,lastNameField.getText());
            float salaryValue = Float.parseFloat(salaryField.getText());
            stmt.setFloat(4, salaryValue);
            int brCodeValue = Integer.parseInt(branchField.getText());
            stmt.setInt(5,brCodeValue);
            
            stmt.executeUpdate();
            
            //an exw keno to field password kalw synartisei pou kanei insert tin default timi password
            String passwordValue = passwordField.getText();
            if(passwordValue.isEmpty()){
                insertItAdminDefPass();
                return 0;
            }
            
            sql = "INSERT INTO it_admin(it_at,it_password,it_start_date,it_end_date)VALUES(?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            
            String endDateValue = endDateField.getText();
            stmt.setString(1, idField.getText());
            stmt.setString(2, passwordValue);
            stmt.setString(3, startDateField.getText());
            if(endDateValue.isEmpty()){
                stmt.setObject(4,null);
            }
            else{
                stmt.setString(4, endDateValue);
            }
            
            stmt.executeUpdate();
            
            stmt.close();
            
        }catch(SQLException e) {
            e.printStackTrace();
            //mporei na dimiourgithei o user alla na yparxei provlima stin dimiourgia worker i it_admin opote 
            //diagrafw ton user pou eixe dimiourgithei
            String username = lastNameField.getText();
            PreparedStatement stmt= conn.prepareStatement("drop user ?@localhost");
            stmt.setString(1,username);
            stmt.execute();
            
            stmt = conn.prepareStatement("delete from mysql.db WHERE User = ?");
            stmt.setString(1, username);
            stmt.executeUpdate();
            return 1;
        }
        catch(NumberFormatException e){
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
    
    private void insertItAdminDefPass() throws SQLException{
        try {
            String sql = "INSERT INTO it_admin(it_at,it_password,it_start_date,it_end_date)VALUES(?,DEFAULT,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt = conn.prepareStatement(sql);
            
            String endDateValue = endDateField.getText();
            stmt.setString(1, idField.getText());
            stmt.setString(2, startDateField.getText());
            if(endDateValue.isEmpty()){
                stmt.setObject(3,null);
            }
            else{
                stmt.setString(3, endDateValue);
            }
            
            stmt.executeUpdate();
            
            stmt.close();
            
        }catch(SQLException e) {
            e.printStackTrace();
            String username = lastNameField.getText();
            PreparedStatement stmt= conn.prepareStatement("drop user ?@localhost");
            stmt.setString(1,username);
            stmt.execute();
            
            stmt = conn.prepareStatement("delete from mysql.db WHERE User = ?");
            stmt.setString(1, username);
            stmt.executeUpdate();
        }
    }
    
    private boolean createUser(){
        try{            
            String priv = (String)privilegesBox.getSelectedItem();
            CallableStatement stmt;
            
            if(priv.equals("Select Privileges")){
                stmt = conn.prepareCall("{call create_select_user(?, ?)}");
            }
            else{
                stmt = conn.prepareCall("{call create_user(?, ?)}");
            }
            
            String username = lastNameField.getText();
            
            String password = passwordField.getText();
            if(password.isEmpty()){
                password = "password";
            }
            
            //set procedure input args
            stmt.setString(1, username); 
            stmt.setString(2, password); 

            //execute procedure
            stmt.execute();
            
            //close the resources
            stmt.close();
 
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    private void clearTable(DefaultTableModel model){
        while(model.getRowCount()>0) {
            model.removeRow(0);
        }
    }
    
    private int deleteItAdmin(){
        try{
            //den mporw na diagrapsw ton user me ton opoio exw syndethei
            if(login.username.equals(lastNameField.getText())){
                return 1;
            }
            
            String username = lastNameField.getText();
            PreparedStatement stmt= conn.prepareStatement("drop user ?@localhost");
            stmt.setString(1,username);
            
            stmt.execute();
            
            stmt = conn.prepareStatement("delete from worker WHERE wrk_AT = ?");
            
            String at = idField.getText();
            stmt.setString(1, at);

            stmt.executeUpdate();
            
            stmt = conn.prepareStatement("delete from mysql.db WHERE User = ?");
            
            stmt.setString(1, username);

            stmt.executeUpdate();
            
            nameField.setText("");
            lastNameField.setText("");
            idField.setText("");
            salaryField.setText("");
            branchField.setText("");
            passwordField.setText("");
            startDateField.setText("");
            endDateField.setText("");
        }catch(SQLException e){
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        salaryLabel = new javax.swing.JLabel();
        branchCodeLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        startDateLabel = new javax.swing.JLabel();
        endDateLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        salaryField = new javax.swing.JTextField();
        idField = new javax.swing.JTextField();
        branchField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        startDateField = new javax.swing.JTextField();
        endDateField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        privilegesLabel = new javax.swing.JLabel();
        privilegesBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        selectAllButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("IT Admin ");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Worker", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N

        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        nameLabel.setText("Name");

        lastNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lastNameLabel.setText("Last Name");

        idLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        idLabel.setText("ID Number");

        salaryLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        salaryLabel.setText("Salary");

        branchCodeLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        branchCodeLabel.setText("Branch Code");

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        passwordLabel.setText("Password");

        startDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        startDateLabel.setText("Start Date");

        endDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        endDateLabel.setText("End Date");

        lastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameFieldActionPerformed(evt);
            }
        });

        salaryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryFieldActionPerformed(evt);
            }
        });

        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });

        branchField.setEditable(false);
        branchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchFieldActionPerformed(evt);
            }
        });

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        startDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDateFieldActionPerformed(evt);
            }
        });

        endDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endDateFieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("(YYYY-MM-DD HH:MM:SS)");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("(YYYY-MM-DD HH:MM:SS)");

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("leave empty for default value");

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("leave empty for default value");

        privilegesLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        privilegesLabel.setText("Privileges");

        privilegesBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Privileges", "Select Privileges" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(salaryField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(startDateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lastNameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(branchCodeLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(endDateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(salaryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(privilegesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastNameField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(branchField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordField)
                            .addComponent(startDateField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(endDateField)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(0, 90, Short.MAX_VALUE))
                            .addComponent(privilegesBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameField))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idField))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salaryLabel)
                    .addComponent(salaryField))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(branchCodeLabel)
                    .addComponent(branchField))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField))
                .addGap(3, 3, 3)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDateLabel)
                    .addComponent(startDateField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(endDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(privilegesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(privilegesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Worker AT", "Name", "Last Name", "Salary", "Branch Code", "Password", "Start Date", "End Date", "All Privileges"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        selectAllButton.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        selectAllButton.setText("Show All");
        selectAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        saveButton.setText("Insert");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(945, 945, 945))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(selectAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1)))
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(selectAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameFieldActionPerformed

    private void salaryFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryFieldActionPerformed

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void branchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_branchFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void startDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startDateFieldActionPerformed

    private void endDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endDateFieldActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        int selectedRowIndex = jTable.getSelectedRow();
        idField.setText(tmodel.getValueAt(selectedRowIndex ,0 ).toString());
        nameField.setText(tmodel.getValueAt(selectedRowIndex ,1 ).toString());
        lastNameField.setText(tmodel.getValueAt(selectedRowIndex ,2 ).toString());
        salaryField.setText(tmodel.getValueAt(selectedRowIndex ,3 ).toString());
        branchField.setText(tmodel.getValueAt(selectedRowIndex ,4 ).toString());
        passwordField.setText(tmodel.getValueAt(selectedRowIndex ,5).toString());
        startDateField.setText(tmodel.getValueAt(selectedRowIndex ,6).toString());
        
        try{
            endDateField.setText(tmodel.getValueAt(selectedRowIndex ,7 ).toString());
        }
        catch(NullPointerException e){
            endDateField.setText("");
        }
        
        if(tmodel.getValueAt(selectedRowIndex ,8).toString().equals("Y")){
            privilegesBox.setSelectedItem("All Privileges");
        }
        else{
            privilegesBox.setSelectedItem("Select Privileges");
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        clearTable(tmodel);
        try {
            insertItAdmin();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        selectAll();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        //clear text fields
         nameField.setText("");
         lastNameField.setText("");
         idField.setText("");
         salaryField.setText("");
         branchField.setText("");
         passwordField.setText("");
         startDateField.setText("");
         endDateField.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void selectAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllButtonActionPerformed
        clearTable(tmodel);
        selectAll();
    }//GEN-LAST:event_selectAllButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        clearTable(tmodel);
        deleteItAdmin();
        selectAll();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        menu.requestFocus();
    }//GEN-LAST:event_backButtonActionPerformed

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable4.getModel();
        int selectedRowIndex = jTable4.getSelectedRow();
        branchField.setText(model.getValueAt(selectedRowIndex ,0 ).toString());
    }//GEN-LAST:event_jTable4MouseClicked

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
            java.util.logging.Logger.getLogger(ItAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel branchCodeLabel;
    private javax.swing.JTextField branchField;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField endDateField;
    private javax.swing.JLabel endDateLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JComboBox<String> privilegesBox;
    private javax.swing.JLabel privilegesLabel;
    private javax.swing.JTextField salaryField;
    private javax.swing.JLabel salaryLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton selectAllButton;
    private javax.swing.JTextField startDateField;
    private javax.swing.JLabel startDateLabel;
    // End of variables declaration//GEN-END:variables
}

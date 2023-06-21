package classes;

import static classes.Login.conn;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TripEvent extends javax.swing.JFrame {


    public TripEvent() throws SQLException {
        initComponents();
        table_load();
        table_load_Branches();   
    }
    
    PreparedStatement pst;
    PreparedStatement pst1;
    PreparedStatement pst2;
    CallableStatement cs;
    
    public void table_load() throws SQLException {
      Statement st = conn.createStatement();
      String table_sql = "SELECT * FROM trip";
      ResultSet rs = st.executeQuery(table_sql);
      
      while(rs.next()){
          
          String tr_id= String.valueOf(rs.getInt("tr_id"));
          String tr_departure = rs.getString("tr_departure");
          String tr_return = rs.getString("tr_return");
          String tr_maxseats = String.valueOf(rs.getInt("tr_maxseats"));
          String cost = String.valueOf(rs.getFloat("tr_cost"));
          String tr_br_code = String.valueOf(rs.getInt("tr_br_code"));
          String tr_gui_AT = rs.getString("tr_gui_AT");
          String tr_drv_AT = rs.getString("tr_drv_AT");
         
          String tbData[] = {tr_id , tr_departure, tr_return, tr_maxseats , cost , tr_br_code,  tr_gui_AT ,tr_drv_AT };
          
          DefaultTableModel tblModel = (DefaultTableModel)jTable2.getModel();
          tblModel.addRow(tbData); 
      }
    }
    
    public void table_loadDriver(String bf) throws SQLException {
      pst1 = conn.prepareStatement("SELECT wrk_AT ,wrk_name,wrk_lname,wrk_br_code, drv_route FROM worker INNER JOIN driver ON drv_AT = wrk_AT WHERE wrk_br_code =?");
      pst1.setString(1,bf);
      ResultSet rs = pst1.executeQuery();
      
      while(rs.next()){
          
          String at= rs.getString("wrk_AT");
          String name = rs.getString("wrk_name");
          String laname = rs.getString("wrk_lname");
          String code = String.valueOf(rs.getInt("wrk_br_code"));
          String route = rs.getString("drv_route");
         
          String tbData[] = {at,name,laname,code,route};
          
          DefaultTableModel tblModel = (DefaultTableModel)jTabledriver.getModel();
          tblModel.addRow(tbData); 
      }
    }
    
    public void table_loadGuide(String bf) throws SQLException {
      pst2 = conn.prepareStatement( "SELECT wrk_AT ,wrk_name,wrk_lname,wrk_br_code, lng_language FROM worker INNER JOIN languages ON lng_gui_AT = wrk_AT WHERE wrk_br_code =?");
      pst2.setString(1,bf);
      ResultSet rs = pst2.executeQuery();
  
      while(rs.next()){
          
          String at= rs.getString("wrk_AT");
          String name = rs.getString("wrk_name");
          String laname = rs.getString("wrk_lname");
          String code = String.valueOf(rs.getInt("wrk_br_code"));
          String route =rs.getString("lng_language");
         
          String tbData[] = {at,name,laname,code,route};
          
          DefaultTableModel tblModel = (DefaultTableModel)jTableguide.getModel();
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
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ReturnField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        CostField = new javax.swing.JTextField();
        DepartureField = new javax.swing.JTextField();
        SeatsField = new javax.swing.JTextField();
        BranchField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        DriverATField = new javax.swing.JTextField();
        GuideATField = new javax.swing.JTextField();
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
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableguide = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTabledriver = new javax.swing.JTable();
        AdddEventButton = new javax.swing.JButton();

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

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable5);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTable6);

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTable7);

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(jTable8);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Trip & Events");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Trip", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel4.setText("Trip   Departure");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel5.setText("Trip   Return");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel6.setText("Max  Seats");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel7.setText("Cost");

        ReturnField.setText("YYY-MM-DD HH:MM:SS");
        ReturnField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel8.setText("Branch Code");

        CostField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CostFieldActionPerformed(evt);
            }
        });

        DepartureField.setText("YYY-MM-DD HH:MM:SS");
        DepartureField.setToolTipText("");
        DepartureField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartureFieldActionPerformed(evt);
            }
        });

        SeatsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeatsFieldActionPerformed(evt);
            }
        });

        BranchField.setEditable(false);
        BranchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BranchFieldActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel9.setText("Guide AT");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel11.setText("Driver AT");

        DriverATField.setEditable(false);
        DriverATField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DriverATFieldActionPerformed(evt);
            }
        });

        GuideATField.setEditable(false);
        GuideATField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuideATFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(SeatsField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(CostField)
                                    .addComponent(DepartureField, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                    .addComponent(ReturnField)
                                    .addComponent(BranchField)
                                    .addComponent(GuideATField)
                                    .addComponent(DriverATField))))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(DepartureField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ReturnField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(SeatsField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(CostField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(BranchField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(GuideATField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DriverATField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(15, Short.MAX_VALUE))
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
        jLabel10.setText("Trip ID");

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
                .addGap(18, 18, 18)
                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
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
                "Trip ID", "Departure", "Return", "Max Seats", "Cost", "Branch Code", "Guide AT", "Driver AT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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

        jTableguide.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Guide AT", "Name", "Last Name", "Branch Code", "Language"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableguide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableguideMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTableguide);

        jTabledriver.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Driver AT", "Name", "Last Name", "Branch Code", "Route"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabledriver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabledriverMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTabledriver);

        AdddEventButton.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        AdddEventButton.setText("Add Event");
        AdddEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdddEventButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AdddEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(UpdateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AdddEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(UpdateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        jTabledriver.setModel(new DefaultTableModel(null , new String[]{"Driver AT", "Name","Last Name","Branch Code","Route"}));
        jTableguide.setModel(new DefaultTableModel(null , new String[]{"Guide AT", "Name","Last Name","Branch Code","Language"}));
        DefaultTableModel model = (DefaultTableModel)jTable4.getModel();
        int selectedRowIndex = jTable4.getSelectedRow();
        BranchField.setText(model.getValueAt(selectedRowIndex ,0 ).toString());
        try {
            table_loadDriver(model.getValueAt(selectedRowIndex ,0 ).toString());
        } catch (SQLException ex) {
            Logger.getLogger(TripEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            table_loadGuide(model.getValueAt(selectedRowIndex ,0 ).toString());
      } catch (SQLException ex) {
           Logger.getLogger(TripEvent.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        int selectedRowIndex = jTable2.getSelectedRow();
        SearchField.setText(model.getValueAt(selectedRowIndex ,0 ).toString());
        DepartureField.setText(model.getValueAt(selectedRowIndex ,1 ).toString());
        ReturnField.setText(model.getValueAt(selectedRowIndex ,2 ).toString());
        SeatsField.setText(model.getValueAt(selectedRowIndex ,3 ).toString());
        CostField.setText(model.getValueAt(selectedRowIndex ,4 ).toString());
        BranchField.setText(model.getValueAt(selectedRowIndex ,5 ).toString());
        GuideATField.setText(model.getValueAt(selectedRowIndex ,6 ).toString());
        DriverATField.setText(model.getValueAt(selectedRowIndex ,7 ).toString());
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void UpdateButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButton2ActionPerformed

        String departure , returnf , seats , cost , brcode ,srid ,Guideat ,Driverat;

        departure = DepartureField.getText();
        returnf =ReturnField.getText();
        seats = SeatsField.getText();
        cost = CostField.getText();
        brcode = BranchField.getText();
        srid = SearchField.getText();
        Guideat  = GuideATField.getText();
        Driverat = DriverATField.getText();
 
       
        try{

            pst= conn.prepareStatement("update trip set tr_departure=? ,tr_return=? ,tr_maxseats=?, tr_cost=? ,tr_br_code=?, tr_gui_AT=? ,tr_drv_AT =? WHERE tr_id =?");
            pst.setString(1,departure);
            pst.setString(2,returnf);
            pst.setString(3,seats);
            pst.setString(4,cost);
            pst.setString(5,brcode);
            pst.setString(6,Guideat);
            pst.setString(7,Driverat);
            pst.setString(8,srid);
            pst.executeUpdate();    
            JOptionPane.showMessageDialog(null , "Record Update!!");
            jTable2.setModel(new DefaultTableModel(null , new String[]{"Trip ID", "Departure","Return","Max Seats","Cost","Branch Code","Guide AT" ,"Driver AT "}));
            table_load();
            DepartureField.setText("");
            ReturnField.setText("");
            SeatsField.setText("");
            CostField.setText("");
            BranchField.setText("");
            GuideATField.setText("");
            DriverATField.requestFocus();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_UpdateButton2ActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        String srid;

        srid = SearchField.getText();

        try{

            pst= conn.prepareStatement("delete from trip WHERE tr_id =?");
            pst.setString(1,srid);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "Record Deleted!!");
            jTable2.setModel(new DefaultTableModel(null , new String[]{"Trip ID", "Departure","Return","Max Seats","Cost","Branch Code","Guide AT" ,"Driver AT "}));
            table_load();
            DepartureField.setText("");
            ReturnField.setText("");
            SeatsField.setText("");
            CostField.setText("");
            BranchField.setText("");
            GuideATField.setText("");
            DriverATField.requestFocus();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void SearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFieldKeyReleased

        try{

            String wrk_AT = SearchField.getText();

            pst = conn.prepareStatement("SELECT tr_id , tr_departure, tr_return ,tr_maxseats , tr_cost , tr_br_code , tr_gui_AT , tr_drv_AT FROM trip WHERE tr_id = ?");
            pst.setString(1 , wrk_AT);
            ResultSet rs = pst.executeQuery();

            if(rs.next() == true)
            {
                String AT = rs.getString(1);
                String name = rs.getString(2);
                String lname = rs.getString(3);
                String salary = rs.getString(4);
                String code = rs.getString(5);
                String license = rs.getString(6);
                String route = rs.getString(7);
                String  experience = rs.getString(8);

                DepartureField.setText(name);
                ReturnField.setText(lname);
                SeatsField.setText(AT);
                CostField.setText(salary);
                BranchField.setText(code);
            }else{
                  DepartureField.setText("");
                  ReturnField.setText("");
                  SeatsField.setText("");
                  CostField.setText("");
                  BranchField.setText("");
                  GuideATField.setText("");
                  DriverATField.requestFocus();
            }

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_SearchFieldKeyReleased

    private void SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchFieldActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
            
            DepartureField.setText("");
            ReturnField.setText("");
            SeatsField.setText("");
            CostField.setText("");
            BranchField.setText("");
            GuideATField.setText("");
            SearchField.setText("");
            DriverATField.requestFocus();

    }//GEN-LAST:event_ClearButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
       System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed

        String  tr_departure , tr_return , tr_maxseats ,tr_cost ,tr_br_code ,tr_gui_AT, tr_drv_AT;

        tr_departure = DepartureField.getText();
        tr_return = ReturnField.getText();
        tr_maxseats = SeatsField.getText();
        tr_cost= CostField.getText();
        tr_br_code = BranchField.getText();
        tr_gui_AT = GuideATField.getText();
        tr_drv_AT = DriverATField.getText();

        try{

            cs= conn.prepareCall("insert into trip (tr_departure,tr_return,tr_maxseats,tr_cost,tr_br_code,tr_gui_AT,tr_drv_AT)values(?,?,?,?,?,?,?)");
            cs.setString(1,tr_departure);
            cs.setString(2,tr_return);
            cs.setString(3,tr_maxseats);
            cs.setString(4,tr_cost);
            cs.setString(5,tr_br_code);
            cs.setString(6,tr_gui_AT);
            cs.setString(7,tr_drv_AT);
            cs.executeUpdate();
          
            JOptionPane.showMessageDialog(null , "Record Addedd!!");
             jTable2.setModel(new DefaultTableModel(null , new String[]{"Trip ID", "Departure","Return","Max Seats","Cost","Branch Code","Guide AT" ,"Driver AT "}));
            table_load();
            DepartureField.setText("");
            ReturnField.setText("");
            SeatsField.setText("");
            CostField.setText("");
            BranchField.setText("");
            GuideATField.setText("");
            DriverATField.requestFocus();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null , e.getMessage());
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void BranchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BranchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BranchFieldActionPerformed

    private void SeatsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeatsFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeatsFieldActionPerformed

    private void CostFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CostFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CostFieldActionPerformed

    private void ReturnFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReturnFieldActionPerformed

    private void DepartureFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartureFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DepartureFieldActionPerformed

    private void DriverATFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DriverATFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DriverATFieldActionPerformed

    private void GuideATFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuideATFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuideATFieldActionPerformed

    private void jTabledriverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabledriverMouseClicked
        DefaultTableModel model = (DefaultTableModel) jTabledriver.getModel();
        int selectedRowIndex =  jTabledriver.getSelectedRow();
        DriverATField.setText(model.getValueAt(selectedRowIndex ,0 ).toString());
    }//GEN-LAST:event_jTabledriverMouseClicked

    private void jTableguideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableguideMouseClicked
        DefaultTableModel model = (DefaultTableModel) jTableguide.getModel();
        int selectedRowIndex =  jTableguide.getSelectedRow();
        GuideATField.setText(model.getValueAt(selectedRowIndex ,0 ).toString());
    }//GEN-LAST:event_jTableguideMouseClicked

    private void AdddEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdddEventButtonActionPerformed

        try {
            Events e = new Events(); 
            e.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(TripEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AdddEventButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TripEvent().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TripEvent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdddEventButton;
    private javax.swing.JTextField BranchField;
    private javax.swing.JButton ClearButton;
    private javax.swing.JTextField CostField;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField DepartureField;
    private javax.swing.JTextField DriverATField;
    private javax.swing.JButton ExitButton;
    private javax.swing.JTextField GuideATField;
    private javax.swing.JTextField ReturnField;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField SearchField;
    private javax.swing.JTextField SeatsField;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTabledriver;
    private javax.swing.JTable jTableguide;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}

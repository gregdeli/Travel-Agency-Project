package classes;
import static classes.Login.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Travel_To extends javax.swing.JFrame {

   
    public Travel_To() throws SQLException {
        initComponents();
        table_load();
        table_load2();
        table_load3();
    }

   
    PreparedStatement pst;
    CallableStatement cs;

    public void table_load() throws SQLException {
      Statement st = conn.createStatement();
      String table_sql = "SELECT to_tr_id , to_dst_id ,to_arrival ,to_departure FROM travel_to";
      ResultSet rs = st.executeQuery(table_sql);
      
      while(rs.next()){
          
          String to_tr_id = rs.getString("to_tr_id");
          String to_dst_id= rs.getString("to_dst_id");
          String to_arrival = rs.getString("to_arrival");
          String to_departure =  rs.getString("to_departure");
        
          
          String tbData[] = {to_tr_id , to_dst_id, to_arrival , to_departure };
          
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
      
      public void table_load3() throws SQLException {
      Statement st = conn.createStatement();
      String table_sql = "SELECT dst_id , dst_name FROM destination";
      ResultSet rs = st.executeQuery(table_sql);
      
      while(rs.next()){
          
          String dst_id = String.valueOf(rs.getInt("dst_id"));
          String dst_name = rs.getString("dst_name");

          String tbData[] = {dst_id , dst_name };
          
          DefaultTableModel tblModel = (DefaultTableModel)jTable3.getModel();
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
        DepartureField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TripField = new javax.swing.JTextField();
        ArrivalField = new javax.swing.JTextField();
        DestinationField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        SearchTripField = new javax.swing.JTextField();
        DestinationSField = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        ExitButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        UpdateButton2 = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Travel To");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Trip", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel10.setText("Arrival Time");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel11.setText("Departure End");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel7.setText("Trip ID");

        DepartureField.setText("YYYY-MM-DD HH:MM:SS");
        DepartureField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartureFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel8.setText("Destination ID");

        TripField.setEditable(false);
        TripField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TripFieldActionPerformed(evt);
            }
        });

        ArrivalField.setText("YYYY-MM-DD HH:MM:SS");
        ArrivalField.setToolTipText("");
        ArrivalField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArrivalFieldActionPerformed(evt);
            }
        });

        DestinationField.setEditable(false);
        DestinationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DestinationFieldActionPerformed(evt);
            }
        });
        DestinationField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DestinationFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DestinationField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TripField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DepartureField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ArrivalField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ArrivalField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(DepartureField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TripField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(DestinationField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
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
                "Trip ID", "Destination ID", "Time Arrival", "Time Departure"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setToolTipText("");
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 22))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel23.setText("Trip ID");

        SearchTripField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTripFieldActionPerformed(evt);
            }
        });
        SearchTripField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTripFieldKeyReleased(evt);
            }
        });

        DestinationSField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DestinationSFieldActionPerformed(evt);
            }
        });
        DestinationSField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DestinationSFieldKeyReleased(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel24.setText("Destination ID");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(42, 42, 42)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchTripField, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DestinationSField, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(SearchTripField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DestinationSField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        SaveButton.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(UpdateButton2)
                        .addGap(42, 42, 42)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane3))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 50, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UpdateButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DepartureFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartureFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DepartureFieldActionPerformed

    private void TripFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TripFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TripFieldActionPerformed

    private void ArrivalFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArrivalFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ArrivalFieldActionPerformed

    private void DestinationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DestinationFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DestinationFieldActionPerformed

    private void DestinationFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DestinationFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_DestinationFieldKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();
        TripField.setText(model.getValueAt(selectedRowIndex ,0 ).toString());

    }//GEN-LAST:event_jTable1MouseClicked

    private void SearchTripFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTripFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTripFieldActionPerformed

    private void SearchTripFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTripFieldKeyReleased

    }//GEN-LAST:event_SearchTripFieldKeyReleased

    private void DestinationSFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DestinationSFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DestinationSFieldActionPerformed

    private void DestinationSFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DestinationSFieldKeyReleased

        try{

            String sr1 = SearchTripField.getText();
            String sr2 = DestinationSField.getText();

            pst = conn.prepareStatement("SELECT to_tr_id , to_dst_id, to_arrival, to_departure FROM travel_to WHERE to_tr_id =? and to_dst_id =?");
            pst.setString(1 , sr1);
            pst.setString(2 , sr2);
            ResultSet rs = pst.executeQuery();

            if(rs.next() == true)
            {
                String to_tr_id  = rs.getString(1);
                String to_dst_id = rs.getString(2);
                String to_arrival = rs.getString(3);
                String to_departure = rs.getString(4);

                TripField.setText(to_tr_id);
                DestinationField.setText(to_dst_id);
                ArrivalField.setText(to_arrival);
                DepartureField.setText( to_departure);

            }else{

                ArrivalField.setText("");
                DepartureField.setText("");
                TripField.setText("");
                DestinationField.setText("");
                SearchTripField.setText("");
                DestinationSField.setText("");
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_DestinationSFieldKeyReleased

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed

        ArrivalField.setText("");
        DepartureField.setText("");
        TripField.setText("");
        DestinationField.setText("");
        SearchTripField.setText("");
        DestinationSField.setText("");
        
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        String search1 , search2;

        search1 =  SearchTripField.getText();
        search2 = DestinationSField.getText();

        try{

            pst= conn.prepareStatement("delete from travel_to WHERE to_tr_id =? and to_dst_id=? ");
            pst.setString(1, search1);
            pst.setString(2, search2);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null , "Record Deleted!!");
            jTable2.setModel(new DefaultTableModel(null , new String[]{"Trip ID","Destination ID","Time Arrival","Time Departure"}));
            table_load();
             ArrivalField.setText("");
             DepartureField.setText("");
             TripField.setText("");
             DestinationField.setText("");
             SearchTripField.setText("");
             DestinationSField.setText("");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void UpdateButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButton2ActionPerformed

        String to_tr_id ,to_dst_id , to_arrival ,to_departure ,search1 ,search2 ;

        to_dst_id =DestinationField.getText();
        to_arrival  = ArrivalField.getText();
        to_departure= DepartureField.getText();
        to_tr_id =  TripField.getText();
        search1 = SearchTripField.getText();
        search2 = DestinationSField.getText();

        try{

            pst= conn.prepareStatement("update travel_TO set to_tr_id =? ,to_dst_id=? , to_arrival=?, to_departure=? WHERE to_tr_id =? and to_dst_id =?");
            pst.setString(1,to_tr_id);
            pst.setString(2,to_dst_id);
            pst.setString(3,to_arrival);
            pst.setString(4,to_departure);
            pst.setString(5,search1);
            pst.setString(6,search2);
            pst.executeUpdate();
            jTable2.setModel(new DefaultTableModel(null , new String[]{"Trip ID","Destination ID","Time Arrival","Time Departure"}));
            table_load();
             ArrivalField.setText("");
             DepartureField.setText("");
             TripField.setText("");
             DestinationField.setText("");
             SearchTripField.setText("");
             DestinationSField.setText("");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_UpdateButton2ActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        
        String to_tr_id ,to_dst_id , to_arrival ,to_departure ;

        to_dst_id = DestinationField.getText();
        to_arrival  = ArrivalField.getText();
        to_departure= DepartureField.getText();
        to_tr_id = TripField.getText();

        try{

            cs= conn.prepareCall("insert into travel_to (to_tr_id,to_dst_id,to_arrival,to_departure)values(?,?,?,?)");
            cs.setString(1,to_tr_id );
            cs.setString(2,to_dst_id);
            cs.setString(3,to_arrival);
            cs.setString(4,to_departure);
            cs.executeUpdate();
            JOptionPane.showMessageDialog(null , "Record Addedd!!");
             jTable2.setModel(new DefaultTableModel(null , new String[]{"Trip ID","Destination ID","Time Arrival","Time Departure"}));
             table_load();
             ArrivalField.setText("");
             DepartureField.setText("");
             TripField.setText("");
             DestinationField.setText("");
             SearchTripField.setText("");
             DestinationSField.setText("");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable3.getModel();
        int selectedRowIndex = jTable3.getSelectedRow();
        DestinationField.setText(model.getValueAt(selectedRowIndex ,0 ).toString());

    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
       DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        int selectedRowIndex = jTable2.getSelectedRow();
        TripField.setText(model.getValueAt(selectedRowIndex ,0 ).toString());
        SearchTripField.setText(model.getValueAt(selectedRowIndex ,0 ).toString());
        DestinationField.setText(model.getValueAt(selectedRowIndex ,1 ).toString());
        DestinationSField.setText(model.getValueAt(selectedRowIndex ,1 ).toString());
        ArrivalField.setText(model.getValueAt(selectedRowIndex ,2 ).toString());
        DepartureField.setText(model.getValueAt(selectedRowIndex ,3 ).toString());

    }//GEN-LAST:event_jTable2MouseClicked

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
            java.util.logging.Logger.getLogger(Travel_To.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Travel_To.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Travel_To.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Travel_To.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Travel_To().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Travel_To.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ArrivalField;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField DepartureField;
    private javax.swing.JTextField DestinationField;
    private javax.swing.JTextField DestinationSField;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField SearchTripField;
    private javax.swing.JTextField TripField;
    private javax.swing.JButton UpdateButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}

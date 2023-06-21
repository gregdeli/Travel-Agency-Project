package classes;

import static classes.Login.conn;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log_Trip extends javax.swing.JFrame {



public void table_load() throws SQLException {
      Statement st = conn.createStatement();
      String table_sql = "SELECT log_type , log_it_lname , log_timestamp  , log_tr_id ,log_tr_departure,log_tr_return,log_tr_maxseats,log_tr_cost,"
              + "log_tr_br_code, log_tr_gui_AT ,log_tr_drv_AT FROM log_trip ";
      ResultSet rs = st.executeQuery(table_sql);
      
      while(rs.next()){
          
          String log_type = rs.getString("log_type");
          String log_it_lname = rs.getString("log_it_lname");
          String log_timestamp = rs.getString("log_timestamp");
          String log_tr_id = String.valueOf(rs.getInt("log_tr_id"));
          String log_tr_departure = rs.getString("log_tr_departure");
          String log_tr_return  = rs.getString("log_tr_return");
          String log_tr_maxseats =rs.getString("log_tr_maxseats");
          String log_tr_cost = rs.getString("log_tr_cost");
          String log_tr_br_code = rs.getString(rs.getInt("log_tr_br_code"));
          String log_tr_gui_AT = rs.getString("log_tr_gui_AT");
          String log_tr_drv_AT = rs.getString("log_tr_drv_AT");
         
       
          String tbData[] = {log_type,log_it_lname,log_timestamp ,log_tr_id,log_tr_departure , log_tr_return,log_tr_maxseats,log_tr_cost,log_tr_br_code,log_tr_gui_AT,log_tr_drv_AT};
          
          DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel();
          tblModel.addRow(tbData); 
      }
    }

    public Log_Trip() throws SQLException {
        initComponents();
     
        table_load();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("History of Trip Table");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Action Type", "Admin Last Name", "Timestamp", "Trip ID", "Trip Departure", "Trip Return", "Max Seats", "Cost", "Branch Code", "Guide AT", "Driver AT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(437, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(440, 440, 440))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Log_Trip().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Log_Trip.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

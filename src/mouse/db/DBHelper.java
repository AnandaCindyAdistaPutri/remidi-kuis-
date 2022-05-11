/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouse.db;

/**
 *
 * @author ANANDA CINDY
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBHelper {
    public static final String USER = "root";
    public static final String PASSWORD = "";
    public static final String DB = "remidi";
    public static final String MyConn = "jdbc:mysql://localhost/" + DB
            + "?user=" + USER + "&password=" + PASSWORD;
    
    public static Connection getConnection(String driver) {
        Connection conn = null;
        switch (driver) {
            case "MYSQL": {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection(MyConn);
                    System.out.println("Koneksi Berhasil");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Library blm ada");
                    //            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    //            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Koneksi Gagal");
                }
            }
        }

        return conn;
    }
}
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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mouse.model.Mahasiswa;

public class DBHandler {
    public final Connection conn;
    
    public DBHandler(String driver) {
        this.conn = DBHelper.getConnection(driver);
    }
    public void addMahasiswa(Mahasiswa mhs){
        String insertMhs = "INSERT INTO `mouse`(`nama`, `harga`, `tanggal_beli`,`warna`,`merk`)"
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmtInsert = conn.prepareStatement(insertMhs);
            stmtInsert.setString(1, mhs.getNama());
            stmtInsert.setString(2, mhs.getHarga());
            stmtInsert.setString(3, mhs.getTanggalBeli());
            stmtInsert.setString(4, mhs.getWarna());
            stmtInsert.setString(5, mhs.getMerk());
            stmtInsert.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
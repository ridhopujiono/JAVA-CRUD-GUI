
package LATIHAN;

import Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class CRUD {
    private int nim;
    private String nama, jurusan, alamat;
    private Connection koneksiCrud;
    private PreparedStatement psmtCrud;
    private Statement stmCrud;
    private ResultSet hasilCrud;
    private String queryCrud;

    public CRUD() { // Constructor 
        try {
            Koneksi kon = new Koneksi();
            koneksiCrud = kon.koneksiDB();
        } catch (SQLException e) {
            System.out.println(e);
        }
    } 
    
    public abstract int setNim();
    public abstract String setNama();
    public abstract String setAlamat();
    public abstract String setJurusan();
    
    public abstract int getNim();
    public abstract String getNama();
    public abstract String getAlamat();
    public abstract String getJurusan();
    
}

package GUI;

import Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CRUD extends Abstrak implements Interface {

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

    // Membuat Method Tampil 
    public ResultSet tampilData() {
        queryCrud = "select * from mahasiswa";
        try {
            stmCrud = koneksiCrud.createStatement();
            hasilCrud = stmCrud.executeQuery(queryCrud);
        } catch (Exception e) {
        }
        return hasilCrud;
    }

    // Method Tampil
    @Override
    public String simpanData(int nim, String nama, String jurusan, String alamat) {
        queryCrud = "insert into mahasiswa values (?,?,?,?)";
        try {
            psmtCrud = koneksiCrud.prepareStatement(queryCrud);
            psmtCrud.setInt(1, nim);
            psmtCrud.setString(2, nama);
            psmtCrud.setString(3, jurusan);
            psmtCrud.setString(4, alamat);
            psmtCrud.executeUpdate();
            psmtCrud.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return "Berhasil Di Simpan";
    }

    // Method Hapus
    @Override
    public String hapusData(int nim) {
        queryCrud = "delete from mahasiswa where nim = ?";
        try {
            psmtCrud = koneksiCrud.prepareStatement(queryCrud);
            psmtCrud.setInt(1, nim);
            psmtCrud.executeUpdate();
            psmtCrud.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "Data Berhasil Di Hapus";
    }

    //Method Editt 
    @Override
    public String editData(int nim, String nama, String jurusan, String alamat) {
        queryCrud = "update mahasiswa set nama=?, jurusan=?, alamat=? where nim=?";
        try {
            psmtCrud = koneksiCrud.prepareStatement(queryCrud);
            psmtCrud.setString(1, nama);
            psmtCrud.setString(2, jurusan);
            psmtCrud.setString(3, alamat);
            psmtCrud.setInt(4, nim);
            psmtCrud.executeUpdate();
            psmtCrud.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return "Data Berhasil Di Edit";
    }

//    public String cariData(int key) {
//        queryCrud = ("SELECT * FROM mahasiswa WHERE nim LIKE ‘%key%’ OR nama LIKE ‘%key%’'");
//        try {
//            psmtCrud = koneksiCrud.prepareStatement(queryCrud);
//            psmtCrud.executeUpdate();
//            psmtCrud.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        
//        return "Data Berhasil Di Cari";
//    }
      // Membuat Method Tampil 
    public ResultSet cariData(int key) {
        queryCrud = "select * from mahasiswa WHERE nim LIKE '%"+key+"%' ";
        try {
            stmCrud = koneksiCrud.createStatement();
            hasilCrud = stmCrud.executeQuery(queryCrud);
        } catch (Exception e) {
        }
        return hasilCrud;
    }
    
    //Method Setter Dan Getter
    @Override
    public void setNim(int nim) {
        this.nim = nim;
    }

    @Override
    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    @Override
    public int getNim() {
        return nim;
    }

    @Override
    public String getNama() {
        return nama;
    }

    @Override
    public String getAlamat() {
        return alamat;
    }

    @Override
    public String getJurusan() {
        return jurusan;
    }

}

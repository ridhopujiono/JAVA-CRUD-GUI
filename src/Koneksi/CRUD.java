package Koneksi;

import Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CRUD extends Abstrak implements Method_CRUD {

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

    // Membuat Method Setter dan Getter
    @Override
    public int getNim() {
        return nim;
    }

    @Override
    public void setNim(int nim) {
        this.nim = nim;
    }

    @Override
    public String getNama() {
        return nama;
    }

    @Override
    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String getJurusan() {
        return jurusan;
    }

    @Override
    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    @Override
    public String getAlamat() {
        return alamat;
    }

    @Override
    public void setAlamat(String alamat) {
        this.alamat = alamat;
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

    // Method Simpan Data 
    @Override
    public String simpanData(int nim, String nama, String jurusan, String alamat) {
//        String pesan = "Apakah anda yakin ingin menyimpan ?";
//        JOptionPane.showMessageDialog(null, pesan);
//
//        if (pesan.equalsIgnoreCase("Yes")) {

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
//            JOptionPane.showMessageDialog(null, "Data berhasil tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
//
//        } else {
//            JOptionPane.showMessageDialog(null, "Data gagal tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
//        }
        return "Simpan data sukses";
    }

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
        return null;
    }

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
        return null;
    }

}

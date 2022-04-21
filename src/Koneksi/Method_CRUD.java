package Koneksi;

public interface Method_CRUD {

    public String simpanData(int nim, String nama, String jurusan, String alamat);

    public String hapusData(int nim);

    public String editData(int nim, String nama, String jurusan, String alamat);
}

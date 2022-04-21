package Koneksi;

public abstract class Abstrak  {
    protected int nim;
    protected String nama, jurusan, alamat;

    public abstract void setNim(int nim);
    public abstract void setNama(String nama);
    public abstract void setAlamat(String alamat);
    public abstract void setJurusan(String jurusan);
    
    
    public abstract int getNim();
    public abstract String getNama();
    public abstract String getAlamat();
    public abstract String getJurusan();
}

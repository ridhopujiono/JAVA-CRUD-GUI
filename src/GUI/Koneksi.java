
package GUI;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Koneksi {

    private static Connection mysqlkonek;

    public static void main(String[] args) throws SQLException {
        koneksiDB();
    }

    public static Connection koneksiDB() throws SQLException {
        if (mysqlkonek == null) {
            try {
                String url = "jdbc:mysql://localhost/db_mahasiswa";
                String user = "root";
                String pass = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlkonek = (Connection) DriverManager.getConnection(url, user, pass);
                JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal Koneksi");
            }
        }
        return mysqlkonek;
    }   
}

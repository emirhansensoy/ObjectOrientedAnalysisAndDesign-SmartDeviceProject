/*
 *
 * @author Emirhan ŞENSOY - emirhan.sensoy@ogr.sakarya.edu.tr
 * @since 18 Nisan 2021 Pazar, 14:07:51
 *
 */

package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgreSQLSurucu implements IAkilliCihazBilgiSistemi
{
    public KullaniciHesabi kullaniciDogrula(String username, String password)
    {
        KullaniciHesabi kullaniciHesabi = null;

        try
        {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkilliCihaz", "postgres", "123");

            if (conn == null)
            {
                System.out.println("Veritabanına bağlanılamadı!");
            }

            String sql= "SELECT *  FROM \"Kullanicilar\" WHERE \"KullaniciAdi\"='" + username + "' AND \"Sifre\"='" + password + "'";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            conn.close();

            String kullaniciAdi = null;
            String sifre = null;
            String ad = null;
            String soyad = null;

            while(rs.next())
            {
                kullaniciAdi = rs.getString("KullaniciAdi");
                sifre = rs.getString("Sifre");
                ad = rs.getString("Ad");
                soyad = rs.getString("Soyad");

                System.out.print("Kullanıci Adı: "+ kullaniciAdi);
                System.out.print(", Şifre: " + sifre);
                System.out.print(", Ad: " + ad);
                System.out.println(", Soyad: " + soyad);

                kullaniciHesabi = new KullaniciHesabi.KullaniciHesabiBuilder(kullaniciAdi, ad, soyad).build();
            }

            rs.close();
            stmt.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return kullaniciHesabi;
    }

}

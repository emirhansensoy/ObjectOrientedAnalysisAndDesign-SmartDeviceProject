/*
 *
 * @author Emirhan ŞENSOY - emirhan.sensoy@ogr.sakarya.edu.tr
 * @since 18 Nisan 2021 Pazar, 14:07:51
 *
 */

package mypackage;

public class KullaniciHesabi
{
    private String kullaniciAdi;
    private InternetKullanicisi internetKullanicisi;

    private KullaniciHesabi(KullaniciHesabiBuilder builder)
    {
        this.kullaniciAdi = builder.kullaniciAdi;
        this.internetKullanicisi = builder.internetKullanicisi;
    }

    public String getAd()
    {
        return internetKullanicisi.getAd();
    }
    public String getSoyad()
    {
        return internetKullanicisi.getSoyad();
    }

    public static class KullaniciHesabiBuilder
    {
        private String kullaniciAdi;
        private InternetKullanicisi internetKullanicisi;

        public KullaniciHesabiBuilder(String kullaniciAdi, String ad, String soyad)
        {
            this.kullaniciAdi = kullaniciAdi;
            this.internetKullanicisi = new InternetKullanicisi.InternetKullanicisiBuilder(ad, soyad).build();
        }

        public KullaniciHesabi build() {

            return new KullaniciHesabi(this);
        }

    }
}

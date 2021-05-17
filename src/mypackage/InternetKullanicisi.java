/*
 *
 * @author Emirhan ŞENSOY - emirhan.sensoy@ogr.sakarya.edu.tr
 * @since 18 Nisan 2021 Pazar, 14:07:51
 *
 */

package mypackage;

public class InternetKullanicisi
{
    private String ad;
    private String soyad;

    private InternetKullanicisi(InternetKullanicisiBuilder builder)
    {
        this.ad = builder.ad;
        this.soyad = builder.soyad;
    }

    public String getAd()
    {
        return ad;
    }
    public String getSoyad()
    {
        return soyad;
    }

    public static class InternetKullanicisiBuilder
    {
        private String ad;
        private String soyad;

        public InternetKullanicisiBuilder(String ad, String soyad)
        {
            this.ad = ad;
            this.soyad = soyad;
        }

        public InternetKullanicisi build() {

            return new InternetKullanicisi(this);
        }

    }
}

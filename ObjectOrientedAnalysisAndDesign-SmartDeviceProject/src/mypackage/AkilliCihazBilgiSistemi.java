/*
 *
 * @author Emirhan ŞENSOY - emirhan.sensoy@ogr.sakarya.edu.tr
 * @since 18 Nisan 2021 Pazar, 14:07:51
 *
 */

package mypackage;

public class AkilliCihazBilgiSistemi implements IAkilliCihazBilgiSistemi
{
    private IAkilliCihazBilgiSistemi veritabani;

    private AkilliCihazBilgiSistemi(AkilliCihazBilgiSistemiBuilder builder)
    {
        this.veritabani = builder.veritabani;
    }

    public KullaniciHesabi kullaniciDogrula(String kullaniciAdi, String sifre)
    {
        return veritabani.kullaniciDogrula(kullaniciAdi, sifre);
    }

    public static class AkilliCihazBilgiSistemiBuilder
    {
        private IAkilliCihazBilgiSistemi veritabani;

        public AkilliCihazBilgiSistemiBuilder(IAkilliCihazBilgiSistemi veritabani)
        {
            this.veritabani = veritabani;
        }

        public AkilliCihazBilgiSistemi build() {

            return new AkilliCihazBilgiSistemi(this);
        }

    }
}

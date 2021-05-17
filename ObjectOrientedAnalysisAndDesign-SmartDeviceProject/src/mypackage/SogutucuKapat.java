/*
 *
 * @author Emirhan ŞENSOY - emirhan.sensoy@ogr.sakarya.edu.tr
 * @since 18 Nisan 2021 Pazar, 14:07:51
 *
 */

package mypackage;

public class SogutucuKapat implements IIslem
{
    IEkran ekran;
    IEyleyici eyleyici;
    IAgArayuzu agArayuzu;

    private SogutucuKapat(SogutucuKapatBuilder builder)
    {
        this.ekran = builder.ekran;
        this.eyleyici = builder.eyleyici;
        this.agArayuzu = builder.agArayuzu;
    }

    @Override
    public void islemYap()
    {
        ekran.mesajGoruntule("Soğutucu kapatılıyor...");
        Araclar.bekle(1400);
        ekran.mesajGoruntule(agArayuzu.sogutucuKapat(eyleyici.sogutucuKapat()));
        Araclar.bekle(600);
    }

    public static class SogutucuKapatBuilder
    {
        IEkran ekran;
        IEyleyici eyleyici;
        IAgArayuzu agArayuzu;

        public SogutucuKapatBuilder(IEkran ekran, IEyleyici eyleyici, IAgArayuzu agArayuzu)
        {
            this.ekran = ekran;
            this.eyleyici = eyleyici;
            this.agArayuzu = agArayuzu;
        }

        public SogutucuKapat build() {

            return new SogutucuKapat(this);
        }

    }
}

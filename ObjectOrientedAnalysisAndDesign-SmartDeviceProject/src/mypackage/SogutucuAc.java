/*
 *
 * @author Emirhan ŞENSOY - emirhan.sensoy@ogr.sakarya.edu.tr
 * @since 18 Nisan 2021 Pazar, 14:07:51
 *
 */

package mypackage;

public class SogutucuAc implements IIslem
{
    IEkran ekran;
    IEyleyici eyleyici;
    IAgArayuzu agArayuzu;

    private SogutucuAc(SogutucuAcBuilder builder)
    {
        this.ekran = builder.ekran;
        this.eyleyici = builder.eyleyici;
        this.agArayuzu = builder.agArayuzu;
    }

    @Override
    public void islemYap()
    {
        ekran.mesajGoruntule("Soğutucu açılıyor...");
        Araclar.bekle(1200);
        ekran.mesajGoruntule(agArayuzu.sogutucuAc(eyleyici.sogutucuAc()));
        Araclar.bekle(600);
    }

    public static class SogutucuAcBuilder
    {
        IEkran ekran;
        IEyleyici eyleyici;
        IAgArayuzu agArayuzu;

        public SogutucuAcBuilder(IEkran ekran, IEyleyici eyleyici, IAgArayuzu agArayuzu)
        {
            this.ekran = ekran;
            this.eyleyici = eyleyici;
            this.agArayuzu = agArayuzu;
        }

        public SogutucuAc build() {

            return new SogutucuAc(this);
        }

    }
}

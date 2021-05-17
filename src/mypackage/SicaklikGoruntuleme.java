/*
 *
 * @author Emirhan ŞENSOY - emirhan.sensoy@ogr.sakarya.edu.tr
 * @since 18 Nisan 2021 Pazar, 14:07:51
 *
 */

package mypackage;

public class SicaklikGoruntuleme implements IIslem
{
    IEkran ekran;
    IAlgilayici algilayici;
    IAgArayuzu agArayuzu;

    private SicaklikGoruntuleme(SicaklikGoruntulemeBuilder builder)
    {
        this.ekran = builder.ekran;
        this.algilayici = builder.algilayici;
        this.agArayuzu = builder.agArayuzu;
    }

    @Override
    public void islemYap()
    {
        Araclar.bekle(600);
        ekran.mesajGoruntule(agArayuzu.sicaklikGonder(algilayici.sicaklikOku()));
        Araclar.bekle(500);
    }

    public static class SicaklikGoruntulemeBuilder
    {
        IEkran ekran;
        IAlgilayici algilayici;
        IAgArayuzu agArayuzu;

        public SicaklikGoruntulemeBuilder(IEkran ekran, IAlgilayici algilayici, IAgArayuzu agArayuzu)
        {
            this.ekran = ekran;
            this.algilayici = algilayici;
            this.agArayuzu = agArayuzu;
        }

        public SicaklikGoruntuleme build() {

            return new SicaklikGoruntuleme(this);
        }

    }
}

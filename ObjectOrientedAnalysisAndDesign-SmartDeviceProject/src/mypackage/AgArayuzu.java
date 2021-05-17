/*
 *
 * @author Emirhan ŞENSOY - emirhan.sensoy@ogr.sakarya.edu.tr
 * @since 18 Nisan 2021 Pazar, 14:07:51
 *
 */

package mypackage;

public class AgArayuzu implements IAgArayuzu
{
    public String  sicaklikGonder(int sicaklik)
    {
        System.out.println("Sıcaklık Görüntüleniyor...");
        Araclar.bekle(800);
        return "Sıcaklık = " + sicaklik + "C";
    }

    public String sogutucuAc(boolean sogutucuAcikMi)
    {
        if(!sogutucuAcikMi)
        {
            return "Soğutucu zaten açık...";
        }
        else
        {
            return "Soğutucu açıldı...";
        }
    }

    public String sogutucuKapat(boolean sogutucuKapaliMi)
    {
        if(!sogutucuKapaliMi)
        {
            return "Soğutucu zaten kapalı...";
        }
        else
        {
            return "Soğutucu kapandı...";
        }
    }
}

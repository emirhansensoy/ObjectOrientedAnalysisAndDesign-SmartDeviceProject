/*
 *
 * @author Emirhan ŞENSOY - emirhan.sensoy@ogr.sakarya.edu.tr
 * @since 18 Nisan 2021 Pazar, 14:07:51
 *
 */

package mypackage;

public class Ekran implements IEkran
{
    private final IEkranKlavyesi ekranKlavyesi;

    public Ekran()
    {
        ekranKlavyesi = new EkranKlavyesi();
    }

    public void mesajGoruntule(String mesaj)
    {
        System.out.println(mesaj);
    }

    public String veriAl()
    {
        return ekranKlavyesi.veriAl();
    }
}

/*
 *
 * @author Emirhan ŞENSOY - emirhan.sensoy@ogr.sakarya.edu.tr
 * @since 18 Nisan 2021 Pazar, 14:07:51
 *
 */

package mypackage;

public class Uygulama
{
    public static void main(String[] args)
    {
        Publisher publisher = new Publisher();

        IslemKaydi islemKaydi = new IslemKaydi();
        EkranKaydi ekranKaydi = new EkranKaydi();

        publisher.attach(islemKaydi);
        publisher.attach(ekranKaydi);

        AkilliCihaz cihaz = new AkilliCihaz(publisher);

        cihaz.calistir();
    }
}

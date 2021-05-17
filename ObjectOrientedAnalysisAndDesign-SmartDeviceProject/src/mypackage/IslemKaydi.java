/*
 *
 * @author Emirhan ŞENSOY - emirhan.sensoy@ogr.sakarya.edu.tr
 * @since 18 Nisan 2021 Pazar, 14:07:51
 *
 */

package mypackage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IslemKaydi implements IObserver
{
    Date date;
    SimpleDateFormat formatter;

    public IslemKaydi()
    {
        formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    }

    @Override
    public void update(String mesaj)
    {
        date = new Date();
        System.out.println("İşlem Kaydı -> " + formatter.format(date) + " -> " + mesaj);
    }
}

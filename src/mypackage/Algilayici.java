/*
 *
 * @author Emirhan ŞENSOY - emirhan.sensoy@ogr.sakarya.edu.tr
 * @since 18 Nisan 2021 Pazar, 14:07:51
 *
 */

package mypackage;

import java.util.Random;

public class Algilayici implements IAlgilayici
{
    private int sicaklik;

    public Algilayici()
    {
        sicaklik = 0;
    }

    public int sicaklikOku()
    {
        int maxSicaklik = 40;
        int minSicaklik = -8;
        Random rand = new Random();
        sicaklik = rand.nextInt(maxSicaklik - minSicaklik) + minSicaklik;
        return sicaklik;
    }
}

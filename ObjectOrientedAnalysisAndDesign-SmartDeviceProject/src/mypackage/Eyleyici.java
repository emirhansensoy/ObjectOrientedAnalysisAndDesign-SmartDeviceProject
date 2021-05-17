/*
 *
 * @author Emirhan ŞENSOY - emirhan.sensoy@ogr.sakarya.edu.tr
 * @since 18 Nisan 2021 Pazar, 14:07:51
 *
 */

package mypackage;

import java.util.Random;

public class Eyleyici implements IEyleyici
{
    private boolean acikMi;

    public Eyleyici()
    {
        Random rand = new Random();
        acikMi = rand.nextBoolean();
    }

    public boolean sogutucuAc()
    {
        if(acikMi)
        {
            return false;
        }
        else
        {
            acikMi = true;
            return true;
        }
    }

    public boolean sogutucuKapat()
    {
        if(!acikMi)
        {
            return false;
        }
        else
        {
            acikMi = false;
            return true;
        }
    }
}

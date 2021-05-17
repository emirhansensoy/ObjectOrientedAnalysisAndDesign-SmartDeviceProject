/*
 *
 * @author Emirhan ŞENSOY - emirhan.sensoy@ogr.sakarya.edu.tr
 * @since 18 Nisan 2021 Pazar, 14:07:51
 *
 */

package mypackage;

import java.util.Scanner;

public class EkranKlavyesi implements IEkranKlavyesi
{
    public String veriAl()
    {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}

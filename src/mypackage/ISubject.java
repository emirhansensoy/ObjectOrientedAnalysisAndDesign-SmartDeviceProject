/*
 *
 * @author Emirhan ŞENSOY - emirhan.sensoy@ogr.sakarya.edu.tr
 * @since 18 Nisan 2021 Pazar, 14:07:51
 *
 */

package mypackage;

public interface ISubject
{
    void attach(IObserver o);
    void detach(IObserver o);
    void notify(String m);
}

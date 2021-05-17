/*
 *
 * @author Emirhan ŞENSOY - emirhan.sensoy@ogr.sakarya.edu.tr
 * @since 18 Nisan 2021 Pazar, 14:07:51
 *
 */

package mypackage;

import java.util.ArrayList;

public class Publisher implements ISubject
{
    private ArrayList<IObserver> subscribers = new ArrayList<>();

    @Override
    public void attach(IObserver subscriber)
    {
        subscribers.add(subscriber);
    }

    @Override
    public void detach(IObserver subscriber)
    {
        subscribers.remove(subscriber);
    }

    @Override
    public void notify(String mesaj)
    {
        for(IObserver subscriber: subscribers)
        {
            subscriber.update(mesaj);
        }
    }

}

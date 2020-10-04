package cs2030.simulator;
//package simulator;

import java.util.Comparator;

public class EventComparator implements Comparator<Event> {

    public int compare(Event e1, Event e2)  {
        if (e1.getTime() < e2.getTime()) {
            return -1;
        } else if (e1.getTime() > e2.getTime()) {
            return 1;
        } else if (e1.getCustomerID() < e2.getCustomerID()) {
            return -1;
        } else if (e1.getCustomerID() > e2.getCustomerID()) {
            return 1;
        } else {
            System.out.println("Bug with code, please check");
            return 0;
        }

    }
}
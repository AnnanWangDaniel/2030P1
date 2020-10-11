package cs2030.simulator;

import java.util.Comparator;

/**
 * Defining the comparison criteria for priorityQueue.
 */
public class EventComparator implements Comparator<Event> {

    /**
     * Compares 2 Events and decides which is smaller, equal or greater.
     * The first key is to check for the earliest time.
     * If there is a tie breaker, customerID is checked instead, 
     * which also hints on the priority of different type of events.
     * @param e1 left event
     * @param e2 right event
     * @return -1 if left event is prioritised over right event. 
     * 0 if there isn't a priority, which will not happen in this case.
     * 1 if right event is prioritised over left event.
     */

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
            System.out.println("The situation is impossible!");
            return 0;
        }

    }
}
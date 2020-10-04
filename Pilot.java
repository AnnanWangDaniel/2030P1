package cs2030.simulator;
//package simulator;

import java.util.PriorityQueue;
import java.util.List;

public class Pilot {

    Server [] servers;

    private final PriorityQueue<Event> events;

    Statistics statistics = new Statistics();

    public Pilot(int numOfServers, int numOfCustomer, List<Double> arrivalTimes) {
        this.events = new PriorityQueue<>(new EventComparator());
        Customer customer = new Customer(1, arrivalTimes.get(0));
        ArrivalEvent tempEvent = new ArrivalEvent(customer, arrivalTimes.get(0));
        events.add(tempEvent);
        for (int i = 1; i < numOfCustomer; i++) {
            customer = new Customer(i, arrivalTimes.get(i));
            tempEvent = new ArrivalEvent(customer, arrivalTimes.get(i));
            events.add(tempEvent);
        }
        this.servers = new Server [numOfServers];
        for (int i = 0;i < numOfServers;i++) {
            this.servers[i] = new Server(i+1, false, false, 0);
        }
    }

    public void doService() {
        while (events.size() > 0) {
            Event firstEvent = getFirstEvent();
            System.out.println(firstEvent);
            Event newEvent = firstEvent.getNextEvent(servers);
            if (newEvent != null) {
                newEvent.updateStatistics(statistics);
                events.add(newEvent);
            }

        }
        System.out.println(statistics);
    }

    public Event getFirstEvent() {
        return events.poll();
    }
}
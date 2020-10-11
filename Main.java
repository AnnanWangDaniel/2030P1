import cs2030.simulator.*;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numOfServers = sc.nextInt();
        int numOfCustomer = 0;
        List<Double> arrivalTimes = new ArrayList<>();

        while (sc.hasNextDouble()) {
            numOfCustomer++;
            double arrivalTime = sc.nextDouble();
            arrivalTimes.add(arrivalTime);
        }

        sc.close();

        /**
         * Array of servers that determines the way ArrivalEvents are processed.
         */
        List<Server> servers = new ArrayList<>();

        /**
         * Initialize servers.
         */
        for (int i = 0; i < numOfServers; i++) {
            servers.add(new Server(i + 1, true, false, 0));
        }

        /**
         * PriorityQueue of events to be cleared by the end of the simulation.
         */
        PriorityQueue<Event> events = new PriorityQueue<>(new EventComparator());

        /**
         * Customer arrivel.
         */
        for (int i = 0; i < numOfCustomer; i++) {
            Customer tempCustomer = new Customer(i + 1, arrivalTimes.get(i));
            ArriveEvent tempEvent = new ArriveEvent(tempCustomer, servers);
            events.add(tempEvent);
        }

        List<String> records = new ArrayList<>();

        int numServed = 0;
        int numLeaved = 0;
        double sumArrivelTime = 0.0;
        double sumStartTime = 0.0;

        while (events.size() > 0) {
            Event currentEvent = events.poll();
            String recordString = currentEvent.toString();
            records.add(recordString);
            System.out.println(recordString);

            if (recordString.contains("arrives")) {
                sumArrivelTime += currentEvent.getTime();
                numServed++;
            } else if (recordString.contains("leaves")) {
                numLeaved++;
                numServed--;
                sumArrivelTime -= currentEvent.getTime();
            } else if (recordString.contains("served")) {
                sumStartTime += currentEvent.getTime();
            }

            Event newEvent = currentEvent.execute();
            if (newEvent != null) {
                events.add(newEvent);
            }

        }

        double avgWaitingTime = (sumStartTime - sumArrivelTime) / (double) (numServed);

        System.out.println('[' + String.format("%.3f", avgWaitingTime) + ' ' + numServed + ' ' + numLeaved + ']');
    }

}

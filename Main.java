//package simulator;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/*import cs2030.simulator.Event;
import cs2030.simulator.Customer;
import cs2030.simulator.EventComparator;
import cs2030.simulator.Pilot;
import cs2030.simulator.ArrivalEvent;*/

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int numOfServers = sc.nextInt();
        int numOfCustomer = 0;
        List<Double> arrivalTimes = new ArrayList<>();

        while (sc.hasNextDouble()) {
            numOfCustomer ++;
            double arrivalTime = sc.nextDouble();
            arrivalTimes.add(arrivalTime);
        }
        
        sc.close();

        Pilot pilot = new Pilot(numOfServers, numOfCustomer, arrivalTimes);
        pilot.doService();
    }
}
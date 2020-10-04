import java.util.PriorityQueue;

public class EventManager {

    private Server [] servers;

    PriorityQueue<Event> events;
    Statistics statistics = new Statistics();
    RandomGenerator generator;

    public EventManager(int numServers, int numCustomer,
        int seed, double arrivalRate, double svcRate, double restRate) {
        this.events = new PriorityQueue<>(new EventComparator());
        this.gen = new RandomGenerator(seed, arrivalRate,svcRate,restRate);
        double time = 0;
        Customer customer = new Customer(time);
        ArrivalEvent tempEvent = new ArrivalEvent(customer,time);
        events.add(tempEvent);
        for (int i = 0;i < numCustomer - 1;i++) {
            double x = gen.genInterArrivalTime();
            time += x;
            customer = new Customer(time);
            tempEvent = new ArrivalEvent(customer,time);
            events.add(tempEvent);
        }
        this.servers = new Server [numServers];
        for (int i = 0;i < numServers;i++) {
            this.servers[i] = new Server();
        }
    }

    public void doService() {
        
    }

    public Event getFirstEvent() {
        return events.poll();
    }
}
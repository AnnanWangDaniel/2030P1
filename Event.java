package simulator;

import java.util.List;

public abstract class Event {
    private final double time;
    private final Customer customer;
    private final List<Server> servers;

    public Event(double time, Customer customer, List<Server> servers){
        this.time = time;
        this.customer = customer;
        this.servers = servers;
    }

    public abstract Event execute();

    public Customer getCustomer() {
        return customer;
    }

    public int getCustomerID() {
        return this.customer.getCustomerID();
    }

    public double getTime() {
        return time;
    }

    public List<Server> getServers() {
        return servers;
    }

    public abstract Event getNextEvent(Server [] servers,RandomGenerator gen);

    public abstract void updateStatistics(Statistics statistics);
}

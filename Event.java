package cs2030.simulator;
//package simulator;

public abstract class Event {

    private final Customer customer;

    private final double time;

    public Event(Customer customer, double time) {
        this.customer = customer;
        this.time = time;
    }

    public abstract Event getNextEvent(Server [] servers);

    public abstract void updateStatistics(Statistics statistics);

    public Customer getCustomer() {
        return this.customer;
    }

    public int getCustomerID() {
        return this.customer.getCustomerID();
    }

    public double getTime() {
        return this.time;
    }
}

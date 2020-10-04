package cs2030.simulator;

class ServedEvent extends Event {

    private Server server;

    public ServedEvent(Customer customer, double time, Server server) {
        super(customer,time);
        this.server = server;
    }

    public DoneEvent getNextEvent(Server [] servers) {
        DoneEvent newEvent = new DoneEvent(this.getCustomer(), 
            this.getTime() + 1 ,this.server);
        this.server.setServedEvent(newEvent);
        return newEvent;
    }

    public void updateStatistics(Statistics statistics) {
        statistics.increaseServed();
        statistics.increaseWaitingTime(this.getTime() - this.getCustomer().getTime());
    }

    public String toString() {
        return (String.format("%.3f",this.getTime()) + ' ' + this.getCustomerID() + " served by " + server.getServerID());
    }
}
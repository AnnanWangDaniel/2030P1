//package cs2030.simulator;

class WaitEvent extends Event {

    private Server server;


    public WaitEvent(Customer customer, double time, Server server) {
        super(customer,time);
        this.server = server;
    }

    public ServedEvent getNextEvent(Server [] servers) {
        if (!this.server.canTakeWaitEvent()) {
            ServedEvent newEvent = new ServedEvent(this.getCustomer(), 
                this.server.getDoneTime(), this.server);
            this.server.setWaitEvent(newEvent);
            return newEvent;
        }
        return null;
    }

    public void updateStatistics(Statistics statistics) {
        return;
    }

    public String toString() {
        return (String.format("%.3f",this.getTime()) +
            ' ' + this.getCustomerID() + " waits to be served by " + server.getServerID());
    }

}

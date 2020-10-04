package cs2030.simulator;
//package simulator;

class DoneEvent extends Event {
    private Server server;

    public DoneEvent(Customer customer, double time, Server server) {
        super(customer,time);
        this.server = server;
    }

    public Event getNextEvent(Server [] servers) {
        this.server.flushDoneEvent();
        return null;
    }

    public void updateStatistics(Statistics statistics) {
        return;
    }

    public String toString() {
        return String.format("%.3f",this.getTime()) +
            ' ' + this.getCustomerID() + " done serving by " +
            server.getServerID();
    }

}

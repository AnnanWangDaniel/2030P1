package simulator;


/**
 * WaitEvent class to simulate the act of customer waiting.
 * for another customer to be served by the same server.
 */
class WaitEvent extends Event {
    /** 
     * Server that the WaitEvent belongs to.
     */
    private Server server;

    /** 
     * Creates an WaitEvent.
     * @param customer customer that the event is involving
     * @param time time at which event is created
     * @param server server that the WaitEvent belongs to
     */
    public WaitEvent(Customer customer, double time, Server server) {
        super(customer,time);
        this.server = server;
    }

    /**
     * Creates a ServedEvent to signal that the current customer can now be served.
     * Timestamp the current customer is being served is taken from the server.
     * @param servers Array of servers to be checked, not used in this case
     * @param gen RandomGenerator, not used in this case
     * @return ServedEvent
     */
    public ServedEvent getNextEvent(Server [] servers,RandomGenerator gen) {
        if (!this.server.canTakeWaitEvent()) {
            ServedEvent newEvent = new ServedEvent(this.getCustomer(), 
                this.server.getDoneTime(), this.server);
            this.server.setWaitEvent(newEvent);
            return newEvent;
        }
        return null;
    }

    /**
     * Modifies information in statistics if required.
     * @param statistics Not used in this case 
     */
    public void updateStatistics(Statistics statistics) {
        return;
    }

    /**
     * Formats the WaitEvent to print out its profile.
     */
    public String toString() {
        return (String.format("%.3f",this.getTime()) +
            ' ' + this.getCustomerID() + " waits to be served by " +
            server.getServerID());
    }

}
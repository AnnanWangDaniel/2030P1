package cs2030.simulator;

import java.util.List;

public class DoneEvent extends Event{

    private final Server newServer;
    private final Server currentServer;
    private final List<Server> servers;

    public DoneEvent(Customer customer, List<Server> servers, Server server) {
        super(server.getNextAvailableTime(), customer, servers);
        this.newServer = new Server(server.getIdentifier(), server.hasWaitingCustomer(), false, server.getNextAvailableTime());
        this.currentServer = server;
        this.servers = servers;
    }

    @Override
    public Event execute() {
        this.servers.set(currentServer.getIdentifier() - 1, newServer);
        return null;
    }

    @Override
    public String toString() {
        return String.format("%.3f", super.getTime()) + " " + getCustomer().getCustomerID() + " done serving by " + newServer.getIdentifier();
    }
}

package cs2030.simulator;
//package simulator;

public class ArrivalEvent extends Event {

    public ArrivalEvent(Customer customer, double time) {
        super(customer, time);
    }

    public Event getNextEvent(Server [] servers) {
        Server freeServer = getFreeServer(servers);
        if (freeServer == null) {
            return createLeaveEvent();
        } else if (freeServer.canTakeServedEvent()) {
            ServedEvent newEvent = createServedEvent(freeServer);
            freeServer.setServedEvent(newEvent);
            return newEvent;
        } else if (freeServer.canTakeWaitEvent()) {
            WaitEvent newEvent = createWaitEvent(freeServer);
            freeServer.setWaitEvent(newEvent);
            return newEvent;
        } else {
            System.out.println("Bug in ArrivalEvents");
            return null;
        }
    }

    public LeaveEvent createLeaveEvent() {
        return new LeaveEvent(this.getCustomer(),this.getTime());
    }

    public ServedEvent createServedEvent(Server freeServer) {
        return new ServedEvent(this.getCustomer(),this.getTime(),freeServer);
    }

    public WaitEvent createWaitEvent(Server freeServer) {
        return new WaitEvent(this.getCustomer(),this.getTime(),freeServer);
    }

    public void updateStatistics(Statistics statistics) {
        return;
    }

    public Server getFreeServer(Server[] servers) {
        boolean hasFoundSlots = false;
        Server choiceServer = null;
        for (int i = 0; i < servers.length;i++) {
            Server newServer = servers[i];
            if (newServer.canTakeServedEvent()) {
                return newServer;
            } else if (newServer.canTakeWaitEvent() && !hasFoundSlots) {
                choiceServer = newServer;
                hasFoundSlots = true;
            }
        }
        if (hasFoundSlots == false) {
            return null;
        } else {
            return choiceServer;
        }
    }

    public String toString() {
        return String.format("%.3f",this.getTime()) + ' ' +
        this.getCustomerID() + " arrives";
    }
}

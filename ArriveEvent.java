package cs2030.simulator;

import java.util.List;

public class ArriveEvent extends Event{

    public ArriveEvent(Customer customer, List<Server> servers) {
        super(customer.getArrivalTime(), customer, servers);
    }
    
    @Override
    public Event execute() {
        for(Server s : getServers()){
            if(s.isAvailable()==true){
                return new ServeEvent(this.getCustomer(), this.getServers(), s);
            }
        }

        for(Server s : getServers()){
            if(s.hasWaitingCustomer()==false){
                return new WaitEvent(getCustomer(), getServers(), s);
            }
        }
        return new LeaveEvent(getCustomer(), getServers());
    }

    @Override
    public String toString() {
        return String.format("%.3f", this.getTime()) +" " + getCustomer().getCustomerID() + " arrives";
    }

    public Event getNextEvent(Server [] servers,RandomGenerator gen) {
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
}

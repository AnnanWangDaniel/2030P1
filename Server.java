package cs2030.simulator;

class Server {
    private final int serverID;
    //private Event served;
    //private Event wait;

    private final int identifier;
	private final boolean isAvailable;
	private final boolean hasWaitingCustomer;
	private final double nextAvailableTime;

    public Server(int serverID) {
        this.serverID = serverID;
    }

    public Server(int identifier, boolean isAvailable, boolean hasWaitingCustomer, double nextAvailableTime) {
		this.identifier = identifier;
		this.isAvailable = isAvailable;
		this.hasWaitingCustomer = hasWaitingCustomer;
		this.nextAvailableTime = nextAvailableTime;
	}

/*
    public int getServerID() {
        return this.serverID;
    }

    public void setServedEvent(Event newEvent) {
        this.served = newEvent;
    }

    public void setWaitEvent(Event newEvent) {
        this.wait = newEvent;
    }

    public boolean canTakeServedEvent() {
        return (served == null && wait == null);
    }

    public boolean canTakeWaitEvent() {
        return (served != null && wait == null);
    }

    public void flushDoneEvent() {
        if (served != null) {
            served = null;
        }
        if (wait != null) {
            served = wait;
            wait = null;
        }
    }

    public double getDoneTime() {
        return this.served.getTime();
    }*/

    private String getAvailiability() {
		if (isAvailable == true)
			return " is available";
		else {
			if (hasWaitingCustomer == true){
				return " is busy; waiting customer to be served at " + String.format("%.3f", nextAvailableTime);
			}
			else {
				return " is busy; available at " + String.format("%.3f", nextAvailableTime) ;
			}
		} 
	} 

    public String toString() {
		return this.identifier + this.getAvailiability();
	}
}
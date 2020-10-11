package cs2030.simulator;

public class Server {
	private final int identifier;
	private final boolean isAvailable;
	private final boolean hasWaitingCustomer;
	private final double nextAvailableTime;

	public Server(int identifier, boolean isAvailable, boolean hasWaitingCustomer, double nextAvailableTime) {
		this.identifier = identifier;
		this.isAvailable = isAvailable;
		this.hasWaitingCustomer = hasWaitingCustomer;
		this.nextAvailableTime = nextAvailableTime;
	}

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

	public int getIdentifier() {
        return identifier;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean hasWaitingCustomer() {
        return hasWaitingCustomer;
    }

    public double getNextAvailableTime() {
        return nextAvailableTime;
    }

	public String toString() {
		return identifier + this.getAvailiability();
	}
}

package cs2030.simulator;
//package simulator;

public class Customer {
    private final int customerID;
    private final double time;

    public Customer(int customerID, double time) {
        this.customerID = customerID;
        this.time = time;
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public double getTime() {
        return this.time;
    }

    @Override
	public String toString() {
		return customerID + " arrives at " +  time;
	}

}
package cs2030.simulator;
//package simulator;

class LeaveEvent extends Event {

    public LeaveEvent(Customer customer, double time) {
        super(customer,time);
    }

    public Event getNextEvent(Server [] servers) {
        return null;
    }

    public void updateStatistics(Statistics statistics) {
        statistics.increaseLeft();
    }

    public String toString() {
        return String.format("%.3f",this.getTime()) +
            ' ' + this.getCustomerID() + " leaves";
    }

}
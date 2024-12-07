import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

interface RideInterface {
    void addVisitorToQueue(Visitor visitor);
    void removeVisitorFromQueue(Visitor visitor);
    void printQueue();
    void runOneCycle();
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();
}

abstract class Ride implements RideInterface {
    private String rideName;
    private int rideId;
    private Employee rideOperator;
    private String suitablePopulation;
    private List<Visitor> queue;
    private List<Visitor> rideHistory;

    public Ride() {
        this.rideName = "Unknown";
        this.rideId = 0;
        this.rideOperator = null;
        this.suitablePopulation = "Unknown";
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    public Ride(String rideName, int rideId, Employee rideOperator, String suitablePopulation) {
        this.rideName = rideName;
        this.rideId = rideId;
        this.rideOperator = rideOperator;
        this.suitablePopulation = suitablePopulation;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.add(visitor);
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        queue.remove(visitor);
    }

    @Override
    public void printQueue() {
        System.out.println("Visitors in the queue for " + rideName + ":");
        for (Visitor v : queue) {
            System.out.println(v.getName());
        }
    }

    @Override
    public void runOneCycle() {
        System.out.println(rideName + " is running one cycle.");
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride history for " + rideName + ":");
        for (Visitor v : rideHistory) {
            System.out.println(v.getName());
        }
    }

    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    public Employee getRideOperator() {
        return rideOperator;
    }

    public void setRideOperator(Employee rideOperator) {
        this.rideOperator = rideOperator;
    }

    public String getSuitablePopulation() {
        return suitablePopulation;
    }

    public void setSuitablePopulation(String suitablePopulation) {
        this.suitablePopulation = suitablePopulation;
    }
}
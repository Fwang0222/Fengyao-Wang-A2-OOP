import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Comparator;

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
    private Queue<Visitor> queue;
    private List<Visitor> rideHistory;
    private int maxRider;
    private int numOfCycles;

    public Ride() {
        this.rideName = "Unknown";
        this.rideId = 0;
        this.rideOperator = null;
        this.suitablePopulation = "Unknown";
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 1;
        this.numOfCycles = 0;
    }

    public Ride(String rideName, int rideId, Employee rideOperator, String suitablePopulation, int maxRider, int numOfCycles) {
        this.rideName = rideName;
        this.rideId = rideId;
        this.rideOperator = rideOperator;
        this.suitablePopulation = suitablePopulation;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = maxRider;
        this.numOfCycles = 0;
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            queue.add(visitor);
            System.out.println(visitor.getName() + " has been added to " + rideName + " queue.");
        } else {
            System.out.println("Failed to add.");
        }
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.remove(visitor)) {
            System.out.println(visitor.getName() + " has been removed from " + rideName + " queue.");
        } else {
            System.out.println("Failed to remove.");
        }
    }

    @Override
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Visitors in the queue for " + rideName + ":");
            for (Visitor visitor : queue) {
                System.out.println("Name: " + visitor.getName());
            }
        }
    }

    @Override
    public void runOneCycle() {
        if (rideHistory == null) {
            System.out.println("Can not run the ride, because there is no ride operator.");
            return;
        }

        if (queue.isEmpty()) {
            System.out.println("Can not run the ride, because queue is empty.");
            return;
        }

        int riders = Math.min(queue.size(), maxRider);
        System.out.println("Running one cycle of " + rideName + " with " + riders + " visitors.");

        for (int i = 0; i < riders; i++) {
            Visitor visitor = queue.poll();
            addVisitorToHistory(visitor);
        }

        numOfCycles++;
        System.out.println(rideName + " has been run for " + numOfCycles + " cycle(s).");
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println(visitor.getName() + " has been added to " +  rideName + " history.");
        } else {
            System.out.println("Failed to add.");
        }
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
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history is empty.");
        } else {
            Iterator<Visitor> iterator = rideHistory.iterator();
            System.out.println("Visitors in the ride history for " + rideName + ":");
            while (iterator.hasNext()) {
                Visitor v = iterator.next();
                System.out.println("Age: " + v.getAge() + " Name: " + v.getName());
            }
        }
    }

    public void sortRideHistory(Comparator<Visitor> comparator) {
        rideHistory.sort(comparator);
        System.out.println(rideName + " history has been sorted.");
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

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }
}
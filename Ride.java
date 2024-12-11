import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    private final Queue<Visitor> queue;
    private final List<Visitor> rideHistory;
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
        if (rideOperator == null) {
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

    public void exportRideHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                String visitorData = visitor.getName() + "," + visitor.getAge() + "," + visitor.getGender() + ","
                        + visitor.getTelephone() + "," + visitor.getHeight() + "," + visitor.getEmail() + "," + visitor.getHasFastPass();
                writer.write(visitorData);
                writer.newLine();
            }
            System.out.println("Visitor history exported to " + filename);
        } catch (IOException e) {
            System.out.println("Error exporting ride history: " + e.getMessage());
        }
    }

    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 7) {
                    try {
                        String name = data[0].trim();
                        int age = Integer.parseInt(data[1].trim());
                        String gender = data[2].trim();
                        String telephone = data[3].trim();
                        String height = data[4].trim();
                        String email = data[5].trim();
                        boolean hasFastPass = Boolean.parseBoolean(data[6].trim());

                        Visitor visitor = new Visitor(name, age, gender, telephone, height, email, hasFastPass);
                        rideHistory.add(visitor);
                        System.out.println("Visitor " + name + " imported successfully.");

                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing age on line " + lineNumber + ": " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Error processing line " + lineNumber + ": " + e.getMessage());
                    }
                } else {
                    System.out.println("Skipping invalid line " + lineNumber + ": " + line);
                }
                lineNumber++;
            }
            System.out.println("Visitor history imported from " + filename);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public void printFileContent(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Contents of the file " + filename + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
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
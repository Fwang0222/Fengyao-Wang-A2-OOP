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

// Ride interface defining common actions for all ride types
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

// Abstract Ride class implementing RideInterface and providing common functionality for all rides
abstract class Ride implements RideInterface {
    private String rideName;
    private int rideId;
    private Employee rideOperator;
    private String suitablePopulation;
    private final Queue<Visitor> queue;
    private final List<Visitor> rideHistory;
    private int maxRider;
    private int numOfCycles;

    // Default constructor initializing fields to default values
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

    // Parameterized constructor to initialize fields with provided values
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

    // Method to add a visitor to the ride queue
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            queue.add(visitor);
            System.out.println(visitor.getName() + " has been added to " + rideName + " queue.");
        } else {
            System.out.println("Failed to add.");
        }
    }

    // Method to remove a visitor from the ride queue
    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.remove(visitor)) {
            System.out.println(visitor.getName() + " has been removed from " + rideName + " queue.");
        } else {
            System.out.println("Failed to remove.");
        }
    }

    // Method to print the current queue of visitors
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

    // Method to run one cycle of the ride with the visitors in the queue
    @Override
    public void runOneCycle() {
        // Check if there is a ride operator assigned to the ride
        if (rideOperator == null) {
            System.out.println("Can not run the ride, because there is no ride operator.");
            return;
        }

        // Check if the queue of visitors is empty
        if (queue.isEmpty()) {
            System.out.println("Can not run the ride, because queue is empty.");
            return;
        }

        // Determine the number of visitors to ride in this cycle, limited by maxRider
        int riders = Math.min(queue.size(), maxRider);
        System.out.println("Running one cycle of " + rideName + " with " + riders + " visitors.");

        // Process each visitor in the queue and add them to the ride history
        for (int i = 0; i < riders; i++) {
            Visitor visitor = queue.poll(); // Remove the first visitor from the queue
            addVisitorToHistory(visitor); // Add the visitor to the ride history
        }

        // Increment the cycle count
        numOfCycles++;
        System.out.println(rideName + " has been run for " + numOfCycles + " cycle(s).");
    }

    // Method to add a visitor to the ride history
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println(visitor.getName() + " has been added to " +  rideName + " history.");
        } else {
            System.out.println("Failed to add.");
        }
    }

    // Method to check if a visitor exists in the ride history
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    // Method to get the number of visitors in the ride history
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    // Method to print the ride history
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history is empty.");
        } else {
            Iterator<Visitor> iterator = rideHistory.iterator();
            System.out.println("Visitors in the ride history for " + rideName + ":");
            // Loop through and print each visitor's information in the history
            while (iterator.hasNext()) {
                Visitor v = iterator.next();
                System.out.println("Age: " + v.getAge() + " Name: " + v.getName());
            }
        }
    }

    // Method to sort the ride history based on a custom comparator
    public void sortRideHistory(Comparator<Visitor> comparator) {
        rideHistory.sort(comparator);
        System.out.println(rideName + " history has been sorted.");
    }

    // Method to export ride history to a CSV file
    public void exportRideHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Loop through each visitor in the ride history and write their data to the file
            for (Visitor visitor : rideHistory) {
                String visitorData = visitor.getName() + "," + visitor.getAge() + "," + visitor.getGender() + ","
                        + visitor.getTelephone() + "," + visitor.getHeight() + "," + visitor.getEmail() + "," + visitor.getHasFastPass();
                writer.write(visitorData); // Write visitor data as a CSV line
                writer.newLine(); // Add a new line after each entry
            }
            System.out.println("Visitor history exported to " + filename);
        } catch (IOException e) {
            // Catch any IOException that occurs during file writing
            System.out.println("Error exporting ride history: " + e.getMessage());
        }
    }

    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(","); // Split the line by commas

                if (data.length == 7) { // Ensure the line has 7 parts
                    try {
                        String name = data[0].trim();
                        int age = Integer.parseInt(data[1].trim());
                        String gender = data[2].trim();
                        String telephone = data[3].trim();
                        String height = data[4].trim();
                        String email = data[5].trim();
                        boolean hasFastPass = Boolean.parseBoolean(data[6].trim());

                        // Create a new Visitor object from the data
                        Visitor visitor = new Visitor(name, age, gender, telephone, height, email, hasFastPass);
                        rideHistory.add(visitor); // Add the visitor to the ride history
                        System.out.println("Visitor " + name + " imported successfully.");

                    } catch (NumberFormatException e) {
                        // Handle errors in parsing numerical values (e.g., age)
                        System.out.println("Error parsing age on line " + lineNumber + ": " + e.getMessage());
                    } catch (Exception e) {
                        // Handle other types of errors
                        System.out.println("Error processing line " + lineNumber + ": " + e.getMessage());
                    }
                } else {
                    // Skip invalid lines with incorrect number of columns
                    System.out.println("Skipping invalid line " + lineNumber + ": " + line);
                }
                lineNumber++;
            }
            System.out.println("Visitor history imported from " + filename);
        } catch (IOException e) {
            // Catch and print any IOException that occurs during file reading
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    // Method to print the content of a file
    public void printFileContent(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Contents of the file " + filename + ":");
            // Read and print each line from the file
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Catch and print any IOException that occurs during file reading
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    // Getter and Setter methods for ride properties
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
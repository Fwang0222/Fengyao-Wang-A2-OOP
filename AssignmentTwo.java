public class AssignmentTwo {
    public static void main(String[] args) {
        // Create an instance of AssignmentTwo to run all parts of the assignment
        AssignmentTwo assignmentTwo = new AssignmentTwo();

        // Run the methods for each part of the assignment
        assignmentTwo.partThree();
        assignmentTwo.partFourA();
        assignmentTwo.partFourB();
        assignmentTwo.partFive();
        assignmentTwo.partSix();
        assignmentTwo.partSeven();
    }

    // Part Three - Implementing a roller coaster ride and adding/removing visitors from the queue
    public void partThree() {
        // Define the RollerCoaster ride class as a subclass of Ride
        class RollerCoaster extends Ride {
            public RollerCoaster(String rideName, int rideId, Employee rideOperator, String suitablePopulation, int maxSize, int numOfCycles) {
                super(rideName, rideId, rideOperator, suitablePopulation, maxSize, numOfCycles);
            }
        }

        // Create a ride operator (Employee) for the RollerCoaster
        Employee e1 = new Employee("Jack", 25, "Male", "10001", 101, "Operation department", "None");
        // Instantiate a new RollerCoaster ride
        RollerCoaster rollerCoaster = new RollerCoaster("Roller Coaster", 1, e1, "Higher than 155cm, lower than 210cm", 40, 0);

        // Create visitors for the RollerCoaster
        Visitor v1 = new Visitor("Amy", 19, "Female", "1234561","175cm", "121@ab.com", true);
        Visitor v2 = new Visitor("James", 28, "Male", "1234562", "179cm", "122@ab.com", false);
        Visitor v3 = new Visitor("Linda", 19, "Female", "1234563", "167cm", "123@ab.com", false);
        Visitor v4 = new Visitor("Faye", 20, "Male", "1234564", "186cm", "124@ab.com", true);
        Visitor v5 = new Visitor("Karen", 25, "Male", "1234565", "183cm", "125@ab.com", false);

        // Add visitors to the RollerCoaster queue
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        // Remove a visitor from the queue
        rollerCoaster.removeVisitorFromQueue(v3);

        // Print the current queue
        rollerCoaster.printQueue();
    }

    // Part Four A - Implementing a new ride and interacting with ride history
    public void partFourA() {
        // Define the TheWizardOfOz ride class as a subclass of Ride
        class TheWizardOfOz extends Ride {
            public TheWizardOfOz(String rideName, int rideId, Employee rideOperator, String suitablePopulation, int maxSize, int numOfCycles) {
                super(rideName, rideId, rideOperator, suitablePopulation, maxSize, numOfCycles);
            }
        }

        // Create a ride operator (Employee) for TheWizardOfOz ride
        Employee e2 = new Employee("Jakie", 27, "Male", "10002", 102, "Operation department", "None");
        // Instantiate a new TheWizardOfOz ride
        TheWizardOfOz theWizardofOz = new TheWizardOfOz("The Wizard of Oz", 2, e2, "None", 50, 0);

        // Create visitors for TheWizardOfOz ride
        Visitor v6 = new Visitor("Emily", 25, "Female", "1234566", "175cm", "126@ab.com", true);
        Visitor v7 = new Visitor("Peter", 28, "Male", "1234567", "182cm", "127@ab.com", false);
        Visitor v8 = new Visitor("Charlie", 22, "Male", "1234568", "169cm", "128@ab.com", false);
        Visitor v9 = new Visitor("Davis", 30, "Female", "1234569", "163cm", "129@ab.com", true);
        Visitor v10 = new Visitor("Ali", 26, "Female", "1234570", "155cm", "130@ab.com", false);

        // Add visitors to the ride history
        theWizardofOz.addVisitorToHistory(v6);
        theWizardofOz.addVisitorToHistory(v7);
        theWizardofOz.addVisitorToHistory(v8);
        theWizardofOz.addVisitorToHistory(v9);
        theWizardofOz.addVisitorToHistory(v10);

        // Check if a visitor is in the history
        System.out.println("Is Bob in " + theWizardofOz.getRideName() + " history? " + theWizardofOz.checkVisitorFromHistory(v7));

        // Print the number of visitors in the ride history
        System.out.println("Number of visitors in " + theWizardofOz.getRideName() + " history: " + theWizardofOz.numberOfVisitors());

        // Print the full ride history
        theWizardofOz.printRideHistory();
    }

    // Part Four B - Sorting ride history and printing before/after sorting
    public void partFourB() {
        // Define the GreenLanternCoaster ride class as a subclass of Ride
        class GreenLanternCoaster extends Ride {
            public GreenLanternCoaster(String rideName, int rideId, Employee rideOperator, String suitablePopulation, int maxSize, int numOfCycles) {
                super(rideName, rideId, rideOperator, suitablePopulation, maxSize, numOfCycles);
            }
        }

        // Create a ride operator (Employee) for GreenLanternCoaster ride
        Employee e3 = new Employee("Black", 32, "Male", "10003", 103, "Operation department", "None");
        // Instantiate a new GreenLanternCoaster ride
        GreenLanternCoaster greenLanternCoaster = new GreenLanternCoaster("Green Lantern Coaster", 3, e3, "None", 20, 0);

        // Create visitors for GreenLanternCoaster ride
        Visitor v11 = new Visitor("Erica", 23, "Female", "1234571", "167cm", "131@ab.com", false);
        Visitor v12 = new Visitor("Faye", 22, "Male", "1234572", "187cm", "132@ab.com", false);
        Visitor v13 = new Visitor("Bailey", 22, "Female", "1234573", "161cm", "133@ab.com", true);
        Visitor v14 = new Visitor("Eliza", 31, "Male", "1234574", "192cm", "134@ab.com", true);
        Visitor v15 = new Visitor("Hope", 29, "Male", "1234575", "178cm", "135@ab.com", false);

        // Add visitors to the ride history
        greenLanternCoaster.addVisitorToHistory(v11);
        greenLanternCoaster.addVisitorToHistory(v12);
        greenLanternCoaster.addVisitorToHistory(v13);
        greenLanternCoaster.addVisitorToHistory(v14);
        greenLanternCoaster.addVisitorToHistory(v15);

        // Print the ride history before sorting
        System.out.println("Before sorting:");
        greenLanternCoaster.printRideHistory();

        // Sort the ride history using a custom comparator
        greenLanternCoaster.sortRideHistory(new VisitorComparator());

        // Print the ride history after sorting
        System.out.println("After sorting:");
        greenLanternCoaster.printRideHistory();
    }

    // Part Five - Running a ride cycle and updating the visitor queue and history
    public void partFive() {
        // Define the YosemiteSamRailroad ride class as a subclass of Ride
        class YosemiteSamRailroad extends Ride {
            public YosemiteSamRailroad(String rideName, int rideId, Employee rideOperator, String suitablePopulation, int maxSize, int numOfCycles) {
                super(rideName, rideId, rideOperator, suitablePopulation, maxSize, numOfCycles);
            }
        }

        // Create a ride operator (Employee) for YosemiteSamRailroad ride
        Employee e4 = new Employee("Fade", 26, "Male", "10004", 104, "Operation department", "None");
        // Instantiate a new YosemiteSamRailroad ride
        YosemiteSamRailroad yosemiteSamRailroad = new YosemiteSamRailroad("Yosemite Sam Railroad", 4, e4, "Height less than 110cm must be accompanied by an adult", 5, 0);

        // Create visitors for YosemiteSamRailroad ride
        Visitor[] visitors = {
                new Visitor("Angela", 28, "Female", "1234576", "158cm", "201@ab.com", false),
                new Visitor("John", 35, "Male", "1234577", "175cm", "202@ab.com", true),
                new Visitor("Sophie", 22, "Female", "1234578", "165cm", "203@ab.com", true),
                new Visitor("David", 40, "Male", "1234579", "180cm", "204@ab.net", false),
                new Visitor("Emily", 19, "Female", "1234580", "160cm", "205@ab.com", true),
                new Visitor("Michael", 30, "Male", "1234581", "170cm", "206@ab.com", false),
                new Visitor("Olivia", 25, "Female", "1234582", "155cm", "207@ab.com", true),
                new Visitor("James", 32, "Male", "1234583", "178cm", "208@ab.net", false),
                new Visitor("Lily", 27, "Female", "1234584", "162cm", "209@ab.com", false),
                new Visitor("William", 38, "Male", "1234585", "183cm", "210@ab.com", true)
        };

        // Add visitors to the queue for the YosemiteSamRailroad ride
        for (Visitor visitor : visitors) {
            yosemiteSamRailroad.addVisitorToQueue(visitor);
        }

        // Print the queue before running one cycle
        System.out.println("Before run one cycle:");
        yosemiteSamRailroad.printQueue();

        // Print the queue before running one cycle
        yosemiteSamRailroad.runOneCycle();

        // Print the queue after the cycle
        System.out.println("After run one cycle:");
        yosemiteSamRailroad.printQueue();

        // Print the ride history after one cycle
        yosemiteSamRailroad.printRideHistory();
    }

    // Part Six - This section defines a ride called "DOOMSDAYDestroyer" and creates an operator
    public void partSix() {
        // Define another ride: DOOMSDAYDestroyer
        class DOOMSDAYDestroyer extends Ride {
            public DOOMSDAYDestroyer(String rideName, int rideId, Employee rideOperator, String suitablePopulation, int maxSize, int numOfCycles) {
                super(rideName, rideId, rideOperator, suitablePopulation, maxSize, numOfCycles);
            }
        }

        // Create an operator for the DOOMSDAYDestroyer ride
        Employee e5 = new Employee("Sophia", 32, "Female", "10005", 105, "Operation department", "None");
        // Instantiate the DOOMSDAYDestroyer ride with relevant details
        DOOMSDAYDestroyer doomsdayDestroyer = new DOOMSDAYDestroyer("DOOMSDAY Destroyer", 5, e5, "Height more than 130cm and less than 200cm", 30, 0);

        // Instantiate the DOOMSDAYDestroyer ride with relevant details
        Visitor[] visitors = {
                new Visitor("Barry", 23, "Male", "1234586", "176cm", "211@ab.com", false),
                new Visitor("Arthur", 18, "Male", "1234587", "189cm", "212@ab.com", false),
                new Visitor("Devon", 29, "Male", "1234588", "178cm", "213@ab.com", false),
                new Visitor("Dennis", 32, "Male", "1234589", "182cm", "214@ab.net", true),
                new Visitor("Neil", 23, "Male", "1234590", "169cm", "215@ab.com", true),
        };

        // Add visitors to the ride history
        for (Visitor visitor : visitors) {
            doomsdayDestroyer.addVisitorToHistory(visitor);
        }

        // Export the ride history to a CSV file
        doomsdayDestroyer.exportRideHistory("rideHistory.csv");
    }

    // Part Seven - This section creates a Test class "Test" that simulates importing the ride history from a CSV file and printing the file contents
    public void partSeven() {
        // Define a test class to simulate the importing and printing of ride history
        class Test extends Ride {
            public Test(String rideName, int rideId, Employee rideOperator, String suitablePopulation, int maxSize, int numOfCycles) {
                super(rideName, rideId, rideOperator, suitablePopulation, maxSize, numOfCycles);
            }
        }

        // Create a "dummy" employee for the Test ride
        Employee t = new Employee("none", 0, "none", "Unknown", 0, "Unknown", "Unknown");
        // Instantiate the Test ride
        Test test = new Test("Test", 5, t, "Height more than 123cm", 30, 0);

        // Import the ride history from the CSV file
        test.importRideHistory("rideHistory.csv");

        // Print the contents of the CSV file
        test.printFileContent("rideHistory.csv");

        // Output the number of visitors in the history
        System.out.println("Number of visitors history: " + test.numberOfVisitors());

        // Print the ride history after importing it from the CSV
        test.printRideHistory();
    }
}
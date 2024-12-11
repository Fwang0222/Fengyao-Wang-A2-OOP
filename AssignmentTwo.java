public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignmentTwo = new AssignmentTwo();

        assignmentTwo.partThree();
        assignmentTwo.partFourA();
        assignmentTwo.partFourB();
        assignmentTwo.partFive();
        assignmentTwo.partSix();
        assignmentTwo.partSeven();
    }

    public void partThree() {
        class RollerCoaster extends Ride {
            public RollerCoaster(String rideName, int rideId, Employee rideOperator, String suitablePopulation, int maxSize, int numOfCycles) {
                super(rideName, rideId, rideOperator, suitablePopulation, maxSize, numOfCycles);
            }
        }

        Employee e1 = new Employee("Jack", 25, "Male", "10001", 101, "Operation department", "None");
        RollerCoaster rollerCoaster = new RollerCoaster("Roller Coaster", 1, e1, "Higher than 155cm, lower than 210cm", 40, 0);

        Visitor v1 = new Visitor("Amy", 19, "Female", "1234561","175cm", "121@ab.com", true);
        Visitor v2 = new Visitor("James", 28, "Male", "1234562", "179cm", "122@ab.com", false);
        Visitor v3 = new Visitor("Linda", 19, "Female", "1234563", "167cm", "123@ab.com", false);
        Visitor v4 = new Visitor("Faye", 20, "Male", "1234564", "186cm", "124@ab.com", true);
        Visitor v5 = new Visitor("Karen", 25, "Male", "1234565", "183cm", "125@ab.com", false);

        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        rollerCoaster.removeVisitorFromQueue(v3);

        rollerCoaster.printQueue();
    }

    public void partFourA() {
        class TheWizardOfOz extends Ride {
            public TheWizardOfOz(String rideName, int rideId, Employee rideOperator, String suitablePopulation, int maxSize, int numOfCycles) {
                super(rideName, rideId, rideOperator, suitablePopulation, maxSize, numOfCycles);
            }
        }

        Employee e2 = new Employee("Jakie", 27, "Male", "10002", 102, "Operation department", "None");
        TheWizardOfOz theWizardofOz = new TheWizardOfOz("The Wizard of Oz", 2, e2, "None", 50, 0);

        Visitor v6 = new Visitor("Emily", 25, "Female", "1234566", "175cm", "126@ab.com", true);
        Visitor v7 = new Visitor("Peter", 28, "Male", "1234567", "182cm", "127@ab.com", false);
        Visitor v8 = new Visitor("Charlie", 22, "Male", "1234568", "169cm", "128@ab.com", false);
        Visitor v9 = new Visitor("Davis", 30, "Female", "1234569", "163cm", "129@ab.com", true);
        Visitor v10 = new Visitor("Ali", 26, "Female", "1234570", "155cm", "130@ab.com", false);

        theWizardofOz.addVisitorToHistory(v6);
        theWizardofOz.addVisitorToHistory(v7);
        theWizardofOz.addVisitorToHistory(v8);
        theWizardofOz.addVisitorToHistory(v9);
        theWizardofOz.addVisitorToHistory(v10);

        System.out.println("Is Bob in " + theWizardofOz.getRideName() + " history? " + theWizardofOz.checkVisitorFromHistory(v7));

        System.out.println("Number of visitors in " + theWizardofOz.getRideName() + " history: " + theWizardofOz.numberOfVisitors());

        theWizardofOz.printRideHistory();
    }

    public void partFourB() {
        class GreenLanternCoaster extends Ride {
            public GreenLanternCoaster(String rideName, int rideId, Employee rideOperator, String suitablePopulation, int maxSize, int numOfCycles) {
                super(rideName, rideId, rideOperator, suitablePopulation, maxSize, numOfCycles);
            }
        }

        Employee e3 = new Employee("Black", 32, "Male", "10003", 103, "Operation department", "None");
        GreenLanternCoaster greenLanternCoaster = new GreenLanternCoaster("Green Lantern Coaster", 3, e3, "None", 20, 0);

        Visitor v11 = new Visitor("Erica", 23, "Female", "1234571", "167cm", "131@ab.com", false);
        Visitor v12 = new Visitor("Faye", 22, "Male", "1234572", "187cm", "132@ab.com", false);
        Visitor v13 = new Visitor("Bailey", 22, "Female", "1234573", "161cm", "133@ab.com", true);
        Visitor v14 = new Visitor("Eliza", 31, "Male", "1234574", "192cm", "134@ab.com", true);
        Visitor v15 = new Visitor("Hope", 29, "Male", "1234575", "178cm", "135@ab.com", false);

        greenLanternCoaster.addVisitorToHistory(v11);
        greenLanternCoaster.addVisitorToHistory(v12);
        greenLanternCoaster.addVisitorToHistory(v13);
        greenLanternCoaster.addVisitorToHistory(v14);
        greenLanternCoaster.addVisitorToHistory(v15);

        System.out.println("Before sorting:");
        greenLanternCoaster.printRideHistory();

        greenLanternCoaster.sortRideHistory(new VisitorComparator());

        System.out.println("After sorting:");
        greenLanternCoaster.printRideHistory();
    }

    public void partFive() {
        class YosemiteSamRailroad extends Ride {
            public YosemiteSamRailroad(String rideName, int rideId, Employee rideOperator, String suitablePopulation, int maxSize, int numOfCycles) {
                super(rideName, rideId, rideOperator, suitablePopulation, maxSize, numOfCycles);
            }
        }

        Employee e4 = new Employee("Fade", 26, "Male", "10004", 104, "Operation department", "None");
        YosemiteSamRailroad yosemiteSamRailroad = new YosemiteSamRailroad("Yosemite Sam Railroad", 4, e4, "Height less than 110cm must be accompanied by an adult", 5, 0);

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

        for (Visitor visitor : visitors) {
            yosemiteSamRailroad.addVisitorToQueue(visitor);
        }

        System.out.println("Before run one cycle:");
        yosemiteSamRailroad.printQueue();

        yosemiteSamRailroad.runOneCycle();

        System.out.println("After run one cycle:");
        yosemiteSamRailroad.printQueue();

        yosemiteSamRailroad.printRideHistory();
    }

    public void partSix() {
        class DOOMSDAYDestroyer extends Ride {
            public DOOMSDAYDestroyer(String rideName, int rideId, Employee rideOperator, String suitablePopulation, int maxSize, int numOfCycles) {
                super(rideName, rideId, rideOperator, suitablePopulation, maxSize, numOfCycles);
            }
        }

        Employee e5 = new Employee("Sophia", 32, "Female", "10005", 105, "Operation department", "None");
        DOOMSDAYDestroyer doomsdayDestroyer = new DOOMSDAYDestroyer("DOOMSDAY Destroyer", 5, e5, "Height more than 130cm and less than 200cm", 30, 0);

        Visitor[] visitors = {
                new Visitor("Barry", 23, "Male", "1234586", "176cm", "211@ab.com", false),
                new Visitor("Arthur", 18, "Male", "1234587", "189cm", "212@ab.com", false),
                new Visitor("Devon", 29, "Male", "1234588", "178cm", "213@ab.com", false),
                new Visitor("Dennis", 32, "Male", "1234589", "182cm", "214@ab.net", true),
                new Visitor("Neil", 23, "Male", "1234590", "169cm", "215@ab.com", true),
        };

        for (Visitor visitor : visitors) {
            doomsdayDestroyer.addVisitorToHistory(visitor);
        }

        doomsdayDestroyer.exportRideHistory("rideHistory.csv");
    }

    public void partSeven() {
        class Test extends Ride {
            public Test(String rideName, int rideId, Employee rideOperator, String suitablePopulation, int maxSize, int numOfCycles) {
                super(rideName, rideId, rideOperator, suitablePopulation, maxSize, numOfCycles);
            }
        }

        Employee t = new Employee("none", 0, "none", "Unknown", 0, "Unknown", "Unknown");
        Test test = new Test("Test", 5, t, "Height more than 123cm", 30, 0);

        test.importRideHistory("rideHistory.csv");

        test.printFileContent("rideHistory.csv");

        System.out.println("Number of visitors history: " + test.numberOfVisitors());

        test.printRideHistory();
    }
}
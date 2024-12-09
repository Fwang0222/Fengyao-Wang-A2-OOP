public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignmentTwo = new AssignmentTwo();

        assignmentTwo.partFive();
    }

    public void partThree() {
        class RollerCoaster extends Ride {
            public RollerCoaster(String rideName, int rideId, Employee rideOperator, String suitablePopulation, int maxSize, int numOfCycles) {
                super(rideName, rideId, rideOperator, suitablePopulation, maxSize, numOfCycles);
            }
        }

        Employee e1 = new Employee("Jack", 25, "Male", "1234567", 101, "Operation department", "None");
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

        Employee e2 = new Employee("Jakie", 27, "Male", "1234568", 102, "Operation department", "None");
        TheWizardOfOz theWizardofOz = new TheWizardOfOz("The Wizard of Oz", 2, e2, "None", 50, 0);

        Visitor v6 = new Visitor("Emily", 25, "Female", "1234566", "175cm", "126@ab.com", true);
        Visitor v7 = new Visitor("Peter", 28, "Male", "1234567", "182cm", "127@ab.com", false);
        Visitor v8 = new Visitor("Charlie", 22, "Male", "1234568", "169cm", "128@ab.com", false);
        Visitor v9 = new Visitor("Davis", 30, "Female", "1234569", "163cm", "129@ab.com", true);
        Visitor v10 = new Visitor("Ali", 26, "Female", "1234571", "155cm", "131@ab.com", false);

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

        Employee e3 = new Employee("Black", 32, "Male", "1234569", 103, "Operation department", "None");
        GreenLanternCoaster greenLanternCoaster = new GreenLanternCoaster("Green Lantern Coaster", 3, e3, "None", 20, 0);

        Visitor v11 = new Visitor("Erica", 23, "Female", "1234572", "167cm", "132@ab.com", false);
        Visitor v12 = new Visitor("Faye", 22, "Male", "1234573", "187cm", "133@ab.com", false);
        Visitor v13 = new Visitor("Bailey", 22, "Female", "1234574", "161cm", "134@ab.com", true);
        Visitor v14 = new Visitor("Eliza", 31, "Male", "1234575", "192cm", "135@ab.com", true);
        Visitor v15 = new Visitor("Hope", 29, "Male", "1234576", "178cm", "136@ab.com", false);

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

        Employee e4 = new Employee("Fade", 26, "Male", "1234571", 104, "Operation department", "None");
        YosemiteSamRailroad yosemiteSamRailroad = new YosemiteSamRailroad("Yosemite Sam Railroad", 4, e4, "Height less than 110cm must be accompanied by an adult", 5, 0);

        Visitor[] visitors = {
                new Visitor("Angela", 28, "Female", "1234577", "158cm", "201@ab.com", false),
                new Visitor("John", 35, "Male", "9876543", "175cm", "john@xyz.com", true),
                new Visitor("Sophie", 22, "Female", "2345678", "165cm", "sophie@gmail.com", true),
                new Visitor("David", 40, "Male", "8765432", "180cm", "david@ab.net", false),
                new Visitor("Emily", 19, "Female", "3456789", "160cm", "emily@outlook.com", true),
                new Visitor("Michael", 30, "Male", "5432109", "170cm", "michael@yahoo.com", false),
                new Visitor("Olivia", 25, "Female", "6543210", "155cm", "olivia@hotmail.com", true),
                new Visitor("James", 32, "Male", "4321098", "178cm", "james@xyz.net", false),
                new Visitor("Lily", 27, "Female", "1230987", "162cm", "lily@aol.com", false),
                new Visitor("William", 38, "Male", "8765912", "183cm", "william@outlook.com", true)
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

    }

    public void partSeven() {

    }
}
public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignmentTwo = new AssignmentTwo();

        assignmentTwo.partThree();
        assignmentTwo.partFourA();
        assignmentTwo.partFourB();
    }

    public void partThree() {
        class RollerCoaster extends Ride {
            public RollerCoaster(String rideName, int rideId, Employee rideOperator, String suitablePopulation) {
                super(rideName, rideId, rideOperator, suitablePopulation);
            }
        }

        Employee e1 = new Employee("Jack", 25, "Male", "1234567", 101, "Operation department", "None");
        RollerCoaster rollerCoaster = new RollerCoaster("Roller Coaster", 1, e1, "Higher than 155cm, lower than 210cm");

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
            public TheWizardOfOz(String rideName, int rideId, Employee rideOperator, String suitablePopulation) {
                super(rideName, rideId, rideOperator, suitablePopulation);
            }
        }

        Employee e2 = new Employee("Jakie", 27, "Male", "1234568", 102, "Operation department", "None");
        TheWizardOfOz theWizardofOz = new TheWizardOfOz("The Wizard of Oz", 2, e2, "None");

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
            public GreenLanternCoaster(String rideName, int rideId, Employee rideOperator, String suitablePopulation) {
                super(rideName, rideId, rideOperator, suitablePopulation);
            }
        }

        Employee e3 = new Employee("Black", 32, "Male", "1234569", 103, "Operation department", "None");
        GreenLanternCoaster greenLanternCoaster = new GreenLanternCoaster("Green Lantern Coaster", 3, e3, "None");

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

    }

    public void partSix() {

    }

    public void partSeven() {

    }
}
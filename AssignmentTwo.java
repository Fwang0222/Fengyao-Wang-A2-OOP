public class AssignmentTwo {
    public static void main(String[] args) {
        Employee operator1 = new Employee("Jack", 25, "Male", "1234567", 101, "Operation department", "None");
        Visitor visitor1 = new Visitor("Amy", 19, "Female", "1234568","175cm", "123@ab.com", true);
        Visitor visitor2 = new Visitor("James", 28, "Male", "12345679", "179cm", "124@ab.com", false);

        class RollerCoaster extends Ride {
            public RollerCoaster(String rideName, int rideId, Employee rideOperator, String suitablePopulation) {
                super(rideName, rideId, rideOperator, suitablePopulation);
            }
        }

        RollerCoaster rollerCoaster = new RollerCoaster("Roller Coaster", 1, operator1, "up to 170cm");

        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);

        rollerCoaster.printQueue();

        rollerCoaster.runOneCycle();

        rollerCoaster.addVisitorToHistory(visitor1);
        rollerCoaster.addVisitorToHistory(visitor2);

        rollerCoaster.printRideHistory();

        System.out.println("Is Amy in history? " + rollerCoaster.checkVisitorFromHistory(visitor1));

    }

    public void partThree() {

    }

    public void partFourA() {

    }

    public void partFourB() {


    }

    public void partFive() {

    }

    public void partSix() {

    }

    public void partSeven() {

    }
}
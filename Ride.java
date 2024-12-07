public class Ride {
    private String rideName;
    private int rideId;
    private Employee rideOperator;
    private String suitablePopulation;

    public Ride() {
        this.rideName = "Unknown";
        this.rideId = 0;
        this.rideOperator = null;
        this.suitablePopulation = "Unknown";
    }

    public Ride(String rideName, int rideId, Employee rideOperator, String suitablePopulation) {
        this.rideName = rideName;
        this.rideId = rideId;
        this.rideOperator = rideOperator;
        this.suitablePopulation = suitablePopulation;
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

// Visitor class extending Person, adding specific fields for a visitor
public class Visitor extends Person {
    private String height;
    private String email;
    private boolean hasFastPass;

    // Default constructor initializing fields to default values
    public Visitor() {
        super();
        this.height = "Unknown";
        this.email = "Unknown";
        this.hasFastPass = false;
    }

    // Parameterized constructor to initialize fields with provided values
    public Visitor(String name, int age, String gender, String telephone, String height, String email, boolean hasFastPass) {
        super(name, age, gender, telephone);
        this.height = height;
        this.email = email;
        this.hasFastPass = hasFastPass;
    }

    // Getter and setter methods for each field
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getHasFastPass() {
        return hasFastPass;
    }

    public void setHasFastPass(boolean hasFastPass) {
        this.hasFastPass = hasFastPass;
    }
}

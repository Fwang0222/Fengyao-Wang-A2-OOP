// Employee class extending Person, adding specific fields for an employee
public class Employee extends Person {
    private int id;
    private String department;
    private String address;

    // Default constructor initializing fields to default values
    public Employee() {
        super();
        this.id = 0;
        this.department = "Unknown";
        this.address = "Unknown";
    }

    // Parameterized constructor to initialize fields with provided values
    public Employee(String name, int age, String gender, String telephone, int id, String department, String address) {
        super(name, age, gender, telephone);
        this.id = id;
        this.department = department;
        this.address = address;
    }

    // Getter and setter methods for each field
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

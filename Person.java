// Abstract class representing a Person with basic personal information
public abstract class Person {
    private String name;
    private int age;
    private String gender;
    private String telephone;

    // Default constructor initializing fields to default values
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.gender = "Unknown";
        this.telephone = "Unknown";
    }

    // Parameterized constructor to initialize fields with provided values
    public Person(String name, int age, String gender, String telephone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.telephone = telephone;
    }

    // Getter and setter methods for each field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}

package office;

public class Unit {

    private int id;
    private String name;
    private String phoneNumber;
    private Employee[] employees = new Employee[50];

    public Unit(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Employee[] getEmployees() {
        return employees;
    }
}

package BaiTap37PrintWriter;

public class Employee {
    private static int nextID = 101;
    private String id;
    private String fullName;
    private String address;
    private int age;
    private String phoneNumber;
    private float salary;
    private float experience;

    public Employee() {
        setId();
        id = "";
        fullName = "";
        address = "";
        age = 0;
        phoneNumber = "";
        salary = 0;
        experience = 0;
    }

    public Employee(String id) {
        if (id == null) {
            setId();
        } else {
            this.id = id;
        }
    }

    public Employee(String id, String fullName) {
        this(id);
        this.fullName = fullName;
    }

    public Employee(String id, String fullName, String address) {
        this(id, fullName);
        this.address = address;
    }

    public Employee(String id, String fullName, String address, int age) {
        this(id, fullName, address);
        this.age = age;
    }

    public Employee(String id, String fullName,
                    String address, int age, String phoneNumber) {
        this(id, fullName, address, age);
        this.phoneNumber = phoneNumber;
    }

    public Employee(String id, String fullName, String address,
                    int age, String phoneNumber, float salary) {
        this(id, fullName, address, age, phoneNumber);
        this.salary = salary;
    }

    public Employee(String id, String fullName, String address,
                    int age, String phoneNumber, float salary, float experience) {
        this(id, fullName, address, age, phoneNumber, salary);
        this.experience = experience;
    }

    public static void setNextID(int nextID) {
        Employee.nextID = nextID;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = "EMP" + nextID;
        nextID++;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }
}

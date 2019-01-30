package lab1b;

public class Student extends Person {

    public final static String freshman = "freshman";
    public final static String sophmore = "sophmore";
    public final static String junior = "junior";
    public final static String senior = "senior";
    private String status;

    public Student(String name, String address, String phone, String email, String status) {
        super(name, address, phone, email);
        this.status = status;
    }

    public String toString() {
        System.out.println("Student: " + this.name);
        System.out.println("Status: " + this.status);
        super.toString();
        return "";
    }
}

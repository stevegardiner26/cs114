package lab1b;

public class Staff extends Employee {

    String title;

    public Staff(String name, String address, String phone, String email, String officenum, String salary, String datehired, String title) {
        super(name, address, phone, email, officenum, salary, datehired);
        this.title = title;
    }

    public String toString() {
        System.out.println("Staff: " + this.name);
        super.toString();
        return "";
    }

}

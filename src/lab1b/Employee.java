package lab1b;

public class Employee extends Person {

    String officenum;
    String salary;
    String datehired;

    public Employee(String name, String address, String phone, String email, String officenum, String salary, String datehired) {
        super(name, address, phone, email);
        this.officenum = officenum;
        this.salary = salary;
        this.datehired = datehired;
    }

    public String toString() {
        System.out.println("Salary: " + this.salary);
        System.out.println("Date Hired: " + this.datehired);
        System.out.println("Office: " + this.officenum);
        super.toString();
        return "";
    }
}

package lab1b;

public class Faculty extends Employee {

    String officehours;
    String rank;

    public Faculty(String name, String address, String phone, String email, String officenum, String salary, String datehired, String rank, String officehours) {
        super(name, address, phone, email, officenum, salary, datehired);
        this.rank = rank;
        this.officehours = officehours;
    }

    public String toString() {
        System.out.println("Faculty: " + this.name);
        System.out.println("Rank: " + this.rank);
        System.out.println("Office Hours: " + this.officehours);
        super.toString();
        return "";
    }

}

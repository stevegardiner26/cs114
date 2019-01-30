package lab1b;

public class Person {

    String name;
    String address;
    String phone;
    String email;

    public Person() {
        this.name = "n/a";
        this.address = "n/a";
        this.phone = "n/a";
        this.email = "n/a";
    }

    public Person(String name, String address, String phone, String email){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    //@Override
    public String toString() {
        System.out.println("Address: " + this.address);
        System.out.println("Phone Number: " + this.phone);
        System.out.print("Email: " + this.email);
        return "";
    }
}

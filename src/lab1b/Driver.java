package lab1b;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        System.out.println("Enter 1 for a Student:");
        System.out.println("Enter 2 for an Employee:");
        Scanner input = new Scanner(System.in);
        String eval = input.next();
        if(eval.equals("1")) {
            Scanner input2 = new Scanner(System.in);
            System.out.print("Enter a name: ");
            String name = input2.nextLine();
            System.out.print("Enter an address: ");
            String address = input2.nextLine();
            System.out.print("Enter a phone number: ");
            String phone = input2.nextLine();
            System.out.print("Enter an email: ");
            String email = input2.nextLine();
            System.out.print("Enter a status: ");
            String status = input2.nextLine();
            Student member = new Student(name, address, phone, email, status);
            member.toString();
        } else if (eval.equals("2")) {
            Scanner input3 = new Scanner(System.in);
            System.out.print("Enter a name: ");
            String name = input3.nextLine();
            System.out.print("Enter a address: ");
            String address = input3.nextLine();
            System.out.print("Enter a phone number: ");
            String phone = input3.nextLine();
            System.out.print("Enter an email: ");
            String email = input3.nextLine();
            System.out.println("Enter 1 for a Faculty Member: ");
            System.out.println("Enter 2 for a Staff Member: ");
            eval = input.next();
            if(eval.equals("1")) {
                System.out.print("Enter office number: ");
                String officenum = input3.nextLine();
                System.out.print("Enter salary: ");
                String salary = input3.nextLine();
                System.out.print("Enter date hired (mm/dd/yy): ");
                String datehiredpre = input3.nextLine();
                MyDate datehired = new MyDate(datehiredpre);
                System.out.print("Enter rank: ");
                String rank = input3.nextLine();
                System.out.print("Enter office hours: ");
                String officehours = input3.nextLine();
                Faculty member = new Faculty(name, address, phone, email, officenum, salary, datehired.getDate(), rank, officehours);
                member.toString();
            } else if (eval.equals("2")) {
                System.out.print("Enter office number: ");
                String officenum = input3.nextLine();
                System.out.print("Enter salary: ");
                String salary = input3.nextLine();
                System.out.print("Enter date hired (mm/dd/yy): ");
                String datehiredpre = input3.nextLine();
                MyDate datehired = new MyDate(datehiredpre);
                System.out.print("Enter title: ");
                String title = input3.nextLine();
                Staff member = new Staff(name, address, phone, email, officenum, salary, datehired.getDate(), title);
                member.toString();
            }
        } else {
            System.out.println("You did not enter a proper number.");
        }
    }
}

package lab7a;
import java.io.*;
import java.util.*;

public class Driver {

    public static void main(String [] args) throws IOException {
        UALdictionary<String, StaffMember> dictionary1 = new UALdictionary<>();
        UALdictionary<String, StaffMember> dictionary2 = new UALdictionary<>();
        Scanner scanner = new Scanner(System.in);
        File file = new File("C:\\Users\\steve\\Documents\\GitHub\\cs114\\src\\lab7a\\employee.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                String [] stats = line.split(",");
                StaffMember staff = new StaffMember();
                staff.name = stats[0];
                staff.address = stats[1];
                staff.phone = stats[2];
                staff.SocialSec = stats[3];
                staff.Rate = Double.parseDouble(stats[4]);
                dictionary1.insert(staff.SocialSec, staff);
                dictionary2.insert(staff.name, staff);
                System.out.println(staff);
            }
        } finally {
            reader.close();
        }
        System.out.println("The Dictionary Size is " + dictionary1.size());
        String input = "";
        while (!input.equals("DONE")) {
            System.out.println("Enter 'S' to use SSN or 'N' to use name to access the record: (Type DONE to exit)");
            input = scanner.nextLine();
            if(input.equalsIgnoreCase("S")) {
                System.out.println("Enter SSN of Employee");
                input = scanner.nextLine();
                if(dictionary1.find(input) != null) {
                    System.out.println(dictionary1.find(input));
                } else {
                    System.out.println(input + " not found!");
                }
            } else if(input.equalsIgnoreCase("N")) {
                System.out.println("Enter Name of Employee");
                input = scanner.nextLine();
                if(dictionary2.find(input) != null) {
                    System.out.println(dictionary2.find(input));
                } else {
                    System.out.println(input + " not found!");
                }
            }
        }
    }

}

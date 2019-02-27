package lab3b;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Staff persons = new Staff();
        ArrayList a = new ArrayList();
        System.out.print(persons);
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < persons.getSize(); i++) {
            System.out.println(persons.getStaff(i));
        }
        System.out.println("Enter a name to display: ");
        String input = scanner.nextLine();
        int none = 0;
        for (int i = 0; i < persons.getSize(); i++) {
            if (persons.getStaff(i).name.equals(input)) {
                System.out.println(persons.getStaff(i));
                none = 0;
                return;
            } else {
                none = 1;
            }
        }
        if (none == 1) {
            System.out.println("Name not found");
        }
        System.out.println("Enter a name to delete: ");
        input = scanner.nextLine();
        none = 0;
        for (int i = 0; i < persons.getSize(); i++) {
            if (persons.getStaff(i).name.equals(input)) {
                /*if(persons.getStaff(i)) {

                }*/
                none = 0;
                return;
            } else {
                none = 1;
            }
        }
        if (none == 1) {
            System.out.println("Name not found");
        }
    }
}

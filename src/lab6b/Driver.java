package lab6b;
import java.io.*;
import java.util.*;

public class Driver {
    static TreeSet<String> nameSet = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        File file = new File("C:\\Users\\steve\\Documents\\GitHub\\cs114\\src\\lab6b\\employee.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                String name = line.split(",")[0];
                Iterator<String> itr = nameSet.iterator();
                boolean duplicate = false;
                while (itr.hasNext()) {
                    if(name.equals(itr.next().split(",")[0])) {
                        System.out.println(line + " is duplicated");
                        duplicate = true;
                    }
                }
                if(!duplicate) {
                    nameSet.add(line);
                }
            }
        } finally {
            reader.close();
        }

        String employee;

        do
        {
            System.out.print("Enter a name of a person (DONE to quit): ");
            employee = scan.nextLine();
            if (!employee.equalsIgnoreCase("DONE")) {
                if (employeeExists(employee)) {
                    System.out.println(employee + " is an Employee!");
                } else {
                    System.out.println(employee + " is not an Employee!");
                }
            }
        } while (!employee.equalsIgnoreCase("DONE"));
    }

    public static boolean employeeExists(String employee)
    {
        Iterator<String> itr = nameSet.iterator();
        while (itr.hasNext()) {
            if(employee.equals(itr.next().split(",")[0])) {
                return true;
            }
        }
        return false;
    }
}

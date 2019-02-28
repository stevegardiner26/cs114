package lab4a;
import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Maintain<E> extends LList<E> {

    public static void main(String[] args) throws IOException {
        System.out.println("Original List");
        String fileName = "C:\\Users\\steve\\Documents\\GitHub\\cs114\\src\\lab4a\\gamescore.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        LList<String> LL = new LList<>();
        Scanner scanner = new Scanner(System.in);
        String line;
        while((line = br.readLine()) != null){
            //process the line
            LL.append(line);
        }
        for(int i = 0; i < LL.length(); i++){
            System.out.println(LL.getValue());
            LL.next();
        }
        boolean trigger = false;
        String input = "";
        while (!trigger) {
            System.out.println("Enter A to add, D to delete game entry record or return to exit");
            input = scanner.nextLine();
            if(input.equals("A")) {
                System.out.println("Enter a Name:");
                String name = scanner.nextLine();
                System.out.println("Enter a Score:");
                String score = scanner.nextLine();
                LL.append(name + "," + score);
                System.out.println("(" + name + "," + score + ")");
            } else if (input.equals("D")) {
                System.out.println("Enter a Name:");
                String name = scanner.nextLine();
                boolean exists = false;
                for(int i = 0; i < LL.length(); i++){
                    if(LL.getValue().contains(name)){
                        exists = true;
                    }
                    LL.next();
                }
                if(exists) {
                    for(int i = 0; i < LL.length(); i++){
                        if(LL.getValue().split(",")[0].equals(name)){
                            LL.remove();
                        }
                        LL.next();
                    }
                    LL.remove();
                } else {
                    System.out.println(name + " doesn't exist");
                }
            } else if (input.equals("")) {
                trigger = true;
                LL.moveToStart();
                for(int i = 0; i < LL.length(); i++){
                    System.out.println(LL.getValue());
                    LL.next();
                }
            }
        }
    }
}

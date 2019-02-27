package lab2;
import java.util.Scanner;

public class Recursion {
    //Here is the count method which is going to count how many times the char is within the string
    public static int amount = 0;
    public static void count(String str, char a) {
        //Checking if that character is the desired character
        if(str.charAt(0) == a) {
            //Adding 1 to the counters
            amount++;
        }
        //Restarting the Function to check a string without the first char
        if(str.length() > 1) {
            count(str.substring(1), a);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String to search: ");
        String string = scanner.nextLine();
        System.out.print("Enter a Char: ");
        String b = scanner.nextLine();
        //Getting the char from the scanner string because the scanner returns a string
        char character = b.charAt(0);
        count(string, character);
        System.out.print(amount);
    }
}

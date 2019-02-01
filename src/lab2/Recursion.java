package lab2;
import java.util.Scanner;

public class Recursion {
    //Here is the count method which is going to count how many times the char is within the string
    public static int count(String str, char a) {
        //Defining a counter variable to 0
        int amount = 0;
        //Looping through the characters of the string
        for(int i = 0; i < str.length(); i++) {
            //Checking if that character is the desired character
            if(str.charAt(i) == a) {
                //Adding 1 to the counter
                amount++;
            }
        }
        //returning the counter
        return amount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String to search: ");
        String string = scanner.nextLine();
        System.out.print("Enter a Char: ");
        String b = scanner.nextLine();
        //Getting the char from the scanner string because the scanner returns a string
        char character = b.charAt(0);
        System.out.print(count(string, character));
    }
}

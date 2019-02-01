package lab2;
import java.util.Scanner;
import java.io.File;

public class Recursion2 {


    public static long getSize(File file) {
        //Setting the size to 0
        long size = 0;
        //Getting the children of the file into an array
        if(file.isDirectory()) {
            //Getting the list of contents within the file if it is a directory
            String[] fileContents = file.list();
            //Looping through each child file
            for(int i = 0; i < fileContents.length; i++) {
                //Getting this file and then getting the size through recursion
                File next = new File(file, fileContents[i]);
                size += getSize(next);
            }
        } else {
            //Getting the size of the file and adding it to the total size
            size += file.length();
        }
        //Returning the total size
        return size;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file path to get the size of the file: ");
        String path = scanner.nextLine();
        //Creating a new file object from the given path
        File file = new File(path);
        System.out.print(getSize(file));
    }
}

package lab8a;
import java.io.*;
import java.util.*;

public class Driver {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BST binarytree = new BST();

        //Creation of File
        File file = new File("C:\\Users\\steve\\Documents\\GitHub\\cs114\\src\\lab8a\\inventory.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                //Creation of Binary Tree and Population of it from the reading of the file
                Inventory inventory = new Inventory();
                String [] array = line.split(",");
                inventory.PartNo = array[0];
                inventory.Model = array[1];
                inventory.Description = array[2];
                inventory.ListPrice = Double.parseDouble(array[3]);
                binarytree.insert(inventory.PartNo, inventory);
            }
        } finally {
            //Closing the Reader
            reader.close();
        }
        //Printing the Binary Tree Inorder in the begining of the program
        System.out.println("Inorder of the tree is in Sorted Order");
        System.out.println(binarytree);
        String input = "";
        //Starting a loop for the Deletion and Retrival of Entries
        while(!input.equalsIgnoreCase("DONE")) {
            System.out.println("Enter D to Delete or R to retrieve a Inventory record: (Insert 'DONE' to quit) ");
            input = scanner.nextLine();
            //If the user enters D prompt for a value to delete
            if (input.equalsIgnoreCase("D")) {
                System.out.println("Enter value to delete: ");
                input = scanner.nextLine();
                //If that value is in the binary tree remove it and if not inform the user
                if(binarytree.find(input) != null) {
                    Object removed = binarytree.remove(input);
                    System.out.println(removed);
                    System.out.println("deleted");
                } else {
                    System.out.println(input + " not on the list");
                }
                //If the user enters R prompt for a value to retrieve
            } else if (input.equalsIgnoreCase("R")) {
                System.out.println("Enter value to retrieve: ");
                input = scanner.nextLine();
                //If the value exists in the binary tree find it and output or let the user know it doesn't exist
                if(binarytree.find(input) != null) {
                    Object found = binarytree.find(input);
                    System.out.println("Found: " + found);
                } else {
                    System.out.println(input + " not on the list");
                }
            }
        }

        //Printing the Inorder, PostOrder, and PreOrder after program Execution
        System.out.println("Inorder of the Tree");
        System.out.println(inorder(binarytree));
        System.out.println("PostOrder of the Tree");
        System.out.println(postorder(binarytree));
        System.out.println("PreOrder of the Tree");
        System.out.println(preorder(binarytree));
    }

    public static String inorder(BST tree) {
        return tree.toString();
    }

    public static String postorder(BST tree) {
        return tree.toPost();
    }

    public static String preorder(BST tree) {
        return tree.toPre();
    }
}

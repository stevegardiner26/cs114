package lab8a;
import java.io.*;
import java.util.*;

public class Driver {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BST binarytree = new BST();

        File file = new File("C:\\Users\\steve\\Documents\\GitHub\\cs114\\src\\lab8a\\inventory.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                Inventory inventory = new Inventory();
                String [] array = line.split(",");
                inventory.PartNo = array[0];
                inventory.Model = array[1];
                inventory.Description = array[2];
                inventory.ListPrice = Double.parseDouble(array[3]);
                binarytree.insert(inventory.PartNo, inventory);
            }
        } finally {
            reader.close();
        }
        System.out.println("Inorder of the tree is in Sorted Order");
        System.out.println(binarytree);
        String input = "";
        while(!input.equalsIgnoreCase("DONE")) {
            System.out.println("Enter D to Delete or R to retrieve a Inventory record: (Insert 'DONE' to quit) ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("D")) {
                System.out.println("Enter value to delete: ");
                input = scanner.nextLine();
                if(binarytree.find(input) != null) {
                    Object removed = binarytree.remove(input);
                    System.out.println(removed);
                    System.out.println("deleted");
                } else {
                    System.out.println(input + " not on the list");
                }
            } else if (input.equalsIgnoreCase("R")) {
                System.out.println("Enter value to retrieve: ");
                input = scanner.nextLine();
                if(binarytree.find(input) != null) {
                    Object found = binarytree.find(input);
                    System.out.println("Found: " + found);
                } else {
                    System.out.println(input + " not on the list");
                }
            }
        }
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

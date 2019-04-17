package lab10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws IOException {
        //Scanning for the File and getting the lines
        Scanner scanner = new Scanner(System.in);
        String list[] = new String[9];
        int index = 0;
        //Creation of File
        File file = new File("C:\\Users\\steve\\Documents\\GitHub\\cs114\\src\\lab10\\inventory.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        try {
            System.out.println("List the Input Records");
            while ((line = reader.readLine()) != null) {
                //Converting the lines to an Array
                list[index++] = line;
                System.out.print(line + " ");
            }
        } finally {
            //Closing the Reader
            reader.close();
        }
        System.out.println(" ");
        //Putting the Array into a MaxHeap
        MaxHeap<String> heap = new MaxHeap<>(list, 9, 10);
        System.out.println("Heap Completed");
        System.out.println("MaxHeap Size is: " + heap.heapsize());
        int max = heap.heapsize();
        //Building the Heap
        heap.buildheap();
        //Printing the Heap Values in the Array Form
        for(int i = 0; i < max; i++) {
            String temporder = heap.Heap[i];
            System.out.print(i + "=" + temporder + " ");
        }
        System.out.println(" ");
        //Removing the Heap's Max
        heap.removemax();
        System.out.println("Remove Max");
        System.out.println("MaxHeap Size is: " + heap.heapsize());
        max = heap.heapsize();
        //Reprinting the Heap in Array Form
        for(int i = 0; i < max; i++) {
            String temporder = heap.Heap[i];
            System.out.print(i + "=" + temporder + " ");
        }
        System.out.println(" ");
        System.out.println("Print Priority queue in priority order");
        max = heap.heapsize();
        //Printing the Array in priority form
        for(int i = 0; i < max; i++) {
            System.out.println(heap.remove(0));
        }
    }
}

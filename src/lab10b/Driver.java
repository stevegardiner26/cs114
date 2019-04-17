package lab10b;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Driver {

    public static void main(String[] args) throws IOException {
        //Creation of File
        File file = new File("C:\\Users\\steve\\Documents\\GitHub\\cs114\\src\\lab10b\\patient.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        PriorityQueue<Patient> priorityQueue = new PriorityQueue<>(idComparator);
        String line = null;
        try {
            System.out.println("Lab 10 Problem 2 Part A");
            System.out.println("List the input records");
            while ((line = reader.readLine()) != null) {
                //Reading the File and creating patients and adding them to the queue
                Patient patient = new Patient(Integer.parseInt(line.split(",")[0]), line.split(",")[1], line.split(",")[2]);
                System.out.println(patient);
                priorityQueue.add(patient);
            }
        } finally {
            //Closing the Reader
            reader.close();
        }
        System.out.println(" ");
        System.out.println("Priority Queue using Comparator:");
        //Printing the Priority Queue
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Lab 10 Problem 2 Part B");
        File file2 = new File("C:\\Users\\steve\\Documents\\GitHub\\cs114\\src\\lab10b\\inventoryNew.txt");
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));
        PriorityQueue<Inventory> priorityQueue2 = new PriorityQueue<>(inventoryComparator);
        String line2 = null;
        try {
            while ((line2 = reader2.readLine()) != null) {
                //Getting the file and creating inventory items with each line and adding it to the priority queue
                Inventory inventory = new Inventory();
                inventory.PartNo = line2.split(",")[0];
                inventory.Model = line2.split(",")[1];
                inventory.Description = line2.split(",")[2];
                inventory.ListPrice = Double.parseDouble(line2.split(",")[3]);
                priorityQueue2.add(inventory);
            }
        } finally {
            //Closing the Reader
            reader.close();
        }
        System.out.println("Heap Completed");
        System.out.println("Max-Heap in iterator order: ");
        //Iterating through the Heap and printing each element
        priorityQueue2.forEach(inventory -> {
            System.out.println(inventory.toString());
        });
        //Printing Heap Items in priority order
        System.out.println("Max-Heap in priority order: ");
        Iterator iterator = priorityQueue2.iterator();
        while (iterator.hasNext()) {
            System.out.println(priorityQueue2.poll());
        }
    }

    //Comparator for Part 1 Hospital Problem
    public static Comparator<Patient> idComparator = new Comparator<Patient>() {
        @Override
        public int compare(Patient c1, Patient c2) {
            return (c1.getId() - c2.getId());
        }
    };

    //Comparator for Part 2 Inventory
    public static Comparator<Inventory> inventoryComparator = new Comparator<Inventory>() {
        @Override
        public int compare(Inventory o1, Inventory o2) {
            return (o2.PartNo.compareTo(o1.PartNo));
        }
    };
}

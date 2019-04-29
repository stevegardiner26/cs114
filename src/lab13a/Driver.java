package lab13a;

import java.util.*;
import java.io.*;

public class Driver {

    public static void main(String[] args) throws IOException {
        long timeEnd, timeStart;
        try {
            File file = new File("C:\\Users\\steve\\Documents\\GitHub\\cs114\\src\\lab13a\\inventory.txt");
            Scanner scan = new Scanner(file);

            System.out.println("Start input inventory.txt");
            ArrayList<String> data = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    //Reading the File and creating patients and adding the lines to the array
                    data.add(line);
                }
            } finally {
                //Closing the Reader
                reader.close();
            }

            String dataI[] = new String[1];
            String dataQ[] = new String[1];
            String dataM[] = new String[1];
            String dataS[] = new String[1];
            dataI = data.toArray(dataI);
            dataQ = data.toArray(dataQ);
            dataM = data.toArray(dataM);
            dataS = data.toArray(dataS);

            //Insertion Sort
            System.out.println("Start of Insertion Sort for " + dataI.length + " records");
            timeStart = System.nanoTime();
            InsertionSort.Sort(dataI, dataI.length);
            timeEnd = System.nanoTime();
            System.out.println("End of Insertion Sort. Time is: " + (timeEnd - timeStart));
            System.out.println("\n");

            //Selection sort
            SelectionSortS selection = new SelectionSortS();
            for (int i = 0; i < dataS.length; i++) {
                selection.add(dataS[i]);
            }
            System.out.println("Start of Selection Sort for " + dataS.length + " records");
            timeStart = System.nanoTime();
            selection.sort();
            timeEnd = System.nanoTime();
            System.out.println("End of Selection Sort. Time is: " + (timeEnd - timeStart));
            System.out.println();

            //Merge sort
            System.out.println("Start of Merge Sort for " + dataM.length + " records");
            timeStart = System.nanoTime();
            MergeSort.Sort(dataM);
            timeEnd = System.nanoTime();
            System.out.println("End of Merge Sort. Time is: " + (timeEnd - timeStart));
            System.out.println();

            //Quick sort
            System.out.println("Start of Quick Sort for " + dataQ.length + " records");
            timeStart = System.nanoTime();
            QuickSort.Sort(dataQ);
            timeEnd = System.nanoTime();
            System.out.println("End of Quick Sort. Time is: " + (timeEnd - timeStart));
            System.out.println("\n");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}

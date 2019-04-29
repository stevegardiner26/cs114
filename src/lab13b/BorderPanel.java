//********************************************************************
//  BorderPanel.java      
//
//  Represents the panel in the LayoutDemo program that demonstrates
//  the border layout manager.
//********************************************************************
package lab13b;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import javax.swing.*;
import javax.swing.border.Border;

public class BorderPanel extends JPanel
{
   //-----------------------------------------------------------------
   //  Sets up this panel with a button in each area of a border
   //  layout to show how it affects their position, shape, and size.
   //-----------------------------------------------------------------
   public BorderPanel()
   {
      ArrayList<String> data = new ArrayList<>();
      try {
         File file = new File("C:\\Users\\steve\\Documents\\GitHub\\cs114\\src\\lab13b\\inventory.txt");
         System.out.println("Start input inventory.txt");
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
      } catch (IOException ex) {
         ex.printStackTrace();
      }
      setLayout (new BorderLayout());

      JButton b1 = new JButton ("Insertion Sort");
      JButton b2 = new JButton ("Selection Sort");
      JButton b3 = new JButton ("Merge Sort");
      JButton b4 = new JButton ("Quick Sort");
      JTextArea text = new JTextArea();
      JTextArea text2 = new JTextArea();

      JPanel panel = new JPanel();
      JPanel panel2 = new JPanel();

      panel.add(b1);
      panel.add(b2);
      panel.add(b3);
      panel.add(b4);
      add(panel, BorderLayout.NORTH);

      //add (b1, BorderLayout.EAST);
      //add (b2, BorderLayout.EAST);
      //add (b3, BorderLayout.WEST);
      //add (b4, BorderLayout.WEST);
      //add (b2);

      text.setColumns(50);
      text2.setColumns(50);
      panel2.add(text);
      panel2.add(text2);
      add(panel2, BorderLayout.SOUTH);
      //add(text, BorderLayout.CENTER);
      //add(text2, BorderLayout.CENTER);

      b1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            //Insertion Sort
            long timeEnd, timeStart;
            String data2[] = new String[1];
            data2 = data.toArray(data2);
            text.setText("Start of Insertion Sort for " + data2.length + " records");
            timeStart = System.nanoTime();
            InsertionSort.Sort(data2, data2.length);
            timeEnd = System.nanoTime();
            text2.setText("End of Insertion Sort. Time is: " + (timeEnd - timeStart));
            System.out.println("\n");
         }
      });
      b2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            //Selection sort
            long timeEnd, timeStart;
            String data2[] = new String[1];
            data2 = data.toArray(data2);
            SelectionSortS selection = new SelectionSortS();
            for (int i = 0; i < data2.length; i++) {
               selection.add(data2[i]);
            }
            text.setText("Start of Selection Sort for " + data2.length + " records");
            timeStart = System.nanoTime();
            selection.sort();
            timeEnd = System.nanoTime();
            text2.setText("End of Selection Sort. Time is: " + (timeEnd - timeStart));
            System.out.println();
         }
      });
      b3.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            //Merge sort
            long timeEnd, timeStart;
            String data2[] = new String[1];
            data2 = data.toArray(data2);
            text.setText("Start of Merge Sort for " + data2.length + " records");
            timeStart = System.nanoTime();
            MergeSort.Sort(data2);
            timeEnd = System.nanoTime();
            text2.setText("End of Merge Sort. Time is: " + (timeEnd - timeStart));
         }
      });
      b4.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            //Quick sort
            long timeEnd, timeStart;
            String data2[] = new String[1];
            data2 = data.toArray(data2);
            text.setText("Start of Quick Sort for " + data2.length + " records");
            timeStart = System.nanoTime();
            QuickSort.Sort(data2);
            timeEnd = System.nanoTime();
            text2.setText("End of Quick Sort. Time is: " + (timeEnd - timeStart));
         }
      });
   }
}

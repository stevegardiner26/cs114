//********************************************************************
//  LayoutDemo.java   
//
//  Demonstrates the use of flow, border, grid, and box layouts.
//********************************************************************
package lab13b;

import javax.swing.*;
import java.awt.*;

public class LayoutDemo
{
   //-----------------------------------------------------------------
   //  Sets up a frame containing a tabbed pane. The panel on each
   //  tab demonstrates a different layout manager.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("Sort GUI");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      frame.add(new BorderPanel());
      frame.getContentPane();
      frame.pack();
      frame.setVisible(true);
   }
}

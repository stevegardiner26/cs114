//********************************************************************
//  HashGUIPanel.java
//
//********************************************************************
package lab11a;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;

public class HashGUIPanel extends JPanel
{
   private HashFieldPanel onePanel, twoPanel, threePanel, fourPanel;
   private HashFieldPanel searchPanel;
   private JLabel resultLabel;
   private JButton sendButton;

   //-----------------------------------------------------------------
   //  Constructor: Sets up the main GUI components.
   //-----------------------------------------------------------------
   public HashGUIPanel()
   {
      onePanel = new HashFieldPanel("Hash Key #1", 30);
      twoPanel = new HashFieldPanel("Hash Key #2", 30);
      threePanel = new HashFieldPanel("Hash Key #3", 30);
      fourPanel = new HashFieldPanel("Hash Key #4", 30);
      searchPanel = new HashFieldPanel("Search for Key", 30);
      resultLabel = new JLabel ("------");
      
      sendButton = new JButton("Hash Search");
      sendButton.addActionListener(new SendListener());

      add(onePanel);
      add(twoPanel);
      add(threePanel);
      add(fourPanel);
      add(searchPanel);
      add(sendButton);
      add(resultLabel);

      setPreferredSize (new Dimension(500, 325));
      setBackground (Color.yellow);
   }

   //*****************************************************************
   //  Represents an action listener for the send button.
   //*****************************************************************
   private class SendListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Prints the field information to standard output.
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event)
      {
         HashMap<String, String> hashMap = new HashMap<>();
         hashMap.put(onePanel.getFieldText(), "Hash Table Key 1");
         hashMap.put(twoPanel.getFieldText(), "Hash Table Key 2");
         hashMap.put(threePanel.getFieldText(), "Hash Table Key 3");
         hashMap.put(fourPanel.getFieldText(), "Hash Table Key 4");
         if(hashMap.containsKey(searchPanel.getFieldText())) {
            resultLabel.setText("Found " + searchPanel.getFieldText());
         } else {
            resultLabel.setText(searchPanel.getFieldText() + " not found");
         }
      }
   }
}

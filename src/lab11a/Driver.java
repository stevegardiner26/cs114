package lab11a;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Driver {

    public static void main(String[] args) {
        JFrame frame = new JFrame ("Hash GUI");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new HashGUIPanel());
        frame.pack();
        frame.setVisible(true);
    }
}

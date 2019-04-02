package lab9;
import java.awt.*;
import javax.print.attribute.standard.JobMediaSheetsCompleted;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Driver extends JPanel implements ActionListener {

    static JTextArea text;
    static JFileChooser fc;
    static String filePath;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Driver.startProgram();
            }
        });
    }

    public static void startProgram() {
        JFrame frame = new JFrame("Display and Save File");
        JPanel panel = new JPanel();
        text = new JTextArea();
        JButton savebutton = new JButton("Save");
        savebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pageContent = text.getText();
                try {
                    FileWriter writer = new FileWriter(filePath);
                    writer.write(pageContent);
                    writer.close();
                    text.setText("File Saved in " + filePath);
                    System.out.println("Successfully Saved File!");
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        });

        fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(fc);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try {
                filePath = file.getAbsolutePath();
                text.read(new FileReader(file.getAbsolutePath()), null);
                JScrollPane scrollPane = new JScrollPane(text);
                frame.add(panel,BorderLayout.NORTH);
                frame.add(scrollPane,BorderLayout.CENTER);
                frame.add(savebutton,BorderLayout.SOUTH);
                frame.setSize(600, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            } catch (IOException ex) {
                System.out.println("Problem accessing file" + file.getAbsolutePath());
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

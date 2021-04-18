package laba2Package;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    public MainFrame(ArrayList<Student> students) {
        setLayout(new BorderLayout());
        setBounds(100, 100, 1000, 600);
        StudentsTable st = new StudentsTable();
        add(st, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    class MyDialog extends JDialog {
        public MyDialog(JFrame jFrame) {
            super(jFrame, "Title", true);
            add(new JTextField(), BorderLayout.NORTH);
            add(new JButton("button"), BorderLayout.SOUTH);
            setBounds(500, 500, 250, 250);
        }
    }
}

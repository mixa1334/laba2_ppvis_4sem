package laba2Package;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    public MainFrame(ArrayList<Student> students) {

        setBounds(100, 100, 1200, 800);
        add(new StudentsTable(students));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

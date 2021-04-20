package laba2Package;

import laba2Package.Exceptions.StudentException;
import laba2Package.Exceptions.StudentModelException;
import laba2Package.Models.Student;
import laba2Package.Models.StudentsModel;
import laba2Package.Views.View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test extends JDialog {
    public Test(JFrame jFrame) {
        super(jFrame, "Title", true);
        JPanel jp = new JPanel(new BorderLayout());
        jp.add(new JTextField(), BorderLayout.NORTH);
        jp.add(new JButton("button"), BorderLayout.SOUTH);

        Point loc = jFrame.getLocation();
        setLocation(loc.x + 80, loc.y + 80);
        getContentPane().add(jp);
        pack();
        setVisible(true);
    }
}

class MainTest extends JFrame {
    public MainTest() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 500, 500);
    }

    public static void main(String[] args) {
        new Test(new MainTest());
    }
}
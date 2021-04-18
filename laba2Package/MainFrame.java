package laba2Package;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    public MainFrame(ArrayList<Student> students) {
        setLayout(new BorderLayout());
        setBounds(100, 100, 1000, 500);
        StudentsTable st = new StudentsTable();
        try {
            st.setStudentsToDisplay(students);
        } catch (StudentsTableException e) {
            e.printStackTrace();
        }

        JPanel test = new JPanel(new GridLayout(2, 1));

        JButton x = new JButton("X");
        x.addActionListener(e -> {
            try {
                st.setStudentsToDisplay(new ArrayList<>());
            } catch (StudentsTableException studentsTableException) {
                studentsTableException.printStackTrace();
            }
        });

        JButton y = new JButton("Y");
        y.addActionListener(e -> {
            try {
                st.setStudentsToDisplay(students);
            } catch (StudentsTableException studentsTableException) {
                studentsTableException.printStackTrace();
            }
        });


        add(st, BorderLayout.CENTER);
        test.add(x);
        test.add(y);
        add(test, BorderLayout.EAST);
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

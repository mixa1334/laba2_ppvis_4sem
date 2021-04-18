package laba2Package;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    public MainFrame(ArrayList<Student> students) {
        setLayout(new BorderLayout());
        setBounds(100, 100, 1000, 600);
        StudentsTable st = new StudentsTable(students);
        add(st, BorderLayout.CENTER);


        JPanel jp = new JPanel();


        JButton change = new JButton("change");
        change.addActionListener(e -> {
            st.setNotesPerPage(3);
        });
        JButton back = new JButton("back");
        back.addActionListener(e -> {
            st.setNotesPerPage(10);
        });

        jp.add(change);
        jp.add(back);
        add(jp, BorderLayout.SOUTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

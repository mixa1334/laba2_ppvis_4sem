package laba2Package;

import laba2Package.Exceptions.StudentException;
import laba2Package.Exceptions.StudentModelException;
import laba2Package.Models.Student;
import laba2Package.Models.StudentsModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Test extends JDialog {
    public Test(JFrame jFrame) {
        super(jFrame, "Title", true);
        add(new JTextField(), BorderLayout.NORTH);
        add(new JButton("button"), BorderLayout.SOUTH);
        setBounds(500, 500, 250, 250);
    }
}

class MainTest {
    public static void main(String[] args) {
        StudentsModel stm = new StudentsModel();
        try {
            stm.addStudent(new Student("Mixa", 4, "921703", 4, 1, "java"));
            stm.addStudent(new Student("Max", 3, "2121", 1, 1, "java"));
            stm.addStudent(new Student("Goga", 2, "777Asino", 12, 1, "c#"));
            stm.addStudent(new Student("Mixa", 2, "666", 84, 51, "c++"));
        } catch (StudentException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(stm.getStudents());
            System.out.println("---------------------------------------------------");
            ArrayList<Student> stds = stm.searchStudents(StudentsModel.SearchCriteria.COURSE, "2");
            System.out.println(stds);
            System.out.println("---------------------------------------------------");
            stm.removeStudents(stds.toArray(new Student[0]));
            System.out.println(stm.getStudents());
        } catch (StudentModelException e) {
            System.out.println(e.getMessage());
        }
    }
}
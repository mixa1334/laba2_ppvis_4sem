package laba2Package;

import laba2Package.Views.AddStudentDialog;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Test extends JDialog {
    public Test(JFrame jFrame) {
        super(jFrame, "Title", true);
        JPanel jp = new JPanel(new BorderLayout(5, 5));
        jp.add(new JTextField(), BorderLayout.NORTH);
        JButton jb = new JButton("button");
        jb.addActionListener(e -> setVisible(false));
        jp.add(jb, BorderLayout.SOUTH);
        Point loc = jFrame.getLocation();

        getContentPane().add(jp);

        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //setSize(new Dimension(500, 500));
        setLocation(loc.x + loc.x / 2,
                loc.y + loc.y / 2);
        //setResizable(false);
        pack();
        //setVisible(true);
    }
}

class MainTest extends JFrame {
    public MainTest() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 500, 500);
    }

    public static void main(String[] args) {
        JFrame jf = new MainTest();
        AddStudentDialog jd = new AddStudentDialog(jf);
        //jd.setSize(new Dimension(500, 500));
        //jd.setLocation(jf.getLocation().x + jf.getLocation().x / 2,
        // jf.getLocation().y + jf.getLocation().y / 2);
        //jd.pack();
        jd.setActionToAddStudentJButton(e -> {
            String[] arr = jd.getValuesFromTable();
            if (arr.length > 0) {
                System.out.println(Arrays.toString(arr));
                jd.setVisible(false);
            } else {
                System.out.println("error");
            }
        });
        jd.setVisible(true);
    }
}
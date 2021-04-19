package laba2Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Test extends JDialog {
    public Test(JFrame jFrame) {
        super(jFrame, "Title", true);
        add(new JTextField(), BorderLayout.NORTH);
        add(new JButton("button"), BorderLayout.SOUTH);
        setBounds(500, 500, 250, 250);
    }
}
package laba2Package.Views;

import laba2Package.Models.Student;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainView extends JFrame {
    public MainView(ArrayList<Student> students) {


        JMenuBar menubar = new JMenuBar();
        menubar.setBackground(Color.GRAY);
        JMenu menu = new JMenu("File");
        JMenuItem itm = new JMenuItem("New");
        menu.add(itm);
        itm = new JMenuItem("Open");
        menu.add(itm);
        itm = new JMenuItem("Close");
        menu.add(itm);
        // если нужен элемент меню с иконкой
        //itm = new JMenuItem("Close", new ImageIcon("image.gif"));
        //itm = new JMenuItem(new ImageIcon("image.gif"));
        menu.add(new JSeparator());
        menubar.add(menu);


        ViewerOfPages st = new ViewerOfPages();

        JToolBar jtb = new JToolBar("my toolbar");
        jtb.setBackground(Color.GRAY);
        jtb.setOrientation(SwingConstants.VERTICAL);
        jtb.add(new JButton("save"));
        jtb.addSeparator();
        jtb.add(new JButton("load"));
        jtb.addSeparator();
        jtb.add(new JButton("new file"));
        jtb.addSeparator();
        jtb.add(new JButton("add note"));
        jtb.addSeparator();
        jtb.add(new JButton("delete note"));
        jtb.addSeparator();
        jtb.add(new JButton("search note"));
        jtb.addSeparator();



        setLayout(new BorderLayout(5,5));
        setBounds(100, 100, 1500, 700);

        add(menubar,BorderLayout.NORTH);
        add(st, BorderLayout.CENTER);
        add(jtb, BorderLayout.WEST);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

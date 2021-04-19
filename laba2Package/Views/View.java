package laba2Package.Views;

import laba2Package.Models.Student;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class View {

    private JMenuBar jMenuBar;
    private JMenu fileJMenu;
    private JMenuItem loadListJMenuItem;
    private JMenuItem saveListJMenuItem;
    private JMenuItem emptyListJMenuItem;
    private JMenu editJMenu;
    private JMenuItem addNoteJMenuItem;
    private JMenuItem searchNoteJMenuItem;
    private JMenuItem deleteNoteJMenuItem;
    private final ViewerOfPages viewerOfPages;
    private final JToolBar jToolBar;
    JButton saveJButton;
    JButton loadJButton;
    JButton newFileJButton;
    JButton editJButton;
    JButton deleteNoteJButton;
    JButton searchJButton;


    public View() {
        JFrame jFrame = new JFrame("Students");

        jMenuBar = new JMenuBar();

        fileJMenu = new JMenu("File");
        loadListJMenuItem = new JMenuItem("Load list");
        saveListJMenuItem = new JMenuItem("Save list");
        emptyListJMenuItem = new JMenuItem("Empty list");
        fileJMenu.add(loadListJMenuItem);
        fileJMenu.add(saveListJMenuItem);
        fileJMenu.add(emptyListJMenuItem);

        editJMenu = new JMenu("Edit");
        addNoteJMenuItem = new JMenuItem("Add note");
        searchNoteJMenuItem = new JMenuItem("Search notes");
        deleteNoteJMenuItem = new JMenuItem("Delete notes");
        editJMenu.add(addNoteJMenuItem);
        editJMenu.add(searchNoteJMenuItem);
        editJMenu.add(deleteNoteJMenuItem);

        jMenuBar.add(fileJMenu);
        jMenuBar.add(editJMenu);

        viewerOfPages = new ViewerOfPages();

        jToolBar = new JToolBar();
        jToolBar.setOrientation(SwingConstants.VERTICAL);

        saveJButton = new JButton(new ImageIcon("src//laba2Package//Pictures//save.png"));
        saveJButton.setBorderPainted(false);
        loadJButton = new JButton(new ImageIcon("src//laba2Package//Pictures//load.png"));
        loadJButton.setBorderPainted(false);
        newFileJButton = new JButton(new ImageIcon("src//laba2Package//Pictures//newFile.png"));
        newFileJButton.setBorderPainted(false);
        editJButton = new JButton(new ImageIcon("src//laba2Package//Pictures//edit.png"));
        editJButton.setBorderPainted(false);
        deleteNoteJButton = new JButton(new ImageIcon("src//laba2Package//Pictures//deleteNote.png"));
        deleteNoteJButton.setBorderPainted(false);
        searchJButton = new JButton(new ImageIcon("src//laba2Package//Pictures//search.png"));
        searchJButton.setBorderPainted(false);

        jToolBar.add(saveJButton);
        jToolBar.addSeparator();
        jToolBar.add(loadJButton);
        jToolBar.addSeparator();
        jToolBar.add(newFileJButton);
        jToolBar.addSeparator();
        jToolBar.add(editJButton);
        jToolBar.addSeparator();
        jToolBar.add(deleteNoteJButton);
        jToolBar.addSeparator();
        jToolBar.add(searchJButton);

        jFrame.setLayout(new BorderLayout(5, 5));
        jFrame.setBounds(100, 100, 1500, 700);

        jFrame.add(jMenuBar, BorderLayout.NORTH);
        jFrame.add(viewerOfPages, BorderLayout.CENTER);
        jFrame.add(jToolBar, BorderLayout.WEST);

        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

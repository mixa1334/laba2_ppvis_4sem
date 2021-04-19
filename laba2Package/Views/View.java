package laba2Package.Views;

import laba2Package.Models.Student;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class View {

    private final JMenuBar jMenuBar;

    private final JMenu fileJMenu;
    private final JMenuItem loadListJMenuItem;
    private final JMenuItem saveListJMenuItem;
    private final JMenuItem emptyListJMenuItem;

    private final JMenu editJMenu;
    private final JMenuItem addNoteJMenuItem;
    private final JMenuItem searchNoteJMenuItem;
    private final JMenuItem deleteNoteJMenuItem;

    private final JToolBar jToolBar;
    private final JButton saveJButton;
    private final JButton loadJButton;
    private final JButton newFileJButton;
    private final JButton editJButton;
    private final JButton deleteNoteJButton;
    private final JButton searchJButton;

    private final ViewerOfPages viewerOfPages;

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
        saveJButton.setContentAreaFilled(false);
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

    public JMenuBar getJMenuBar() {
        return jMenuBar;
    }

    public JMenu getFileJMenu() {
        return fileJMenu;
    }

    public JMenuItem getLoadListJMenuItem() {
        return loadListJMenuItem;
    }

    public JMenuItem getSaveListJMenuItem() {
        return saveListJMenuItem;
    }

    public JMenuItem getEmptyListJMenuItem() {
        return emptyListJMenuItem;
    }

    public JMenu getEditJMenu() {
        return editJMenu;
    }

    public JMenuItem getAddNoteJMenuItem() {
        return addNoteJMenuItem;
    }

    public JMenuItem getSearchNoteJMenuItem() {
        return searchNoteJMenuItem;
    }

    public JMenuItem getDeleteNoteJMenuItem() {
        return deleteNoteJMenuItem;
    }

    public JToolBar getJToolBar() {
        return jToolBar;
    }

    public JButton getSaveJButton() {
        return saveJButton;
    }

    public JButton getLoadJButton() {
        return loadJButton;
    }

    public JButton getNewFileJButton() {
        return newFileJButton;
    }

    public JButton getEditJButton() {
        return editJButton;
    }

    public JButton getDeleteNoteJButton() {
        return deleteNoteJButton;
    }

    public JButton getSearchJButton() {
        return searchJButton;
    }

    public ViewerOfPages getViewerOfPages() {
        return viewerOfPages;
    }
}
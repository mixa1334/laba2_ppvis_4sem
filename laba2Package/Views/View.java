package laba2Package.Views;

import javax.swing.*;
import java.awt.*;

public class View {
    private final JFrame MainFrame;

    private final AddStudentDialog addStudentDialog;
    private final DeleteStudentsDialog deleteStudentsDialog;
    private final SearchStudentsDialog searchStudentsDialog;

    private final ViewerOfPages viewerOfPages;

    public View() {
        MainFrame = new JFrame("Students");
        MainFrame.setLayout(new BorderLayout(5, 5));
        MainFrame.setBounds(100, 100, 1500, 700);

        viewerOfPages = new ViewerOfPages();
        addStudentDialog = new AddStudentDialog(MainFrame);
        searchStudentsDialog = new SearchStudentsDialog(MainFrame);
        deleteStudentsDialog = new DeleteStudentsDialog(MainFrame);
        MainFrame.add(viewerOfPages, BorderLayout.CENTER);

        setJMenuBar();
        setJToolBar();

        MainFrame.setVisible(true);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public AddStudentDialog getAddStudentDialog() {
        return addStudentDialog;
    }

    public DeleteStudentsDialog getDeleteStudentsDialog() {
        return deleteStudentsDialog;
    }

    public SearchStudentsDialog getSearchStudentsDialog() {
        return searchStudentsDialog;
    }

    public JFrame getMainFrame() {
        return MainFrame;
    }


    public ViewerOfPages getViewerOfPages() {
        return viewerOfPages;
    }

    private void setJToolBar() {
        JToolBar jToolBar = new JToolBar();
        jToolBar.setOrientation(SwingConstants.VERTICAL);

        JButton saveJButton = new JButton(new ImageIcon("src//laba2Package//Pictures//save.png"));
        saveJButton.setBorderPainted(false);
        JButton loadJButton = new JButton(new ImageIcon("src//laba2Package//Pictures//load.png"));
        loadJButton.setBorderPainted(false);
        JButton newFileJButton = new JButton(new ImageIcon("src//laba2Package//Pictures//newFile.png"));
        newFileJButton.setBorderPainted(false);
        JButton editJButton = new JButton(new ImageIcon("src//laba2Package//Pictures//edit.png"));
        editJButton.setBorderPainted(false);
        editJButton.addActionListener(e -> addStudentDialog.setVisible(true));
        JButton deleteNoteJButton = new JButton(new ImageIcon("src//laba2Package//Pictures//deleteNote.png"));
        deleteNoteJButton.setBorderPainted(false);
        deleteNoteJButton.addActionListener(e -> deleteStudentsDialog.setVisible(true));
        JButton searchJButton = new JButton(new ImageIcon("src//laba2Package//Pictures//search.png"));
        searchJButton.setBorderPainted(false);
        searchJButton.addActionListener(e -> searchStudentsDialog.setVisible(true));

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

        MainFrame.add(jToolBar, BorderLayout.WEST);
    }

    private void setJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu fileJMenu = new JMenu("File");
        JMenuItem loadListJMenuItem = new JMenuItem("Load list");
        JMenuItem saveListJMenuItem = new JMenuItem("Save list");
        JMenuItem emptyListJMenuItem = new JMenuItem("Empty list");
        fileJMenu.add(loadListJMenuItem);
        fileJMenu.add(saveListJMenuItem);
        fileJMenu.add(emptyListJMenuItem);

        JMenu editJMenu = new JMenu("Edit");
        JMenuItem addNoteJMenuItem = new JMenuItem("Add note");
        addNoteJMenuItem.addActionListener(e -> addStudentDialog.setVisible(true));
        JMenuItem searchNoteJMenuItem = new JMenuItem("Search notes");
        searchNoteJMenuItem.addActionListener(e -> searchStudentsDialog.setVisible(true));
        JMenuItem deleteNoteJMenuItem = new JMenuItem("Delete notes");
        deleteNoteJMenuItem.addActionListener(e -> deleteStudentsDialog.setVisible(true));
        editJMenu.add(addNoteJMenuItem);
        editJMenu.add(searchNoteJMenuItem);
        editJMenu.add(deleteNoteJMenuItem);

        jMenuBar.add(fileJMenu);
        jMenuBar.add(editJMenu);

        MainFrame.add(jMenuBar, BorderLayout.NORTH);
    }
}
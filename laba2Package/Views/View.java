package laba2Package.Views;

import laba2Package.Views.CustomDialogs.AddStudentDialog;
import laba2Package.Views.CustomDialogs.DeleteStudentsDialog;
import laba2Package.Views.CustomDialogs.SearchStudentsDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {
    private final JFrame MainFrame;

    private JButton saveJButton;
    private JButton loadJButton;

    private JMenuItem loadListJMenuItem;
    private JMenuItem saveListJMenuItem;

    private final AddStudentDialog addStudentDialog;
    private final DeleteStudentsDialog deleteStudentsDialog;
    private final SearchStudentsDialog searchStudentsDialog;
    private final XMLFileChooser xmlFileChooser;

    private final ViewerOfPages viewerOfPages;

    public View() {
        MainFrame = new JFrame("Students");
        MainFrame.setLayout(new BorderLayout(5, 5));
        MainFrame.setBounds(100, 100, 1500, 700);

        viewerOfPages = new ViewerOfPages();
        addStudentDialog = new AddStudentDialog(MainFrame);
        searchStudentsDialog = new SearchStudentsDialog(MainFrame);
        deleteStudentsDialog = new DeleteStudentsDialog(MainFrame);
        xmlFileChooser = new XMLFileChooser();
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

    public XMLFileChooser getXmlFileChooser() {
        return xmlFileChooser;
    }

    public void setActionToLoadFileButtons(ActionListener action) {
        loadJButton.addActionListener(action);
        loadListJMenuItem.addActionListener(action);
    }

    public void setActionToSaveFileButtons(ActionListener action) {
        saveJButton.addActionListener(action);
        saveListJMenuItem.addActionListener(action);
    }

    public ViewerOfPages getViewerOfPages() {
        return viewerOfPages;
    }

    private void setJToolBar() {
        JToolBar jToolBar = new JToolBar();
        jToolBar.setOrientation(SwingConstants.VERTICAL);

        saveJButton = new JButton(new ImageIcon("src//laba2Package//Pictures//save.png"));
        saveJButton.setBorderPainted(false);
        loadJButton = new JButton(new ImageIcon("src//laba2Package//Pictures//load.png"));
        loadJButton.setBorderPainted(false);
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
        loadListJMenuItem = new JMenuItem("Load list");
        saveListJMenuItem = new JMenuItem("Save list");
        fileJMenu.add(loadListJMenuItem);
        fileJMenu.add(saveListJMenuItem);

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
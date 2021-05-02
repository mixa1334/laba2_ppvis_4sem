package laba2Package.Views;

import laba2Package.Views.CustomDialogs.AddStudentDialog;
import laba2Package.Views.CustomDialogs.DeleteStudentsDialog;
import laba2Package.Views.CustomDialogs.SearchStudentsDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

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
        MainFrame = new JFrame("Таблица студентов");
        MainFrame.setLayout(new BorderLayout(5, 5));
        MainFrame.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 600,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 400,
                1200, 800);

        viewerOfPages = new ViewerOfPages();
        addStudentDialog = new AddStudentDialog(MainFrame);
        searchStudentsDialog = new SearchStudentsDialog(MainFrame);
        deleteStudentsDialog = new DeleteStudentsDialog(MainFrame);
        xmlFileChooser = new XMLFileChooser();
        MainFrame.add(viewerOfPages, BorderLayout.CENTER);

        setJMenuBar();
        setJToolBar();

        MainFrame.setVisible(true);
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

        saveJButton = new MyButton(Paths.get("Pictures//save.png").toFile());
        loadJButton = new MyButton(Paths.get("Pictures//load.png").toFile());
        JButton editJButton = new MyButton(Paths.get("Pictures//edit.png").toFile());
        editJButton.addActionListener(e -> {
            addStudentDialog.setCustomDialogLocation();
            addStudentDialog.setVisible(true);
        });
        JButton deleteNoteJButton = new MyButton(Paths.get("Pictures//delete-note.png").toFile());
        deleteNoteJButton.addActionListener(e -> {
            deleteStudentsDialog.setCustomDialogLocation();
            deleteStudentsDialog.setVisible(true);
        });
        JButton searchJButton = new MyButton(Paths.get("Pictures//search.png").toFile());
        searchJButton.addActionListener(e -> {
            searchStudentsDialog.setCustomDialogLocation();
            searchStudentsDialog.setVisible(true);
        });

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

        JMenu fileJMenu = new JMenu("Файл");
        loadListJMenuItem = new JMenuItem("Загрузить данные");
        saveListJMenuItem = new JMenuItem("Сохранить данные");
        fileJMenu.add(loadListJMenuItem);
        fileJMenu.add(saveListJMenuItem);

        JMenu editJMenu = new JMenu("Редактировать");
        JMenuItem addNoteJMenuItem = new JMenuItem("Добавить студента");
        addNoteJMenuItem.addActionListener(e -> addStudentDialog.setVisible(true));
        JMenuItem searchNoteJMenuItem = new JMenuItem("Поиск студентов");
        searchNoteJMenuItem.addActionListener(e -> searchStudentsDialog.setVisible(true));
        JMenuItem deleteNoteJMenuItem = new JMenuItem("Удаление студентов");
        deleteNoteJMenuItem.addActionListener(e -> deleteStudentsDialog.setVisible(true));
        editJMenu.add(addNoteJMenuItem);
        editJMenu.add(searchNoteJMenuItem);
        editJMenu.add(deleteNoteJMenuItem);

        jMenuBar.add(fileJMenu);
        jMenuBar.add(editJMenu);

        MainFrame.add(jMenuBar, BorderLayout.NORTH);
    }
}
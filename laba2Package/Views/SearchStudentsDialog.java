package laba2Package.Views;

import laba2Package.Models.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SearchStudentsDialog extends JDialog {
    private final SearchStudentJPanel searchStudentJPanel;
    private final JButton searchStudentsJButton;
    private final ViewerOfPages viewerOfPages;

    public SearchStudentsDialog(JFrame jFrame) {
        super(jFrame, "Delete students");

        setLayout(new BorderLayout(5, 5));
        viewerOfPages = new ViewerOfPages();
        searchStudentJPanel = new SearchStudentJPanel();
        searchStudentsJButton = new JButton("Delete students!");
        getContentPane().add(viewerOfPages, BorderLayout.CENTER);
        getContentPane().add(searchStudentJPanel, BorderLayout.WEST);
        getContentPane().add(searchStudentsJButton, BorderLayout.SOUTH);

        pack();
    }

    public ViewerOfPages getViewerOfPages() {
        return viewerOfPages;
    }

    public void setActionToDeleteStudentsJButton(ActionListener action) {
        searchStudentsJButton.addActionListener(action);
    }

    public Student.AllCriteria getSelectedCriteria() {
        return searchStudentJPanel.getSelectedCriteria();
    }

    public String getValueForSearch() {
        return searchStudentJPanel.getValueForSearch();
    }

    public void setAllProgrammingLanguages(String[] programmingLanguages) {
        searchStudentJPanel.setAllProgrammingLanguages(programmingLanguages);
    }

    public void setAllNumberOfTasks(String[] numberOfTasks) {
        searchStudentJPanel.setAllNumberOfTasks(numberOfTasks);
    }

    public void setAllNumberOfCompletedTasks(String[] numberOfCompletedTasks) {
        searchStudentJPanel.setAllNumberOfCompletedTasks(numberOfCompletedTasks);
    }
}

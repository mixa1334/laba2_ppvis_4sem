package laba2Package.Views.CustomDialogs;

import laba2Package.Models.Student;
import laba2Package.Views.ViewerOfPages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SearchStudentsDialog extends CustomDialog {
    private final SearchStudentJPanel searchStudentJPanel;
    private final JButton searchStudentsJButton;
    private final ViewerOfPages viewerOfPages;

    public SearchStudentsDialog(JFrame jFrame) {
        super(jFrame, "Search students");

        setLayout(new BorderLayout(5, 5));
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        viewerOfPages = new ViewerOfPages();
        searchStudentJPanel = new SearchStudentJPanel();
        searchStudentsJButton = new JButton("Search students!");
        jPanel.add(viewerOfPages);
        jPanel.add(searchStudentJPanel);
        getContentPane().add(jPanel, BorderLayout.CENTER);
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

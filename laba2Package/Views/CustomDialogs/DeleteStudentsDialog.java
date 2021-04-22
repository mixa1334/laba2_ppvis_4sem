package laba2Package.Views.CustomDialogs;

import laba2Package.Models.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DeleteStudentsDialog extends CustomDialog {

    private final SearchStudentJPanel searchStudentJPanel;
    private final JButton deleteStudentsJButton;

    public DeleteStudentsDialog(JFrame jFrame) {
        super(jFrame, "Delete students");

        setLayout(new BorderLayout(5, 5));

        searchStudentJPanel = new SearchStudentJPanel();
        deleteStudentsJButton = new JButton("Delete students!");
        JPanel buttonJPanel = new JPanel();
        buttonJPanel.add(deleteStudentsJButton);
        getContentPane().add(searchStudentJPanel, BorderLayout.CENTER);
        getContentPane().add(buttonJPanel, BorderLayout.SOUTH);
        pack();
        setCustomDialogLocation();
    }

    public void setActionToDeleteStudentsJButton(ActionListener action) {
        deleteStudentsJButton.addActionListener(action);
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
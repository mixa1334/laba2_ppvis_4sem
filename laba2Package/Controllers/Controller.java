package laba2Package.Controllers;

import laba2Package.Exceptions.StudentException;
import laba2Package.Models.Student;
import laba2Package.Models.StudentsModel;
import laba2Package.Views.View;

import javax.swing.*;
import java.util.ArrayList;

public class Controller {
    private final View view;
    private final StudentsModel studentsModel;

    public Controller(final View view, final StudentsModel studentsModel) {
        this.view = view;
        this.studentsModel = studentsModel;
        init();
    }

    public void addStudents() {
        String[] newStudentParameters = view.getAddStudentDialog().getValuesFromUser();
        try {
            studentsModel.addStudent(new Student(newStudentParameters[0], Integer.parseInt(newStudentParameters[1]),
                    newStudentParameters[2], Integer.parseInt(newStudentParameters[3]),
                    Integer.parseInt(newStudentParameters[4]), newStudentParameters[5]));
            updateView();
            view.getAddStudentDialog().setVisible(false);
        } catch (NumberFormatException | StudentException e) {
            JOptionPane.showMessageDialog(view.getAddStudentDialog(), "Incorrect parameters");
        }
    }

    public void searchStudents() {
        view.getSearchStudentsDialog().getViewerOfPages().setStudentsToDisplay(
                studentsModel.searchStudents(view.getSearchStudentsDialog().getSelectedCriteria(),
                        view.getSearchStudentsDialog().getValueForSearch()));
    }

    public void deleteStudents() {
        ArrayList<Student> studentsToRemove = studentsModel.searchStudents(view.getDeleteStudentsDialog().getSelectedCriteria(),
                view.getDeleteStudentsDialog().getValueForSearch());
        studentsModel.removeStudents(studentsToRemove);
        view.getDeleteStudentsDialog().setVisible(false);
        updateView();
        JOptionPane.showMessageDialog(view.getMainFrame(), studentsToRemove.size() + " students were removed");
    }

    private void updateView() {
        view.getViewerOfPages().resetPageView();
        view.getSearchStudentsDialog().setAllNumberOfCompletedTasks(studentsModel.getAllNumberOfCompletedTasks());
        view.getSearchStudentsDialog().setAllNumberOfTasks(studentsModel.getAllNumberOfTasks());
        view.getSearchStudentsDialog().setAllProgrammingLanguages(studentsModel.getAllProgrammingLanguages());

        view.getDeleteStudentsDialog().setAllNumberOfCompletedTasks(studentsModel.getAllNumberOfCompletedTasks());
        view.getDeleteStudentsDialog().setAllNumberOfTasks(studentsModel.getAllNumberOfTasks());
        view.getDeleteStudentsDialog().setAllProgrammingLanguages(studentsModel.getAllProgrammingLanguages());
    }

    private void init() {
        view.getViewerOfPages().setStudentsToDisplay(studentsModel.getStudents());
        view.getAddStudentDialog().setActionToAddStudentJButton(e -> addStudents());
        view.getSearchStudentsDialog().setActionToDeleteStudentsJButton(e -> searchStudents());
        view.getDeleteStudentsDialog().setActionToDeleteStudentsJButton(e -> deleteStudents());
    }
}

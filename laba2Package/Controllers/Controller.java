package laba2Package.Controllers;

import laba2Package.Exceptions.StudentException;
import laba2Package.Models.Student;
import laba2Package.Models.StudentsModel;
import laba2Package.Views.View;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private final View view;
    private final StudentsModel studentsModel;
    private boolean needToSaveData;

    public Controller(final View view, final StudentsModel studentsModel) {
        this.view = view;
        this.studentsModel = studentsModel;
        needToSaveData = false;
        view.getViewerOfPages().setStudentsToDisplay(studentsModel.getStudents());
        view.getAddStudentDialog().setActionToAddStudentJButton(e -> addStudents());
        view.getSearchStudentsDialog().setActionToDeleteStudentsJButton(e -> searchStudents());
        view.getDeleteStudentsDialog().setActionToDeleteStudentsJButton(e -> deleteStudents());
        view.setActionToLoadFileButtons(e -> loadStudentsFromFile());
        view.setActionToSaveFileButtons(e -> saveStudentsToFile());
        view.getMainFrame().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        view.getMainFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closingFrameAction();
            }
        });
    }

    public void loadStudentsFromFile() {
        try {
            File fileToLoadStudents = view.getXmlFileChooser().getPath();
            if (fileToLoadStudents == null) return;
            int incorrectStudents = studentsModel.loadStudentsFromFile(fileToLoadStudents);
            view.getViewerOfPages().setStudentsToDisplay(studentsModel.getStudents());
            updateView();
            JOptionPane.showMessageDialog(view.getMainFrame(),
                    "Данные загружены успешно!\n" + incorrectStudents + " - число неверно записанных студенты в файле");
        } catch (IOException | SAXException | ParserConfigurationException e) {
            JOptionPane.showMessageDialog(view.getMainFrame(), "Невозможно открыть файл!");
        }
    }

    public void saveStudentsToFile() {
        try {
            File fileToSaveStudents = view.getXmlFileChooser().getPath();
            if (fileToSaveStudents == null) return;
            studentsModel.saveStudentsToFile(fileToSaveStudents);
            needToSaveData = false;
            JOptionPane.showMessageDialog(view.getMainFrame(), "Данные сохранены успешно!");
        } catch (IOException | SAXException | ParserConfigurationException | TransformerException e) {
            JOptionPane.showMessageDialog(view.getMainFrame(), "Невозможно открыть файл!");
        }
    }

    public void addStudents() {
        String[] newStudentParameters = view.getAddStudentDialog().getValuesFromUser();
        try {
            studentsModel.addStudent(new Student(newStudentParameters[0], Integer.parseInt(newStudentParameters[1]),
                    newStudentParameters[2], Integer.parseInt(newStudentParameters[3]),
                    Integer.parseInt(newStudentParameters[4]), newStudentParameters[5]));
            view.getAddStudentDialog().clearTextFields();
            needToSaveData = true;
            updateView();
            JOptionPane.showMessageDialog(view.getAddStudentDialog(), "Студент был добавлен!");
        } catch (StudentException e) {
            JOptionPane.showMessageDialog(view.getAddStudentDialog(), e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view.getAddStudentDialog(),
                    "Поля \"Курс\"\\\"Общее число работ\"\\\"Количество выполненных работ\" должны содержать целочисленные значения!");
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
        if (studentsToRemove.size() > 0) {
            updateView();
            needToSaveData = true;
        }
        JOptionPane.showMessageDialog(view.getMainFrame(), "Студентов было удалено: " + studentsToRemove.size());
    }

    public void closingFrameAction() {
        if (needToSaveData) {
            if (JOptionPane.showConfirmDialog(view.getMainFrame(),
                    "Данные не были сохранены. Желаете их сохранить?", "Сохранить данные?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
            saveStudentsToFile();
            if (needToSaveData) return;
        }
        System.exit(0);
    }

    public void updateView() {
        view.getViewerOfPages().resetPageView();
        view.getSearchStudentsDialog().setAllNumberOfCompletedTasks(studentsModel.getAllNumberOfCompletedTasks());
        view.getSearchStudentsDialog().setAllNumberOfTasks(studentsModel.getAllNumberOfTasks());
        view.getSearchStudentsDialog().setAllProgrammingLanguages(studentsModel.getAllProgrammingLanguages());

        view.getDeleteStudentsDialog().setAllNumberOfCompletedTasks(studentsModel.getAllNumberOfCompletedTasks());
        view.getDeleteStudentsDialog().setAllNumberOfTasks(studentsModel.getAllNumberOfTasks());
        view.getDeleteStudentsDialog().setAllProgrammingLanguages(studentsModel.getAllProgrammingLanguages());
    }
}
package laba2Package.Views.CustomDialogs;

import laba2Package.Models.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class SearchStudentJPanel extends JPanel implements ActionListener {
    private final JComboBox<String> criteriaJComboBox;

    private final JTextField jTextField;
    private final JComboBox<String> numberOfTasksJComboBox;
    private final JComboBox<String> numberOfCompletedTasksJComboBox;
    private final JComboBox<String> programmingLanguagesJComboBox;

    public SearchStudentJPanel() {
        setLayout(new GridLayout(2, 2, 10, 5));

        criteriaJComboBox = new JComboBox<>(Student.AllCriteria.getAllName());
        criteriaJComboBox.addActionListener(this);

        jTextField = new JTextField();
        numberOfTasksJComboBox = new JComboBox<>();
        numberOfCompletedTasksJComboBox = new JComboBox<>();
        programmingLanguagesJComboBox = new JComboBox<>();

        add(new JLabel("Criteria"));
        add(new JLabel("Value"));
        add(criteriaJComboBox);
        add(jTextField);
    }

    public Student.AllCriteria getSelectedCriteria() {
        for (Student.AllCriteria criteria : Student.AllCriteria.values()) {
            if (criteria.getName().equals(criteriaJComboBox.getSelectedItem())) {
                return criteria;
            }
        }
        return Student.AllCriteria.FIO;
    }

    public String getValueForSearch() {
        if (Objects.equals(criteriaJComboBox.getSelectedItem(), Student.AllCriteria.NUMBER_OF_TASKS.getName())) {
            return Objects.requireNonNull(numberOfTasksJComboBox.getSelectedItem()).toString();
        } else if (Objects.equals(criteriaJComboBox.getSelectedItem(), Student.AllCriteria.NUMBER_OF_COMPLETED_TASKS.getName())) {
            return Objects.requireNonNull(numberOfCompletedTasksJComboBox.getSelectedItem()).toString();
        } else if (Objects.equals(criteriaJComboBox.getSelectedItem(), Student.AllCriteria.PROGRAMMING_LANGUAGE.getName())) {
            return Objects.requireNonNull(programmingLanguagesJComboBox.getSelectedItem()).toString();
        } else {
            return jTextField.getText();
        }
    }

    public void setAllProgrammingLanguages(String[] programmingLanguages) {
        if (programmingLanguages == null) return;
        programmingLanguagesJComboBox.removeAllItems();
        Arrays.stream(programmingLanguages).forEach(programmingLanguagesJComboBox::addItem);
    }

    public void setAllNumberOfTasks(String[] numberOfTasks) {
        if (numberOfTasks == null) return;
        numberOfTasksJComboBox.removeAllItems();
        Arrays.stream(numberOfTasks).forEach(numberOfTasksJComboBox::addItem);
    }

    public void setAllNumberOfCompletedTasks(String[] numberOfCompletedTasks) {
        if (numberOfCompletedTasks == null) return;
        numberOfCompletedTasksJComboBox.removeAllItems();
        Arrays.stream(numberOfCompletedTasks).forEach(numberOfCompletedTasksJComboBox::addItem);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        remove(3);
        if (Objects.equals(criteriaJComboBox.getSelectedItem(), Student.AllCriteria.NUMBER_OF_TASKS.getName())) {
            add(numberOfTasksJComboBox);
        } else if (Objects.equals(criteriaJComboBox.getSelectedItem(), Student.AllCriteria.NUMBER_OF_COMPLETED_TASKS.getName())) {
            add(numberOfCompletedTasksJComboBox);
        } else if (Objects.equals(criteriaJComboBox.getSelectedItem(), Student.AllCriteria.PROGRAMMING_LANGUAGE.getName())) {
            add(programmingLanguagesJComboBox);
        } else {
            add(jTextField);
        }
        revalidate();
        repaint();
    }
}
package laba2Package.Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddStudentDialog extends CustomDialog {
    private final JButton addStudentJButton;
    private final JTextField fioJTextField;
    private final JTextField courseJTextField;
    private final JTextField groupJTextField;
    private final JTextField numberOfTasksJTextField;
    private final JTextField numberOfCompletedTasksJTextField;
    private final JTextField programmingLanguageJTextField;

    public AddStudentDialog(JFrame jFrame) {
        super(jFrame, "Add new student");
        JPanel jPanel = new JPanel(new GridLayout(3, 4, 10, 5));
        addStudentJButton = new JButton("add student");
        jPanel.add(new JLabel("ФИО"));
        jPanel.add(fioJTextField = new JTextField());
        jPanel.add(new JLabel("Курс"));
        jPanel.add(courseJTextField = new JTextField());
        jPanel.add(new JLabel("Группа"));
        jPanel.add(groupJTextField = new JTextField());
        jPanel.add(new JLabel("Общее число работ"));
        jPanel.add(numberOfTasksJTextField = new JTextField());
        jPanel.add(new JLabel("Количество выполненных работ"));
        jPanel.add(numberOfCompletedTasksJTextField = new JTextField());
        jPanel.add(new JLabel("Язык программирования"));
        jPanel.add(programmingLanguageJTextField = new JTextField());

        setLayout(new BorderLayout(5, 5));

        getContentPane().add(jPanel, BorderLayout.CENTER);
        getContentPane().add(addStudentJButton, BorderLayout.SOUTH);
        pack();
    }

    public void setActionToAddStudentJButton(ActionListener action) {
        addStudentJButton.addActionListener(action);
    }

    public String[] getValuesFromTable() {
        hideCustomDialog();
        return new String[]{
                fioJTextField.getText(),
                courseJTextField.getText(),
                groupJTextField.getText(),
                numberOfTasksJTextField.getText(),
                numberOfCompletedTasksJTextField.getText(),
                programmingLanguageJTextField.getText(),
        };
    }
}

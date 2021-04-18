package laba2Package;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class StudentsTable extends JPanel {

    private final DefaultTableModel tableModel;
    private final JLabel numberOfCurrentPageLabel;
    private final JLabel countOfStudentsLabel;
    private ArrayList<Student> students;
    private int currentPageNumber;
    private int notesPerPage;
    private int allPagesCount;

    public StudentsTable(ArrayList<Student> students) {
        this.students = students;
        numberOfCurrentPageLabel = new JLabel();
        countOfStudentsLabel = new JLabel();
        JTable table = new JTable();
        String[] columnNames = {"ФИО", "Курс",
                "группа", "Общее число работ", "Количество выполненных работ",
                "Язык программирования"};

        notesPerPage = 10;
        setPageNumberAndCountOfOPages();

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columnNames);
        table.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800, 500));

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        addButtonsAndLabels();
        displayPage();
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
        setPageNumberAndCountOfOPages();
        displayPage();
    }

    public void setNotesPerPage(int notesPerPage) {
        this.notesPerPage = notesPerPage;
        setPageNumberAndCountOfOPages();
        displayPage();
    }

    private void setPageNumberAndCountOfOPages() {
        currentPageNumber = 1;
        allPagesCount = students.size() % notesPerPage == 0 ?
                students.size() / notesPerPage : students.size() / notesPerPage + 1;
    }

    private void displayPage() {
        tableModel.setRowCount(0);
        getStudentsToDisplay().forEach(student -> {
            tableModel.addRow(new Object[]{
                    student.getFIO(),
                    student.getCourse(),
                    student.getGroup(),
                    student.getNumberOfTasks(),
                    student.getNumberOfCompletedTasks(),
                    student.getProgrammingLanguage()
            });
        });
        countOfStudentsLabel.setText("Количество всех студентов: " + students.size());
        numberOfCurrentPageLabel.setText(currentPageNumber + "/" + allPagesCount);
    }

    private ArrayList<Student> getStudentsToDisplay() {
        return new ArrayList<>(students.subList((currentPageNumber - 1) * 10, Math.min(currentPageNumber * 10, students.size())));
    }

    private void addButtonsAndLabels() {
        JPanel pageControllerPanel = new JPanel();
        JButton nextButton = new JButton(">");
        JButton lastPage = new JButton(">>");
        JButton firstPage = new JButton("<<");
        JButton previousButton = new JButton("<");

        nextButton.addActionListener(e -> {
            if (currentPageNumber < allPagesCount) {
                currentPageNumber++;
                displayPage();
            }

        });
        previousButton.addActionListener(e -> {
            if (currentPageNumber > 1) {
                currentPageNumber--;
                displayPage();
            }
        });
        lastPage.addActionListener(e -> {
            currentPageNumber = allPagesCount;
            displayPage();
        });
        firstPage.addActionListener(e -> {
            currentPageNumber = 1;
            displayPage();
        });

        pageControllerPanel.add(firstPage);
        pageControllerPanel.add(previousButton);
        pageControllerPanel.add(numberOfCurrentPageLabel);
        pageControllerPanel.add(nextButton);
        pageControllerPanel.add(lastPage);
        pageControllerPanel.add(countOfStudentsLabel);
        add(pageControllerPanel, BorderLayout.SOUTH);
    }
}
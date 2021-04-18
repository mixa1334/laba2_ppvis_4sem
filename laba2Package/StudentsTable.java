package laba2Package;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class StudentsTable extends JPanel {

    private final DefaultTableModel tableModel;
    private final JLabel numberOfCurrentPageLabel;
    private final JLabel countOfStudentsLabel;
    private final JLabel notesPerPageLAbel;
    private ArrayList<Student> students;
    private int currentPageNumber;
    private int notesPerPage;
    private int allPagesCount;

    public StudentsTable() {
        this.students = new ArrayList<>();
        numberOfCurrentPageLabel = new JLabel();
        countOfStudentsLabel = new JLabel();
        notesPerPageLAbel = new JLabel();
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
        scrollPane.setPreferredSize(new Dimension(800, 300));

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        initButtonsAndLabels();
    }

    public void setStudents(ArrayList<Student> students) throws StudentsTableException {
        if (students == null || students.size() == 0)
            throw new StudentsTableException("Невозможно загрузить список студентов, т.к. он пуст!");
        this.students = students;
        setPageNumberAndCountOfOPages();
        displayPage();
    }

    public void setNotesPerPage(int notesPerPage) throws StudentsTableException {
        if (notesPerPage <= 0)
            throw new StudentsTableException("Нельзя отобразить " + notesPerPage + " элементов на старнице");
        this.notesPerPage = notesPerPage;
        if (students.size() == 0) return;
        setPageNumberAndCountOfOPages();
        displayPage();
    }

    private void setPageNumberAndCountOfOPages() {
        if (students.size() == 0) return;
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
        notesPerPageLAbel.setText("Отображать " + notesPerPage + " студентов на странице");
        countOfStudentsLabel.setText("Количество всех студентов: " + students.size());
        numberOfCurrentPageLabel.setText(currentPageNumber + "/" + allPagesCount);
    }

    private ArrayList<Student> getStudentsToDisplay() {
        return new ArrayList<>(students.subList(
                (currentPageNumber - 1) * notesPerPage,
                Math.min(currentPageNumber * notesPerPage, students.size())
        ));
    }

    private void initButtonsAndLabels() {
        JPanel downPanel = new JPanel();
        JPanel upPanel = new JPanel();
        JButton nextPageButton = new JButton(">");
        JButton lastPageButton = new JButton(">>");
        JButton firstPageButton = new JButton("<<");
        JButton previousPageButton = new JButton("<");

        notesPerPageLAbel.setText("Отображать студентов на странице - " + notesPerPage);
        countOfStudentsLabel.setText("Количество всех студентов: " + students.size());
        numberOfCurrentPageLabel.setText(currentPageNumber + "/" + allPagesCount);

        nextPageButton.addActionListener(e -> {
            if (students.size() == 0) return;
            if (currentPageNumber < allPagesCount) {
                currentPageNumber++;
                displayPage();
            }
        });
        previousPageButton.addActionListener(e -> {
            if (students.size() == 0) return;
            if (currentPageNumber > 1) {
                currentPageNumber--;
                displayPage();
            }
        });
        lastPageButton.addActionListener(e -> {
            if (students.size() == 0) return;
            currentPageNumber = allPagesCount;
            displayPage();

        });
        firstPageButton.addActionListener(e -> {
            if (students.size() == 0) return;
            currentPageNumber = 1;
            displayPage();

        });

        downPanel.add(firstPageButton);
        downPanel.add(previousPageButton);
        downPanel.add(numberOfCurrentPageLabel);
        downPanel.add(nextPageButton);
        downPanel.add(lastPageButton);
        upPanel.add(notesPerPageLAbel);
        upPanel.add(countOfStudentsLabel);
        add(downPanel, BorderLayout.SOUTH);
        add(upPanel, BorderLayout.NORTH);
    }
}
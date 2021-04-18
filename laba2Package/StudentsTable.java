package laba2Package;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class StudentsTable extends JPanel {

    private final DefaultTableModel tableModel;
    private final JLabel numberOfCurrentPageLabel;
    private final JLabel countOfStudentsLabel;
    private final JButton nextPageButton;
    private final JButton lastPageButton;
    private final JButton firstPageButton;
    private final JButton previousPageButton;
    private final JComboBox<NotesPerPageEnum> notesPerPageJComboBox;
    private ArrayList<Student> students;
    private int currentPageNumber;
    private int notesPerPage;
    private int allPagesCount;

    public StudentsTable() {
        this.students = new ArrayList<>();
        numberOfCurrentPageLabel = new JLabel();
        countOfStudentsLabel = new JLabel();
        JLabel notesPerPageLAbel = new JLabel();
        JPanel downPanel = new JPanel();
        JPanel upPanel = new JPanel();
        nextPageButton = new JButton(">");
        lastPageButton = new JButton(">>");
        firstPageButton = new JButton("<<");
        previousPageButton = new JButton("<");
        JTable jTable = new JTable();

        notesPerPageJComboBox = new JComboBox(NotesPerPageEnum.values());

        String[] columnNames = {"ФИО", "Курс",
                "группа", "Общее число работ", "Количество выполненных работ",
                "Язык программирования"};

        notesPerPageLAbel.setText("Display students on page  - ");
        countOfStudentsLabel.setText("Number of all students : " + students.size());
        numberOfCurrentPageLabel.setText(currentPageNumber + "/" + allPagesCount);

        notesPerPage = 5;

        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columnNames);
        jTable.setModel(tableModel);

        JScrollPane scrollPane = new JScrollPane(jTable);
        scrollPane.setPreferredSize(new Dimension(800, 300));

        setLayout(new BorderLayout());
        downPanel.add(firstPageButton);
        downPanel.add(previousPageButton);
        downPanel.add(numberOfCurrentPageLabel);
        downPanel.add(nextPageButton);
        downPanel.add(lastPageButton);
        upPanel.add(notesPerPageLAbel);
        upPanel.add(notesPerPageJComboBox);
        upPanel.add(countOfStudentsLabel);
        add(scrollPane, BorderLayout.CENTER);
        add(downPanel, BorderLayout.SOUTH);
        add(upPanel, BorderLayout.NORTH);

        resetPageView();
        initActions();
    }

    public void setStudentsToDisplay(ArrayList<Student> students) throws StudentsTableException {
        if (students == null)
            throw new StudentsTableException("Cant display NULL List of student");
        this.students = students;
        resetPageView();
    }

    public void resetPageView() {
        allPagesCount = students.size() % notesPerPage == 0 ?
                students.size() / notesPerPage : students.size() / notesPerPage + 1;
        currentPageNumber = 1;
        if (students.size() == 0) {
            currentPageNumber = 0;
        }
        displayPage();
    }

    private void displayPage() {
        tableModel.setRowCount(0);
        countOfStudentsLabel.setText("Number of all students : " + students.size());
        numberOfCurrentPageLabel.setText(currentPageNumber + "/" + allPagesCount);
        if (students.size() == 0) return;
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
    }

    private ArrayList<Student> getStudentsToDisplay() {
        return new ArrayList<>(students.subList(
                (currentPageNumber - 1) * notesPerPage,
                Math.min(currentPageNumber * notesPerPage, students.size())
        ));
    }

    private void initActions() {
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
        notesPerPageJComboBox.addActionListener(e -> {
            this.notesPerPage = ((NotesPerPageEnum) notesPerPageJComboBox.getSelectedItem()).getValue();
            resetPageView();
        });
    }

    private enum NotesPerPageEnum {
        FIVE(5),
        TEN(10),
        TWENTY(20);

        private final int numValue;

        NotesPerPageEnum(int numValue) {
            this.numValue = numValue;
        }

        public int getValue() {
            return numValue;
        }
    }
}
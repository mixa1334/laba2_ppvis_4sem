package laba2Package.Models;

import laba2Package.Exceptions.StudentModelException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StudentsModel {

    private ArrayList<Student> students;
    private TreeSet<String> allProgrammingLanguages;
    private TreeSet<Integer> allNumberOfTasks;
    private TreeSet<Integer> allNumberOfCompletedTasks;

    public StudentsModel() {
        students = new ArrayList<>(50);
        allProgrammingLanguages = new TreeSet<>();
        allNumberOfTasks = new TreeSet<>();
        allNumberOfCompletedTasks = new TreeSet<>();
    }

    public void clear() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (student == null) return;
        students.add(student);
    }

    public ArrayList<Student> searchStudents(SearchCriteria searchCriteria, String criteria) throws StudentModelException {
        if (criteria == null) throw new StudentModelException("Empty criteria");
        Field field = null;
        try {
            field = Student.class.getDeclaredField(searchCriteria.getValue());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        final Field finalField = field;
        finalField.setAccessible(true);

        return students.stream().filter(student -> {
            try {
                return (finalField.get(student)).toString().equals(criteria);
            } catch (IllegalAccessException e) {
            }
            return false;
        }).collect(Collectors.toCollection(ArrayList::new));
    }

    public void removeStudents(Student... students) {
        this.students.removeAll(Arrays.asList(students));
    }

    public ArrayList<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void loadStudentsFromFile(File file) throws IOException, SAXException, ParserConfigurationException {
        this.students = StudentSAX.readStudents(file);
    }

    public void saveStudentsToFile(File file) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        StudentDOM.writeStudents(this.students, file);
    }

    public String[] getAllProgrammingLanguages() {
        return allProgrammingLanguages.toArray(new String[0]);
    }

    public Integer[] getAllNumberOfTasks() {
        return allNumberOfTasks.toArray(new Integer[0]);
    }

    public Integer[] getAllNumberOfCompletedTasks() {
        return allNumberOfCompletedTasks.toArray(new Integer[0]);
    }

    private void setAllProgrammingLanguages() {
        allProgrammingLanguages = new TreeSet<>();
        students.forEach(e -> allProgrammingLanguages.add(e.getProgrammingLanguage()));
    }

    private void setAllNumberOfTasks() {
        allNumberOfTasks = new TreeSet<>();
        students.forEach(e -> allNumberOfTasks.add(e.getNumberOfTasks()));
    }

    private void setAllNumberOfCompletedTasks() {
        allNumberOfCompletedTasks = new TreeSet<>();
        students.forEach(e -> allNumberOfCompletedTasks.add(e.getNumberOfCompletedTasks()));
    }

    public enum SearchCriteria {
        FIO("FIO"),
        COURSE("course"),
        GROUP("group"),
        NUMBER_OF_TASKS("numberOfTasks"),
        NUMBER_OF_COMPLETED_TASKS("numberOfCompletedTasks"),
        PROGRAMMING_LANGUAGE("programmingLanguage");

        private final String numValue;

        SearchCriteria(String numValue) {
            this.numValue = numValue;
        }

        public String getValue() {
            return numValue;
        }
    }
}
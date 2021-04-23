package laba2Package.Models;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StudentsModel {

    private ArrayList<Student> students;
    private TreeSet<String> allProgrammingLanguages;
    private TreeSet<String> allNumberOfTasks;
    private TreeSet<String> allNumberOfCompletedTasks;

    public StudentsModel() {
        students = new ArrayList<>(50);
        allProgrammingLanguages = new TreeSet<>();
        allNumberOfTasks = new TreeSet<>();
        allNumberOfCompletedTasks = new TreeSet<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        if (student == null) return;
        students.add(student);
        update();
    }

    public void removeStudents(ArrayList<Student> studentsToRemove) {
        this.students.removeAll(studentsToRemove);
        update();
    }

    public int loadStudentsFromFile(File file) throws IOException, SAXException, ParserConfigurationException {
        PairOfLoadedAndIncorrectlyStudents pair = StudentSAX.readStudents(file);
        this.students = pair.getListOfLoadedStudents();
        update();
        return pair.getIncorrectlyEnteredStudents();
    }

    public void saveStudentsToFile(File file) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        StudentDOM.writeStudents(this.students, file);
    }

    public String[] getAllProgrammingLanguages() {
        return allProgrammingLanguages.toArray(new String[0]);
    }

    public String[] getAllNumberOfTasks() {
        return allNumberOfTasks.toArray(new String[0]);
    }

    public String[] getAllNumberOfCompletedTasks() {
        return allNumberOfCompletedTasks.toArray(new String[0]);
    }

    public ArrayList<Student> searchStudents(Student.AllCriteria searchCriteria, String criteria) {
        try {
            Field field = Student.class.getDeclaredField(searchCriteria.getValue());
            field.setAccessible(true);
            return students.stream().filter(student -> {
                try {
                    return (field.get(student)).toString().equals(criteria);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return false;
            }).collect(Collectors.toCollection(ArrayList::new));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private void setAllProgrammingLanguages() {
        allProgrammingLanguages = new TreeSet<>();
        students.forEach(e -> allProgrammingLanguages.add(e.getProgrammingLanguage()));
    }

    private void setAllNumberOfTasks() {
        allNumberOfTasks = new TreeSet<>();
        students.forEach(e -> allNumberOfTasks.add(Integer.toString(e.getNumberOfTasks())));
    }

    private void setAllNumberOfCompletedTasks() {
        allNumberOfCompletedTasks = new TreeSet<>();
        students.forEach(e -> allNumberOfCompletedTasks.add(Integer.toString(e.getNumberOfCompletedTasks())));
    }

    private void update() {
        setAllNumberOfCompletedTasks();
        setAllNumberOfTasks();
        setAllProgrammingLanguages();
    }

}
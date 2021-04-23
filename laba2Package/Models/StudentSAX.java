package laba2Package.Models;

import laba2Package.Exceptions.StudentException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class StudentSAX {
    private static ArrayList<Student> students;

    private static class StudentHandler extends DefaultHandler {
        private Student student;
        private String field;
        private int incorrectlyEnteredStudents;
        private final ArrayList<String> allStudentFields;

        public StudentHandler() {
            incorrectlyEnteredStudents = 0;
            allStudentFields = new ArrayList<>(8);
            for (Field tempField : Student.class.getDeclaredFields()) {
                allStudentFields.add(tempField.getName());
            }
        }

        public int getIncorrectlyEnteredStudents() {
            return incorrectlyEnteredStudents;
        }


        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equalsIgnoreCase(Student.class.getSimpleName())) {
                student = new Student();
            }
            field = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (student == null) return;
            if (allStudentFields.stream().noneMatch(field::equals)) return;
            try {
                Field fieldToWrite = Student.class.getDeclaredField(field);
                fieldToWrite.setAccessible(true);
                if (fieldToWrite.getType() == int.class) {
                    fieldToWrite.setInt(student, Integer.parseInt(String.copyValueOf(ch, start, length)));
                } else {
                    fieldToWrite.set(student, String.copyValueOf(ch, start, length));
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equalsIgnoreCase(Student.class.getSimpleName())) {
                try {
                    students.add(new Student(student));
                } catch (StudentException e) {
                    incorrectlyEnteredStudents++;
                }
                student = null;
            }
            field = "";
        }
    }

    public static PairOfLoadedAndIncorrectlyStudents readStudents(File file) throws ParserConfigurationException, SAXException, IOException, NumberFormatException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        students = new ArrayList<>();

        StudentHandler studentHandler = new StudentHandler();
        saxParser.parse(file, studentHandler);
        return new PairOfLoadedAndIncorrectlyStudents(students, studentHandler.getIncorrectlyEnteredStudents());
    }
}
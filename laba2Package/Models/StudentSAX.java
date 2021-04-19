package laba2Package.Models;

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

    public static ArrayList<Student> readStudents(File file) throws ParserConfigurationException, SAXException, IOException, NumberFormatException {
        DefaultHandler handler = new DefaultHandler() {
            private Student student;
            private String field;

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
                    students.add(student);
                    student = null;
                }
                field = "";
            }
        };

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        students = new ArrayList<>();

        saxParser.parse(file, handler);
        return students;
    }
}
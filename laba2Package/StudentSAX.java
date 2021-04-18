package laba2Package;

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

    public static ArrayList<Student> readStudents(File file) throws ParserConfigurationException, SAXException, IOException {
        DefaultHandler handler = new DefaultHandler() {
            private Student student;
            private String field;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equalsIgnoreCase("student")) {
                    student = new Student();
                }
                field = qName;
            }

            @Override
            public void characters(char ch[], int start, int length) throws SAXException {
                try {
                    Field fieldToWrite = Student.class.getDeclaredField(field);
                    fieldToWrite.setAccessible(true);
                    if (fieldToWrite.getType() == int.class) {
                        try {
                            fieldToWrite.setInt(student, Integer.parseInt(String.copyValueOf(ch, start, length)));
                        } catch (Exception e) {
                            fieldToWrite.setInt(student, 0);
                        }
                    } else {
                        fieldToWrite.set(student, String.copyValueOf(ch, start, length));
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if (qName.equalsIgnoreCase("student")) {
                    students.add(student);
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
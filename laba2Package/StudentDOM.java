package laba2Package;


import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StudentDOM {
    public static void writeStudents(ArrayList<Student> students, File file) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        clearDocument(document);
        for (Student temp : students) {
            writeToDocument(temp, document);
        }
        updateXML(document, file);
    }

    private static void writeToDocument(Student student, Document document) {
        Node root = document.getDocumentElement();
        Element studentElement = document.createElement(Student.class.getSimpleName());
        for (Field f : Student.class.getDeclaredFields()) {
            Element temp = document.createElement(f.getName());
            f.setAccessible(true);
            try {
                temp.setTextContent(f.get(student).toString());
            } catch (IllegalAccessException e) {
            }
            studentElement.appendChild(temp);
        }
        root.appendChild(studentElement);
    }

    private static void updateXML(Document document, File file) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(file);
        transformer.transform(domSource, streamResult);
    }

    public static void clearDocument(Document document) {
        NodeList students = document.getElementsByTagName(Student.class.getSimpleName());
        Set<Element> targets = new HashSet<>();
        for (int i = 0; i < students.getLength(); i++) {
            targets.add((Element) students.item(i));
        }
        targets.forEach(e -> e.getParentNode().removeChild(e));
    }
}
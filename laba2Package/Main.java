package laba2Package;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        File file = Paths.get("test.xml").toFile();

        //System.out.println(new MySAX().readStudents(file));

        ArrayList<Student> stds = new ArrayList<>(2);
        stds.add(new Student("Valerian Ept", 2, "921701", 12, 11, "js"));
        stds.add(new Student("Goga Vashin", 2, "921702", 7, 2, "c++"));

        MyDOM.writeStudents(stds, file);
    }
}

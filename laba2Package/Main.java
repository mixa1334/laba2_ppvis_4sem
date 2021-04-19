package laba2Package;

import laba2Package.Models.StudentSAX;
import laba2Package.Views.MainView;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        File file = Paths.get("src\\laba2Package\\test.xml").toFile();

        new MainView(StudentSAX.readStudents(file));
    }
}

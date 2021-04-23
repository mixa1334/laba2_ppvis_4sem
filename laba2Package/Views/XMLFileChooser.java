package laba2Package.Views;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class XMLFileChooser extends JFileChooser {
    public XMLFileChooser() {
        FileFilter filter = new FileNameExtensionFilter("XML file", "xml");
        setAcceptAllFileFilterUsed(false);
        setFileFilter(filter);
        addChoosableFileFilter(filter);
    }

    public File getPath() {
        int ret = showDialog(null, "Choose file");
        if (ret == JFileChooser.APPROVE_OPTION) {
            return getSelectedFile();
        }
        return null;
    }
}

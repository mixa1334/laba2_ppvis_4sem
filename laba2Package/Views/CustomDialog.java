package laba2Package.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CustomDialog extends JDialog {
    private final JFrame jFrame;

    public CustomDialog(final JFrame jFrame, final String nameOfDialog) {
        super(jFrame, nameOfDialog, true);
        this.jFrame = jFrame;

        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setResizable(false);
        setLocation(jFrame.getLocation().x + jFrame.getSize().width / 2,
                jFrame.getLocation().y + jFrame.getSize().height / 2);

        pack();
    }

    public void hideCustomDialog() {
        setVisible(false);
        setLocation(jFrame.getLocation().x + jFrame.getSize().width / 2,
                jFrame.getLocation().y + jFrame.getSize().height / 2);
    }
}

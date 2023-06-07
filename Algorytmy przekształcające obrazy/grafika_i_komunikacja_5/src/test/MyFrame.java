package test;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(int wybor, String nazwa, double wartosc) {
        super("Program obrazkowy");

        JPanel obrazPanel = new GrayScale(wybor,nazwa,wartosc);
        add(obrazPanel);
        obrazPanel.setPreferredSize(new Dimension(GrayScale.width,GrayScale.height));
        pack();
        setVisible(true);

    }
}

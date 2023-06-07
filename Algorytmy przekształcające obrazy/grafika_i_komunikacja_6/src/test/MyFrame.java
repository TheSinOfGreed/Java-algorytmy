package test;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {


    MyPanel panel;
    MyFrame(){
        panel = new MyPanel();


        this.add(panel);
        this.pack();
        this.setTitle("Moja mina kiedy Pan Profesor wstawia mi 20% za innowacyjnosc");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

}

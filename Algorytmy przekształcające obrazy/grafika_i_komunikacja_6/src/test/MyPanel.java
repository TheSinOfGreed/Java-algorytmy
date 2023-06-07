package test;



import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    MyPanel(){
        this.setPreferredSize(new Dimension(1000,600));
    }
    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.red);

        for(int i=0;i<256;i++) {

            g2D.drawLine(i, 0, i, algorytmy.tablicar[i]);
        }
        g2D.setColor(Color.green);
        for(int i=256;i<512;i++) {

            g2D.drawLine(i, 0, i, algorytmy.tablicag[i-256]);
        }
        g2D.setColor(Color.blue);
        for(int i=512;i<768;i++) {

            g2D.drawLine(i, 0, i, algorytmy.tablicab[i-512]);
        }

    }
}

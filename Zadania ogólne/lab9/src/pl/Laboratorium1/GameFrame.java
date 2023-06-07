package pl.Laboratorium1;

import javax.swing.JFrame;
import java.io.IOException;

public class GameFrame extends JFrame {//rama gry
    GameFrame()  {//konstr

        GamePanel panel = new GamePanel();
        this.add(panel);
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack(); //jesli damy komponenty do jframe to pack funkcja  dopasuje do wszystkich komponentow
        this.setVisible(true);
        this.setLocationRelativeTo(null);//pojawia sie na srodkku
    }
}

package pl.Laboratorium1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.Random;


public class GamePanel extends JPanel implements ActionListener {
    static final int szerokosc = 600;
    static final int wysokosc = 600;
    static final int unitsWielkosc = 25;
    static final int skala=(szerokosc*wysokosc)/unitsWielkosc;
    static final int opoznienie=75;

    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;

    char direction ='R';
    boolean running = false;
    Timer timer;
    Random random;
    final int x[]=new int[skala];
    final int y[]=new int[skala];

    final int enemyX[] = new int[skala];
    final int enemyY[] = new int[skala];

    final int enemyX2[] = new int[skala];
    final int enemyY2[] = new int[skala];

    final int enemyX3[] = new int[skala];
    final int enemyY3[] = new int[skala];

//    int poisonappleX;
//    int poisonappleY;

    public char getDirection() {
        return direction;
    }


    GamePanel()  {//konstr
        random = new Random();
        this.setPreferredSize(new Dimension(szerokosc,wysokosc));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        enemyX[0]=300;
        enemyY[0]=300;

        enemyX2[0]=500;
        enemyY2[0]=500;

        enemyX3[0]=400;
        enemyY3[0]=100;
        startGame();

        //poisonnewApple();


    }
    public void startGame(){
        newApple();
        running=true;
        timer = new Timer(opoznienie,this);
        timer.start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){ //SIATKA
        if(running) {

            g.setColor(Color.red);
            g.fillOval(appleX, appleY, unitsWielkosc, unitsWielkosc);//jak duze jabko jest
//            g.setColor(Color.yellow);
//            g.fillOval(poisonappleX, poisonappleY, UNIT_SIZE, UNIT_SIZE);

            //enemy waz
            for (int i = 0; i < 6; i++) {
                if (i == 0) {
                    g.setColor(Color.red);
                    g.fillRect(enemyX[i], enemyY[i], unitsWielkosc, unitsWielkosc);
                } else {
                    g.setColor(new Color(3,117,54));
                    g.fillRect(enemyX[i], enemyY[i], unitsWielkosc, unitsWielkosc);
                }

            }
            for (int i = 0; i < 6; i++) {
                if (i == 0) {
                    g.setColor(Color.blue);
                    g.fillRect(enemyX2[i], enemyY2[i], unitsWielkosc, unitsWielkosc);
                } else {
                    g.setColor(new Color(3,117,54));
                    g.fillRect(enemyX2[i], enemyY2[i], unitsWielkosc, unitsWielkosc);
                }

            }
            for (int i = 0; i < 6; i++) {
                if (i == 0) {
                    g.setColor(Color.yellow);
                    g.fillRect(enemyX3[i], enemyY3[i], unitsWielkosc, unitsWielkosc);
                } else {
                    g.setColor(new Color(3,117,54));
                    g.fillRect(enemyX3[i], enemyY3[i], unitsWielkosc, unitsWielkosc);
                }

            }

            //waz
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], unitsWielkosc,unitsWielkosc);
                } else {
                    g.setColor(new Color(45, 180, 0));
                    g.fillRect(x[i], y[i], unitsWielkosc, unitsWielkosc);
                }

            }

            g.setColor(Color.red);
            g.setFont(new Font("Ink Free",Font.BOLD,40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Punkty:"+applesEaten,(szerokosc - metrics.stringWidth("Score:"+applesEaten))/2,g.getFont().getSize());
        }else{gameOver(g);}
    }
    public void newApple(){
        appleX=random.nextInt((int)(szerokosc/unitsWielkosc))*unitsWielkosc;
        appleY=random.nextInt((int)(wysokosc/unitsWielkosc))*unitsWielkosc;
    }
//    public void poisonnewApple(){
//        poisonappleX=random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
//        poisonappleY=random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
//    }
    public void move(){
        for(int i = bodyParts;i>0;i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        switch(direction){
            case 'U'->
                    y[0]=y[0] - unitsWielkosc;
            case 'D'->
                    y[0]=y[0] + unitsWielkosc;
            case 'L'->
                    x[0]=x[0] - unitsWielkosc;
            case 'R'->
                    x[0]=x[0] + unitsWielkosc;
        }

    }
    public void enemyMove(){
        for(int i = 6;i>0;i--){
            enemyX[i] = enemyX[i-1];
            enemyY[i] = enemyY[i-1];
        }
        switch(random.nextInt(4)){
            case 1->
                    enemyY[0]=enemyY[0] - unitsWielkosc;
            case 2->
                    enemyY[0]=enemyY[0] + unitsWielkosc;
            case 3->
                    enemyX[0]=enemyX[0] - unitsWielkosc;
            case 4->
                    enemyX[0]=enemyX[0] + unitsWielkosc;
        }
        for(int i = 6;i>0;i--){
            enemyX2[i] = enemyX2[i-1];
            enemyY2[i] = enemyY2[i-1];
        }
        switch(random.nextInt(4)){
            case 1->
                    enemyY2[0]=enemyY2[0] - unitsWielkosc;
            case 2->
                    enemyY2[0]=enemyY2[0] + unitsWielkosc;
            case 3->
                    enemyX2[0]=enemyX2[0] - unitsWielkosc;
            case 4->
                    enemyX2[0]=enemyX2[0] + unitsWielkosc;
        }
        for(int i = 6;i>0;i--){
            enemyX3[i] = enemyX3[i-1];
            enemyY3[i] = enemyY3[i-1];
        }
        switch(random.nextInt(4)){
            case 1->
                    enemyY3[0]=enemyY3[0] - unitsWielkosc;
            case 2->
                    enemyY3[0]=enemyY3[0] + unitsWielkosc;
            case 3->
                    enemyX3[0]=enemyX3[0] - unitsWielkosc;
            case 4->
                    enemyX3[0]=enemyX3[0] + unitsWielkosc;
        }


    }
//    public void enemyMove(){
//
//        switch(random.nextInt(4)){
//            case 1->
//                    enemyY=enemyY - UNIT_SIZE;
//            case 2->
//                    enemyY=enemyY + UNIT_SIZE;
//            case 3->
//                    enemyX=enemyX - UNIT_SIZE;
//            case 4->
//                    enemyX=enemyX + UNIT_SIZE;
//        }
//
//
//    }


    public void checkApple(){
        if((x[0] == appleX)&& (y[0]==appleY)){
            bodyParts++;
            applesEaten++;
            newApple();

            //poisonnewApple();

        }
    }
//    public void poisoncheckApple(){
//        if((x[0] == poisonappleX)&& (y[0]==poisonappleY)){
//            running=false;
//
//        }
//    }
    public void checkCollisions(){
        //sprawdza czy glowa dotyka ciala
        for(int i=bodyParts;i>0;i--)
        {
            if((x[0] == x[i])&& (y[0]==y[i])){
                running=false;
            }
        }
        //czy wezu dotyka drugiego wezu
        for(int i=6;i>0;i--)
        {
            if((x[0] == enemyX[i])&& (y[0]==enemyY[i])){
                running=false;
            }
        }
        for(int i=6;i>0;i--)
        {
            if((x[0] == enemyX2[i])&& (y[0]==enemyY2[i])){
                running=false;
            }
        }
        for(int i=6;i>0;i--)
        {
            if((x[0] == enemyX3[i])&& (y[0]==enemyY3[i])){
                running=false;
            }
        }



        //czy glowa dotyka granicy lewwej/prawej
        if(x[0]<0){
            running=false;
        }
        if(x[0]>szerokosc){
            running=false;
        }

        if(y[0]<0){
            running=false;
        }
        if(y[0]>wysokosc){
            running=false;
        }
        if(enemyX[0]<0){
            enemyX[0]=600;
        }
        if(enemyX[0]>szerokosc){
            enemyX[0]=1;
        }

        if(enemyY[0]<0){
            enemyY[0]=600;
        }
        if(enemyY[0]>wysokosc){
            enemyY[0]=1;
        }
        if(enemyX2[0]<0){
            enemyX2[0]=600;
        }
        if(enemyX2[0]>szerokosc){
            enemyX2[0]=1;
        }

        if(enemyY2[0]<0){
            enemyY2[0]=600;
        }
        if(enemyY2[0]>wysokosc){
            enemyY2[0]=1;
        }
        if(enemyX3[0]<0){
            enemyX3[0]=600;
        }
        if(enemyX3[0]>szerokosc){
            enemyX3[0]=1;
        }

        if(enemyY3[0]<0){
            enemyY3[0]=600;
        }
        if(enemyY3[0]>wysokosc){
            enemyY3[0]=1;
        }

        if(!running){
            timer.stop();
        }


    }
    public void gameOver(Graphics g){
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free",Font.BOLD,40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Punkty:"+applesEaten,(szerokosc - metrics1.stringWidth("Punkty:"+applesEaten))/2,g.getFont().getSize());
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free",Font.BOLD,25));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Koniec gry",(szerokosc - metrics2.stringWidth("Koniec gry"))/2, wysokosc/3);
        g.drawString("(nacisnij spacje aby zagrac ponownie)",(szerokosc - metrics2.stringWidth("(nacisnij spacje aby zagrac ponownie)"))/2, wysokosc/2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            enemyMove();

            checkApple();
            //poisoncheckApple();
            checkCollisions();
        }
        repaint();
    }
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(direction != 'R'){
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L'){
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D'){
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U'){
                        direction = 'D';
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    direction='S';
                    break;
            }
            if(!running) {
                if(e.getKeyChar()==KeyEvent.VK_SPACE) {
                    startGame();
                    bodyParts=6;
                    direction ='R';
                    x[0] = 0;
                    y[0] = 0;
                    for(int i=bodyParts;i>0;i--)
                    {
                        x[i] = -1;
                        y[i] = -1;
                    }




                    enemyX[0]=300;
                    enemyY[0]=300;

                    enemyX2[0]=500;
                    enemyY2[0]=500;

                    enemyX3[0]=400;
                    enemyY3[0]=100;
                    repaint();
                    applesEaten = 0;

                }

            }
        }
    }

}

package test;



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
    static int opoznienie=75;

    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    int poisonappleX;
    int poisonappleY;
    int poisonappleX2;
    int poisonappleY2;
    int moveappleX;
    int moveappleY;

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



    public char getDirection() {
        return direction;
    }


    GamePanel()  {
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




    }
    public void startGame(){
        newApple();
        newMoveApple();
        running=true;
        timer = new Timer(opoznienie,this);
        timer.start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        if(running) {

            g.setColor(Color.red);
            g.fillOval(appleX, appleY, unitsWielkosc, unitsWielkosc);

            g.setColor(Color.GRAY);
            g.fillOval(poisonappleX, poisonappleY, unitsWielkosc, unitsWielkosc);

            g.setColor(Color.GRAY);
            g.fillOval(poisonappleX2, poisonappleY2, unitsWielkosc, unitsWielkosc);

            g.setColor(Color.orange);
            g.fillOval(moveappleX, moveappleY, unitsWielkosc, unitsWielkosc);

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
        }
        else {gameOver(g);
        }
    }
    public void newApple(){
        appleX=random.nextInt((int)(szerokosc/unitsWielkosc))*unitsWielkosc;
        appleY=random.nextInt((int)(wysokosc/unitsWielkosc))*unitsWielkosc;

        poisonappleX=random.nextInt((int)(szerokosc/unitsWielkosc))*unitsWielkosc;
        poisonappleY=random.nextInt((int)(wysokosc/unitsWielkosc))*unitsWielkosc;

        poisonappleX2=random.nextInt((int)(szerokosc/unitsWielkosc))*unitsWielkosc;
        poisonappleY2=random.nextInt((int)(wysokosc/unitsWielkosc))*unitsWielkosc;
    }

    public void newMoveApple(){

        moveappleX=random.nextInt((int)(szerokosc/unitsWielkosc))*unitsWielkosc;
        moveappleY=random.nextInt((int)(wysokosc/unitsWielkosc))*unitsWielkosc;
    }


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
        switch(random.nextInt(4)){
            case 1->
                    moveappleY=moveappleY - unitsWielkosc;
            case 2->
                    moveappleY=moveappleY + unitsWielkosc;
            case 3->
                    moveappleX=moveappleX- unitsWielkosc;
            case 4->
                    moveappleX=moveappleX + unitsWielkosc;
        }


    }



    public void checkApple(){
        if((x[0] == appleX)&& (y[0]==appleY)){
            bodyParts++;
            applesEaten++;
            if(opoznienie>10) {
                opoznienie  = opoznienie - 1;
                timer.stop();
                timer = new Timer(opoznienie, this);
                timer.start();
            }
            newApple();
        }

        if ((x[0] == moveappleX) && (y[0] == moveappleY)) {
                bodyParts = bodyParts + 2;
                applesEaten = applesEaten + 2;
                if(opoznienie>10) {
                    opoznienie  = opoznienie - 1;
                    timer.stop();
                    timer = new Timer(opoznienie, this);
                    timer.start();
                }
                newMoveApple();
        }

    }


    public void checkCollisions(){

        for(int i=bodyParts;i>0;i--)
        {
            if((x[0] == x[i])&& (y[0]==y[i])){
                running=false;
            }
        }

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

        if((x[0] == poisonappleX)&& (y[0]==poisonappleY)){
            running=false;
        }
        if((x[0] == poisonappleX2)&& (y[0]==poisonappleY2)){
            running=false;
        }




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
        if(moveappleX<0){
            moveappleX=600;
        }
        if(moveappleX>szerokosc){
            moveappleX=1;
        }

        if(moveappleY<0){
            moveappleY=600;
        }
        if(moveappleY>wysokosc){
            moveappleY=1;
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
                    opoznienie=75;
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

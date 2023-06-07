package test;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Zgadywanka extends Game {

    Random rand;
    int podana_liczba ;
    Scanner skaner;
    int wylosowana_liczba;
    String komunikat;
    boolean czyWygral =false;


    @Override
    void initialize() {
        rand = new Random();
        skaner = new Scanner(System.in);
        wylosowana_liczba = rand.nextInt(30);
        //System.out.println(wylosowana_liczba);
        makeMoves();

    }

    @Override
    boolean gameOver() {
        System.out.println("Game over");
        return false;
    }

    @Override
    void makeMoves() {
        for(int i=0; i<4; i++){
            System.out.println("Podaj liczbe");
            podana_liczba = skaner.nextInt();
            if(podana_liczba == wylosowana_liczba){
                czyWygral =true;
                onEnd();
                break;
            }
            else if(podana_liczba > wylosowana_liczba){
                komunikat = "mniej";
                paintScreen();
            }
            else if(podana_liczba < wylosowana_liczba){
                komunikat = "wiecej";
                paintScreen();
            }

        }
        if(!czyWygral){
        gameOver();}
    }

    @Override
    void onEnd() {
        if(czyWygral){
            System.out.println("wygrales");
        }
        else{
            System.out.println("Przegrales");
        }
    }

    @Override
    void paintScreen() {
        System.out.println(komunikat);
    }


}

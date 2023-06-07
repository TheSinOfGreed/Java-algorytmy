package pl.Laboratorium1;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

        Macierz macierz1 = new Macierz(4,4);
        System.out.println(macierz1);



        Macierz macierz2 = new Macierz(4,4);
        System.out.println(macierz2);
        macierz1.Odejmij(macierz2);
        System.out.println(macierz1);

//        macierz1.Pomnoz(30);
//        System.out.println(macierz1);




//
//        System.out.println(macierz1.Pomnoz(macierz2));







    }
}

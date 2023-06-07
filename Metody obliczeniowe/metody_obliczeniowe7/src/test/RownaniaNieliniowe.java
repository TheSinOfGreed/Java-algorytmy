package test;

import java.util.ArrayList;

public class RownaniaNieliniowe {


//    static double funkcja(double x){
//        return Math.pow(x,2)+x-5;
//    }
//    static double funkcjaPochodna1(double x){
//        return 2*x+1;
//    }
//    static double funkcjaPochodna2(double x){
//        return 2;
//    }

    static double funkcja(double x){
        return 6*(Math.pow(x,2) + x -6);
    }
    static double funkcjaPochodna1(double x){
        return 6*(2*x + 1);
    }
    static double funkcjaPochodna2(double x){
        return 12;
    }


    static void warunekKonieczny(double a, double b) throws Exception {
        if(!(funkcja(a) * funkcja(b) < 0 )){
            throw new Exception("warunek konieczny nie jest spełniony");
        }
    }


    static int licznikIteracji = 0;
    static int licznikIteracji2 = 0;
    static int licznikIteracji3 = 0;




    public static void bisekcja(double poczatek_przedzialu, double koniec_przedzialu, double epsilon) throws Exception {
        warunekKonieczny(poczatek_przedzialu,koniec_przedzialu);
        boolean x = false;
        double wynik =0;
        do {
            x= false;
            double Xsr = 0.5 * (poczatek_przedzialu + koniec_przedzialu); //dzielimy na polowe
            if (funkcja(Xsr) == 0) {
                wynik= Xsr;
            } else {

                if (funkcja(Xsr) * funkcja(poczatek_przedzialu) < 0) {
                    koniec_przedzialu = Xsr;
                } else {
                    poczatek_przedzialu = Xsr;

                }
            }
            if (Math.abs(funkcja(Xsr)) < epsilon) {
                wynik= Xsr;
            } else {
                x=true;
            }
        licznikIteracji +=1;
        }while(x);
        System.out.println("x: "+wynik);
        System.out.println("wartosc funkcji wejsciowej: "+ funkcja(wynik));
        System.out.println("liczba iteracji: "+licznikIteracji);
    }

    public static void styczne(double poczatek_przedzialu, double koniec_przedzialu, double epsilon) throws Exception {
    ////wprowadzic recznie pochdne
        warunekKonieczny(poczatek_przedzialu,koniec_przedzialu);

        if(!(funkcjaPochodna1(poczatek_przedzialu)*funkcjaPochodna1(koniec_przedzialu) >=0 ||funkcjaPochodna2(poczatek_przedzialu)*funkcjaPochodna2(koniec_przedzialu)>=0)){
            System.out.println("warunki  zbieżności  nie  są  spełnione");
        }

        double punkt_startowy;
        double wynik;
        boolean x=false;
        if(funkcja(poczatek_przedzialu) * funkcjaPochodna2(poczatek_przedzialu) >0 ){
            punkt_startowy=poczatek_przedzialu;
        }
        else{
            punkt_startowy=koniec_przedzialu;
        }

        do{
            wynik = punkt_startowy -(funkcja(punkt_startowy) / funkcjaPochodna1(punkt_startowy));
            if((Math.abs(funkcja(wynik))  < epsilon) || Math.abs(wynik-punkt_startowy)<epsilon){
                x=true;
            }
            else{
                punkt_startowy= wynik;
            }

            licznikIteracji2 +=1;
        }while(x==false);

        System.out.println("x: "+wynik);
        System.out.println("wartosc funkcji wejsciowej: "+funkcja(wynik));
        System.out.println("liczba iteracji: "+licznikIteracji2);

    }

    public static void sieczne(double poczatek_przedzialu, double koniec_przedzialu, double epsilon) throws Exception {
        warunekKonieczny(poczatek_przedzialu, koniec_przedzialu);

        double wynik =0;
        boolean x = true;
        ArrayList<Double> lista = new ArrayList<>();
        if(funkcja(poczatek_przedzialu) * funkcjaPochodna2(poczatek_przedzialu) >0 ){
            lista.add(koniec_przedzialu);

                    while (x) {
                        lista.add(lista.get(licznikIteracji3) - (funkcja(lista.get(licznikIteracji3)) / (funkcja(lista.get(licznikIteracji3)) - funkcja(poczatek_przedzialu)) *
                                (lista.get(licznikIteracji3) - poczatek_przedzialu)));
                        if ((Math.abs(funkcja(lista.get(lista.size() - 1))) < epsilon) || Math.abs(lista.get(licznikIteracji3 + 1) -
                                lista.get(licznikIteracji3)) < epsilon) {
                                x = false;
                        }
                        licznikIteracji3++;
                    }

            }
            else{
            lista.add(poczatek_przedzialu);
            while (x) {
                lista.add(lista.get(licznikIteracji3) - (funkcja(lista.get(licznikIteracji3)) / (funkcja(koniec_przedzialu) - funkcja(lista.get(licznikIteracji3))) * (koniec_przedzialu -
                        lista.get(licznikIteracji3))));
                if ((Math.abs(funkcja(lista.get(lista.size() - 1))) < epsilon) || Math.abs(lista.get(licznikIteracji3 + 1) -
                        lista.get(licznikIteracji3)) < epsilon) {
                    x = false;
                }
                licznikIteracji3++;
            }
            }



        wynik = lista.get(lista.size() - 1);
        System.out.println("x: "+wynik);
        System.out.println("wartosc funkcji wejsciowej: "+funkcja(wynik));
        System.out.println("liczba iteracji: "+licznikIteracji3);

    }
}

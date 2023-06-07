package test;

import java.util.ArrayList;

public class Newton {

    static double x_pochodna(double x, double y, double h){
        return (f(x+h, y) - f(x,y) )/h;
    }

    static double y_pochodna(double x, double y, double h){
        return (f(x, y+h) - f(x,y) )/h;
    }

    static double x2_pochodna(double x, double y, double h){
        return (f(x+2*h, y) - 2*f(x+h,y) + f(x,y) )/Math.pow(h,2);
    }

    static double y2_pochodna(double x, double y, double h){
        return (f(x, y+2*h) - 2*f(x, y+h) + f(x,y) )/Math.pow(h,2);
    }

    static double xy_pochodna(double x, double y, double h){
        return (f(x+h, y+h) -f(x+h,y) - f(x, y+h) +f(x,y))/Math.pow(h,2);
    }

//    static double f(double x, double y){
//        return 10 * Math.pow(x,2) +12 * x * y + 10 * Math.pow(y,2);
//    }
   // moje
    static double f(double x, double y){
        return Math.pow(x,3) + 8*Math.pow(y,2) -5*x*y - y +3;

    }
    //jarka
//    static double f(double x, double y){
//        return 3*Math.pow(y,3) - 2 *x * y + Math.pow(x,2) - y + 6;
//    }

    static int iteration = 0;
    static int iteration2 = 0;
    static int iteration3 = 0;
    static void Newton(double x, double y, double epsilon){

        double h = 0.00001;
        double[][] HesseMatrix = new double[2][2];
        double gradient_licznik;
        double gradient_mianownik;

        double temp;
        double wyznacznik;
        double licznikPomocniczy,mianownikPomocniczy;
        double stareX,stareY;

        while (true) {
            iteration += 1;
            //liczymy hassego
            HesseMatrix[0][0] = x2_pochodna(x, y, h);
            HesseMatrix[0][1] = xy_pochodna(x, y, h);
            HesseMatrix[1][0] = xy_pochodna(x, y, h);
            HesseMatrix[1][1] = y2_pochodna(x, y, h);

            //liczymy gradient
            gradient_licznik = x_pochodna(x, y, h);
            gradient_mianownik = y_pochodna(x, y, h);

            //liczenie macierzy odwrotnej
            wyznacznik = (HesseMatrix[0][0] * HesseMatrix[1][1]) - (HesseMatrix[0][1]*HesseMatrix[1][0]);
            temp = HesseMatrix[0][0];
            HesseMatrix[0][0] =HesseMatrix[1][1];
            HesseMatrix[0][1] = -1 * HesseMatrix[0][1];
            HesseMatrix[1][0] = -1* HesseMatrix[1][0];
            HesseMatrix[1][1] = temp;

            // właściwe liczenie ze wzoru
            licznikPomocniczy =((gradient_licznik *  HesseMatrix[0][0]) + (gradient_mianownik * HesseMatrix[0][1])) * (1/wyznacznik);
            mianownikPomocniczy =( (gradient_licznik * HesseMatrix[1][0]) + (gradient_mianownik * HesseMatrix[1][1]) ) * (1/wyznacznik);

            stareX = x;
            stareY = y;
            x  = x - licznikPomocniczy;
            y = y - mianownikPomocniczy;


            if((Math.abs(x-stareX) <= epsilon) && (Math.abs(y-stareY) <= epsilon) || (  ( x_pochodna(x,y,h) <=epsilon) && ( y_pochodna(x,y,h) <=epsilon) ) ){
                System.out.println("[" + x + "]");
                System.out.println("[" + y + "]");
                System.out.println(iteration);
                break;
            }
            if(iteration==12){
                System.out.println("[" + x + "]");
                System.out.println("[" + y + "]");
                System.out.println(iteration);
                break;
            }
        }
    }

    static void NajszybszySpadek(double x, double y, double epsilon){

        double h = 0.00001;
        double[][] HesseMatrix = new double[2][2];
        double gradient_licznik;
        double gradient_mianownik;
        double stareX,stareY;
        double licznikPomocniczy,mianownikPomocniczy;
        double ak;

        while (true) {
            iteration2 += 1;
            //liczymy hassego
            HesseMatrix[0][0] = x2_pochodna(x, y, h);
            HesseMatrix[0][1] = xy_pochodna(x, y, h);
            HesseMatrix[1][0] = xy_pochodna(x, y, h);
            HesseMatrix[1][1] = y2_pochodna(x, y, h);

            //liczymy gradient
            gradient_licznik = x_pochodna(x, y, h);
            gradient_mianownik = y_pochodna(x, y, h);

            // właściwe liczenie ze wzoru
            ak = (Math.pow(gradient_licznik,2) + Math.pow(gradient_mianownik,2))/  (((gradient_licznik * HesseMatrix[0][0] + gradient_mianownik * HesseMatrix[1][0])*gradient_licznik)  +  ((gradient_licznik*HesseMatrix[0][1] + gradient_mianownik*HesseMatrix[1][1])*gradient_mianownik));
            licznikPomocniczy = gradient_licznik*ak;
            mianownikPomocniczy = gradient_mianownik*ak;

            stareX = x;
            stareY = y;

            x=x-licznikPomocniczy;
            y=y-mianownikPomocniczy;

            if((Math.abs(x-stareX) <= epsilon) && (Math.abs(y-stareY) <= epsilon) || (  ( x_pochodna(x,y,h) <=epsilon) && ( y_pochodna(x,y,h) <=epsilon) ) ){
                System.out.println("[" + x + "]");
                System.out.println("[" + y + "]");
                System.out.println(iteration2);
                break;
            }
            if(iteration2 == 12){
                System.out.println("[" + x + "]");
                System.out.println("[" + y + "]");
                System.out.println(iteration2);
                break;
            }
        }
    }
    //////////////////////////////////////////////////////////////GAUSS SEIDL//////////////////////////////////////////////////////////////////////////////////////////
    static void Gaussa_Seidla(double x, double y, double epsilon) throws Exception {
        double h = 0.00001;
        int poczatek_przedzialu = 0;
        int koniec_przedzialu = 100;
   
        while(true){
            iteration3 += 1;
           x = bisekcja(poczatek_przedzialu,koniec_przedzialu,0.0001,y);
           y = bisekcja2(poczatek_przedzialu,koniec_przedzialu,0.0001,x);


            if( ( Math.abs(x_pochodna(x,y,h)) <=epsilon) && ( Math.abs(y_pochodna(x,y,h)) <=epsilon) ){
                System.out.println("["+ x + "]");
                System.out.println("["+y + "]");
                System.out.println(iteration3);
                break;
            }
            if(iteration3==12){
                System.out.println("["+ x + "]");
                System.out.println("["+y + "]");
                System.out.println(iteration3);
                break;
            }
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static double bisekcja(double poczatek_przedzialu, double koniec_przedzialu, double epsilon, double y) throws Exception {
        warunekKonieczny(poczatek_przedzialu,koniec_przedzialu,y, 0.00001);
        boolean x = false;
        double wynik =0;
        double h = 0.00001;
        double Xsr;
        do {
            x= false;
            Xsr = 0.5 * (poczatek_przedzialu + koniec_przedzialu); //dzielimy na polowe
            if (x_pochodna(Xsr,y,h) == 0) {
                wynik= Xsr;
            } else {
                if (x_pochodna(Xsr,y,h) * x_pochodna(poczatek_przedzialu,y,h) < 0) {
                    koniec_przedzialu = Xsr;
                } else {
                    poczatek_przedzialu = Xsr;
                }
            }
            if (Math.abs(x_pochodna(Xsr,y,h)) < epsilon) {
                wynik= Xsr;
            } else {
                x=true;
            }
        }while(x);
        return Xsr;
    }

    public static double bisekcja2(double poczatek_przedzialu, double koniec_przedzialu, double epsilon, double y) throws Exception {
        //warunekKonieczny(poczatek_przedzialu,koniec_przedzialu);
        boolean x = false;
        double wynik =0;
        double h = 0.00001;
        double Xsr;
        do {
            x= false;
            Xsr = 0.5 * (poczatek_przedzialu + koniec_przedzialu); //dzielimy na polowe
            if (y_pochodna(y,Xsr,h) == 0) {
                wynik= Xsr;
            } else {
                if (y_pochodna(y,Xsr,h) * y_pochodna(y,poczatek_przedzialu,h) < 0) {
                    koniec_przedzialu = Xsr;
                } else {
                    poczatek_przedzialu = Xsr;
                }
            }
            if (Math.abs(y_pochodna(y,Xsr,h)) < epsilon) {
                wynik= Xsr;
            } else {
                x=true;
            }
        }while(x);
        return Xsr;
    }

    static void warunekKonieczny(double a, double b, double y, double h) throws Exception {

       //System.out.println(x_pochodna(a,y,h) +"   " + x_pochodna(b,y,h));
        if(!(x_pochodna(a,y,h) * x_pochodna(b,y,h) < 0 )){
            throw new Exception("warunek konieczny nie jest spełniony");
        }
    }




}

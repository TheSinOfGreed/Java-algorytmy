package test;

import java.util.ArrayList;

public class Statyczne {

    static int iteration = 3;
    static int iteracjeGlobalne = 0;

    public static double funkcja(double x){
        //return Math.pow((100-x),2); //z zajec przyklad

        //return -8*Math.pow(x,3) -5* Math.pow(x,2) + 154*x -16; //jarka
        return 3*Math.pow(x,3) - 5 * Math.pow(x,2) -9 *x +6; //moje
    }


    public static void Fibonacci(double a, double b, double sigma, boolean czy_min){


        ArrayList<Double> fn = new ArrayList<Double>();
        int n;
        double x1;
        double x2;
        double fn_wartosc;
        fn.add(0.0);
        fn.add(1.0);
        fn.add(2.0);

        while(true) {
            fn.add(fn.get(iteration - 1) + fn.get(iteration - 2));
            if (((b - a) / fn.get(iteration)) < 2 * sigma) {
                break;
            }
            iteration++;
        }
        n =iteration-1;
        fn_wartosc = fn.get(iteration-1);


        x1 = b-((fn.get(n-1))/ fn.get(n))*(b-a);
        x2 = a +((fn.get(n-1))/ fn.get(n) *(b-a));


        if(czy_min){
            while(true) {
                iteracjeGlobalne +=1;
                if (funkcja(x1) < funkcja(x2)) {

                    b = x2;
                    x2 = x1;
                    n = n - 1;
                    x1 = b - ((fn.get(n - 1)) / fn.get(n)) * (b - a);

                } else {

                    a = x1;
                    x1 = x2;
                    n = n - 1;
                    x2 = a + ((fn.get(n - 1)) / fn.get(n) * (b - a));
                }
                System.out.println(x1 + " iteracje " + iteracjeGlobalne);
                if ((  Math.abs(x2 - x1) < sigma) || (n == 1)) {

                    break;
                }
            }
        }else{
            while(true) {
                iteracjeGlobalne+=1;
                if (funkcja(x1) > funkcja(x2)) {
                    b = x2;
                    x2 = x1;
                    n = n - 1;
                    x1 = b - ((fn.get(n - 1)) / fn.get(n)) * (b - a);
                } else {
                    a = x1;
                    x1 = x2;
                    n = n - 1;
                    x2 = a + ((fn.get(n - 1)) / fn.get(n) * (b - a));
                }
                if ((Math.abs(x2 - x1) < sigma) || (n == 1)) {
                    System.out.println(x1 + " iteacje" +iteracjeGlobalne);
                    break;
                }
            }
        }



    }
}

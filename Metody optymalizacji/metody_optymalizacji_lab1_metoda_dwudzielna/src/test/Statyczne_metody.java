package test;

public class Statyczne_metody {

    public static double funkcja(double x){
        // return Math.pow((100-x),2); //z zajec przyklad

        //return -8*Math.pow(x,3) -5* Math.pow(x,2) + 154*x -16; //jarka
        return 3*Math.pow(x,3) - 5 * Math.pow(x,2) -9 *x +6; //moje
    }
    static int iteracje = 0;
    public static void metoda_dwudzielna(double a, double b, double sigma, boolean czy_min){
        //wynik to 99,375
        //1 punkt
        double xSrodkowe = (a+b)/2;

        //2 punkt
        double L =b-a;
        double x1 =a + (L/4);
        double x2 =b - (L/4);
        double max =0;
        double min =0;

        if(czy_min == false) {
            //pkt 3-5
            while (true) {
                iteracje +=1;
                if (funkcja(x1) > funkcja(xSrodkowe)) {// dla max

                    b = xSrodkowe;
                    xSrodkowe = x1;
                    if (L <= sigma) {
                        max = xSrodkowe;
                        break;
                    }
                   // System.out.println("x1: " + x1 + " x2: " + x2 + " func(x1): " + funkcja(x1) + " f(x2): " + funkcja(x2) + " xSrodkowe: " + xSrodkowe);
                    L = b - a;
                    x1 = a + (L / 4);
                    x2 = b - (L / 4);


                } else if (funkcja(x1) <= funkcja(xSrodkowe)) {// dla max
                    if (funkcja(x2) > funkcja(xSrodkowe)) {
                        a = xSrodkowe;
                        xSrodkowe = x2;
                    } else if (funkcja(x2) <= funkcja(xSrodkowe)) {
                        a = x1;
                        b = x2;
                    }
                    if (L <= sigma) {
                        max = xSrodkowe;
                        break;
                    }
                    //System.out.println("x1: " + x1 + " x2: " + x2 + " func(x1): " + funkcja(x1) + " f(x2): " + funkcja(x2) + " xSrodkowe: " + xSrodkowe);
                    L = b - a;
                    x1 = a + (L / 4);
                    x2 = b - (L / 4);


                }

            }
            System.out.println("Max wynosi: "+max);
        }else {
            while (true) {
                iteracje +=1;
                if (funkcja(x1) < funkcja(xSrodkowe)) {//dla min
                    b = xSrodkowe;
                    xSrodkowe = x1;
                    if (L <= sigma) {
                        min = xSrodkowe;
                        break;
                    }
                    //System.out.println("x1: " + x1 + " x2: " + x2 + " func(x1): " + funkcja(x1) + " f(x2): " + funkcja(x2) + " xSrodkowe: " + xSrodkowe);
                    L = b - a;
                    x1 = a + (L / 4);
                    x2 = b - (L / 4);


                } else if (funkcja(x1) >= funkcja(xSrodkowe)) {// dla min
                    if (funkcja(x2) < funkcja(xSrodkowe)) {
                        a = xSrodkowe;
                        xSrodkowe = x2;
                    } else if (funkcja(x2) >= funkcja(xSrodkowe)) {
                        a = x1;
                        b = x2;
                    }
                    if (L <= sigma) {
                        min = xSrodkowe;
                        break;
                    }
                    //System.out.println("x1: " + x1 + " x2: " + x2 + " func(x1): " + funkcja(x1) + " f(x2): " + funkcja(x2) + " xSrodkowe: " + xSrodkowe);
                    L = b - a;
                    x1 = a + (L / 4);
                    x2 = b - (L / 4);
                }
                System.out.println("Min wynosi: "+xSrodkowe + " iteracje:"+iteracje);
            }
            System.out.println("Min wynosi: "+min + " iteracje:"+iteracje);
        }
    }
}

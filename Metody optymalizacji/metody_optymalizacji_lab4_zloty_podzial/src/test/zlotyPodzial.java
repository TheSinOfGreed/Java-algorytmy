package test;

import java.util.ArrayList;

public class zlotyPodzial {

    public static double funkcja(double x){
        return 3*Math.pow(x,3) - 5 * Math.pow(x,2) -9 *x +6;
    }
    static int iteration = 0;
    public static void zlotyPodzial(double a, double b, double sigma, boolean czy_min){

        double k = (Math.sqrt(5) - 1)/2;
        double x1 = b-k*(b-a);
        double x2 = a+k*(b-a);

        while(true){
            iteration +=1;
            if(czy_min){//min
                if(funkcja(x1) < funkcja(x2)){
                    b=x2;
                    x2=x1;
                    x1=b-k*(b-a);
                }else{
                    a=x1;
                    x1=x2;
                    x2=a+k*(b-a);
                }
                System.out.println("iteracje "+ iteration+" odpowiedz dla min: "+x1 );
                if( Math.abs(x2 - x1) < sigma){

                    break;
                }

            }else{//max

                if(funkcja(x1) > funkcja(x2)){
                    b=x2;
                    x2=x1;
                    x1 = b-k *(b-a);
                }else{
                    a=x1;
                    x1=x2;
                    x2= a+k*(b-a);
                }

                if( Math.abs(x2-x1) < sigma){
                    System.out.println("odpowiedz dla max: " + x1);
                    break;
                }
            }
        }













    }
}

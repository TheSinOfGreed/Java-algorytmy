package test;

public class Aproksymacja {

    private static double wielomianyLangrade(double x, int wybor) {
    switch(wybor){
        case 0 ->{ return 1;}
        case 1 ->{ return x;}
        case 2 ->{ return 0.5*(3*Math.pow(x,2)-1);}
        case 3 ->{ return 0.5 * (5 * Math.pow(x, 3) - 3 * x);}
        case 4 ->{ return 0.128 * (35 * Math.pow(x, 4) - 30 * Math.pow(x, 2) + 3);}
        case 5 -> {return 0.128 * (63 * Math.pow(x, 5) - 70 * Math.pow(x, 3) + 15 * x);}
        case 6 -> {return 0.0625 * (231 * Math.pow(x, 6) - 315 * Math.pow(x, 4) + 105 * Math.pow(x, 2) - 5);}
        case 7 -> {return 0.0625 * (429 * Math.pow(x, 7) - 693 * Math.pow(x, 5) + 315 * Math.pow(x, 3) - 35 * x);}

        default -> throw new IllegalArgumentException("gfhfgh"){};

    }
    }
    private static double funkcja2(double x,int ii) {

        return Math.pow(wielomianyLangrade(x,ii),2) ;

    }

    public static double metodaSimsona(double poczatekPrzedzialu, double koniecPrzedzialu, int n,int ii){
        double h = (koniecPrzedzialu-poczatekPrzedzialu)/(double)n;
        double sum1=0;
        double sum2=0;
        double[] tablica = new double[n+1];
        double[] tablicaBezF = new double[n+1];
        for(int i=0;i<n+1;i++){
            tablicaBezF[i] = poczatekPrzedzialu+i*h ;
            tablica[i] = funkcja2(poczatekPrzedzialu+i*h,ii) /* xi */;
        }
        double[] t = new double[n];
        for(int i=0;i<n;i++){
            t[i] = funkcja2((tablicaBezF[i+1] +tablicaBezF[i])/2,ii) ;
        }
        for(int i =0 ; i<n;i++){
            sum1 += t[i];
        }
        sum1 *=4;
        for(int i =1 ; i<n;i++){
            sum2 += tablica[i];
        }
        sum2 *=2;
        return (funkcja2(poczatekPrzedzialu,ii)+sum1+sum2+tablica[n]) * (h/6);
    }
///////////////////////////////////////////////C///////////////////////////////////////////////////////
public static double metodaSimsona2(double poczatekPrzedzialu, double koniecPrzedzialu, int n,int ii){
    double h = (koniecPrzedzialu-poczatekPrzedzialu)/(double)n;
    double sum1=0;
    double sum2=0;
    double[] tablica = new double[n+1];
    double[] tablicaBezF = new double[n+1];
    for(int i=0;i<n+1;i++){
        tablicaBezF[i] = poczatekPrzedzialu+i*h ;
        tablica[i] = funkcja(poczatekPrzedzialu+i*h,ii) /* xi */;
    }
    double[] t = new double[n];
    for(int i=0;i<n;i++){
        t[i] = funkcja((tablicaBezF[i+1] +tablicaBezF[i])/2,ii) ;
    }
    for(int i =0 ; i<n;i++){
        sum1 += t[i];
    }
    sum1 *=4;
    for(int i =1 ; i<n;i++){
        sum2 += tablica[i];
    }
    sum2 *=2;
    return (funkcja(poczatekPrzedzialu,ii)+sum1+sum2+tablica[n]) * (h/6);
}
    private static double funkcja(double x,int ii) {

        return wielomianyLangrade(x,ii)* Math.sqrt(3*Math.pow(x,2)+1) ;
        ///////////////////////////////////TU JEST F(X)/////////////////////////////////////////////
    }


    public static double aproksymacjaOrtogonalna(int n, double x){

        //n - stopien wielomianu apro
        double[] lambda = new double[n+1]; //lambda liczenie
        for(int i =0;i<=n;i++){
            lambda[i]= metodaSimsona(-1,1,n,i);
        }
        double[] c_array = new double[n+1]; //liczenie c
        for(int i =0;i<=n;i++){
            c_array[i]= metodaSimsona2(-1,1,n,i) * (1/lambda[i]);
            //System.out.println(c_array[i]);
        }
        double suma= 0;
        for(int i =0;i<=n;i++){
            suma += c_array[i] * wielomianyLangrade(x,i);
        }
        return suma;
    }
}

package test;

public class Aproksymacja {

    private static double f(double x,int i,int j, double waga) {

        return Math.pow(x,i) *Math.pow(x,j) * waga;

    }
    public static double metodaTrapezow(double poczatekPrzedzialu, double koniecPrzedzialu, int n,int a, int b, double waga){
        double h = (koniecPrzedzialu-poczatekPrzedzialu)/(double)n;
        double sum=0;
        for(int i=1; i<n;i++){

            sum += f(poczatekPrzedzialu+i*h,a,b,waga /* xi */);

        }
        return h*((f(poczatekPrzedzialu,a,b,waga)/2)+ sum + (f(koniecPrzedzialu,a,b,waga)/2));
    }
    private static double fx(double x) {

        return Math.sqrt(3*Math.pow(x,2)+1) ;

    }
    private static double f2(double x,int i, double waga) {

        return Math.pow(x,i)*waga* fx(x);

    }
    public static double metodaTrapezowDlaKonca(double poczatekPrzedzialu, double koniecPrzedzialu, int n,int a, double waga){
        double h = (koniecPrzedzialu-poczatekPrzedzialu)/(double)n;
        double sum=0;
        for(int i=1; i<n;i++){

            sum += f2(poczatekPrzedzialu+i*h,a,waga );

        }
        return h*((f2(poczatekPrzedzialu,a,waga)/2)+ sum + (f2(koniecPrzedzialu,a,waga)/2));
    }

    public static double aproksymacjaSredniokwadratowa(double poczatek_przedzialu,
                                                 double koniec_przedzialu, double px,int stopienWielomianuApr, int n, double punkt){

        //px -waga
        //n ilosc przedzialow calkowaia

        double[][] tablica = new double[stopienWielomianuApr+1][stopienWielomianuApr+2];

        for(int i=0; i< stopienWielomianuApr+1;i++){
            for(int j=0;j<stopienWielomianuApr+2;j++){
                if(j!=stopienWielomianuApr+2-1){ //pierwsza czesc
                    tablica[i][j]= metodaTrapezow(poczatek_przedzialu,koniec_przedzialu,n,i,j,px);
                    //System.out.println(tablica[i][j]);
                }
                else{//druga czesc macierzy
                    tablica[i][j]= metodaTrapezowDlaKonca(poczatek_przedzialu,koniec_przedzialu,n,i,px);
                    //System.out.println(tablica[i][j]);
                }
            }

        }
        double[] wynik = Gauss.Gauss(tablica);
//        for(int i =0;i<wynik.length;i++){
//            System.out.println(wynik[i]);
//        }
        double suma = 0;
        for(int a=0;a<wynik.length;a++){

            suma += wynik[a] * Math.pow(punkt,a);

        }


        return suma;
    }


}

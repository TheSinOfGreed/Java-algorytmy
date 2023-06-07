package test;

import java.util.LinkedList;

public class Statyczne {
/////////////////////////////////////////////////////////////////////////////////////////////////Lab3
    public static double Lagrange(double[] Tx,double[] Ty,int liczbaPunktow , double x){


        double wartoscKoncowa=0;
        double wartoscL=1;

        for(int i=0;i<liczbaPunktow;i++){
            for(int j=0;j<liczbaPunktow;j++){
                if(i ==j ){continue;}
                wartoscL *= (x - Tx[j]) / (Tx[i] -Tx[j]);

            }
            wartoscKoncowa += wartoscL * Ty[i];
            wartoscL = 1;

        }

        return wartoscKoncowa;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////LAB4
    public static double NewtonInterpulation(double[] Tx,double[] Ty, int iloscRzedow, double x){


        double[][] tablica_do_liczenia = new double[iloscRzedow][iloscRzedow]; //tablic do ilorazów różnicowych

        for(int i =0;i<iloscRzedow;i++){ //liczmy 1 rzad
            tablica_do_liczenia[0][i] = SingleNewtonInterpulation(Tx[i],Ty[i],Tx[i+1],Ty[i+1]);
        }
        for(int i =1;i<iloscRzedow;i++){  //liczymy kolejne rzedy
            for(int j=0;j<iloscRzedow-i;j++){
                tablica_do_liczenia[i][j] =   ( tablica_do_liczenia[i-1][j+1] - tablica_do_liczenia[i-1][j] )  /( Tx[i+1+j] -Tx[j]);
            }
        }
        double sum =1;
        double[] lista = new double[iloscRzedow];            //liczmy koncowy wzor
        for(int a = iloscRzedow-1;a >= 0;a--) {

                sum =1;
                for (int b = a ; b >= 0; b--) {
                    sum *= x - Tx[b];
                }
                lista[a] = sum * tablica_do_liczenia[a][0];
        }

        double suma = 0;
        for(int i =0;i< lista.length;i++){      //sumujemy kolejne wyrazenia ze wzoru
           suma += lista[i];
        }
        return suma += Ty[0];   //dodajemy wyraz 0 i zwracamy


    }
    public static double SingleNewtonInterpulation(double x, double y,double x1,double y2){ //lab4

        return (y2 - y)/ (x1-x);
    }


    //////////////////////////////////////////////////////////////////////////////////////////////LAB5

    public static double funkcje_sklejane(double[] Tx, double[] Ty, double pochodna_poczatkowa, double pochodna_koncowa, double x){

        // x[0] + x[1]* x + x[2] * x^2 + x[3] * x^2

        double[][] tablica = new double[Tx.length+2][4+1+(Ty.length-1-1)];
        //double[] tablica = new double[4];

        //liczeni wielomianu 3 stopnia (pamietac ze a0 uzupelnic)
        for(int i=0;i<Tx.length;i++) {

            tablica[i][0]=1;
            for (int j = 1; j < 4; j++) {
                tablica[i][j]=1;
                tablica[i][j] = tablica[i][j] * Math.pow(Tx[i],j);
            }
            if(i>1){
                int stala = 4;
                int stala1 =1;
            for (int s = Tx.length; s < Ty.length+1+(Ty.length-1-1-1); s++) {

                if(Tx[i]<Tx[stala1]){
                    stala++;
                    continue;}
                tablica[i][stala]= Math.pow(Tx[i]-Tx[stala1],3);
                stala++;
                stala1++;
            }
            }
        }
        //dwa ostatnie
        for(int a =Tx.length;a<Tx.length+2;a++){
            for(int b=1;b<4;b++){
                if(a==Tx.length){//pierwszy
                if(b==1) {
                    tablica[a][b] = 1;
                }
                if(b==2) {
                    tablica[a][b] = 1;
                    tablica[a][b] = tablica[a][b] * Tx[0] * 2;
                }
                if(b==3){
                    tablica[a][b] = 1;
                    tablica[a][b] = tablica[a][b] * Math.pow(Tx[0],2) * 3;
                }}
                if(a==Tx.length+1){//ostatni
                    if(b==1) {
                        tablica[a][b] = 1;
                    }
                    if(b==2) {
                        tablica[a][b] = 1;
                        tablica[a][b] = tablica[a][b] * Tx[Tx.length-1] * 2;
                    }
                    if(b==3){
                        tablica[a][b] = 1;
                        tablica[a][b] = tablica[a][b] * Math.pow(Tx[Tx.length-1],2) * 3;
                    }}

            }
        }
        //ostatnie komorki ostatniego wiersza
        int stala_czw=4;
        for(int t= Tx.length;t<Ty.length+1+(Ty.length-1-1-1);t++){
            tablica[Tx.length+1][stala_czw]= Math.pow(Tx[Tx.length-1]-Tx[t-(Tx.length-1)],2)*3;
            stala_czw++;
        }
        for(int v=0;v<Tx.length+2;v++){
            if(v==Tx.length+1){
                tablica[v][Tx.length+2]=pochodna_koncowa;
            }
            else if(v==Tx.length){
                tablica[v][Tx.length+2]=pochodna_poczatkowa;
            }
            else{
                tablica[v][Tx.length+2]=Ty[v];
            }

        }
////////////////////////////////////////////////////////////////////////////////////ok
            //sprawdzenie czy dziala
//        for(int i =0;i<Tx.length+2;i++){
//            for(int j=0;j<Ty.length+3;j++){
//                System.out.print("["+tablica[i][j]+"]");
//            }
//            System.out.println();
//        }
        double[] tablicaWynik;
        tablicaWynik=Gauss.Gauss(tablica);
//        for(int i=0;i<tablicaWynik.length;i++){
//            System.out.println(tablicaWynik[i]);
//        }
        double suma=tablicaWynik[0];
        for(int z=1; z<tablicaWynik.length;z++){
            if(z<4){
                suma += tablicaWynik[z] * Math.pow(x,z);

            }else{
                if( !(x<Tx[1] && x>Tx[0])){
                for(int y=1;y<= IleRazySuma(Tx,x) ;y++){

                    suma+=tablicaWynik[z]*Math.pow(x-Tx[y],3);
                    z++;
                }}
            }
        }

        return suma;
    }

    public static int IleRazySuma(double[] tablica,double x){

        for(int i =0;i<tablica.length-1;i++){
            if(x > tablica[i] && x<tablica[i+1]){
                if(i==0){return 0 ;}
                return i;
            }
        }
        return 0;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////LAB6

    public static double NewtonInterpulationRP(double[] Tx,double[] Ty, int iloscRzedow, double x){

        double h= Tx[1]-Tx[0];
        double[][] tablica = new double[iloscRzedow][iloscRzedow];
        for(int i =0;i<iloscRzedow-1;i++){
            tablica[0][i] = Ty[i+1]-Ty[i];
        }
        for(int i =1;i<iloscRzedow;i++){
            for(int j=0;j<iloscRzedow-i;j++){
                tablica[i][j] =  tablica[i-1][j+1] - tablica[i-1][j];
            }
        }
        double sum =1;
        double[] lista = new double[iloscRzedow];
        for(int a = iloscRzedow-1;a >= 0;a--) {

            sum =1;
            for (int b = a ; b >= 0; b--) {
                sum *= x - Tx[b];
            }
            lista[a] = sum * (tablica[a][0]/(silnia(a+1)*Math.pow(h,a+1)));
        }
        double suma = 0;
        for(int i =0;i< lista.length-1;i++){
            suma += lista[i];
        }
        return suma += Ty[0];




    }

    public static int silnia(int x){
        if(x<1){
            return 1;
        }
        else{
            return x * silnia(x-1);
        }
    }


}

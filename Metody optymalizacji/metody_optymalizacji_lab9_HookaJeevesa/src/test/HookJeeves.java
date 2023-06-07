package test;

public class HookJeeves {

//    static double f(double x1, double x2){
//        return 2.5*Math.pow((Math.pow(x1,2) -x2),2) + Math.pow((1-x1),2);
//    }

    static double f(double x, double y){
        return Math.pow(x,3) + 8*Math.pow(y,2) -5*x*y - y +3;
    }
    static void HookJeeves(double x, double y, double e, double beta, double epsilon, int n, boolean czyMin){


        //pkty startowe
        double[] x0 = new double[2];
        //pkty bazowe
        double[] xB0 = new double[2];
        double[] xB = new double[2];
        // nadanie im wartości
        x0[0] = x;x0[1] = y;
        xB0[0] = x;xB0[1] = y;
        xB[0] = x;xB[1] = y;
        //dodatkowe zmienne/funkcje
        double f;
        int j;
        double f_0;double f_B;
        // X do obliczen
        double[] X_do_obliczen = new double[2];
        double[] X_do_obliczen_stare = new double[2];
        X_do_obliczen_stare[0] = x0[0];
        X_do_obliczen_stare[1] = x0[1];
        boolean czy_1_pkt_ma_sie_wykonac = true;
        //Ksi baza wektorów ortogonalnych
        double[] Ksi1 = {1, 0};
        double[] Ksi2 = {0, 1};
        // żeby nie wywalało błędu że może być nie zainicjowane
        j = 1;
        f_0 = f(x0[0], x0[1]);
        f_B = f(xB[0], xB[1]);
        // iteracje aby sie odwoływac
        int iteration =0;


        while(true){
            iteration =1+ iteration;
            if(czy_1_pkt_ma_sie_wykonac) {
                //1
                j = 1;
                f_0 = f(x0[0], x0[1]);
                f_B = f(xB[0], xB[1]);

            }
            //2
            X_do_obliczen[0] =(j ==1? x0[0] :X_do_obliczen_stare[0]) + e * (j==1? Ksi1[0] : Ksi2[0]) ;
            X_do_obliczen[1] =(j==1? x0[1] : X_do_obliczen_stare[1]) + e * (j==1? Ksi1[1] : Ksi2[1]) ;
            f = f(X_do_obliczen[0], X_do_obliczen[1]);


            //3
            if( czyMin ? f < f_0 : f > f_0 ){
                f_0 = f;
            }else{
                X_do_obliczen[0] = X_do_obliczen[0] - 2 * e * (j==1? Ksi1[0] : Ksi2[0]) ;
                X_do_obliczen[1] = X_do_obliczen[1] - 2 * e * (j==1? Ksi1[1] : Ksi2[1]) ;
                f = f(X_do_obliczen[0],X_do_obliczen[1]);



                //4
                if(czyMin ? f < f_0 : f > f_0){
                    f_0 = f;
                }else{
                    X_do_obliczen[0] = X_do_obliczen[0] + e * (j==1? Ksi1[0] : Ksi2[0]) ;
                    X_do_obliczen[1] = X_do_obliczen[1] + e *(j==1? Ksi1[1] : Ksi2[1]) ;
                    f = f(X_do_obliczen[0], X_do_obliczen[1]);

                }

            }

            //5
            if(j != n){
                j=j+1;
                X_do_obliczen_stare[0] =X_do_obliczen[0];
                X_do_obliczen_stare[1] = X_do_obliczen[1];
                czy_1_pkt_ma_sie_wykonac =false;
                if(iteration == 20){
                    System.out.println(X_do_obliczen[0] + " - "+ X_do_obliczen[1]);
                    System.out.println(iteration);
                    break;
                }
                continue;
            }else{
                if( czyMin ? f_B > f_0 : f_B < f_0){

                    //6 etap roboczy

                    xB0[0]=xB[0];
                    xB0[1]=xB[1];

                    xB[0] = X_do_obliczen[0];
                    xB[1] = X_do_obliczen[1];


                    x0[0] = xB[0] +(xB[0] - xB0[0] ) ;
                    x0[1] = xB[1] +(xB[1] - xB0[1] ) ;

                    //uaktualnienie zmiennych
                    czy_1_pkt_ma_sie_wykonac = true;
                    X_do_obliczen_stare[0] = X_do_obliczen[0];
                    X_do_obliczen_stare[1] = X_do_obliczen[1];

                }else{
                    //7
                    if( e > epsilon){
                        e = beta * e;
                        x0[0] = xB[0];
                        x0[1] = xB[1];

                        czy_1_pkt_ma_sie_wykonac = true;
                        X_do_obliczen_stare[0] = X_do_obliczen[0];
                        X_do_obliczen_stare[1] = X_do_obliczen[1];
                    }else{
                        System.out.println(X_do_obliczen[0] + " "+ X_do_obliczen[1] + " END");

                        break;
                    }

                }
            }
            if(iteration == 20){
                System.out.println(X_do_obliczen[0] + " | "+ X_do_obliczen[1]);
                System.out.println(iteration);
                break;
            }

        }

    }
}

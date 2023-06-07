public class Simplex {

    static double funkcja( double x, double y){
        return x + 2 * y;
    }


    static void Simplex(double[][] macierz, double[] ci, double[] cj, double[] bi, boolean min, int dl, int wys){

        double[] zj = new double[dl];
        double[] cjMINUSzj = new double[dl];
        double[] biPODZIELai = new double[wys];
        boolean czyWarunekStopSpelniony = false;
        double kryterium_wyjscia_wejscia = 0;
        int iteracje = 0;

        while(true) {

            if( iteracje == 0) {
                for (int j = 0; j < dl; j++) {
                    for (int i = 0; i < wys; i++) {
                        zj[j] += ci[i] * macierz[i][j];
                    }
                }
                for (int j = 0; j < dl; j++) {
                    cjMINUSzj[j] = cj[j] - zj[j];
                }
            }



            // szukanie kryterium wejscia
            int kryterium_wejscia = 0;
            for (int i = 0; i < cjMINUSzj.length; i++) {
                kryterium_wejscia = cjMINUSzj[i] > cjMINUSzj[kryterium_wejscia] ? i : kryterium_wejscia;
            }


            for (int i = 0; i < biPODZIELai.length; i++) {
                biPODZIELai[i] = bi[i] / macierz[i][kryterium_wejscia];
            }


            //szukanie kryterium wyjscia //najmn elem i bez minusowych
            int kryterium_wyjscia = 0;
            for (int i = 0; i < biPODZIELai.length; i++) {
                if (biPODZIELai[i] < 0) {
                    continue;
                }
                kryterium_wyjscia = biPODZIELai[i] < biPODZIELai[kryterium_wyjscia] ? i : kryterium_wyjscia;
            }

            kryterium_wyjscia_wejscia = macierz[kryterium_wyjscia][kryterium_wejscia];


            //dzielimy wiersz z kryterium wyjscia
            for (int j = 0; j < dl; j++) {
                macierz[kryterium_wyjscia][j] = macierz[kryterium_wyjscia][j] /kryterium_wyjscia_wejscia;
            }
            bi[kryterium_wejscia] = bi[kryterium_wejscia] / kryterium_wyjscia_wejscia;


            ci[kryterium_wyjscia] /= kryterium_wyjscia_wejscia;



            //pozostałe wiersze: od i-tego wiersza odejmu

            double[][] nowa_macierz = new double[wys][dl];

            for (int i = 0; i < wys; i++) {
                for (int j = 0; j < dl; j++) {
                    if (i != kryterium_wyjscia) {
                        nowa_macierz[i][j] = macierz[i][j] - (macierz[kryterium_wyjscia][j] * macierz[i][kryterium_wejscia]);
                    } else {
                        nowa_macierz[i][j] = macierz[i][j];
                    }
                }
            }

            double[] nowe_bi = new double[wys];



            for (int i = 0; i < bi.length; i++) {
                if (i != kryterium_wyjscia) {
                    nowe_bi[i] = bi[i] - (bi[kryterium_wyjscia] * macierz[i][kryterium_wejscia]);
                } else {
                    nowe_bi[i] = bi[i];
                }
            }



            //Dodatkowo zmienną kryterium wejścia
            ci[kryterium_wyjscia] = cj[kryterium_wejscia];



            for (int i = 0; i < dl; i++) {
                zj[i] = 0;
            }



            for (int j = 0; j < dl; j++) {
                for (int i = 0; i < wys; i++) {
                    zj[j] += ci[i] * nowa_macierz[i][j];
                }
            }


            for (int j = 0; j < dl; j++) {
                cjMINUSzj[j] = cj[j] - zj[j];
            }

            //warunek sprawdzamy
            if(min){
                for (int j = 0; j < dl; j++) {
                    if( cjMINUSzj[j] <= 0 ){
                        break;
                    }
                    czyWarunekStopSpelniony = true;
                }
            }else{
                for (int j = 0; j < dl; j++) {
                    if( cjMINUSzj[j] >= 1 ){
                        break;
                    }
                    czyWarunekStopSpelniony = true;
                }
            }





            // jak warunek spełniony to wypisujemy wartosci
            if(czyWarunekStopSpelniony){
                for(int i =0;i <wys ;i++){
                    System.out.println("x" +(i+1) + ": " +nowe_bi[i]);
                }
                System.out.println("Funkcja f(x) = "+funkcja(nowe_bi[0],nowe_bi[1] ));
                break;
            }

            // jak nie to do macierzy przypisujemy wartosci nowej macierzy, i nowa macierz zerujemy
            for(int i=0;i<wys;i++){
                for(int j=0; j<dl; j++){
                    macierz[i][j] = nowa_macierz[i][j];
                    nowa_macierz[i][j] = 0;
                }
            }
            //zerujemy bi
            for(int i = 0; i<wys; i++){
                bi[i] = nowe_bi[i];
                nowe_bi[i] = 0;
            }
            //zerujemy biPodzielai
            for(int i = 0; i<wys; i++){
                biPODZIELai[i] = 0;
            }

            iteracje += 1;



        }

    }
}

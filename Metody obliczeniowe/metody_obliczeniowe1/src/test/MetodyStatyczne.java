package test;

public class MetodyStatyczne {

    static void Gauss(double[][] macierz){

        double[][] mWynik = new double[macierz.length][macierz[0].length];

        for(int a=0;a<macierz.length;a++){
            for(int b=0;b<macierz[0].length;b++){
                mWynik[a][b]= macierz[a][b];
            }
        }

         for(int i=0;i<macierz.length-1;i++) {
             for (int j = i+1; j < macierz.length; j++) {

                 for (int k = 0; k < macierz[0].length; k++) {

                     mWynik[j][k] = macierz[j][k] -macierz[i][k] *  (macierz[j][i]/macierz[i][i]);
                 }
             }
             for(int a=0;a<macierz.length;a++){
                 for(int b=0;b<macierz[0].length;b++){
                     macierz[a][b]= mWynik[a][b];
                 }
             }
         }

        double[][] macierz_zwykla = new double[macierz.length][macierz[0].length-1];
        double[] wektor = new double[macierz.length];

        for(int a=0;a<macierz.length;a++){   //macierz
            for(int b=0;b<macierz[0].length-1;b++){
               macierz_zwykla[a][b]= macierz[a][b];
            }
        }
        for(int a=0;a<macierz.length;a++){ //wektor
            for(int b=macierz[0].length-1;b<macierz[0].length;b++){
                wektor[a]= macierz[a][b];
            }
        }
        double[] WynikKoncowy = new double[macierz.length];
        for (int i = macierz.length - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < macierz.length; j++) {
                sum += macierz_zwykla[i][j] * WynikKoncowy[j];
            }
            WynikKoncowy[i] = (wektor[i] - sum) / macierz_zwykla[i][i];
        }

        for (int i=0;i<WynikKoncowy.length;i++){
            System.out.println(WynikKoncowy[i]);
        }







    }


}

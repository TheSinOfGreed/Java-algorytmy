package test;

public class UkladRownan {


    public static void MetodaIteracjiProstych(double[][] macierz,int W, int K, double epsillon){

        int iteracje = 0;
        boolean warunek = true;

        for(int i=0;i<W;i++){
            double nn = macierz[i][i];
            for(int j=0;j<K;j++){
                macierz[i][j] =macierz[i][j] / nn  ;
            }
        }

        double[] wyniki = new double[W];
        double[] nPlusJeden = new double[W];
        boolean[] tablicaBolean = new boolean[W];
        for(int i=0;i<W;i++){
            for(int j=0;j<K-1;j++){

                if(i != j) {
                    macierz[i][j] *= -1;
                }
            }
        }

        do{

            for(int i=0;i<W;i++){
                tablicaBolean[i] = true;
                for(int j=0;j<K;j++){
                    if(j == K-1) {
                        wyniki[i] += macierz[i][j];
                    }
                    else if (i != j) {
                            wyniki[i] += macierz[i][j] * nPlusJeden[j];
                    }
                }
                if(Math.abs(wyniki[i] - nPlusJeden[i]) < epsillon){
                    tablicaBolean[i] = false;
                }
            }
            for(int i=0;i<W;i++){
                //System.out.println(nPlusJeden[i]);
                nPlusJeden[i] = wyniki[i];
                wyniki[i] = 0;

            }
            iteracje++;
            for(int i=0;i<W;i++){
                if(tablicaBolean[i] == true){
                    warunek=true;
                    break;
                }
                warunek=false;
            }
        }while(warunek);

        for(int i=0;i<W;i++){
            System.out.println(nPlusJeden[i] );
        }
        System.out.println("Liczba iteracji: "+(iteracje));
    }


}

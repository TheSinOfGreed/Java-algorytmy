package test;

public class Aproksymacja {

    public static void aproksymacjaMetodaNajmniejszychKwadratow(int n, int m, double[] tablicaX, double[] tablicaY, double x){
        //n - liczba punktow =4
        //m - stopien aproksymujacy = 2
        double[][] tablica = new double[n][n+m+2];
        int licznik = 0;  // bo i+j nie dziala
        int licznik2 = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n+m+2;j++){
                if( j < n+1) {
                    tablica[i][j] = Math.pow(tablicaX[i],licznik++);
                }else{
                    tablica[i][j] = Math.pow(tablicaX[i],licznik2++) * tablicaY[i];
                }
            }
            licznik=0;
            licznik2=0;
        }
        double[] tablicaDoSumy = new double[n+m+2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n+m+2;j++){
                tablicaDoSumy[j] += tablica[i][j];
            }
        }
//        for(int i=0;i<tablicaDoSumy.length;i++){
//            System.out.println(tablicaDoSumy[i]);
//        }
//
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n+m+2;j++){
//
//                System.out.print("["+tablica[i][j]+"]");
//            }
//            System.out.println();
//        }
        int licznik3=0;
        int licznik4=n+1;
        double[][] tablica2 = new double[m+1][m+2];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<m+2;j++){
                if(j!=m+1){
                    //System.out.println(licznik3);
                    tablica2[i][j]= tablicaDoSumy[licznik3++];
                }else{
                    //System.out.println(licznik4);
                    tablica2[i][j] = tablicaDoSumy[licznik4++];
                }
            }
            licznik3 -=m;
        }
//        for(int i=0;i<m+1;i++){
//            for(int j=0;j<m+2;j++){
//
//                System.out.print("["+tablica2[i][j]+"]");
//            }
//            System.out.println();
//        }
        double[] WynikKoncowy = Gauss.Gauss(tablica2);
        double sum =0;
        for(int i=0;i< WynikKoncowy.length;i++){
            sum += Math.pow(x,i) * WynikKoncowy[i];
        }

        System.out.println(sum);






    }
}

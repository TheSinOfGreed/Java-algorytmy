package test;


import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Statyczne.Bezieur(Statyczne.wczytaj("czajnik.txt"),3,3,"plik.txt");
        Statyczne.Bezieur(Statyczne.wczytaj("filizanka.txt"),3,3,"plik2.txt");
        Statyczne.Bezieur(Statyczne.wczytaj("lyzka.txt"),3,3,"plik3.txt");




//        double Px =0;
//        double Py=0;
//        double Pz=0;
//
//
//        for(int i =0;i<16;i++){
//            for(double v=0.0;v<=1.0;v=v+0.001){
//                for(double w=0.0;w<=1.0;w=w+0.001){
//
//                    Px += tablica[i][0] * Statyczne.DwumianNewtona(3,i);
//
//
//
//
//
//                }
//            }}


        
    }
}

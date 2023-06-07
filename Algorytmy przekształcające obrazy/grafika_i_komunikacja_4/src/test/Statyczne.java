package test;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Statyczne {

    public static int DwumianNewtona(int n, int k) {

        if (k != 0)
            return silnia(n) / (silnia(k) * silnia(n - k));
        else {
            return 1;
        }
    }
    public static int silnia(int x){
        if(x<1){
            return 1;
        }
        else{
            return x * silnia(x-1);
        }
    }

    public static void Bezieur(LinkedList<Punkt[][]> tablica , int m , int n ,String nazwaPliku){


        try {

            Writer zapis = new FileWriter(nazwaPliku);
            zapis.write("x,y,z"+ System.lineSeparator());

            double Tx = 0;
            double Ty = 0;
            double Tz = 0;


            for (int abc = 0; abc < tablica.size(); abc++) {
                for (double v = 0.0; v <= 1.0; v = v + 0.01) {
                    for (double w = 0.0; w <= 1.0; w = w + 0.01) {
                        for (int i = 0; i <= m; i++) {
                            for (int j = 0; j <= n; j++) {

                                Tx += Statyczne.DwumianNewtona(m, i) * Math.pow(v, i) * Math.pow(1 - v, m - i) * Statyczne.DwumianNewtona(n, j) * Math.pow(w, j) * Math.pow(1 - w, n - j) * tablica.get(abc)[i][j].x;
                                Ty += Statyczne.DwumianNewtona(m, i) * Math.pow(v, i) * Math.pow(1 - v, m - i) * Statyczne.DwumianNewtona(n, j) * Math.pow(w, j) * Math.pow(1 - w, n - j) * tablica.get(abc)[i][j].y;
                                Tz += Statyczne.DwumianNewtona(m, i) * Math.pow(v, i) * Math.pow(1 - v, m - i) * Statyczne.DwumianNewtona(n, j) * Math.pow(w, j) * Math.pow(1 - w, n - j) * tablica.get(abc)[i][j].z;
                            }
                        }

                        zapis.write(Tx+","+Ty+","+Tz+System.lineSeparator());

                        Tx = 0;
                        Ty = 0;
                        Tz = 0;
                    }
                }

            }
            zapis.close();
        }catch(Exception e){};
    }

    static public LinkedList<Punkt[][]> wczytaj(String nazwa_pliku) throws FileNotFoundException {

        Scanner input = new Scanner(new File(nazwa_pliku));
        input.useDelimiter(" |"+System.lineSeparator());
        LinkedList<Punkt[][]> macierz_pktow = new LinkedList<>();

        while(input.hasNextLine()){
            macierz_pktow.add(new Punkt[4][4]);
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    macierz_pktow.getLast()[i][j] = new Punkt(Double.parseDouble(input.next()), Double.parseDouble(input.next()),Double.parseDouble(input.next()) );

                }
            }
        }

        return macierz_pktow;
    }




}

package pl.Laboratorium1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Graf graf = new Graf(0,0);

        try {
            String str = "", pom = "";
            String[] d = new String[3];
            d[0] = "";
            d[1] = "";
            d[2] = "";
            int i = 0;
            int ilosc_wierzcholkow;
            int startowy_wierzcholek;
            int j = 0;
            File file = new File("plik.txt");

            Scanner in = new Scanner(file);
            str = in.nextLine();

            while (str.charAt(i) != ' ') {
                pom += str.charAt(i);
                i++;
            }
            ilosc_wierzcholkow   = zamiana.zamiana_na_int(pom); //wczytuje ilosc wierzcholkow

            pom = "";
            for (i++; i < str.length(); i++) {//wierzcholek poczatkowy
                pom += str.charAt(i);
            }
            startowy_wierzcholek = zamiana.zamiana_na_int(pom);
            Graf g = new Graf(ilosc_wierzcholkow, startowy_wierzcholek);
            // srodkowa czesc z nazwami
            str = in.nextLine();
            g.ustawWierzcholek(new Wierzcholek(0,str, null), 0);
            for(i = 1; i < ilosc_wierzcholkow; i++) {
                str = in.nextLine();
                g.ustawWierzcholek(new Wierzcholek(i,str, g.wexWierzcholek(i-1)), i);
            }

            // ostatnie czesc
            while(in.hasNextLine()) {
                str = in.nextLine();
                for(i = 0; i < str.length(); i++) {
                    if(str.charAt(i) == ' ') j++;
                    else d[j] = d[j] + str.charAt(i);
                }
                g.wexWierzcholek(zamiana.zamiana_na_int(d[0])).add_krawendz(new Krawedz( g.wexWierzcholek(zamiana.zamiana_na_int(d[1])),zamiana.zamiana_na_int(d[2]), zamiana.zamiana_na_int(d[1])));
                d[0] = "";
                d[1] = "";
                d[2] = "";
                j = 0;

            }
            graf = g;

            Dikstra.najkrotsza_droga(graf);
        } catch ( ArrayIndexOutOfBoundsException e) {
            System.out.println("Nieprawidlowe dane: "+e);;
        }

        







    }
}

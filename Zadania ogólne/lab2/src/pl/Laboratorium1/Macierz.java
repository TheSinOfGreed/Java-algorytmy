package pl.Laboratorium1;

import java.sql.SQLOutput;
import java.util.Random;

public class Macierz {


    private int ilosc_kolumn;
    private int ilosc_wierszy;
    private int[][] tablica;

    public Macierz(int ilosc_kolumn, int ilosc_wierszy) {

            this.ilosc_wierszy=ilosc_wierszy;
            this.ilosc_kolumn=ilosc_kolumn;

            if(ilosc_kolumn > 0 && ilosc_wierszy > 0 ) {
                tablica = new int[ilosc_wierszy][ilosc_kolumn];
                for (int i = 0; i < ilosc_wierszy; i++)
                    for (int j = 0; j < ilosc_kolumn; j++)
                        tablica[i][j] = (int) (Math.random() * 9);
            }
            else
            {
                this.ilosc_wierszy=1;
                this.ilosc_kolumn=1;
                tablica = new int[this.ilosc_wierszy][this.ilosc_kolumn];

                for (int i = 0; i < 1; i++)
                    for (int j = 0; j < 1; j++)

                        tablica[i][j] = (int) (Math.random() * 9);
            }
    }



    @Override
    public String toString() {
        String obiekt_klasy_string = new String();
        for(int i=0;i<ilosc_wierszy;i++)
        {
            for(int j=0;j<ilosc_kolumn;j++)
            {
                obiekt_klasy_string +=tablica[j][i];
                obiekt_klasy_string +=" ";
            }
            obiekt_klasy_string +=System.lineSeparator();

        }
        return obiekt_klasy_string;
    }



    public void setIlosc_kolumn(int ilosc_kolumn) {
        this.ilosc_kolumn = ilosc_kolumn;
    }

    public void setIlosc_wierszy(int ilosc_wierszy) {
        this.ilosc_wierszy = ilosc_wierszy;
    }

    public void setTablica(int[][] tablica) {
        this.tablica = tablica;
    }

    public int[][] getTablica() {
        return tablica;
    }

    public int getIlosc_kolumn() {return ilosc_kolumn;}
    public int getIlosc_wierszy() {return ilosc_wierszy;}


    public boolean Dodaj(Macierz m)
    {

        if(this.ilosc_kolumn == m.ilosc_kolumn && this.ilosc_wierszy == m.ilosc_wierszy)
        {
            for(int i =0;i<ilosc_wierszy;i++) {
                for (int j = 0; j < ilosc_kolumn; j++)
                {
                    this.tablica[i][j] += m.tablica[i][j];
                }

            }
            return true;
        }
        else{
            return false;
        }
    }
    public boolean Odejmij(Macierz m)
    {
        if(this.ilosc_kolumn == m.ilosc_kolumn && this.ilosc_wierszy == m.ilosc_wierszy)
        {
            for(int i =0;i<ilosc_wierszy;i++) {
                for (int j = 0; j < ilosc_kolumn; j++)
                {
                    this.tablica[i][j] -= m.tablica[i][j];
                }

            }
            return true;
        }
        else{
            return false;
        }
    }
    public void Pomnoz(int n)
    {
        for(int i =0;i<ilosc_wierszy;i++) {
            for (int j = 0; j < ilosc_kolumn; j++)
            {
                this.tablica[i][j] *= n;
            }

        }
    }

    public boolean Pomnoz(Macierz m)    // macierz pierwsza z ,,lewej strony", macierz druga z "prawej"
    {
        if(this.ilosc_kolumn !=m.ilosc_wierszy){return false;}
        Macierz wynik = new Macierz(m.ilosc_kolumn,this.ilosc_wierszy);
        for(int i=0;i< wynik.ilosc_wierszy;i++)
        {
            for(int j=0;j< wynik.ilosc_kolumn;j++)
            {
                wynik.tablica[i][j]=0;
                for(int k=0;k<this.ilosc_kolumn;k++)
                {
                    wynik.tablica[i][j]+=this.tablica[i][k]* m.tablica[k][j];
                }
                System.out.print("["+wynik.tablica[i][j]+"]");
            }
            System.out.println();
        }
        return true;
    }
    public void Transponuj() {
        Macierz A = new Macierz(ilosc_wierszy, ilosc_kolumn);
        for (int i = 0; i < ilosc_wierszy; i++) {
            for (int j = 0; j < ilosc_kolumn; j++){
                A.tablica[j][i] = this.tablica[i][j];}
        }

        System.out.println(A);
    }

    public int ObliczWyznacznik(int[][] tablica, int stopien)
    {
        if(this.ilosc_kolumn != this.ilosc_wierszy) throw new IllegalArgumentException("Liczba kolumn i wierszy nie jest równa!");
        int[][] macierz_uzup;
        int wynik=0;
        if(stopien ==1)                 // przypadek podstawowy
            return tablica[0][0];
        else{
            macierz_uzup= new int[stopien-1][stopien-1];
            for(int i=0;i<stopien;i++) {
                for (int j = 0; j < stopien-1; j++) {
                    for (int k = 0; k < stopien-1; k++) {
                        macierz_uzup[j][k] = tablica[j + 1][k < i ? k : k + 1];
                    }
                }
                if (i % 2 == 0){
                    wynik +=tablica[0][i]*ObliczWyznacznik(macierz_uzup,stopien-1);
                }else{
                    wynik -=tablica[0][i]*ObliczWyznacznik(macierz_uzup,stopien-1);
                }
            }
            return wynik;
        }

    }
}





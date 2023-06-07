package pl.Laboratorium1;

import java.util.LinkedList;
import java.util.List;

public class Graf {

    Wierzcholek[] lista_wierzcholkow_graf;
    int wierzcholek_startowy;
    int ile;

    public Graf( int ile,int wierzcholek_startowy) {

        this.wierzcholek_startowy = wierzcholek_startowy;
        this.ile = ile;
        this.lista_wierzcholkow_graf=new Wierzcholek[ile];
    }
    public void ustawWierzcholek(Wierzcholek w,int a)
    {
        lista_wierzcholkow_graf[a]=w;
    }
    public Wierzcholek wexWierzcholek(int a)
    {
        return this.lista_wierzcholkow_graf[a];
    }
    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < this.lista_wierzcholkow_graf.length; i++) s += i + " " +this.lista_wierzcholkow_graf[i] + "\n";
        return s;
    }
    static String wyswietlNazweMiejscowosci(Graf a,int numerid)
    {
        for(int h=0;h<a.lista_wierzcholkow_graf.length;h++)
        {
            if(a.lista_wierzcholkow_graf[h].index_w == numerid)
                return a.lista_wierzcholkow_graf[h].nazwa_w;
        }
        return "brak";
    }

    public Wierzcholek[] getLista_wierzcholkow_graf() {
        return lista_wierzcholkow_graf;
    }

    public int getWierzcholek_startowy() {
        return wierzcholek_startowy;
    }

    public int getIle() {
        return ile;
    }

    public void setLista_wierzcholkow_graf(Wierzcholek[] lista_wierzcholkow_graf) {
        this.lista_wierzcholkow_graf = lista_wierzcholkow_graf;
    }

    public void setWierzcholek_startowy(int wierzcholek_startowy) {
        this.wierzcholek_startowy = wierzcholek_startowy;
    }

    public void setIle(int ile) {
        this.ile = ile;
    }
}

package pl.Laboratorium1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Wierzcholek {
    int index_w;
    String nazwa_w;
    Wierzcholek poprzednik;
    ArrayList<Krawedz> lista_k;

    public Wierzcholek(int index_w,String nazwa_w, Wierzcholek poprzednik) {
        this.index_w=index_w;
        this.nazwa_w = nazwa_w;
        this.poprzednik = poprzednik;
        this.lista_k=new ArrayList<>();
    }

    public void add_krawendz(Krawedz krawedz)
    {
        this.lista_k.add(krawedz);
    }
    public Krawedz getKrawendz(int a)
    {
        return lista_k.get(a);
    }
    public void SetKrawedz(Krawedz k,int a)
    {
        this.lista_k.set(a,k);
    }

    @Override
    public String toString()
    {
        return nazwa_w;
    }

    public int getIndex_w() {
        return index_w;
    }

    public String getNazwa_w() {
        return nazwa_w;
    }

    public Wierzcholek getPoprzednik() {
        return poprzednik;
    }

    public ArrayList<Krawedz> getLista_k() {
        return lista_k;
    }

    public void setIndex_w(int index_w) {
        this.index_w = index_w;
    }

    public void setNazwa_w(String nazwa_w) {
        this.nazwa_w = nazwa_w;
    }

    public void setPoprzednik(Wierzcholek poprzednik) {
        this.poprzednik = poprzednik;
    }

    public void setLista_k(ArrayList<Krawedz> lista_k) {
        this.lista_k = lista_k;
    }
}

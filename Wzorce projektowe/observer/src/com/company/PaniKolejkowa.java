package com.company;

import java.util.Observable;
import java.util.Observer;

public class PaniKolejkowa implements Observer {
    String imie;
    String nazwisko;


    public PaniKolejkowa(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;

    }

    @Override
    public String toString() {
        return "PaniKolejkowa{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }

    public void KupujIleSieDa(Sklep sklep){
        System.out.println("Pani"+ imie +" "+nazwisko + " wykupuje " + sklep);
    }

    @Override
    public void update(Observable o, Object arg) {
        KupujIleSieDa((Sklep) o);
    }

}

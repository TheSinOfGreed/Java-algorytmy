package com.company;

public class Main {

    public static void main(String[] args) {
	Sklep sklep1 = new Sklep("lewiatan");
    Sklep sklep2 = new Sklep("biedronka");
    Sklep sklep3 = new Sklep("archelan");

    PaniKolejkowa pani1= new PaniKolejkowa("Iza","Kowalska");
    PaniKolejkowa pani2= new PaniKolejkowa("Anna","Nowak");
    PaniKolejkowa pani3= new PaniKolejkowa("Aldona","Wisniewska");
    PaniKolejkowa pani4= new PaniKolejkowa("Elżbieta","Roszkowska");
    PaniKolejkowa pani5= new PaniKolejkowa("Ewelina","Zabielska");

    sklep1.addObserver(pani1);
    sklep1.addObserver(pani2);
    sklep1.addObserver(pani3);
    sklep1.addObserver(pani4);

    sklep2.addObserver(pani5);
    sklep2.addObserver(pani4);

    sklep3.addObserver(pani1);

        sklep1.rzuciliTowar("jajka");
        sklep2.rzuciliTowar("mięso");
        sklep3.rzuciliTowar("mleko");

    sklep1.setChanged();
    sklep2.setChanged();
    sklep3.setChanged();
    sklep1.notifyObservers();
    sklep2.notifyObservers();
    sklep3.notifyObservers();


    }
}

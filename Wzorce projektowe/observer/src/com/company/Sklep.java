package com.company;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Sklep extends Observable {
    String nazwa;



    public Sklep(String nazwa) {
        this.nazwa = nazwa;
    }

    public void rzuciliTowar(String nazwaTowaru){
        System.out.println("Rzucono dostawe "+ nazwaTowaru +" do MDK. Tłumy szaleją");
    }

    @Override
    public String toString() {
        return nazwa + " ";
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }
}

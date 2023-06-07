package pl.Laboratorium1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        Punkt punkt1=new Punkt(0.0,0.0);    //p1 lewy dolny
//        Punkt punkt2=new Punkt(6.0,0.0);       //p2 prawy dolny
//        Punkt punkt3=new Punkt(6.0,2.0);        //prawy gorny
//        Punkt punkt4=new Punkt(0.0,2.0);    //lewy gorny

        ArrayList<Figura>lista1 = new ArrayList<Figura>();
        lista1.add(new Trojkat(new Punkt(0.0,0.0),new Punkt(6.0,0.0),new Punkt(6.0,2.0)));
        lista1.add(new Prostokat(new Punkt(0.0,0.0),new Punkt(6.0,0.0),new Punkt(6.0,2.0),new Punkt(0.0,2.0)));
        lista1.add(new Kolo(new Punkt(0.0,0.0),6));

        System.out.println(lista1.get(0).toString());
        System.out.println(lista1.get(0).getObwod());
        System.out.println(lista1.get(0).getPole());

        System.out.println(lista1.get(1).toString());
        System.out.println(lista1.get(1).getObwod());
        System.out.println(lista1.get(1).getPole());

        System.out.println(lista1.get(2).toString());
        System.out.println(lista1.get(2).getObwod());
        System.out.println(lista1.get(2).getPole());







    }
}

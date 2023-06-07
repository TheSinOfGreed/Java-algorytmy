package com.company;

public class Sklep {
    public String nazwa;
    private static Sklep instance = new Sklep();
    StanSklep stan = new StanOtwarty();


    private Sklep() {
        System.out.println("Utworzono sklep");
    }



    public static Sklep getInstance() {
        if (instance == null)
            instance = new Sklep();
        return instance;
    }

    @Override
    public String toString() {
        return "Sklep{" +
                "nazwa='" + nazwa + '\'' +
                '}';
    }

    public void kupuj(){
        stan.kupuj();
    }

    public void zamknij(){stan=new StanZamkniety();}
    public void otworz(){stan= new StanOtwarty();}
    public void remontuj(){stan = new StanRemont();}
}

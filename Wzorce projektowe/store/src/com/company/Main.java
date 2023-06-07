package com.company;

public class Main {

    public static void main(String[] args) {
       Sklep sk = Sklep.getInstance();
       sk.kupuj();
       sk.zamknij();
       sk.kupuj();
       sk.remontuj();
       sk.kupuj();
       sk.otworz();
       sk.kupuj();

//       sk.nazwa="biedronka";
//       System.out.println(sk);

    }
}

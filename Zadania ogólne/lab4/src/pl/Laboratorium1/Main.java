package pl.Laboratorium1;

public class Main {

    public static void main(String[] args) {
        try {
//        LiczbyWymierne liczba1 = new LiczbyWymierne(1,2);
//        LiczbyWymierne liczba2 = new LiczbyWymierne(-2,4);
//        LiczbyWymierne liczba3 = new LiczbyWymierne(3,4);
//        LiczbyWymierne liczba4 = new LiczbyWymierne(5,6);
//
//
//        System.out.println(liczba1.dodaj(liczba2).podziel(liczba3.odejmij(liczba4)));

        LiczbyWymierne liczba5 = new LiczbyWymierne(-3,2);
        LiczbyWymierne liczba6 = new LiczbyWymierne(2,7);
        LiczbyWymierne liczba7 = new LiczbyWymierne(3,5);
        LiczbyWymierne liczba8 = new LiczbyWymierne(4,3);


        System.out.println(liczba5.dodaj(liczba6).podziel(liczba7.pomnoz(liczba8)));

            LiczbyWymierne liczba1 = new LiczbyWymierne(0,-2);
            LiczbyWymierne liczba2 = new LiczbyWymierne(-2,7);
            LiczbyWymierne liczba3 = new LiczbyWymierne(3,-7);
            LiczbyWymierne liczba4 = new LiczbyWymierne(20,3);

            System.out.println(liczba3);

//            LiczbyWymierne liczba1 = new LiczbyWymierne(7,1);
//            LiczbyWymierne liczba2 = new LiczbyWymierne(1,2);
//            LiczbyWymierne liczba3 = new LiczbyWymierne(10,2);
//            LiczbyWymierne liczba4 = new LiczbyWymierne(5,1);
//
//
//
//            int a = 7;
//            float b=7.0f;
//            float c=5/10;
//            double d =0.5d;
//            double e=5.0d;
//            System.out.println(liczba1.equals(a));
//            System.out.println(liczba1.equals(b));
//            System.out.println(liczba2.equals(c));
//            System.out.println(liczba2.equals(d));
//            System.out.println(liczba3.equals(e));
//            System.out.println(liczba3.equals(liczba4));



        }
        catch(Exception e){
            System.out.println(e);
        }


    }
}

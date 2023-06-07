package test;

public class Main {

    public static void main(String[] args) {

//        double[] tablicaX = {1,2,3,4};
//        double[] tablicaY = {6,19,40,69};
        double[] tablicaX2 = {-1,-0.5,0,0.5,1};
        double[] tablicaY2 = {2,1.3228756555322954,1,1.3228756555322954,2};
//	    Aproksymacja.aproksymacjaMetodaNajmniejszychKwadratow(4,2,tablicaX,tablicaY,2.5);
//        Aproksymacja.aproksymacjaMetodaNajmniejszychKwadratow(4,2,tablicaX,tablicaY,2.0);
        Aproksymacja.aproksymacjaMetodaNajmniejszychKwadratow(5,7,tablicaX2,tablicaY2,0.25);
    }
}

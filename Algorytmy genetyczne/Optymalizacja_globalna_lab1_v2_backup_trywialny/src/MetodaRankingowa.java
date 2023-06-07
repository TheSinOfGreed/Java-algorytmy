import java.util.*;

public class MetodaRankingowa {

    Osobnik[] wynik;

    public MetodaRankingowa(Osobnik[] osobniki, int n, boolean czyMin) {

        for(int i =0; i < n; i++){
            System.out.println(osobniki[i].toString());
        }

        if(czyMin){
            Arrays.sort(osobniki, Comparator.comparing(Osobnik::getWartosc));
        }else{
            Arrays.sort(osobniki, Comparator.comparing(Osobnik::getWartosc).reversed());
        }
        System.out.println("[PO SORTOWANIU]");

        for(int i =0; i < n; i++){
            System.out.println(osobniki[i].toString());
        }

        System.out.println("[LOSOWANIE]");
        int wylosowanaLiczba;
        wynik = new Osobnik[n];
        for(int i =0; i < n; i++){
            wylosowanaLiczba = Losuj(Losuj(n));
            System.out.println(wylosowanaLiczba);
            wynik[i] = osobniki[wylosowanaLiczba - 1];
            wynik[i].setIndex(wylosowanaLiczba);
        }

        System.out.println("[WYNIK KONCOWY]");
        for(int i =0; i < n; i++){
            System.out.println(wynik[i].toString() + " "+ wynik[i].getIndex());
        }
    }

    public Osobnik[] getWynik() {
        return wynik;
    }

    public int Losuj(int max) {
        Random random = new Random();
        return random.nextInt(max - 1 + 1) + 1;
    }
}


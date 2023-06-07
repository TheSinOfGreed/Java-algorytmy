import java.util.Random;

public class MetodaRuletki {

    Osobnik[] wynik;

    public MetodaRuletki(Osobnik[] osobniki, int n, boolean czyMin) {

        double funkcjaCalkowitegoDopasowania = 0;

        for(int i =0; i < n; i++){
            funkcjaCalkowitegoDopasowania += osobniki[i].wartosc;
            osobniki[i].setIndex(i+1);
            System.out.println(osobniki[i].toString() + " "+ osobniki[i].getIndex());
        }
        System.out.println("Funkcja calkowitego dopasowanie: "+ funkcjaCalkowitegoDopasowania);
        System.out.println("*PRAWDOPODOBIENSTWO*");

        if(czyMin) {
            for (int i = 0; i < n; i++) {
                osobniki[i].setPrawdopodobienstwo((1-(osobniki[i].getWartosc() / funkcjaCalkowitegoDopasowania))/(n-1));
                System.out.println(osobniki[i].getPrawdopodobienstwo());
            }
        }else{
            for (int i = 0; i < n; i++) {
                osobniki[i].setPrawdopodobienstwo(osobniki[i].getWartosc() / funkcjaCalkowitegoDopasowania);
                System.out.println(osobniki[i].getPrawdopodobienstwo());
            }
        }
        double pomocniczyKwartyl=0;
        System.out.println("*KWARTYLE*");
        for(int i =0; i < n; i++){
            pomocniczyKwartyl += osobniki[i].getPrawdopodobienstwo();
            osobniki[i].setKwartyl(pomocniczyKwartyl);
            System.out.println(osobniki[i].getKwartyl());
        }

        wynik = new Osobnik[n];
        System.out.println("-------------------------------------------------------");
        for(int i =0; i < n; i++){
            double wylosowanaLiczba = Losuj();
            System.out.println("WYLOSOWANA LICZBA "+ wylosowanaLiczba);
            if(wylosowanaLiczba <= osobniki[0].getKwartyl()){
                wynik[i] = osobniki[0];
                System.out.println((0+1) + " "+ wynik[i] + " DLA "+ wylosowanaLiczba + "<=" + osobniki[0].getKwartyl());
            }else {
                for (int j = 0; j < n-1; j++) {
                    if( osobniki[j].getKwartyl() < wylosowanaLiczba && wylosowanaLiczba <= osobniki[j+1].getKwartyl()){
                        wynik[i] = osobniki[j+1];
                        System.out.println((j+2) + " "+ wynik[i] + " Dla " + osobniki[j].getKwartyl() +"(q"+(j+1) +")<"+ wylosowanaLiczba +"<="+osobniki[j+1].getKwartyl()+"(q"+(j+2)+")");
                        break;
                    }
                }
            }
        }
    }

    public Osobnik[] getWynik() {
        return wynik;
    }

    public double Losuj() {
        Random random = new Random();
        return random.nextDouble(1.0 - 0.0 + 0.0) + 0.0;
    }
}

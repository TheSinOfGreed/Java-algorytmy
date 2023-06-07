import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Inwersja {
    Osobnik[] wynik;
    Osobnik[] zmienioneOsobniki; //NEW
    public Inwersja(Osobnik[] osobniki, int n) {

        List<Osobnik> zmienioneOsobnikiList = new ArrayList<>();//NEW
        double prawdopodobienstwoMutacji =  0.05;

        System.out.println("*PRZED*");
        for(int i =0; i < n; i++){
            System.out.println(osobniki[i].wartoscLancuch);
        }
        System.out.println("*LOSOWANIE*");
        for(int i =0; i < n; i++){
            double wylosowanaLiczba = Losuj();
            if(wylosowanaLiczba < prawdopodobienstwoMutacji){

                ArrayList<Integer> listZNumerami = new ArrayList<Integer>();
                for (int j=1; j<osobniki[i].wartoscLancuch.length()+1; j++){ listZNumerami.add(j);}
                Collections.shuffle(listZNumerami);
                int liczbaPierwsza = 0;
                int liczbaDruga = 0;

                if(listZNumerami.get(0) < listZNumerami.get(1)){
                    liczbaPierwsza = listZNumerami.get(0);
                    liczbaDruga = listZNumerami.get(1);
                }else{
                    liczbaPierwsza = listZNumerami.get(1);
                    liczbaDruga = listZNumerami.get(0);
                }


                String wycinekStringa = osobniki[i].wartoscLancuch.substring(liczbaPierwsza-1, liczbaDruga-1);
                String wycinekStringaReverse = new StringBuilder(wycinekStringa).reverse().toString();
                System.out.print(osobniki[i].wartoscLancuch+" Zamiana z przedzialu["+(liczbaPierwsza-1)+":"+(liczbaDruga-1)+"] "+ wycinekStringa + " "+wycinekStringaReverse+ " na ");

                StringBuffer buf = new StringBuffer(osobniki[i].wartoscLancuch);
                osobniki[i].wartoscLancuch = buf.replace(liczbaPierwsza-1, liczbaDruga-1, wycinekStringaReverse).toString();
                zmienioneOsobnikiList.add(osobniki[i]); // NEW
                System.out.println(osobniki[i].wartoscLancuch);

            }else{
                System.out.println(osobniki[i].wartoscLancuch);
            }
        }

        wynik = new Osobnik[n];
        for(int i =0; i < n; i++){
            wynik[i] = new Osobnik(0.0, osobniki[i].wartoscLancuch);
            wynik[i].setIndex(osobniki[i].getIndex());
        }

        //NEW
        zmienioneOsobniki = new Osobnik[zmienioneOsobnikiList.size()];
        for(int i =0; i < zmienioneOsobnikiList.size(); i++){
            zmienioneOsobniki[i] = zmienioneOsobnikiList.get(i);
        }
    }

    public Osobnik[] getWynik() {
        return wynik;
    }

    public Osobnik[] getZmienioneOsobniki() {
        return zmienioneOsobniki;
    }

    public double Losuj() {
        Random random = new Random();
        return random.nextDouble(1.0 - 0.0 + 0.0) + 0.0;
    }
    public int LosujInt(int max) {
        Random random = new Random();
        return random.nextInt(max - 0 + 0) + 0;
    }
}

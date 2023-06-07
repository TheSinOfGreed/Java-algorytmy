import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mutacja {

    Osobnik[] wynik;
    Osobnik[] zmienioneOsobniki; //NEW
    public Mutacja(Osobnik[] osobniki, int n) {
        List<Osobnik> zmienioneOsobnikiList = new ArrayList<>(); //new
        double prawdopodobienstwoMutacji =  0.05;

        //System.out.println("*PRZED*");
        for(int i =0; i < n; i++){
            //System.out.println(osobniki[i].wartoscLancuch + " " + osobniki[i].getIndex());
        }
        //System.out.println("*WYLOSOWANE*");
        for(int i =0; i < n; i++){
            char[] charArray = osobniki[i].wartoscLancuch.toCharArray();
            boolean czyZmienionyOsobnik = false; //NEW
            for(int j=0; j < charArray.length; j++){
                double wylosowanaLiczba = Losuj();

                if(wylosowanaLiczba < prawdopodobienstwoMutacji){
                    czyZmienionyOsobnik = true;
                    //System.out.print(" ("+ (Math.round(wylosowanaLiczba * 100.0) / 100.0) + ") ");
                    if(charArray[j] == '0'){
                        charArray[j] = '1';
                    }else{
                        charArray[j] = '0';
                    }
                }else{
                    //System.out.print(" "+ (Math.round(wylosowanaLiczba * 100.0) / 100.0) + " ");
                }
            }
            osobniki[i].wartoscLancuch = new String(charArray);
            if(czyZmienionyOsobnik){ //NEW
                zmienioneOsobnikiList.add(osobniki[i]);
            }
            //System.out.println();
        }
        //System.out.println("*PO*");
        for(int i =0; i < n; i++){
            //System.out.println(osobniki[i].wartoscLancuch + " " + osobniki[i].getIndex());
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
}

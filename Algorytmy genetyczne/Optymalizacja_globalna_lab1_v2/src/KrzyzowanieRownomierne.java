import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class KrzyzowanieRownomierne {

    public KrzyzowanieRownomierne(Osobnik[] osobniki, int n) {

        int m = osobniki[0].wartoscLancuch.length(); // dlugos lancucha
        double Pk = 0.5;
        List<Osobnik> podPopulacja = new ArrayList<>();

        for(int i =0; i < n; i++){
            double r = Losuj();
            if( r < Pk ){
                //System.out.println("Wybrano " + (i+1) + " poniewaz r=" + r );
                osobniki[i].setIndex(i+1);
                podPopulacja.add(osobniki[i]);
            }else{
                //System.out.println("Niewybrano "+ (i+1) + " poniewaz r=" + r);
            }
        }

        //System.out.println();

        if(podPopulacja.size() % 2 != 0){
            int indexDoUsuniecia = LosujInt(podPopulacja.size());
            //System.out.println("Wybrana liczba osobnikow nieparzysta, usuwam: " + podPopulacja.get(indexDoUsuniecia).getIndex());
            podPopulacja.remove(indexDoUsuniecia);
        }

        //System.out.println();

        Collections.shuffle(podPopulacja); // Tworzymy pary losowe
        List<ParaOsobnikow> paryOsobnikow = new ArrayList<>();
        //DODANIE WSZYSTKIEGO DO KLASY PARAOSOBNIKOW
        for(int i =0 ; i < podPopulacja.size() ; i+=2){
            //System.out.println("Rodzic 1: [" +  podPopulacja.get(i).getIndex() + "] " + podPopulacja.get(i).toString() + " Rodzic 2: ["+podPopulacja.get(i+1).getIndex() + "] " + podPopulacja.get(i+1).toString() );
            paryOsobnikow.add(new ParaOsobnikow(podPopulacja.get(i), podPopulacja.get(i+1)));
        }

        for(int i =0 ; i < paryOsobnikow.size() ; i++){
            Integer[] wzorzec = new Integer[m];
            for(int j = 0; j < m ; j++){
                wzorzec[j] = Math.toIntExact(Math.round(Math.random()));
            }
            //System.out.println("Para nr " + (i+1));
            //System.out.println("["+paryOsobnikow.get(i).rodzic1.index + "] " + paryOsobnikow.get(i).rodzic1.wartoscLancuch);
            //System.out.println("["+paryOsobnikow.get(i).rodzic2.index + "] " + paryOsobnikow.get(i).rodzic2.wartoscLancuch);
            //System.out.println("Wzorzec");
            for(int j = 0; j < m ; j++){
                //System.out.print(wzorzec[j]);
            }
            //System.out.println();
            Integer[] pierwszyLancuch = new Integer[m];
            Integer[] drugiLancuch = new Integer[m];
            String potomek1 = "";
            String potomek2 = "";

            for (int j = 0; j < m; j++) {
                pierwszyLancuch[j] = Character.getNumericValue(paryOsobnikow.get(i).rodzic1.wartoscLancuch.charAt(j));
                drugiLancuch[j] = Character.getNumericValue(paryOsobnikow.get(i).rodzic2.wartoscLancuch.charAt(j));
            }
            //System.out.println();
            //Pierwszy Potomek
            for (int j = 0; j < m; j++) {
                if(wzorzec[j] == 0){
                    potomek1 += pierwszyLancuch[j];
                }else{
                    potomek1 += drugiLancuch[j];
                }
            }
            //Drugi Potomek
            for (int j = 0; j < m; j++) {
                if(wzorzec[j] == 0){
                    potomek2 += drugiLancuch[j];
                }else{
                    potomek2 += pierwszyLancuch[j];
                }
            }
            //System.out.println("Potomek 1 " + potomek1);
            //System.out.println("Potomek 2 " + potomek2);
            //System.out.println("-----------------------------");
        }

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

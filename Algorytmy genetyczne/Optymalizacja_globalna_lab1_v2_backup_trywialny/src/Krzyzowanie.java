import java.util.*;
import java.util.stream.Collectors;

public class Krzyzowanie {
    List<Osobnik> wynik;
    Osobnik[] wynikJakoArray;



    public Krzyzowanie(Osobnik[] osobniki, int n, int liczbaPunktow) {

        wynik = new ArrayList<Osobnik>();
        wynikJakoArray = new Osobnik[n];

        for(int i =0; i < n; i++){
            osobniki[i].setPoczatkowaPozycja(i);
            System.out.println(osobniki[i].toString() + " "+ osobniki[i].getIndex());
        }

        int m = osobniki[0].wartoscLancuch.length(); // dlugos lancucha
        double Pk = 0.5;
        List<Osobnik> podPopulacja = new ArrayList<>();

        for(int i =0; i < n; i++){
            double r = Losuj();
            if( r < Pk ){
                System.out.println("Wybrano " + osobniki[i].getIndex() + " poniewaz r=" + r );
//                osobniki[i].setIndex(i+1);
                podPopulacja.add(osobniki[i]);
            }else{
                System.out.println("Niewybrano "+ osobniki[i].getIndex() + " poniewaz r=" + r);
                wynik.add(osobniki[i]);
            }
        }

        System.out.println();

        if(podPopulacja.size() % 2 != 0){
            int indexDoUsuniecia = LosujInt(podPopulacja.size());
            System.out.println("Wybrana liczba osobnikow nieparzysta, usuwam: " + podPopulacja.get(indexDoUsuniecia).getIndex());
            wynik.add(podPopulacja.get(indexDoUsuniecia));
            podPopulacja.remove(indexDoUsuniecia);
        }

        System.out.println();

        Collections.shuffle(podPopulacja); // Tworzymy pary losowe
        List<ParaOsobnikow> paryOsobnikow = new ArrayList<>();
        //DODANIE WSZYSTKIEGO DO KLASY PARAOSOBNIKOW
        for(int i =0 ; i < podPopulacja.size() ; i+=2){
            System.out.println("Rodzic 1: [" +  podPopulacja.get(i).getIndex() + "] " + podPopulacja.get(i).toString() + " Rodzic 2: ["+podPopulacja.get(i+1).getIndex() + "] " + podPopulacja.get(i+1).toString() );
            paryOsobnikow.add(new ParaOsobnikow(podPopulacja.get(i), podPopulacja.get(i+1)));
        }

        System.out.println();
        Random rng = new Random();


        for(int i =0 ; i < paryOsobnikow.size() ; i++){
            //PUNKTY LOSOWANIE
            List<Integer> punkty = rng.ints(0, m).distinct().limit(LosujInt(m/3)).boxed().collect(Collectors.toList());
            Collections.sort(punkty);
            for(int index = 0; index < punkty.size(); index++){
                System.out.print(punkty.get(index) + " ");
            }
            System.out.println();

            //Wypisanie przed:
            System.out.println("PRZED " + paryOsobnikow.get(i).rodzic1.wartoscLancuch + " " + paryOsobnikow.get(i).rodzic2.wartoscLancuch);

            for(int j=0; j<punkty.size(); j+=2){
                if(punkty.size() % 2 != 0){//nieparzysta liczba punktow

                    if(j == punkty.size() - 1){
                        //Wycinki substring
                        String wycinekRodzicOne = paryOsobnikow.get(i).rodzic1.wartoscLancuch.substring(punkty.get(j), m);
                        String wycinekRodzicTwo = paryOsobnikow.get(i).rodzic2.wartoscLancuch.substring(punkty.get(j), m);
                        //Bufer
                        StringBuffer buffer1 = new StringBuffer(paryOsobnikow.get(i).rodzic1.wartoscLancuch);
                        StringBuffer buffer2 = new StringBuffer(paryOsobnikow.get(i).rodzic2.wartoscLancuch);
                        //Replace
                        paryOsobnikow.get(i).rodzic1.wartoscLancuch = buffer1.replace(punkty.get(j), m, wycinekRodzicTwo).toString();
                        paryOsobnikow.get(i).rodzic2.wartoscLancuch = buffer2.replace(punkty.get(j), m, wycinekRodzicOne).toString();
                    }else{
                        //Wycinki substring
                        String wycinekRodzicOne = paryOsobnikow.get(i).rodzic1.wartoscLancuch.substring(punkty.get(j), punkty.get(j+1));
                        String wycinekRodzicTwo = paryOsobnikow.get(i).rodzic2.wartoscLancuch.substring(punkty.get(j), punkty.get(j+1));
                        //Bufer
                        StringBuffer buffer1 = new StringBuffer(paryOsobnikow.get(i).rodzic1.wartoscLancuch);
                        StringBuffer buffer2 = new StringBuffer(paryOsobnikow.get(i).rodzic2.wartoscLancuch);
                        //Replace
                        paryOsobnikow.get(i).rodzic1.wartoscLancuch = buffer1.replace(punkty.get(j), punkty.get(j+1), wycinekRodzicTwo).toString();
                        paryOsobnikow.get(i).rodzic2.wartoscLancuch = buffer2.replace(punkty.get(j), punkty.get(j+1), wycinekRodzicOne).toString();
                    }

                }else{//parzysta liczba punktow

                    //Wycinki substring
                    String wycinekRodzicOne = paryOsobnikow.get(i).rodzic1.wartoscLancuch.substring(punkty.get(j), punkty.get(j+1));
                    String wycinekRodzicTwo = paryOsobnikow.get(i).rodzic2.wartoscLancuch.substring(punkty.get(j), punkty.get(j+1));
                    //Bufer
                    StringBuffer buffer1 = new StringBuffer(paryOsobnikow.get(i).rodzic1.wartoscLancuch);
                    StringBuffer buffer2 = new StringBuffer(paryOsobnikow.get(i).rodzic2.wartoscLancuch);
                    //Replace
                    paryOsobnikow.get(i).rodzic1.wartoscLancuch = buffer1.replace(punkty.get(j), punkty.get(j+1), wycinekRodzicTwo).toString();
                    paryOsobnikow.get(i).rodzic2.wartoscLancuch = buffer2.replace(punkty.get(j), punkty.get(j+1), wycinekRodzicOne).toString();
                }
            }
            //Wypisanie po:
            System.out.println("PO    " + paryOsobnikow.get(i).rodzic1.wartoscLancuch  +" " + paryOsobnikow.get(i).rodzic2.wartoscLancuch);
            wynik.add(paryOsobnikow.get(i).rodzic1);
            wynik.add(paryOsobnikow.get(i).rodzic2);
            System.out.println();
        }


        for(int i =0; i < n; i++){
            wynikJakoArray[i] = wynik.get(i);
        }
        Arrays.sort(wynikJakoArray, Comparator.comparing(Osobnik::getPoczatkowaPozycja) );
        for(int i =0; i < n; i++){
            System.out.println(wynikJakoArray[i] );
        }
    }

    public Osobnik[] getWynikJakoArray() {
        return wynikJakoArray;
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

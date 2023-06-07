import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Wymiar[] input_wymiary = {new Wymiar(-1,1), new Wymiar(-1,1), new Wymiar(-1,1), new Wymiar(-1,1), new Wymiar(-1,1)};
        List<Integer> listaM = new ArrayList<>();
        double[] d = { 6, 6, 6, 6, 6};
        double ilosc_kombinacji;
        int[] m_list = new int[input_wymiary.length];

        int n = 5;
        String[] lancuchy_znakow = new String[n];
        for(int i=0; i< n ;i ++){lancuchy_znakow[i] = "";}
        double[][] macierz_calosciowa = new double[n][input_wymiary.length];

        //OBLICZANIE M-----------------------------------------------------------------
        for(int i=0;i<input_wymiary.length;i++){
            ilosc_kombinacji = (input_wymiary[i].b - input_wymiary[i].a) * Math.pow(10,d[i]) + 1;
            int m = 0; //nasz zmienna m tzn dlugosc łancucha binarnego
            while(true){
                if((Math.pow(2,m-1) <= ilosc_kombinacji) && (ilosc_kombinacji <= Math.pow(2,m))){
                    m_list[i] = m;
                    listaM.add(m);
                    break;
                }
                m++;
            }
            int[][] populacja = new int[n][m_list[i]];

            //nadawanie wartosci dla skrawka
            for(int iter =0;iter<n;iter++){
                for(int j=0;j<m_list[i];j++){
                    populacja[iter][j] = (int) Math.round( Math.random() );
                }
            }
            //zamiana na dziesietne
            String pomocniczyString;
            int[] populacja_dziesietny = new int[n];

            for(int iter =0;iter <n;iter ++){
                pomocniczyString = "";
                for(int j=0;j<m_list[i];j++){
                    pomocniczyString += populacja[iter][j];
                }
                lancuchy_znakow[iter] += pomocniczyString;//DODANE POZNIEJ
                populacja_dziesietny[iter] = Integer.parseInt(pomocniczyString, 2);
            }

            //przesuniecie do przedzialu
            for(int iter =0;iter<n;iter++){
                macierz_calosciowa[iter][i] = (input_wymiary[i].a + (((input_wymiary[i].b-input_wymiary[i].a) * populacja_dziesietny[iter]) / (Math.pow(2,m_list[i]) -1)));
//                System.out.println(macierz_calosciowa[iter][i]);
            }
        }

        double[] wynik_z_Rastrigin = new double[n];

        for(int i=0;i<n;i++){
            wynik_z_Rastrigin[i] = 10 * input_wymiary.length;
            for(int j=0;j<input_wymiary.length; j++){
                wynik_z_Rastrigin[i] += Math.pow(macierz_calosciowa[i][j], 2) - 10 * Math.cos(20 * 3.14159265358979323846 * macierz_calosciowa[i][j]);
            }
        }

////        WYPISANIE
        for(int i=0;i<n;i++){
            System.out.println("F(..) = "+wynik_z_Rastrigin[i] + " Lancuch znakow:"+lancuchy_znakow[i]);
        }


////    OSOBNIKI POGRUPOWANE DO METOD
        Osobnik[] osobniki = new Osobnik[n];

        for(int i =0; i < n; i++){
            osobniki[i] = new Osobnik(wynik_z_Rastrigin[i], lancuchy_znakow[i]);
//            System.out.println(osobniki[i].toString());
        }
////    METODY LAB3
//        MetodaTurniejowa metoda1 = new MetodaTurniejowa(osobniki, n, false, 2, true);
//        MetodaRankingowa metoda2 = new MetodaRankingowa(osobniki, n, false);
//        MetodaRuletki metoda3 = new MetodaRuletki(osobniki, n, false);

////    METODY LAB4
//        Mutacja metoda4 = new Mutacja(osobniki, n);
//        Inwersja metoda5 = new Inwersja(osobniki, n);


////    METODY LAB5
//        Krzyzowanie metoda6 = new Krzyzowanie(osobniki, n, 4);
//        KrzyzowanieRownomierne metoda7 = new KrzyzowanieRownomierne(osobniki, n);

////    METODY LAB6
////    TRYWIALNA:
//        Osobnik[] osobnikDoPetli = osobniki;
//        for(int index = 0; index < 10; index++){
//            SukcesjaTrywialna sukcesja = new SukcesjaTrywialna(osobnikDoPetli, n, 1, input_wymiary, d, listaM);
//            osobnikDoPetli = sukcesja.getENDosobnik();
//        }

////    Z CZĘŚCIOWYM ZASTĘPOWANIEM
        Osobnik[] osobnikDoPetli = osobniki;
        for(int index = 0; index < 100; index++){
            SukcesjaCzescioweZastepowanie sukcesja = new SukcesjaCzescioweZastepowanie(osobnikDoPetli, n, 1, input_wymiary, d, listaM);
            osobnikDoPetli = sukcesja.getENDosobnik();
        }
    }
}
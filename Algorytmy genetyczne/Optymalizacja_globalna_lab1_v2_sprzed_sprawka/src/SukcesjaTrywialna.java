import java.util.List;

public class SukcesjaTrywialna {
    Osobnik[] ENDosobnik;
    public SukcesjaTrywialna(Osobnik[] osobniki, int n, int epoki, Wymiar[] input_wymiary, double[] d, List<Integer> listaM) {

        System.out.println("NOWA EPOKA-----------------------------------------------------------------------------------");
            //--SELEKCJA--
          System.out.println("SELEKCJA: ");
//        MetodaTurniejowa selekcja = new MetodaTurniejowa(osobniki, n, false, 2, true);
        MetodaRankingowa selekcja = new MetodaRankingowa(osobniki, n, false);
         // MetodaRuletki selekcja = new MetodaRuletki(osobniki, n, false);

          Osobnik[] osobnikiPoSelekcji = selekcja.getWynik();
          //NAPRAWIENIE BŁĘDU ODWOŁYWANIA SIĘ
          Osobnik[] osobnikiPoSelekcjiNaprawione = new Osobnik[n];
          for(int i=0; i<n ;i++){
              osobnikiPoSelekcjiNaprawione[i] = new Osobnik(0.0, osobnikiPoSelekcji[i].wartoscLancuch);//PO SELEKCJI
              osobnikiPoSelekcjiNaprawione[i].setIndex(osobnikiPoSelekcji[i].getIndex());
          }
          System.out.println();

            //--OPERATORY GENETYCZNE--
          System.out.println("OPERATORY GENETYCZNE: ");
          System.out.println("1. Mutacja");
          Mutacja operatoryGenetyczne = new Mutacja(osobnikiPoSelekcjiNaprawione, n);
          Osobnik[] osobnikiPoMutacji = operatoryGenetyczne.getWynik(); // PO MUTACJI

          System.out.println("2. Inwersja");
          Inwersja operatoryGenetyczne2 = new Inwersja(osobnikiPoMutacji, n);
          Osobnik[] osobnikiPoInwersji = operatoryGenetyczne2.getWynik(); //PO INWERSJI

          System.out.println("3. Krzyzowanie");
          Krzyzowanie operatoryGenetyczne3 = new Krzyzowanie(osobnikiPoInwersji, n, 2);
          Osobnik[] osobnikiPoKrzyzowaniu = operatoryGenetyczne3.getWynikJakoArray(); // PO KRZYŻOWANIU

          System.out.println("OCENA I SELEKCJA: ");
          double[][] macierz_calosciowa = new double[n][input_wymiary.length];
          int[] populacja_dziesietny = new int[input_wymiary.length];
          for(int i=0; i<n ;i++) {
              int poczatek = 0;
              int koniec = listaM.get(0);
              String[] tabelaZStringam = new String[input_wymiary.length];
              for (int j = 0; j < input_wymiary.length; j++) {
                  tabelaZStringam[j] = osobnikiPoKrzyzowaniu[i].wartoscLancuch.substring(poczatek , koniec);
                  poczatek = koniec;
                  if(j != input_wymiary.length - 1) {
                      koniec += listaM.get(j + 1);
                  }
//                  System.out.println(tabelaZStringam[j]);
                  populacja_dziesietny[j] = Integer.parseInt(tabelaZStringam[j], 2);
                  macierz_calosciowa[i][j] = (input_wymiary[j].a + (((input_wymiary[j].b-input_wymiary[j].a) * populacja_dziesietny[j]) / (Math.pow(2,listaM.get(j)) -1)));
//                  System.out.println(macierz_calosciowa[i][j]);
              }
          }
          double[] wynik_z_Rastrigin = new double[n];
          for(int i=0;i<n;i++){
            wynik_z_Rastrigin[i] = 10 * input_wymiary.length;
            for(int j=0;j<input_wymiary.length; j++){
                wynik_z_Rastrigin[i] += Math.pow(macierz_calosciowa[i][j], 2) - 10 * Math.cos(20 * 3.14159265358979323846 * macierz_calosciowa[i][j]);
            }
          }
        for(int i=0;i<n;i++){
         System.out.print(wynik_z_Rastrigin[i] + ", " );
        }
        System.out.println();

        ENDosobnik = new Osobnik[n];
        for(int i =0; i < n; i++){
            ENDosobnik[i] = new Osobnik(wynik_z_Rastrigin[i], osobnikiPoKrzyzowaniu[i].wartoscLancuch);
        }
    }

    public Osobnik[] getENDosobnik() {
        return ENDosobnik;
    }
}

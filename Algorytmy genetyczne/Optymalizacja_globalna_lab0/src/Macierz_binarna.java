import java.util.Arrays;

public class Macierz_binarna {
    int wiersze;
    int kolumny;
    int[][] macierz;
    String pomocniczyString;
    int[] dziesietne_array;
    double a,b;
    double liczba;

    public Macierz_binarna(int wiersze, int kolumny) {
        this.wiersze = wiersze;
        this.kolumny = kolumny;
        macierz = new int[wiersze][kolumny];
        pomocniczyString = "";
        dziesietne_array = new int[wiersze];
        a = -1;
        b = 1;

        for(int i =0;i<wiersze;i++){
            for(int j=0;j<kolumny;j++){
                macierz[i][j] = (int) Math.round( Math.random() );
            }
        }

        for(int i =0;i<wiersze;i++){
            pomocniczyString = "";
            for(int j=0;j<kolumny;j++){
                pomocniczyString += macierz[i][j];
            }
            dziesietne_array[i] = Integer.parseInt(pomocniczyString, 2);
//            System.out.println(dziesietne_array[i]);
        }

        for(int i =0;i<wiersze;i++){
            liczba = (a + (((b-a) * dziesietne_array[i]) / (Math.pow(2,kolumny) -1)));
            System.out.println(liczba);
        }
    }

    public void wypisz_macierz(){
        for(int i =0;i<wiersze;i++){
            for(int j=0;j<kolumny;j++){
                System.out.print(macierz[i][j]);
            }
            System.out.println();
        }
    }
}

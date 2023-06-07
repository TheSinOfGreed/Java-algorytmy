package pl.Laboratorium1;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;
public class Main {

    public static void main(String[] args) {


        zad3("kajak");

    }

    public static void zad4()
    {
        Random losuj = new Random();
        List<Punkt> tablicaPunktow = new ArrayList<>();
        int i;

        for(i=0; i <10; i++)
        {
            tablicaPunktow.add(new Punkt(losuj.nextDouble()*20, losuj.nextDouble()*20));
        }
        for(i=0;i<10;i++)
        {
            System.out.println("\n");
            int nr = i+1;
            System.out.print("Suma wspolrzednych punktu nr["+nr+"] to: ");
            System.out.println(tablicaPunktow.get(i).sumaWspolrzednych());


            System.out.print("Odległość punktu nr["+nr+"] od środka to: ");
            System.out.println(Math.round(((tablicaPunktow.get(i).odlegloscOdSrodka())*1000.0)) / 1000.0);


            int nr2=nr+1;




                System.out.print(("odleglosc punktu nr.[10] od punktu nr.[1] to: "));
                System.out.println(Math.round(((tablicaPunktow.get(i).odlegloscOdPktu(tablicaPunktow.get((i+1)%tablicaPunktow.size()))))*1000.0)/1000.0);



            System.out.println("\n");
        }
        
    }

    public static void zad1()
    {
        Scanner skaner = new Scanner(System.in);

        System.out.println("podaj liczbe wierszy");
        double wiersze=skaner.nextDouble();

        System.out.println("podaj liczbe kolumn");
        double kolumny=skaner.nextDouble();

        double[][] tablica = new double[(int) wiersze][(int) kolumny];
        Random losowanie = new Random();
        double najwieksza_wartosc = 0;
        double suma_z_wierszy = 0;
        for(int i=0; i< wiersze; i++)
        {
            System.out.print("[");
            for(int j=0;j< kolumny;j++)
            {
                tablica[i][j] =losowanie.nextDouble()*10;
                System.out.print(tablica[i][j] + " | ");

                if(tablica[i][j] > najwieksza_wartosc)
                {
                    najwieksza_wartosc= tablica[i][j];
                }
            }
            System.out.println("]");
        }
        for(int i=0; i< wiersze; i++)
        {
            for(int j=0;j< kolumny;j++)
            {
                suma_z_wierszy+=tablica[i][j];
            }
            System.out.println("średnia z wiersza nr("+i+")" +suma_z_wierszy/kolumny);
            suma_z_wierszy=0;


        }

        System.out.println("najwieksza wartosc to: "+najwieksza_wartosc);



    }
    public static boolean zad2(String slowo_1,String slowo_2)
    {
        String slowo1 = new String(slowo_1);
        String slowo2 = new String(slowo_2);

        char[] array= slowo1.toCharArray();
        char[] array2= slowo2.toCharArray();
        boolean status = true;
        if(slowo1.length() != slowo2.length())
        {
            status=false;
        }
        else
        {
            Arrays.sort(array);
            Arrays.sort(array2);
            status = Arrays.equals(array, array2);
        }

       return status;

    }

    public static void zad3(String slowo)
    {
        int dlugoscWyrazu = slowo.length();
        boolean czyPalindrom = true;
        int slowoOdKonca = (dlugoscWyrazu-1);
        for(int i=0;i<dlugoscWyrazu/2;i++)
        {
            if(slowo.charAt(i) != slowo.charAt(slowoOdKonca))
            {
                czyPalindrom=false;
                break;
            }
            slowoOdKonca--;
        }


        if (!czyPalindrom)
            System.out.println("Nie jest palindromem");
        else {
            System.out.println("Jest palindromem");
        }

    }

}

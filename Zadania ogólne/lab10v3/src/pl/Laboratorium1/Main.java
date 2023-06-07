package pl.Laboratorium1;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        LinkedList<Data> zadanie = new LinkedList<>();
        LinkedList<Data> ram = new LinkedList<Data>();
        LinkedList<Data> odczyt = new LinkedList<>();
        LinkedList<Data> poOdczycie = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        Statyczne.wielkoscPr = 0;

        while (true) {
            System.out.println("Podaj przedział w postaci yyyy-MM-dd_HH:mm:ss");
            String time_simple_date_format = input.next();

            System.out.println("Podaj koniec przedzialu w postaci yyyy-MM-dd_HH:mm:ss");
            String time_simple_date_format2 = input.next();
            System.out.println("Otrzymano zadanie odczytu z przedzialu: " + time_simple_date_format + " - " + time_simple_date_format2);

            try {
                Zawansowane.DodajPrzedzial(zadanie, poOdczycie, odczyt, time_simple_date_format, time_simple_date_format2);
            }
            catch(NumberFormatException e)
            {
                System.out.println("Błąd!");
                if(!poOdczycie.isEmpty())
                {
                    System.out.println("W pamieci trzymane sa teraz przedzialy:");
                    for (Data s : poOdczycie) {
                        System.out.println(s);
                    }
                }
                continue;

            }

            if (zadanie.size() > 1) {
                Zawansowane.wyznaczCzWspolne(zadanie,poOdczycie,ram);

                if(ram.size()==1)
                {
                    Zawansowane.jednaCzesWspolna(zadanie,poOdczycie,ram,odczyt);
                    Zawansowane.sumowaniePrzedzialow(poOdczycie,odczyt);
                }
                if(ram.size()>1)
                {
                    Zawansowane.wieleCzescciWspolnych(zadanie,poOdczycie,ram,odczyt);
                    Zawansowane.sumowaniePrzedzialow(poOdczycie,odczyt);
                }
                Zawansowane.czyOddzielne(zadanie,poOdczycie,ram,odczyt);
            }
            for(int i = 0;i<poOdczycie.size();i++)
            {
                Statyczne.scal(poOdczycie);
            }
            for (Data a : odczyt) {
                System.out.println("Czytanie z dysku plikow z przedzialu:" + a);

            }
            for (Data a : ram) {
                System.out.println("Wykorzystanie wczytanego przedzialu:" + a);

            }
            System.out.println("W pamieci trzymane sa teraz przedzialy:");
            for (Data a : poOdczycie) {
                System.out.println(a);
            }
            odczyt.clear();
            ram.clear();
            Statyczne.wielkoscPr += 1;
            Statyczne.czyszczeniePamieci(zadanie,poOdczycie,ram,odczyt);
    }
}}
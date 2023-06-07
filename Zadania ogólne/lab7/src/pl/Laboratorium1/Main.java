package pl.Laboratorium1;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IllegalArgumentException, FileNotFoundException {

        Sito_Erastotenesa.policzSito(200);
        System.out.println("--------------");
        Scanner skaner = new Scanner(new File("baza.txt"));
        skaner.useDelimiter("\\r?\\n");
        while(skaner.hasNext()) {
            try {
                String a = skaner.nextLine();
                String[] abc = a.split(" ");
                //Notacja_polska str = new Notacja_polska();
                double wynik = Notacja_polska.stos(abc);
                System.out.println(wynik);
            }catch (IllegalArgumentException e)
            {
                System.out.println("Błąd!"+e);
            }
        }







    }


}
























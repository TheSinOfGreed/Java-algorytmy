package pl.Laboratorium1;

import java.text.ParseException;
import java.util.Collections;
import java.util.LinkedList;

public class Statyczne {

    static public void czyszczeniePamieci(LinkedList<Data> zadanie, LinkedList<Data> poOdczycie, LinkedList<Data> ram, LinkedList<Data> odczyt)
    {
        if(Statyczne.wielkoscPr%15==0) {
            System.out.println("Pamięć została wyczyszczona!");
            zadanie.clear();
            poOdczycie.clear();
            ram.clear();
            odczyt.clear();
        }

    }
    static public Data pobierzRAM(Data a,Data b) throws ParseException {
        if(b.poczatek.isAfter(a.poczatek)&&b.koniec.isBefore(a.koniec))
            return new Data(b.time_simple_date_format,b.time_simple_date_format2);
        //new1
        if(a.poczatek.isAfter(b.poczatek)&&a.koniec.isBefore(b.koniec))
            return new Data(a.time_simple_date_format,a.time_simple_date_format2);
        //new2
        if(a.poczatek.equals(b.poczatek)&&a.koniec.equals(b.koniec))
            return new Data(a.time_simple_date_format,a.time_simple_date_format2);
        if(b.poczatek.isBefore(a.poczatek)&&b.koniec.isAfter(a.poczatek)&&b.koniec.isBefore(a.koniec))
            return new Data(a.time_simple_date_format,b.time_simple_date_format2);
        //new3
        if(b.poczatek.isAfter(a.poczatek)&&b.poczatek.isBefore(a.koniec)&&b.koniec.isAfter(a.koniec))
            return new Data(b.time_simple_date_format,a.time_simple_date_format2);
        //new4
        if(a.poczatek.equals(b.poczatek)&&a.koniec.isAfter(b.koniec))
            return new Data(b.time_simple_date_format,b.time_simple_date_format2);
        if(a.koniec.equals(b.koniec)&&a.poczatek.isBefore(b.poczatek) )
            return new Data(b.time_simple_date_format,b.time_simple_date_format2);
        //new 5
        if(a.poczatek.equals(b.poczatek)&&a.koniec.isBefore(b.koniec))
            return new Data(a.time_simple_date_format,a.time_simple_date_format2);
        if(a.koniec.equals(b.koniec)&&a.poczatek.isAfter(b.poczatek))
            return new Data(a.time_simple_date_format,b.time_simple_date_format2);


        else
            throw new ArithmeticException();
    }
    public  static Data pobierzOdczyt(Data first, Data second)
    {
        //new2
        if(first.poczatek.equals(second.poczatek)&&first.koniec.isBefore(second.koniec))
            return new Data(first.time_simple_date_format2,second.time_simple_date_format2);
        if(first.koniec.equals(second.koniec)&&second.poczatek.isBefore(first.poczatek))
            return new Data(second.time_simple_date_format,first.time_simple_date_format);
        //new2
        if(second.poczatek.isBefore(first.poczatek)&&second.koniec.isAfter(first.poczatek)&&second.koniec.isBefore(first.koniec))
            return new Data(second.time_simple_date_format,first.time_simple_date_format);
        if(second.poczatek.isAfter(first.poczatek)&&second.poczatek.isBefore(first.koniec)&&second.koniec.isAfter(first.koniec))
            return  new Data(first.time_simple_date_format2,second.time_simple_date_format2);
        else
            throw new ArithmeticException("rererere");

    }
    public static int konsola(Data first ,Data second)
    {
        if(second.poczatek.isAfter(first.poczatek)&&second.poczatek.isBefore(first.koniec)&&second.koniec.isAfter(first.koniec))
            return 1;
        if(second.poczatek.isBefore(first.poczatek)&&second.koniec.isAfter(first.poczatek)&&second.koniec.isBefore(first.koniec))
            return 2;
        //new1
        if(first.poczatek.equals(second.poczatek)&&first.koniec.equals(second.koniec))
            return 3;
        if(second.poczatek.isAfter(first.poczatek)&&second.koniec.isBefore(first.koniec))
            return 5;
        //new3
        if(second.koniec.equals(first.koniec)&&second.poczatek.isAfter(first.poczatek))
            return 6;
        if(second.poczatek.equals(first.poczatek)&&second.koniec.isBefore(first.koniec))
            return 7;
        //new2
        if(first.poczatek.equals(second.poczatek)&&first.koniec.isBefore(second.koniec))
            return 8;
        if(first.koniec.equals(second.koniec)&&second.poczatek.isBefore(first.poczatek))
            return 9;

        return 4;
    }
    public static Data pobierzOdczytPomiedzy(Data a , Data b)
    {
        return new Data(a.time_simple_date_format2,b.time_simple_date_format);
    }
    public static LinkedList scal(LinkedList<Data> zadanie)
    {
        for(int j=0;j<zadanie.size()*2;j++) {
            for (int i = 0; i < zadanie.size() - 1; i++) {
                if (zadanie.get(i).koniec.equals(zadanie.get(i + 1).poczatek)) {
                    zadanie.add(new Data(zadanie.get(i).poczatek.toString(), zadanie.get(i + 1).koniec.toString()));
                    zadanie.remove(i);
                    zadanie.remove(i);
                }
                else if (zadanie.get(i).poczatek.equals(zadanie.get(i + 1).poczatek)&&zadanie.get(i).koniec.isBefore(zadanie.get(i + 1).koniec)) {
                    zadanie.add(new Data(zadanie.get(i).time_simple_date_format, zadanie.get(i + 1).time_simple_date_format2));
                    zadanie.remove(i);
                    zadanie.remove(i);
                }
            }
            Collections.sort(zadanie);
        }
        return zadanie;
    }
    static public boolean konsolatruefalse(Data a,Data b)
    {
        if(b.poczatek.isAfter(a.poczatek)&&b.poczatek.isBefore(a.koniec) ||
                a.poczatek.equals(b.poczatek)&&a.koniec.equals(b.koniec) ||
                b.poczatek.isAfter(a.poczatek)&&b.koniec.isBefore(a.koniec) ||
                a.poczatek.isAfter(b.poczatek)&&a.koniec.isBefore(b.koniec) ||
                a.poczatek.equals(b.poczatek)&&a.koniec.isAfter(b.koniec) ||
                b.poczatek.equals(a.poczatek)&&b.koniec.isAfter(a.koniec) ||
                a.koniec.equals(b.koniec)&& a.poczatek.isBefore(b.poczatek) ||
                a.koniec.equals(b.koniec)&&b.poczatek.isBefore(a.poczatek)
        ){
            return true;}
        if(a.poczatek.isAfter(b.koniec))
            return false;
        else
        if(a.poczatek.isAfter(b.poczatek)&&a.koniec.isAfter(b.koniec))
            return true;

        return false;
    }

    public  static void pobierzOdczytLewyPrawy(LinkedList<Data> zadanie, LinkedList<Data> poOdczycie, LinkedList<Data> ram,LinkedList<Data> odczyt)
    {
        for(int z=0;z<poOdczycie.size();z++)
        {
            if(Statyczne.konsola(poOdczycie.get(z),ram.getFirst())==3 && zadanie.getLast().poczatek.isBefore(ram.getFirst().poczatek))
            {
                odczyt.add(new Data(zadanie.getLast().time_simple_date_format,ram.getFirst().time_simple_date_format));
            }
            if(Statyczne.konsola(poOdczycie.get(z),ram.getLast())==3 && zadanie.getLast().koniec.isAfter(ram.getLast().koniec))
            {
                odczyt.add(new Data(ram.getLast().time_simple_date_format2,zadanie.getLast().time_simple_date_format2));
            }
        }
    }
    public static int wielkoscPr;


}

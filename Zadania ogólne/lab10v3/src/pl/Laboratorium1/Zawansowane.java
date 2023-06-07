package pl.Laboratorium1;

import java.util.Collections;
import java.util.LinkedList;

public class Zawansowane {
    public static void wyznaczCzWspolne(LinkedList<Data> zadanie, LinkedList<Data> poOdczycie, LinkedList<Data> ram) {
        for (int i = 0; i < poOdczycie.size(); i++) {
                try {
                    ram.add(Statyczne.pobierzRAM(poOdczycie.get(i), zadanie.getLast()));

                } catch (Exception e) {
                }
        }
    }
    public static void DodajPrzedzial(LinkedList<Data> zadanie, LinkedList<Data> poOdczycie, LinkedList<Data> odczyt, String s1, String s2) {
        try {
            zadanie.add(new Data(s1, s2));
            if (poOdczycie.isEmpty()) {
                poOdczycie.add(new Data(s1, s2));
                odczyt.add(new Data(s1, s2));
            }
        } catch (Exception e) {
            throw new NumberFormatException();
        }
    }
    public static void jednaCzesWspolna(LinkedList<Data> zadanie, LinkedList<Data> poOdczycie, LinkedList<Data> ram,LinkedList<Data> odczyt)
    {
        for(int i=0;i<poOdczycie.size();i++)
                    {
                        if(Statyczne.konsolatruefalse(poOdczycie.get(i),ram.get(0))) {
                            // jeden a póniej drugi poxniej
                            if (Statyczne.konsola(poOdczycie.get(i), zadanie.getLast()) == 1) {
                                try {
                                    odczyt.add(Statyczne.pobierzOdczyt(poOdczycie.get(i), zadanie.getLast()));
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            }
                            //jeden poxniej a drugi wczesniej, luknac czemu gowno nie dziala
                            if (Statyczne.konsola(poOdczycie.get(i), zadanie.getLast()) == 2) {
                                try {
                                    odczyt.add(Statyczne.pobierzOdczyt(poOdczycie.get(i), zadanie.getLast()));

                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            }
                            /////////////////////////////new2
                            ////drugie weiksze od pierwszego i z lewej
                            if (Statyczne.konsola(poOdczycie.get(i), zadanie.getLast()) == 8) {
                                try {
                                    odczyt.add(Statyczne.pobierzOdczyt(poOdczycie.get(i), zadanie.getLast()));
                                    // poOdczycie.add(odczyt.get(0));
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            }
                            ////drugie weiksze od pierwszego i z prawej
                            if (Statyczne.konsola(poOdczycie.get(i), zadanie.getLast()) == 9) {
                                try {
                                    odczyt.add(Statyczne.pobierzOdczyt(poOdczycie.get(i), zadanie.getLast()));

                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            }
                            //////////////////////////////////new2
                            /////takie samo
                            if (Statyczne.konsola(poOdczycie.get(i), zadanie.getLast()) == 3) {

                            }
                            /////////////////////////////////////luknac czemu nie działało
                            if (Statyczne.konsola(poOdczycie.get(i), zadanie.getLast()) == 4) {
                                odczyt.add(new Data(zadanie.getLast().time_simple_date_format, ram.get(0).time_simple_date_format));
                                odczyt.add(new Data(ram.get(0).time_simple_date_format2, zadanie.getLast().time_simple_date_format2));
                            }
                            ////////////////////////////////////////////////////////////////
                            if (Statyczne.konsola(poOdczycie.get(i), zadanie.getLast()) == 5) {
                            ////znajduje sie w środku
                            }
                        }
                    }
    }
    public static void sumowaniePrzedzialow(LinkedList<Data> poOdczycie, LinkedList<Data> odczyt)
    {
        for(int i = 0;i<odczyt.size();i++)
        {
            poOdczycie.add(odczyt.get(i));
        }
    }
    public static void czyOddzielne(LinkedList<Data> zadanie, LinkedList<Data> poOdczycie, LinkedList<Data> ram,LinkedList<Data> odczyt)
    {
        if(ram.isEmpty()&&odczyt.isEmpty())
        {
            odczyt.add(zadanie.getLast());
            poOdczycie.add(odczyt.get(0));
        }
    }
    public static void wieleCzescciWspolnych(LinkedList<Data> zadanie, LinkedList<Data> poOdczycie, LinkedList<Data> ram,LinkedList<Data> odczyt)
    {
        for(int i = 0;i<ram.size()-1;i++)
        {
            odczyt.add(Statyczne.pobierzOdczytPomiedzy(ram.get(i),ram.get(i+1)));//here
            if(ram.size()-1==i+1)
            { Statyczne.pobierzOdczytLewyPrawy(zadanie,poOdczycie,ram,odczyt);}
        }
        Collections.sort(odczyt);
    }






}

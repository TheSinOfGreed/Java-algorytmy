package pl.Laboratorium1;

import java.util.Iterator;
import java.util.LinkedList;


public class Sito_Erastotenesa {


    static public void policzSito(int przedzial)
    {
        LinkedList<Integer> lista = new LinkedList<>();
        LinkedList<Integer> tablica_do_liczb_p = new LinkedList<>();
        for(int i=2;i<=przedzial;i++)
        {
            lista.add(i) ;
        }
        while (!lista.isEmpty()) {
            int front = lista.remove(0);
            tablica_do_liczb_p.add(front);
            Iterator<Integer> obiekt_itr = lista.iterator();
            while (obiekt_itr.hasNext()) {
                int a = obiekt_itr.next();
                if (a % front == 0) {
                    obiekt_itr.remove();
                }
            }
        }
        for (int i = 0;i<tablica_do_liczb_p.size();i++)
        {
            System.out.println(tablica_do_liczb_p.get(i));
        }
    }

}

package pl.Laboratorium1;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Dikstra {


    public static void najkrotsza_droga(Graf g) {
        final int max = Integer.MAX_VALUE;

        int j,u,i;
        int S[]=new int[g.ile];
        int S2[]=new int[g.ile];
        int wskazniStosu=0;
        int[] d = new int[g.ile]; // tablica kosztow dojscia
        int[] p = new int[g.ile]; // tablica poprzednikow
        boolean[] QS = new boolean[g.ile]; // zbiory Q i S
        for( i = 0; i < g.ile; i++){

            d[i] = max;
            p[i] = -1;
        }
        d[g.wierzcholek_startowy] = 0;

        ArrayList<Krawedz> k;
        for(i = 0; i < g.ile; i++)
        {
            for(j = 0; QS [j]; j++);
            for(u = j++; j < g.ile-1; j++)
                if(!QS [j] && (d[j] < d[u])) u = j;

            QS [u] = true;

            k = g.wexWierzcholek(u).lista_k;
            for(int t = 0; t < k.size(); t++) {
                if (!QS[k.get(t).nr] && (d[k.get(t).nr] > d[u] + k.get(t).koszt_dotarcia)) {
                    d[k.get(t).nr] = d[u] + k.get(t).koszt_dotarcia;
                    p[k.get(t).nr] = u;
                }
            }
        }
        int h;
        for( i = 0; i < g.ile; i++ )
        {

            for( j = i; j > -1; j = p [ j ] ){
                S [ wskazniStosu ] = j;
                S2 [ wskazniStosu++ ] = j;
            }
            for(h=0;h<S2.length;h++)
            {
                if(h==0)
                    System.out.print(Graf.wyswietlNazweMiejscowosci(g,g.wierzcholek_startowy)+" -> "+Graf.wyswietlNazweMiejscowosci(g,S2[h])+": " );
            }

            while( wskazniStosu>0 ){
                if(wskazniStosu==1) {
                    System.out.print("" + Graf.wyswietlNazweMiejscowosci(g, S[--wskazniStosu])+", ");
                }
                else{
                System.out.print(""+Graf.wyswietlNazweMiejscowosci(g,S[ --wskazniStosu ])+"-" );}
            }
//            int ostatni = S[--wskazniStosu];
//            System.out.println(Graf.wyswietlNazweMiejscowosci(g,ostatni));
//            System.out.println(Graf.wyswietlNazweMiejscowosci(g,ostatni));
            // wskaznikStosu-1

            System.out.println("odleglosc: "+d[i]+"km");
            System.out.println();
        }






    }

}

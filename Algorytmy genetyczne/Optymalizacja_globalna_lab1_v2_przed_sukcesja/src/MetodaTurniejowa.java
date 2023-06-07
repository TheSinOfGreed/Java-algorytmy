import java.util.*;

public class MetodaTurniejowa {
    // wielkoscGrup = j-elementowe grupy
    Osobnik[] wynik;
    public MetodaTurniejowa(Osobnik[] osobniki, int n, boolean czyMin, int wielkoscGrup, boolean bezZwracania) {
        wynik = new Osobnik[n];

        for(int i =0; i < n; i++){
            System.out.println(osobniki[i].toString());
        }

        List<Osobnik> list = Arrays.asList(osobniki);


        System.out.println("------------------------------");
        if(bezZwracania) {
            for (int i = 0; i < n; i++) {
                Collections.shuffle(list); //MIESZA POSZCZEGOLNE LISTY
                List<Osobnik> podGrupa = list.subList(0, wielkoscGrup);
                System.out.println("Grupa "+(i+1)+"------------------------");
                for (int j = 0; j < podGrupa.size(); j++) {
                    System.out.print(" " + podGrupa.get(j).toString() + " ");
                }
                System.out.println();
                if (czyMin) {
                    wynik[i] = Collections.min(podGrupa, Comparator.comparing(Osobnik::getWartosc));
                } else {
                    wynik[i] = Collections.max(podGrupa, Comparator.comparing(Osobnik::getWartosc));
                }
            }
        }else{
            for (int i = 0; i < n; i++) {
                List<Osobnik> podGrubaZeZwracaniem = new ArrayList<>();
                System.out.println("Grupa "+(i+1)+"------------------------");
                for (int j = 0; j < wielkoscGrup; j++) {
                    podGrubaZeZwracaniem.add( osobniki[Losuj(n)-1] );
                    System.out.print(" "+podGrubaZeZwracaniem.get(podGrubaZeZwracaniem.size()-1)+ " ");
                }
                System.out.println();
                if (czyMin) {
                    wynik[i] = Collections.min(podGrubaZeZwracaniem, Comparator.comparing(Osobnik::getWartosc));
                } else {
                    wynik[i] = Collections.max(podGrubaZeZwracaniem, Comparator.comparing(Osobnik::getWartosc));
                }
            }
        }
        System.out.println("Wyniki:");
        for(int i =0; i < n; i++){
            System.out.println(wynik[i].toString());
        }

    }

    public int Losuj(int max) {
        Random random = new Random();
        return random.nextInt(max - 1 + 1) + 1;
    }
}

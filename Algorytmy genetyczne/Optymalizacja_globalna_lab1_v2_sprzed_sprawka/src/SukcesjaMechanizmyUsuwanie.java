import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SukcesjaMechanizmyUsuwanie {

    public static Osobnik[] elitarne(Osobnik[] wspolnaTablicaNieList, int n, boolean czyMin){
        if(czyMin){
            Arrays.sort(wspolnaTablicaNieList, Comparator.comparing(Osobnik::getWartosc));
        }else{
            Arrays.sort(wspolnaTablicaNieList, Comparator.comparing(Osobnik::getWartosc).reversed());
        }

        Osobnik[] doZwrocenia = new Osobnik[n];
        for(int i=0; i<n ; i++){
            doZwrocenia[i] = wspolnaTablicaNieList[i];
        }
        Arrays.sort(doZwrocenia, Comparator.comparing(Osobnik::getPoczatkowaPozycja));
        return doZwrocenia;
    }

    public static Osobnik[] zeSciskiem(Osobnik[] wspolnaTablicaNieList, int n){



        return wspolnaTablicaNieList;
    }

    public static Osobnik[] losowe(Osobnik[] wspolnaTablicaNieList, int n){
        List<Osobnik> list = Arrays.asList(wspolnaTablicaNieList);
        Collections.shuffle(list);

        Osobnik[] doZwrocenia = new Osobnik[n];
        for(int i=0; i<n ; i++){
            doZwrocenia[i] = list.get(i);
        }

        return doZwrocenia;

    }
}

package pl.Laboratorium1;



public class zamiana {
    public static int zamiana_na_int(String s) {
        int wynik = 0;
        int mnoznik = 1;
        for(int i = s.length()-1; i >= 0; i--){
            wynik += (int)(s.charAt(i) - 48) * mnoznik;
            mnoznik *= 10;
        }
        return wynik;
    }



}

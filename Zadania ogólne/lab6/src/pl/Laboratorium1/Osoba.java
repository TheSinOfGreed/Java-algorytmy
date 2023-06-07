package pl.Laboratorium1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Osoba {
    static int UNIQUE_ID = 0;
    int uid = UNIQUE_ID;
    String imie,nazwisko;

    int B_dzien,B_miesiac,B_rok;
    Calendar B_data;

    int plec_int;
    Plec plec;

    int wyksztalcenie_int;
    Wyksztalcenie wyksztalcenie;

    int stanCywilny_int;
    Stancywilny stanCywilny;

    int ilosc_dzieci;
    boolean czy_karny;

    String miejsce_pracy;
    int pensja;

    int W_dzien,W_miesiac,W_rok;
    Calendar W_data;





    public Osoba(String imie, String nazwisko, int b_dzien, int b_miesiac, int b_rok, int plec_int, int wyksztalcenie_int, int stanCywilny_int, int ilosc_dzieci, boolean czy_karny, String miejsce_pracy, int pensja, int w_dzien, int w_miesiac, int w_rok) throws ParseException {


        UNIQUE_ID+=1;
        setID();
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.B_dzien = b_dzien;
        this.B_miesiac = b_miesiac;
        this.B_rok = b_rok;
        this.plec_int = plec_int;
        this.wyksztalcenie_int = wyksztalcenie_int;
        this.stanCywilny_int = stanCywilny_int;
        this.ilosc_dzieci = ilosc_dzieci;
        this.czy_karny=czy_karny;
        this.miejsce_pracy = miejsce_pracy;
        this.pensja = pensja;
        W_dzien = w_dzien;
        W_miesiac = w_miesiac;
        W_rok = w_rok;
        this.plec =Plec.mężczyzna;
        switch (plec_int) {
            case 1:
                plec = Plec.mężczyzna;
                break;
            case 2:
                plec = Plec.kobieta;
                break;

        }
        switch (wyksztalcenie_int) {
            case 1:
                this.wyksztalcenie = Wyksztalcenie.podstawowe;
                break;
            case 2:
                this.wyksztalcenie = Wyksztalcenie.gimnazjalne;
                break;
            case 3:
                this.wyksztalcenie = Wyksztalcenie.zawodowe;
                break;
            case 4:
                this.wyksztalcenie = Wyksztalcenie.srednie;
                break;
            case 5:
                this.wyksztalcenie = Wyksztalcenie.wyzsze;
                break;
        }
        switch (stanCywilny_int) {
            case 1:
                this.stanCywilny = Stancywilny.żonaty;
                break;
            case 2:
                this.stanCywilny = Stancywilny.kawaler;
                break;
            case 3:
                this.stanCywilny = Stancywilny.zamężna;
                break;
            case 4:
                this.stanCywilny = Stancywilny.panna;
                break;

        }


        B_data = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        B_data.setTime(sdf.parse(b_dzien+"-"+b_miesiac+"-"+b_rok));

        W_data = Calendar.getInstance();
        W_data.setTime(sdf.parse(w_dzien+"-"+w_miesiac+"-"+w_rok));


    }
    public void setID()
    {this.uid=UNIQUE_ID;}


    @Override
    public String toString() {
        if(miejsce_pracy.equalsIgnoreCase("-"))
            return uid+" "+"Imie:"+imie+" "+" Nazwisko:"+nazwisko+" "+" Data urodzenia:"+B_data.get(Calendar.DAY_OF_MONTH)+"/"+(B_data.get(Calendar.MONTH)+1)+"/"+B_data.get(Calendar.YEAR) +" "+plec+" Wyksztalcenie:"+wyksztalcenie+" Stan cywilny:"+stanCywilny+" Ilosc dzieci:"+ilosc_dzieci+" Czy karany:"+czy_karny+" Miejsce pracy:"+miejsce_pracy;
        else
            return uid+" "+"Imie:"+imie+" "+" Nazwisko:"+nazwisko+" "+" Data urodzenia:"+B_data.get(Calendar.DAY_OF_MONTH)+"/"+(B_data.get(Calendar.MONTH)+1)+"/"+B_data.get(Calendar.YEAR) +" "+plec+" Wyksztalcenie:"+wyksztalcenie+" Stan cywilny:"+stanCywilny+" Ilosc dzieci:"+ilosc_dzieci+" Czy karany:"+czy_karny+" Miejsce pracy:"+miejsce_pracy+" Pensja: "+pensja+"zł Data zatrudnienia "+W_data.get(Calendar.DAY_OF_MONTH)+"/"+(W_data.get(Calendar.MONTH)+1)+"/"+W_data.get(Calendar.YEAR);
    }
}

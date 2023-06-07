package pl.Laboratorium1;


import java.io.*;
import java.nio.file.NoSuchFileException;
import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, ParseException {




        Scanner input = new Scanner(System.in);
        LinkedList<Osoba> lista = new LinkedList<>();


        Scanner s2 = new Scanner(new File("baza.txt"));
        s2.useDelimiter(";|" + System.lineSeparator());
        try {
            while (s2.hasNext()) {
                int id =s2.nextInt();
                String imie = s2.next();
                String nazwisko = s2.next();
                int dzien =s2.nextInt();
                int miesiac =s2.nextInt();
                int rok =s2.nextInt();
                int plec=s2.nextInt();
                int wyksztalcenie =s2.nextInt();
                int stanC =s2.nextInt();
                int ilosc_dzieci=s2.nextInt();
                boolean czy_karany=s2.nextBoolean();
                String miejsce_pracy=s2.next();
                int pensja=s2.nextInt();

                int Wdzien =s2.nextInt();
                int Wmiesiac =s2.nextInt();
                int Wrok =s2.nextInt();

                Osoba osoba=new Osoba(imie,nazwisko,dzien,miesiac,rok,plec,wyksztalcenie,stanC,ilosc_dzieci,czy_karany,miejsce_pracy,pensja,Wdzien,Wmiesiac,Wrok);
                lista.add(osoba);
            }
        } catch(NoSuchElementException d)
        {
            System.out.println(d);
        }








        int number = 0;
        while (number != 11) {
            System.out.println();
            System.out.println("Wybierz Operacje: ");
            System.out.println("1. Wyświetl wszystkie osoby ");
            System.out.println("2. Wyświetl osoby o podanych imieniu");
            System.out.println("3. Wyświetl osoby starsze niż podana ilość lat");
            System.out.println("4. Wyświetl osoby o podanym id");
            System.out.println("5. Edytuj osobe o podanym id");
            System.out.println("6. Usun osobe o podanym id");
            System.out.println("7. Dodaj nową osobe");
            System.out.println("8. Wyczysc liste");
            System.out.println("9. Zapisz liste do pliku");
            System.out.println("10. Wczytaj liste z pliku(resetuj)");
            System.out.println("11. Wyjdz");
            switch (number = input.nextInt()) {
                case 1 -> {
                    for(int i=0;i< lista.size();i++)
                    {
                        System.out.println(lista.get(i));
                        Osoba.UNIQUE_ID = lista.size();
                    }

                }
                case 2 -> {
                    String imie_od_uzytkownika = input.next();
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).imie.equalsIgnoreCase(imie_od_uzytkownika))
                            System.out.println(lista.get(i));
                    }
                }
                case 3 -> {

                        int liczba_lat = input.nextInt();
                        for (int i = 0; i < lista.size(); i++) {

                            Calendar dataodUzytkownika = Calendar.getInstance();
                            dataodUzytkownika.set(Calendar.YEAR, dataodUzytkownika.get(Calendar.YEAR) - liczba_lat);
                            if (dataodUzytkownika.after(lista.get(i).B_data)) {
                                System.out.println(lista.get(i));
                            }
                        }



                }
                case 4-> {
                    int id_od_uzytkownika = input.nextInt();
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).uid == id_od_uzytkownika)
                            System.out.println(lista.get(i));

                    }
                }
                case 5 -> {
                    System.out.println("Podaj id osoby ktora ma byc edytowana");
                    int id_do_edytowania = input.nextInt();
                    System.out.println("1.Imię");
                    System.out.println("2.Nazwisko");
                    System.out.println("3.Data urodzin");
                    System.out.println("4.Płeć");
                    System.out.println("5.Wyksztalcenie");
                    System.out.println("6.StanCywilny");
                    System.out.println("7.Ilosc dzieci");
                    System.out.println("8.Czy karany");
                    System.out.println("9.Miejsce pracy");
                    System.out.println("10.Pensja");
                    System.out.println("11.Data zatrudnienia");

                    int id_co_edytowac = input.nextInt();
                    switch(id_co_edytowac) {
                            case 1->
                                {
                                    System.out.println("Podaj nowe imię: ");
                                    String nowe_imie = input.next();
                                    for (int i = 0; i < lista.size(); i++) {
                                        if (lista.get(i).uid == id_do_edytowania) {
                                                        lista.get(i).imie = nowe_imie;
                                        }

                                    }
                                }
                            case 2->
                                    {
                                        System.out.println("Podaj nowe nazwisko: ");
                                        String nowe_nazwisko = input.next();
                                        for (int i = 0; i < lista.size(); i++) {
                                            if (lista.get(i).uid == id_do_edytowania) {
                                                lista.get(i).nazwisko = nowe_nazwisko;
                                            }

                                        }
                                    }
                        case 3->
                                {
                                    System.out.println("Podaj dzien: ");
                                    int nowe_dzien = input.nextInt();
                                    System.out.println("Podaj miesiac: ");
                                    int nowe_miesiac = input.nextInt();
                                    System.out.println("Podaj rok: ");
                                    int nowe_rok = input.nextInt();
                                    for (int i = 0; i < lista.size(); i++) {
                                        if (lista.get(i).uid == id_do_edytowania) {
                                            nowe_miesiac-=1;
                                            lista.get(i).B_data.set(nowe_rok,nowe_miesiac,nowe_dzien);
                                            nowe_miesiac +=1;
                                            lista.get(i).B_dzien = nowe_dzien;
                                            lista.get(i).B_miesiac = nowe_miesiac;
                                            lista.get(i).B_rok = nowe_rok;

                                        }
                                    }
                                }
                        case 4-> {

                            System.out.println("1.mężczynza");
                            System.out.println("2.kobieta");
                            try {
                                int ktora_plec = input.nextInt();

                                for (int i = 0; i < lista.size(); i++) {
                                    if (lista.get(i).uid == id_do_edytowania) {
                                        if (ktora_plec == 1) {
                                            lista.get(i).plec = Plec.mężczyzna;
                                            lista.get(i).plec_int = 1;
                                        } else if (ktora_plec == 2) {
                                            lista.get(i).plec = Plec.kobieta;
                                            lista.get(i).plec_int = 2;
                                        }
                                    }
                                }
                            }catch (IllegalArgumentException e){
                                System.out.println(e);}
                        }
                        case 5->{
                                System.out.println("1.podstawowe");
                            System.out.println("2.gimnazjalne");
                            System.out.println("3.zawodowe");
                            System.out.println("4.srednie");
                            System.out.println("5.wyzsze");
                            int ktora_w = input.nextInt();
                            for (int i = 0; i < lista.size(); i++) {
                                if (lista.get(i).uid == id_do_edytowania) {
                                    if(ktora_w==1){
                                        lista.get(i).wyksztalcenie = Wyksztalcenie.podstawowe;
                                        lista.get(i).wyksztalcenie_int=1;}
                                    else if(ktora_w==2){
                                        lista.get(i).wyksztalcenie = Wyksztalcenie.gimnazjalne;
                                        lista.get(i).wyksztalcenie_int=2;}
                                    else if(ktora_w==3){
                                        lista.get(i).wyksztalcenie = Wyksztalcenie.zawodowe;
                                        lista.get(i).wyksztalcenie_int=3;}
                                    else if(ktora_w==4){
                                        lista.get(i).wyksztalcenie = Wyksztalcenie.srednie;
                                        lista.get(i).wyksztalcenie_int=4;}
                                    else if(ktora_w==5){
                                        lista.get(i).wyksztalcenie = Wyksztalcenie.wyzsze;
                                        lista.get(i).wyksztalcenie_int=5;}
                                }
                            }
                        }
                        case 6->{
                            System.out.println("1.żonaty");
                            System.out.println("2.kawaler");
                            System.out.println("3.zamężna");
                            System.out.println("4.panna");

                            int ktora_c = input.nextInt();
                            for (int i = 0; i < lista.size(); i++) {
                                if (lista.get(i).uid == id_do_edytowania) {
                                    if(ktora_c==1){
                                        lista.get(i).stanCywilny = Stancywilny.żonaty;
                                        lista.get(i).stanCywilny_int=1;}
                                    else if(ktora_c==2){
                                        lista.get(i).stanCywilny = Stancywilny.kawaler;
                                        lista.get(i).stanCywilny_int=2;}
                                    else if(ktora_c==3){
                                        lista.get(i).stanCywilny = Stancywilny.zamężna;
                                        lista.get(i).stanCywilny_int=3;}
                                    else if(ktora_c==4){
                                        lista.get(i).stanCywilny = Stancywilny.panna;
                                         lista.get(i).stanCywilny_int=4;}

                                }
                            }
                        }
                        case 7->
                                {
                                    System.out.println("Podaj ilosc dzieci: ");
                                    int nowe_dzieci = input.nextInt();
                                    for (int i = 0; i < lista.size(); i++) {
                                        if (lista.get(i).uid == id_do_edytowania) {
                                            lista.get(i).ilosc_dzieci = nowe_dzieci;
                                        }

                                    }
                                }
                        case 8->
                                {
                                    System.out.println("1.Nie karany");
                                    System.out.println("2.karany");
                                    int nowe_k = input.nextInt();
                                    for (int i = 0; i < lista.size(); i++) {
                                        if (lista.get(i).uid == id_do_edytowania) {
                                            if(nowe_k==1)
                                                lista.get(i).czy_karny= false;
                                            else if(nowe_k==2)
                                                lista.get(i).czy_karny= true;
                                        }

                                    }
                                }
                        case 9->
                                {
                                    System.out.println("Podaj nowe miejsce pracy: ");
                                    String nowe_m = input.next();
                                    for (int i = 0; i < lista.size(); i++) {
                                        if (lista.get(i).uid == id_do_edytowania) {
                                            lista.get(i).miejsce_pracy = nowe_m;
                                        }

                                    }
                                }
                        case 10->
                                {
                                    System.out.println("Podaj pensje: ");
                                    int nowe_p = input.nextInt();
                                    for (int i = 0; i < lista.size(); i++) {
                                        if (lista.get(i).uid == id_do_edytowania) {
                                            lista.get(i).pensja = nowe_p;
                                        }

                                    }
                                }
                        case 11->
                                {
                                    System.out.println("Podaj dzien: ");
                                    int wnowe_dzien = input.nextInt();
                                    System.out.println("Podaj miesiac: ");
                                    int wnowe_miesiac = input.nextInt();
                                    System.out.println("Podaj rok: ");
                                    int wnowe_rok = input.nextInt();
                                    for (int i = 0; i < lista.size(); i++) {
                                        if (lista.get(i).uid == id_do_edytowania) {
                                            wnowe_miesiac-=1;
                                            lista.get(i).W_data.set(wnowe_rok,wnowe_miesiac,wnowe_dzien);
                                        }
                                    }

                                }
                        default -> System.out.println("Bledna komenda, sprobuj ponownie");


                    }
                }
                case 6 -> {
                    int id_do_usuneica = input.nextInt();
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).uid == id_do_usuneica) {
                            lista.remove(i);
                        }

                    }
                    for (int i = 0; i < lista.size(); i++) {
                        lista.get(i).uid=i+1;
                    }

                }
                case 7 -> {
                    System.out.println("1.Imię");
                    String imie = input.next();
                    System.out.println("2.Nazwisko");
                    String nazwisko = input.next();
                    System.out.println("3.Dzien urodzin  ");
                    int dzien = input.nextInt();
                    System.out.println("4.miesiac urodzin  ");
                    int miesiac = input.nextInt();
                    System.out.println("5.rok urodzin  ");
                    int rok = input.nextInt();
                    System.out.println("6.Płeć 1.mezczyzna 2.kobieta");
                    int stancyw3 = input.nextInt();

                    System.out.println("7.Wyksztalcenie 1.podst 2.gimnazjalne 3.zawodowe 4.srednie 5. wyzsze");
                    int stancyw2 = input.nextInt();

                    System.out.println("8.StanCywilny: 1.żonaty,2.kawaler 3.zamężna 4.panna");
                    int stancyw = input.nextInt();

                    System.out.println("9.Ilosc dzieci");
                    int dzieci = input.nextInt();
                    System.out.println("10.Czy karany true/false");
                    boolean karany = input.nextBoolean();
                    System.out.println("11.Miejsce pracy, '-' jesli brak");
                    String miejscepracy = input.next();
                    System.out.println("12.Pensja");
                    int pensja = input.nextInt();
                    System.out.println("13.Dzien zatrudnienia  ");
                    int Wdzien = input.nextInt();
                    System.out.println("14.miesiac zatrudnienia  ");
                    int Wmiesiac = input.nextInt();
                    System.out.println("15.rok zatrudnienia  ");
                    int Wrok = input.nextInt();
                    Osoba osoba = new Osoba(imie,nazwisko,dzien,miesiac,rok,stancyw3 ,stancyw2 ,stancyw ,dzieci,karany,miejscepracy,pensja,Wdzien,Wmiesiac,Wrok);
                    lista.add(osoba);
                }
                case 8 -> {
                    lista.clear();
                    Osoba.UNIQUE_ID = lista.size();
                }
                case 9->{
                    try {
                        System.out.println("podaj nazwe pliku");
                        String nazwa = input.next();
                        Writer w = new FileWriter(nazwa+".txt");

                        for(int i=0;i<lista.size();i++)
                            w.write(lista.get(i).uid+";"+lista.get(i).imie+";"+lista.get(i).nazwisko+";"+lista.get(i).B_dzien+";"+lista.get(i).B_miesiac+";"+lista.get(i).B_rok+";"+lista.get(i).plec_int+";"+lista.get(i).wyksztalcenie_int+";"+lista.get(i).stanCywilny_int+";"+lista.get(i).ilosc_dzieci+";"+lista.get(i).czy_karny+";"+lista.get(i).miejsce_pracy+";"+lista.get(i).pensja+";"+lista.get(i).W_dzien+";"+lista.get(i).W_miesiac+";"+lista.get(i).W_rok+System.lineSeparator());
                        System.out.println("Plik zapisany pomyślnie");
                        w.close();
                    } catch (IOException e) {

                        e.printStackTrace();

                    }
                }
                case 10 ->{
                    lista.clear();
                    Osoba.UNIQUE_ID = lista.size();
                    System.out.println("podaj nazwe pliku");
                    String nazwa2 = input.next();
                    try {
                        Scanner s = new Scanner(new File(nazwa2 + ".txt"));
                        s.useDelimiter(";|" + System.lineSeparator());



                            while (s.hasNext()) {
                                int id = s.nextInt();
                                String imie = s.next();
                                String nazwisko = s.next();
                                int dzien = s.nextInt();
                                int miesiac = s.nextInt();
                                int rok = s.nextInt();
                                int plec = s.nextInt();
                                int wyksztalcenie = s.nextInt();
                                int stanC = s.nextInt();
                                int ilosc_dzieci = s.nextInt();
                                boolean czy_karany = s.nextBoolean();
                                String miejsce_pracy = s.next();
                                int pensja = s.nextInt();

                                int Wdzien = s.nextInt();
                                int Wmiesiac = s.nextInt();
                                int Wrok = s.nextInt();

                                Osoba osoba = new Osoba(imie, nazwisko, dzien, miesiac, rok, plec, wyksztalcenie, stanC, ilosc_dzieci, czy_karany, miejsce_pracy, pensja, Wdzien, Wmiesiac, Wrok);
                                lista.add(osoba);
                                //System.out.println(id+" "+imie + " " + nazwisko+" "+dzien+" "+miesiac+" "+rok+" "+plec+" "+wyksztalcenie+" "+stanC+" "+ilosc_dzieci+" "+czy_karany);
                            }
                        } catch (FileNotFoundException d) {
                            System.out.println(d);
                        }


                }
                case 11->{
                    System.out.println("program zakonczony");
                }
                default -> System.out.println("Błedna komenda, spróbuj ponownie") ;
            }


        }
    }
}
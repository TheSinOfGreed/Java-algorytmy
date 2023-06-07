package pl.Laboratorium1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;




public class Pesel {

    private String pesel;

    public Pesel(String pesel)  {

        if(pesel.length() != 11)
        {
            throw new IllegalArgumentException("Pesel musi posiadac 11 cyfer!");
        }
        else
        {
            this.pesel=pesel;
        }
    }

    public  void czyDataPrawidlowa(String date) throws ParseException {
        String DATE_FORMAT = "dd-MM-yyyy";
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            System.out.println("PESEL jest poprawny");

        } catch (ParseException d) {
            throw(d);
        }
    }

    public boolean sumaKontrolna(String s)
    {


        int liczba0 =Integer.parseInt(s.substring(0,1));
        int liczba1 =Integer.parseInt(s.substring(1,2));
        int liczba2 =Integer.parseInt(s.substring(2,3));
        int liczba3 =Integer.parseInt(s.substring(3,4));
        int liczba4 =Integer.parseInt(s.substring(4,5));
        int liczba5 =Integer.parseInt(s.substring(5,6));
        int liczba6 =Integer.parseInt(s.substring(6,7));
        int liczba7 =Integer.parseInt(s.substring(7,8));
        int liczba8 =Integer.parseInt(s.substring(8,9));
        int liczba9 =Integer.parseInt(s.substring(9,10));
        int liczba10 =Integer.parseInt(s.substring(10,11));

        int[] liczba = new int[10];
        liczba[0] = liczba0 *1;
        liczba[1] = liczba1 *3;
        liczba[2] = liczba2 *7;
        liczba[3] = liczba3 *9;
        liczba[4] = liczba4 *1;

        liczba[5] = liczba5 *3;
        liczba[6] = liczba6 *7;
        liczba[7] = liczba7 *9;
        liczba[8] = liczba8 *1;
        liczba[9] = liczba9 *3;
        for(int i=0;i<10;i++)
            if(liczba[i] >9)
                liczba[i]=liczba[i]%10;

        int suma=0;
        for(int i = 0;i<10;i++)
        {
            suma += liczba[i];
        }
        if(suma>9)
            suma = suma%10;
        suma = 10- suma;

        if(suma == liczba10)
            return true;
        else
            return false;
    }

    public String getData() throws ParseException {
        try {
            int dzien = Integer.parseInt(this.pesel.substring(4, 6));
            int rok = Integer.parseInt(this.pesel.substring(0, 2));
            int miesiac = Integer.parseInt(this.pesel.substring(2, 4));

            if (miesiac <= 92 && miesiac >= 81) {
                int miesiac2 = miesiac - 80;
                if (dzien <= 9 && miesiac2 <= 9) {
                    czyDataPrawidlowa("0" + dzien + "-0" + miesiac2 + "-18" + rok);
                } else if (dzien <= 9 && miesiac2 > 9) {
                    czyDataPrawidlowa("0" + dzien + "-" + miesiac2 + "-18" + rok);
                } else if (dzien > 9 && miesiac2 <= 9) {
                    czyDataPrawidlowa(dzien + "-0" + miesiac2 + "-18" + rok);
                } else if (dzien < 9 && miesiac2 < 9) {
                    czyDataPrawidlowa(dzien + "-" + miesiac2 + "-18" + rok);
                }
                if (rok <= 9)
                    return "Rok: 180" + rok + " Miesiac: " + (miesiac - 80) + " Dzień: " + dzien;
                else
                    return "Rok: 18" + rok + " Miesiac: " + (miesiac - 80) + " Dzień: " + dzien;
            }
            if (miesiac <= 32 && miesiac >= 21) {
                int miesiac2 = miesiac - 20;
                if (dzien <= 9 && miesiac2 <= 9) {
                    czyDataPrawidlowa("0" + dzien + "-0" + miesiac2 + "-20" + rok);
                } else if (dzien <= 9 && miesiac2 > 9) {
                    czyDataPrawidlowa("0" + dzien + "-" + miesiac2 + "-20" + rok);
                } else if (dzien > 9 && miesiac2 <= 9) {
                    czyDataPrawidlowa(dzien + "-0" + miesiac2 + "-20" + rok);
                } else if (dzien < 9 && miesiac2 < 9) {
                    czyDataPrawidlowa(dzien + "-" + miesiac2 + "-20" + rok);
                }
                if (rok <= 9)
                    return "Rok: 200" + rok + " Miesiac: " + (miesiac - 20) + " Dzień: " + dzien;
                else
                    return "Rok: 20" + rok + " Miesiac: " + (miesiac - 20) + " Dzień: " + dzien;
            }
            if (miesiac <= 52 && miesiac >= 41) {
                int miesiac2 = miesiac - 40;
                if (dzien <= 9 && miesiac2 <= 9) {
                    czyDataPrawidlowa("0" + dzien + "-0" + miesiac2 + "-21" + rok);
                } else if (dzien <= 9 && miesiac2 > 9) {
                    czyDataPrawidlowa("0" + dzien + "-" + miesiac2 + "-21" + rok);
                } else if (dzien > 9 && miesiac2 <= 9) {
                    czyDataPrawidlowa(dzien + "-0" + miesiac2 + "-21" + rok);
                } else if (dzien < 9 && miesiac2 < 9) {
                    czyDataPrawidlowa(dzien + "-" + miesiac2 + "-21" + rok);
                }
                if (rok <= 9)
                    return "Rok: 210" + rok + " Miesiac: " + (miesiac - 40) + " Dzień: " + dzien;
                else
                    return "Rok: 21" + rok + " Miesiac: " + (miesiac - 40) + " Dzień: " + dzien;
            }
            if (miesiac <= 72 && miesiac >= 61) {
                int miesiac2 = miesiac - 60;
                if (dzien <= 9 && miesiac2 <= 9) {
                    czyDataPrawidlowa("0" + dzien + "-0" + miesiac2 + "-22" + rok);
                } else if (dzien <= 9 && miesiac2 > 9) {
                    czyDataPrawidlowa("0" + dzien + "-" + miesiac2 + "-22" + rok);
                } else if (dzien > 9 && miesiac2 <= 9) {
                    czyDataPrawidlowa(dzien + "-0" + miesiac2 + "-22" + rok);
                } else if (dzien < 9 && miesiac2 < 9) {
                    czyDataPrawidlowa(dzien + "-" + miesiac2 + "-22" + rok);
                }
                if (rok <= 9)
                    return "Rok: 220" + rok + " Miesiac: " + (miesiac - 60) + " Dzień: " + dzien;
                else
                    return "Rok: 22" + rok + " Miesiac: " + (miesiac - 60) + " Dzień: " + dzien;
            }
            if (dzien <= 9 && miesiac <= 9) {
                czyDataPrawidlowa("0" + dzien + "-0" + miesiac + "-19" + rok);
            } else if (dzien <= 9 && miesiac > 9) {
                czyDataPrawidlowa("0" + dzien + "-" + miesiac + "-19" + rok);
            } else if (dzien > 9 && miesiac <= 9) {
                czyDataPrawidlowa(dzien + "-0" + miesiac + "-19" + rok);
            } else if (dzien < 9 && miesiac < 9) {
                czyDataPrawidlowa(dzien + "-" + miesiac + "-19" + rok);
            }

            if (rok <= 9) {
                return "Rok: 190" + rok + " Miesiac: " + miesiac + " Dzień: " + dzien;
            } else {
                return "Rok: 19" + rok + " Miesiac: " + miesiac + " Dzień: " + dzien;
            }

        }
        catch (ParseException d) {
            System.out.println("Nieprawidlowe dane!");
            throw (d);
        }
    }
    public String getGender()
    {
        int numerPlci = this.pesel.charAt(9);
        if(numerPlci%2==0)
        {
            return "kobieta";
        }
        else
        {return "mężczyzna";}
    }



    public static class StringParser{

        static int sumaIter(String s)
        {
            int sum=0;
            for(int i=0;i<s.length();i++)
                sum += Integer.parseInt(String.valueOf(s.charAt(i)));
            return sum;
        }
        static int sumaRek(String s)
        {
            int liczba =Integer.parseInt(s);
            if (liczba == 0)
                return 0;

            int liczba1 = liczba/10;
            return (liczba % 10 + sumaRek(Integer.toString(liczba1)));

        }
        static String sumaBinarna(String s1, String s2)
        {
            int a = Integer.parseInt(s1,2);
            int b = Integer.parseInt(s2,2);
            String c = Integer.toBinaryString(a+b);
            return c;

        }
        static String Zamianawspolglosek(String s)
        {
            char[] liczba = s.toCharArray();

            for(int i=0;i<s.length();i++)
            {
                if( liczba[i] == 'a' || liczba[i] == 'e' || liczba[i] == 'i' || liczba[i] == 'o' || liczba[i] == 'u'|| liczba[i] == 'A'|| liczba[i] == 'E'|| liczba[i] == 'I'|| liczba[i] == 'U'|| liczba[i] == 'O'|| liczba[i] == 'y'|| liczba[i] == 'Y')
                {
                    liczba[i] = Character.toUpperCase(liczba[i]);
                }
                else
                {
                    liczba[i] = Character.toLowerCase(liczba[i]);
                }
            }

            s = String.valueOf(liczba);
            return s;
        }
        static boolean upperCase(String s)
        {
            char[] litery = s.toCharArray();
            for(int i=0;i<s.length();i++)
            {
                if( !(java.lang.Character.isUpperCase(litery[i])))
                {
                    return false;
                }
            }
            return true;
        }
        static int maxIter(String s)
        {

            int sum = 0;
            char[] liczba = s.toCharArray();
            for(int i=0;i<s.length();i++)
            {
                if(sum < Character.getNumericValue(liczba[i]))
                {
                    sum = Character.getNumericValue(liczba[i]);
                }
            }
            return sum;
        }

        //private static int max=0;
        static int maxRek(String s)
        {

            int a = Integer.parseInt(String.valueOf(s.charAt(s.length()-1)));

            if( (s.length()==1))
                return a;
            int max = maxRek(s.substring(0,s.length()-1));
            if(max>a)
                return max;
            else
                return a;
        }


        static void zdanie(String nazwaPliku) throws IOException {

            Scanner scanner = new Scanner( new File("C:\\Users\\Medion\\IdeaProjects\\lab5\\"+nazwaPliku+".txt") );
            String text = scanner.useDelimiter("\\A").next();
            scanner.close();
            char[] litery =text.toCharArray();
            for(int i=0;i<litery.length;i++)
            {
                litery[i]=Character.toLowerCase(litery[i]);
            }
            litery[0] = Character.toUpperCase(litery[0]);
            for(int i=0;i<litery.length;i++)
            {
                if(i == litery.length-2)
                {break;}
                else if(litery[i]=='.'  && litery[i+1]==' ' )
                {
                    litery[i+2]= Character.toUpperCase(litery[i+2]);
                }
                else if(litery[i]=='.' && litery[i+1]!=' ')
                {
                    litery[i+1]= Character.toUpperCase(litery[i+1]);
                }
                else if(litery[i]== '\n')
                {
                    litery[i+1]= Character.toUpperCase(litery[i+1]);
                }


            }
            text = String.valueOf(litery);
            File myObj = new File(nazwaPliku+"_edited.txt");
                if (myObj.createNewFile()) {
                    System.out.println("Stworzony plik: " + myObj.getName());
                } else {
                    System.out.println("Błąd");
                }
            PrintWriter writer = new PrintWriter(nazwaPliku+"_edited.txt", "UTF-8");
            writer.println(text);

            writer.close();



        }









    }


}

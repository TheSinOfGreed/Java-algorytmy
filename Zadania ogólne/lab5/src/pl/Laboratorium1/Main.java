package pl.Laboratorium1;


import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        try {
            Pesel pesel1 = new Pesel("99082206253");
            System.out.println(pesel1.getGender());
            System.out.println(pesel1.sumaKontrolna("99062806253"));
            System.out.println(pesel1.getData());
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println();
        System.out.println(Pesel.StringParser.sumaIter("123456"));
        System.out.println(Pesel.StringParser.sumaRek("123456"));
        System.out.println(Pesel.StringParser.sumaBinarna("1010","1001"));
        System.out.println(Pesel.StringParser.Zamianawspolglosek("ayuoeZXCVBNM"));
        System.out.println(Pesel.StringParser.upperCase("KAMIL"));
        System.out.println(Pesel.StringParser.maxIter("6342595"));
        System.out.println(Pesel.StringParser.maxRek("104562547"));
        //Pesel.StringParser.zdanie("plik");



    }
}

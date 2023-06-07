package pl.Laboratorium1;

import java.util.Stack;

public class Notacja_polska {

    static public double stos(String[] wyraz)
    {


        Stack<String> stack = new Stack<String>();
        double x;
        double y;
        String wynik_do_stosu;
        String znak;
        double value = 0;



        for (int i= wyraz.length-1;  i >= 0 ; i--) {

                if ((!wyraz[i].equals("+")) && (!wyraz[i].equals("-"))
                        && (!wyraz[i].equals("*")) && (!wyraz[i].equals("/")) && (!wyraz[i].equals(" "))) {
                    stack.push(wyraz[i]);
                    continue;
                } else if (wyraz[i].equals(" ")) {
                    continue;
                } else {
                    znak = wyraz[i];
                }


                switch (znak) {
                    case "+" -> {
                        x = Double.parseDouble(stack.pop());
                        y = Double.parseDouble(stack.pop());
                        value = x + y;
                        wynik_do_stosu = "" + value;
                        stack.push(wynik_do_stosu);
                    }

                    case "-" -> {
                        x = Double.parseDouble(stack.pop());
                        y = Double.parseDouble(stack.pop());
                        value = x - y;
                        wynik_do_stosu = "" + value;
                        stack.push(wynik_do_stosu);
                    }

                    case "*" -> {
                        x = Double.parseDouble(stack.pop());
                        y = Double.parseDouble(stack.pop());
                        value = x * y;
                        wynik_do_stosu = "" + value;
                        stack.push(wynik_do_stosu);
                    }

                    case "/" -> {

                        x = Double.parseDouble(stack.pop());
                        y = Double.parseDouble(stack.pop());
                        if (y == 0) {
                            throw new IllegalArgumentException();
                        } else {
                            value = x / y;
                            wynik_do_stosu = "" + value;
                            stack.push(wynik_do_stosu);
                        }
                    }


                    default ->{
                        continue;}
                }

            }


        return Double.parseDouble(stack.pop());
    }











}

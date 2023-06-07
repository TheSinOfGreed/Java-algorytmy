package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hub extends JFrame implements ActionListener {


    JFrame frame = new JFrame("Transformacje obrazu");
    JButton button1  = new JButton("Rozjaśnij");
    JButton button2  = new JButton("Przyciemnij");
    JButton button3  = new JButton("Natyw");
    JButton gamma = new JButton("Gamma");
    JTextField sciezka_do_obrazka = new JTextField();
    JTextField wartosc = new JTextField();
    JLabel  label1 = new JLabel("Nazwa obrazka");
    JLabel  label2 = new JLabel("Wartość b");
    static String sciezka;
    static String wartosc_rd;

    hub(){

        label1.setBounds(50,100,120,25);
        label2.setBounds(50,150,75,25);
        sciezka_do_obrazka.setBounds(145,100,200,25);
        wartosc.setBounds(145,150,200,25);
        button1.setBounds(2,200,100,25);
        button1.setFocusable(false);
        button1.addActionListener(this);
        button2.setBounds(302,200,100,25);
        button2.setFocusable(false);
        button2.addActionListener(this);
        button3.setBounds(102,200,100,25);
        button3.setFocusable(false);
        button3.addActionListener(this);
        gamma.setBounds(202,200,100,25);
        gamma.setFocusable(false);
        gamma.addActionListener(this);

        frame.add(label1);
        frame.add(label2);
        frame.add(sciezka_do_obrazka);
        frame.add(wartosc);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(gamma);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }





    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==gamma){

            sciezka = sciezka_do_obrazka.getText();
            wartosc_rd = wartosc.getText();
            new MyFrame(4,sciezka,Double.parseDouble(wartosc_rd));
        }
        if(e.getSource()==button1){

            sciezka = sciezka_do_obrazka.getText();
            wartosc_rd = wartosc.getText();
            new MyFrame(2,sciezka,Double.parseDouble(wartosc_rd));


        }
        if(e.getSource()==button2){

            sciezka = sciezka_do_obrazka.getText();
            wartosc_rd = wartosc.getText();
            new MyFrame(1,sciezka,Double.parseDouble(wartosc_rd));


        }
        if(e.getSource()==button3){

            sciezka = sciezka_do_obrazka.getText();
            wartosc_rd = wartosc.getText();
            new MyFrame(3,sciezka,Double.parseDouble(wartosc_rd));


        }
    }
}

package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hub2  extends JFrame implements ActionListener {

    JFrame frame = new JFrame("Mieszanie obrazów");
    JButton button1  = new JButton("Stworz");
    JTextField obraz_1 = new JTextField();
    JTextField obraz_2 = new JTextField();
    JTextField alfa = new JTextField();
    JLabel  label1 = new JLabel("Nazwa obrazka");
    JLabel  label2 = new JLabel("Nazwa obrazka");
    JLabel  label3 = new JLabel("Podaj alfe");
    String[] tryb = {"suma","odejmowanie","różnica","mnożenie","mnożenie odwrotności","negacja","ciemniejsze","jaśniejsze","wyłączenie","nakładka","ostre światło","łagodne światło","rozcieńczenie","wypalenie","reflect","przezroczystosc"};
    JComboBox combobox = new JComboBox(tryb);

    hub2(){

        label1.setBounds(50,100,120,25);
        label2.setBounds(50,150,120,25);
        label3.setBounds(50,200,120,25);
        obraz_1.setBounds(145,100,200,25);
        obraz_2.setBounds(145,150,200,25);
        alfa.setBounds(145,200,200,25);
        button1.setBounds(102,250,100,25);
        button1.setFocusable(false);
        button1.addActionListener(this);
        combobox.setBounds(202,250,150,25);


        frame.add(combobox);
        frame.add(button1);
        frame.add(obraz_1);
        frame.add(obraz_2);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(alfa);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button1){
            String obraz1 = obraz_1.getText();
            String obraz2 = obraz_2.getText();

            if(combobox.getSelectedItem()=="suma"){
                new algorytmy(1,obraz1,obraz2);
            }
            if(combobox.getSelectedItem()=="odejmowanie"){
                new algorytmy(2,obraz1,obraz2);
            }
            if(combobox.getSelectedItem()=="różnica"){
                new algorytmy(3,obraz1,obraz2);
            }
            if(combobox.getSelectedItem()=="mnożenie"){
                new algorytmy(4,obraz1,obraz2);
            }
            if(combobox.getSelectedItem()=="mnożenie odwrotności"){
                new algorytmy(5,obraz1,obraz2);
            }
            if(combobox.getSelectedItem()=="negacja"){
                new algorytmy(6,obraz1,obraz2);
            }
            if(combobox.getSelectedItem()=="ciemniejsze"){
                new algorytmy(7,obraz1,obraz2);
            }
            if(combobox.getSelectedItem()=="jaśniejsze"){
                new algorytmy(8,obraz1,obraz2);
            }
            if(combobox.getSelectedItem()=="wyłączenie"){
                new algorytmy(9,obraz1,obraz2);
            }
            if(combobox.getSelectedItem()=="nakładka"){
                new algorytmy(10,obraz1,obraz2);
            }
            if(combobox.getSelectedItem()=="ostre światło"){
                new algorytmy(11,obraz1,obraz2);
            }
            if(combobox.getSelectedItem()=="łagodne światło"){
                new algorytmy(12,obraz1,obraz2);
            }
            if(combobox.getSelectedItem()=="rozcieńczenie"){
                new algorytmy(13,obraz1,obraz2);
            }
            if(combobox.getSelectedItem()=="wypalenie"){
                new algorytmy(14,obraz1,obraz2);
            }
            if(combobox.getSelectedItem()=="reflect"){
                new algorytmy(15,obraz1,obraz2);
            }
            if(combobox.getSelectedItem()=="przezroczystosc"){

                new algorytmy(16,obraz1,obraz2,Double.parseDouble(alfa.getText()));
                alfa.setText("");
            }

        }
    }
}

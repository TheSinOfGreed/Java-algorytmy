package test;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hub2  extends JFrame implements ActionListener {

    JFrame frame = new JFrame("Rozmycie/Gauss");
    JButton button1  = new JButton("Stworz");
    JTextField obraz_1 = new JTextField();

    JTextField r = new JTextField();
    JLabel  label1 = new JLabel("Nazwa obrazka");
    JLabel  label3 = new JLabel("Podaj r");
    String[] tryb = {"rozmycie","Gauss"};
    JComboBox combobox = new JComboBox(tryb);

    hub2(){



        label1.setBounds(50,100,120,25);

        label3.setBounds(50,200,120,25);
        obraz_1.setBounds(145,100,200,25);

        r.setBounds(145,200,200,25);
        button1.setBounds(102,250,100,25);
        button1.setFocusable(false);
        button1.addActionListener(this);
        combobox.setBounds(202,250,150,25);


        frame.add(combobox);
        frame.add(button1);
        frame.add(obraz_1);

        frame.add(label1);

        frame.add(label3);
        frame.add(r);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button1){
            String obraz1 = obraz_1.getText();


            if(combobox.getSelectedItem()=="rozmycie"){

                new GrayScale(obraz1,1,Integer.parseInt(r.getText()));
            }
            if(combobox.getSelectedItem()=="Gauss"){
                new GrayScale(obraz1,2,Integer.parseInt(r.getText()));
            }


        }
    }
}


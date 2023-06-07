package test;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
// 243, 194,37
// 2 px bledu są
    MyPanel(){
        this.setPreferredSize(new Dimension(437,404));
    }
    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(82,148,44));
        g2D.fillRect(415,247,22,79);
        g2D.fillRect(1,246,438,404);

        g2D.setPaint(new Color(66,104,61));
        g2D.fillRect(403,190,35,57);
        g2D.fillRect(1,1,438,248);


        g2D.setPaint(new Color(213,159,37));
        g2D.fillRect(426,335,11,69);
        g2D.fillRect(146,359,11,45);
        g2D.fillRect(134,335,12,25);

        g2D.setPaint(new Color(243,194,37));
        g2D.fillRect(294,335,134,69);
        g2D.fillRect(157,359,137,45);
        g2D.fillRect(282,349,12,12);
        g2D.fillRect(282,315,12,12);
        g2D.fillRect(238,347,11,12);
        g2D.fillRect(169,270,69,89);
        g2D.fillRect(294,270,56,68);
        g2D.fillRect(238,295,56,21);
        g2D.fillRect(238,283,11,13);
        g2D.fillRect(260,270,34,25);
        g2D.fillRect(213,237,101,34);
        g2D.fillRect(157,180,202,114);
        g2D.fillRect(347,281,69,56);
        g2D.fillRect(145,326,24,34);
        g2D.fillRect(416,325,11,11);
        g2D.fillRect(359,180,33,102);

        g2D.fillRect(392,146,12,67);
        g2D.fillRect(404,146,10,56);
        g2D.fillRect(414,135,12,55);
        g2D.fillRect(426,135,11,45);
        g2D.fillRect(326,169,67,11);
        g2D.fillRect(348,158,45,11);
        g2D.fillRect(146,180,11,23);
        g2D.fillRect(135,169,79,12);

        g2D.fillRect(123,158,68,11);
        g2D.fillRect(112,147,67,11);
        g2D.fillRect(101,136,68,11);
        g2D.fillRect(101,125,56,11);
        g2D.fillRect(101,114,45,11);
        g2D.fillRect(101,103,34,11);

        g2D.setPaint(new Color(213,159,37));
        g2D.fillRect(213,169,113,11);

        g2D.setPaint(new Color(76,65,4));
        g2D.fillRect(124,325,11,34);
        g2D.fillRect(117,292,10,43);
        g2D.fillRect(123,271,11,22);
        g2D.fillRect(134,225,12,56);
        g2D.fillRect(145,203,12,22);
        g2D.fillRect(135,181,11,22);
        g2D.fillRect(124,169,11,22);

        g2D.setPaint(new Color(227,203,90));
        g2D.fillRect(90,103,12,21);



        g2D.setPaint(new Color(76,65,4));
        g2D.fillRect(134,359,12,45);

        g2D.setPaint(new Color(171,73,4));
        g2D.fillRect(249,349,33,11);
        g2D.fillRect(282,327,12,22);

        g2D.setPaint(new Color(237,129,86));
        g2D.fillRect(249,327,33,22);

        g2D.setPaint(new Color(171,72,4));
        g2D.fillRect(260,315,22,12);
        g2D.fillRect(238,338,11,11);

        g2D.setPaint(new Color(125,37,1));
        g2D.fillRect(238,315,22,12);
        g2D.fillRect(238,327,11,11);

        g2D.setPaint(new Color(110,33,0));
        g2D.fillRect(248,284,22,11);
        g2D.fillRect(238,270,22,14);

        g2D.setPaint(new Color(255,255,255));
        g2D.fillRect(179,236,34,34);
        g2D.fillRect(314,236,35,34);

        g2D.setPaint(new Color(92,14,0));
        g2D.fillRect(179,258,34,12);
        g2D.fillRect(179,247,12,11);
        g2D.fillRect(201,247,12,11);
        g2D.fillRect(190,236,23,11);
        g2D.fillRect(314,258,35,12);
        g2D.fillRect(314,247,12,11);
        g2D.fillRect(337,247,12,11);
        g2D.fillRect(326,236,23,11);

        g2D.setPaint(new Color(153,47,0));
        g2D.fillRect(350,293,9,32);
        g2D.fillRect(359,325,23,10);
        g2D.fillRect(382,293,9,32);
        g2D.fillRect(359,281,23,12);

        g2D.fillRect(127,293,9,32);
        g2D.fillRect(135,325,23,10);
        g2D.fillRect(157,293,12,34);
        g2D.fillRect(134,281,23,12);

        g2D.setPaint(new Color(203,81,39));
        g2D.fillRect(358,293,24,32);
        g2D.fillRect(135,293,24,32);

        g2D.setPaint(new Color(90,69,6));
        g2D.fillRect(427,325,11,11);
        g2D.fillRect(416,281,11,44);
        g2D.fillRect(404,236,11,45);
        g2D.fillRect(392,213,11,23);

        g2D.fillRect(403,202,13,12);
        g2D.fillRect(414,191,12,12);
        g2D.fillRect(426,179,12,12);

        g2D.setPaint(new Color(211,158,36));
        g2D.fillRect(392,236,12,45);

        g2D.setPaint(new Color(213,159,37));
        g2D.fillRect(336,158,12,11);
        g2D.fillRect(370,147,23,11);
        g2D.fillRect(393,135,22,11);
        g2D.fillRect(416,123,23,12);
        g2D.fillRect(146,225,12,57);
        g2D.fillRect(191,158,11,11);

        g2D.fillRect(179,147,11,11);
        g2D.fillRect(169,136,11,11);
        g2D.fillRect(157,125,11,11);
        g2D.fillRect(146,115,11,11);


        g2D.setPaint(new Color(128,56,3));
        g2D.fillRect(202,158,134,11);
        g2D.fillRect(337,147,34,11);
        g2D.fillRect(370,135,23,12);
        g2D.fillRect(392,123,24,12);
        g2D.fillRect(416,112,23,11);



    }
}

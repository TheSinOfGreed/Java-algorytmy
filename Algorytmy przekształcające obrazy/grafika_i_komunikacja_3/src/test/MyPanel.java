package test;
import javax.swing.*;
import java.awt.*;



public class MyPanel extends JPanel  {




    int[] x = {38,38,56,40};
    int[] y = {59,44,357,357};

    int[] x1 = {40,20,130,115};
    int[] y1 = {357,357,363,362};

    int[] x2 = {115,115,118,118};
    int[] y2 = {362,377,216,231};

    int[] x3 = {118,111,190,183};
    int[] y3 = {231,218,378,365};

    int[] x4 = {183,168,268,253};
    int[] y4 = {365,364,364,363};

    int[] x5 = {253,247,179,173};
    int[] y5 = {363,377,154,168};

    int[] x6 = {173,167,235,229};
    int[] y6 = {168,182,36,50};

    int[] x7 = {173,167,235,229};
    int[] y7 = {168,182,36,50};

    int[] x8 = {229,214,159,154};
    int[] y8 = {50,50,62,48};

    int[] x9 = {154,149,121,116};
    int[] y9 = {48,34,173,159};

    int[] x10 = {116,115,109,108};
    int[] y10 = {159,174,34,49};
    int[] x11 = {108,93,64,38};
    int[] y11 = {49,46,64,59};


    int[] x20 = {448,443,336,321};
    int[] y20 = {79,65,405,405};

    int[] x21 = {321,306,406,400};
    int[] y21 = {405,405,390,404};
    int[] x22 = {400,394,482,431};
    int[] y22 = {404,418,292,331};
    int[] x23 = {431,408,549,488};
    int[] y23 = {331,348,340,325};
    int[] x24 = {488,473,526,511};
    int[] y24 = {325,321,409,408};
    int[] x25 = {511,496,571,568};
    int[] y25 = {408,407,397,412};
    int[] x26 = {568,565,495,448};
    int[] y26 = {412,427,67,79};

    int[] x27 = {447,445,452,442};
    int[] y27 = {234,219,274,263};
    int[] x28 = {442,426,502,479};
    int[] y28 = {263,246,251,261};
    int[] x29 = {479,465,477,474};
    int[] y29 = {261,267,217 ,232 };
    int[] x30 = {474,447};
    int[] y30 = {232 ,234};




    MyPanel() {
        this.setPreferredSize(new Dimension(650, 500));
    }

    public void bezier(int[] x, int[] y, Graphics g) {

        double t;
        double xt = 0;
        double yt = 0;
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(95, 95, Color.red, 75, 75,
                Color.yellow, true);
        for (t = 0.0; t <= 1.0; t = t + 0.001) {

            for (int i = 0; i <= x.length - 1; i++) {

                xt += Statyczne.DwumianNewtona(x.length - 1, i) * Math.pow(1 - t, x.length - 1 - i) * Math.pow(t, i) * x[i];
                yt += Statyczne.DwumianNewtona(y.length - 1, i) * Math.pow(1 - t, y.length - 1 - i) * Math.pow(t, i) * y[i];
            }
            g2.setPaint(gp);
            g2.drawOval((int)xt,(int)yt,3,3);
            //g.drawOval((int)xt,(int)yt,3,3);

            xt = 0;
            yt = 0;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        this.setBackground(Color.black);
        g.setColor(Color.red);
        bezier(x,y,g);
        bezier(x1,y1,g);
        bezier(x2,y2,g);
        bezier(x3,y3,g);
        bezier(x4,y4,g);
        bezier(x5,y5,g);
        bezier(x6,y6,g);
        bezier(x7,y7,g);
        bezier(x8,y8,g);
        bezier(x9,y9,g);
        bezier(x10,y10,g);
        bezier(x11,y11,g);
        bezier(x20,y20,g);
        bezier(x21,y21,g);
        bezier(x22,y22,g);
        bezier(x23,y23,g);
        bezier(x24,y24,g);
        bezier(x25,y25,g);
        bezier(x26,y26,g);
        bezier(x27,y27,g);
        bezier(x28,y28,g);
        bezier(x29,y29,g);
        bezier(x30,y30,g);






    }

}
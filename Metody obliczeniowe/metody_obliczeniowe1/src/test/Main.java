package test;

public class Main {

    public static void main(String[] args) {

        double[][] m1 = new double[3][4];
        m1[0][0]= 2;
        m1[0][1]= 0;
        m1[0][2]= 2;
        m1[0][3]= 0;


        m1[1][0]= 0;
        m1[1][1]= 2;
        m1[1][2]= 1;
        m1[1][3]= 0;


        m1[2][0]= 2;
        m1[2][1]= 1;
        m1[2][2]= 0;
        m1[2][3]= 2;




    MetodyStatyczne.Gauss(m1);



    }
}

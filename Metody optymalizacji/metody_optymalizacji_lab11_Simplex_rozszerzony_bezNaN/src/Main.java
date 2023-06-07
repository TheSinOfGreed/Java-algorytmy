public class Main {
    public static void main(String[] args) {


        double[][] macierz = new double[2][4];
        macierz[0][0] = 1;macierz[1][0] = -2;
        macierz[0][1] = 1;macierz[1][1] = 1;
        macierz[0][2] = 1;macierz[1][2] = 0;
        macierz[0][3] = 0;macierz[1][3] = 1;

        double[] cj = new double[4];
        double[] ci = new double[2];
        ci[0]=0;ci[1]=0;cj[2]=0;
        cj[0]=1;cj[1]=2;cj[3]=0;

        double[] bi = new double[2];
        bi[0]=10;bi[1]=4;


        Simplex.Simplex(macierz,ci,cj,bi, false,4,2);

        double[][] macierz2 = new double[3][6];
        macierz2[0][0] = 80;macierz2[1][0] = 20;
        macierz2[0][1] = 100;macierz2[1][1] = 200;
        macierz2[0][2] = -1;macierz2[1][2] = 0;
        macierz2[0][3] = 0;macierz2[1][3] = 1;
        macierz2[0][4] = 0;macierz2[1][4] = 0;
        macierz2[0][5] = 1;macierz2[1][5] = 0;
        macierz2[2][0] = 1;
        macierz2[2][1] = 0;
        macierz2[2][2] = 0;
        macierz2[2][3] = 0;
        macierz2[2][4] = 1;
        macierz2[2][5] = 0;

        double[] bi2 = new double[3];
        bi2[0]=100;bi2[1]=300;bi2[2]=1.5;

        double[] cj2 = new double[6];
        double[] ci2 = new double[3];
        cj2[0]=2;ci2[0]=-1999;
        cj2[1]=18;ci2[1]=0;
        cj2[2]=0;ci2[2]=0;
        cj2[3]=0;
        cj2[4]=0;
        cj2[5]=-1999;


        Simplex.Simplex(macierz2,ci2,cj2,bi2, true,6,3,true);

    }
}
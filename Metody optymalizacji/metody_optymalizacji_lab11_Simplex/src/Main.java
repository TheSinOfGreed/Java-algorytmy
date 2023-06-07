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

    }
}
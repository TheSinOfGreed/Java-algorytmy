public class Main {
    public static void main(String[] args) {

        System.out.println("Moje:");
        CalculusExamples.derivativeExample(CalculusExamples.Przyklad1());
        System.out.println("Za pomocą Calculusa: ");
        Gauss.Gauss(CalculusExamples.macierzZeWspolczynnikami);

/////////////////////////////////////////////////
        double[][] m1 = new double[3][4];
        m1[0][0]= 2; m1[1][0]= 0;m1[2][0]= 2;
        m1[0][1]= 0;m1[1][1]= 2;m1[2][1]= 1;
        m1[0][2]= 2;m1[1][2]= 1;m1[2][2]= 0;
        m1[0][3]= 0;m1[1][3]= 0;m1[2][3]= 2;

        System.out.println("Wynik metodą mnożników Langrage dla L(x1,x2,lambda): ");
        Gauss.Gauss(m1);


    }
}
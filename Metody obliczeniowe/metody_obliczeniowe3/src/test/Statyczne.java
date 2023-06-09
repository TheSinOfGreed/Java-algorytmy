package test;

public class Statyczne {


    private static double f(double x) {

        return x*x ;

    }

    public static double metodaTrapezow(double poczatekPrzedzialu, double koniecPrzedzialu, int n){
        double h = (koniecPrzedzialu-poczatekPrzedzialu)/(double)n;
        double sum=0;
        for(int i=1; i<n;i++){

            sum += f(poczatekPrzedzialu+i*h /* xi */);

        }
        return h*((f(poczatekPrzedzialu)/2)+ sum + (f(koniecPrzedzialu)/2));
    }




    public static double metodaSimsona(double poczatekPrzedzialu, double koniecPrzedzialu, int n){
        double h = (koniecPrzedzialu-poczatekPrzedzialu)/(double)n;
        double sum1=0;
        double sum2=0;

        double[] tablica = new double[n+1];
        double[] tablicaBezF = new double[n+1];

        for(int i=0;i<n+1;i++){
            tablicaBezF[i] = poczatekPrzedzialu+i*h ;
            tablica[i] = f(poczatekPrzedzialu+i*h) /* xi */;
            //System.out.println(tablica[i]);
        }

        double[] t = new double[n];

        for(int i=0;i<n;i++){
            t[i] = f((tablicaBezF[i+1] +tablicaBezF[i])/2) ;

            //System.out.println(t[i]);
        }
        for(int i =0 ; i<n;i++){
            sum1 += t[i];
        }
        sum1 *=4;
        for(int i =1 ; i<n;i++){
            sum2 += tablica[i];
        }
        sum2 *=2;

        return (f(poczatekPrzedzialu)+sum1+sum2+tablica[n]) * (h/6);

    }
    public static double metodaKwadratury(double poczatekPrzedzialu, double koniecPrzedzialu, int n){

        double[] n2_w = new double[2];
        n2_w[0]=1.0000000000000000;
        n2_w[1]=1.0000000000000000;

        double[] n2_x = new double[2];
        n2_x[0]= -0.5773502691896257;
        n2_x[1]= 0.5773502691896257;
/////////////////////////////////////////////////////////
        double[] n4_w = new double[4];
        n4_w[0]=0.6521451548625461;
        n4_w[1]=0.6521451548625461;
        n4_w[2]=0.3478548451374538;
        n4_w[3]=0.3478548451374538;

        double[] n4_x = new double[4];
        n4_x[0]= -0.3399810435848563;
        n4_x[1]= 0.3399810435848563;
        n4_x[2]= -0.8611363115940526;
        n4_x[3]= 0.8611363115940526;
////////////////////////////////////////////////////////////

        double[] n5_w = new double[5];
        n5_w[0]=0.5688888888888889;
        n5_w[1]=0.4786286704993665;
        n5_w[2]=0.4786286704993665;
        n5_w[3]=0.2369268850561891;
        n5_w[4]=0.2369268850561891;

        double[] n5_x = new double[5];
        n5_x[0]= 0.0000000000000000;
        n5_x[1]= -0.5384693101056831;
        n5_x[2]= 0.5384693101056831;
        n5_x[3]= -0.9061798459386640;
        n5_x[4]=0.9061798459386640;
////////////////////////////////////////////////////////////
        double[] n6_w = new double[6];
        n6_w[0]=0.3607615730481386;
        n6_w[1]=0.3607615730481386 	;
        n6_w[2]=0.4679139345726910;
        n6_w[3]=0.4679139345726910 	;
        n6_w[4]=0.1713244923791704;
        n6_w[5]=0.1713244923791704 	;

        double[] n6_x = new double[6];
        n6_x[0]= 0.6612093864662645;
        n6_x[1]= -0.6612093864662645;
        n6_x[2]= -0.2386191860831969;
        n6_x[3]= 0.2386191860831969;
        n6_x[4]= -0.9324695142031521;
        n6_x[5]= 0.9324695142031521;

/////////////////////////////////////////////////////////

        double[] n8_w = new double[8];
        n8_w[0]=0.3626837833783620;
        n8_w[1]=0.3626837833783620 	;
        n8_w[2]=0.3137066458778873;
        n8_w[3]=0.3137066458778873 	;
        n8_w[4]=0.2223810344533745;
        n8_w[5]=0.2223810344533745 	 	;
        n8_w[6]=0.1012285362903763;
        n8_w[7]=0.1012285362903763	;

        double[] n8_x = new double[8];
        n8_x[0]= -0.1834346424956498;
        n8_x[1]= 0.1834346424956498;
        n8_x[2]= -0.5255324099163290;
        n8_x[3]= 0.5255324099163290;
        n8_x[4]= -0.7966664774136267;
        n8_x[5]= 0.7966664774136267;
        n8_x[6]= -0.9602898564975363;
        n8_x[7]= 0.9602898564975363;
////////////////////////////////////////////////////

        double[] n10_w = new double[10];
        n10_w[0]= 	0.2955242247147529;
        n10_w[1]=0.2955242247147529	;
        n10_w[2]=0.2692667193099963;
        n10_w[3]=0.2692667193099963 		;
        n10_w[4]=0.2190863625159820;
        n10_w[5]=0.2190863625159820 		 	;
        n10_w[6]=0.1494513491505806 	;
        n10_w[7]=0.1494513491505806	;
        n10_w[8]=0.0666713443086881 	;
        n10_w[9]=0.0666713443086881	;

        double[] n10_x = new double[10];
        n10_x[0]= -0.1488743389816312;
        n10_x[1]= 0.1488743389816312;
        n10_x[2]= -0.4333953941292472;
        n10_x[3]= 0.4333953941292472;
        n10_x[4]= -0.6794095682990244;
        n10_x[5]= 0.6794095682990244;
        n10_x[6]= -0.8650633666889845;
        n10_x[7]= 0.8650633666889845;
        n10_x[8]= -0.9739065285171717;
        n10_x[9]= 0.9739065285171717;
////////////////////////////////////////////////////////////////////////////
        double[] n16_w = new double[16];
        n16_w[0]= 0.1894506104550685;
        n16_w[1]=0.1894506104550685	;
        n16_w[2]=0.1826034150449236;
        n16_w[3]=0.1826034150449236 		;
        n16_w[4]=0.1691565193950025;
        n16_w[5]=0.1691565193950025		 	;
        n16_w[6]=0.1495959888165767	;
        n16_w[7]=0.1495959888165767	;
        n16_w[8]=0.1246289712555339 	;
        n16_w[9]=0.1246289712555339	;
        n16_w[10]=0.0951585116824928;
        n16_w[11]=0.0951585116824928		 	;
        n16_w[12]=0.0622535239386479 		;
        n16_w[13]=0.0622535239386479	;
        n16_w[14]=0.0271524594117541	;
        n16_w[15]=0.0271524594117541	;

        double[] n16_x = new double[16];
        n16_x[0]= -0.0950125098376374;
        n16_x[1]= 0.0950125098376374;
        n16_x[2]= -0.2816035507792589;
        n16_x[3]= 0.2816035507792589;
        n16_x[4]= -0.4580167776572274;
        n16_x[5]= 0.4580167776572274;
        n16_x[6]= -0.6178762444026438;
        n16_x[7]= 0.6178762444026438;
        n16_x[8]= -0.7554044083550030;
        n16_x[9]= 0.7554044083550030;
        n16_x[10]= -0.8656312023878318;
        n16_x[11]= 0.8656312023878318;
        n16_x[12]= -0.9445750230732326;
        n16_x[13]= 0.9445750230732326;
        n16_x[14]= -0.9894009349916499;
        n16_x[15]= 0.9894009349916499;


        double[] x;
        double[] w;
        double sum = 0;

        switch (n) {
            case 2 ->{
                w = n2_w;
                x = n2_x;}
            case 4 -> {
                w = n4_w;
                x = n4_x;}
            case 5 -> {
                w = n5_w;
                x = n5_x;}
            case 6 -> {
                w = n6_w;
                x = n6_x;}
            case 8 -> {
                w = n8_w;
                x = n8_x;}
            case 10 -> {
                w = n10_w;
                x = n10_x;}
            case 16 -> {
                w = n16_w;
                x = n16_x;}
            default -> {
                x = null;
                w = null;
            }
        }


        for(int i =0;i<n;i++){

            
            sum += w[i] * f(      ((koniecPrzedzialu-poczatekPrzedzialu)/2) * x[i]    +   ((koniecPrzedzialu+poczatekPrzedzialu)/2)                                           );

        }

        double a =sum* (koniecPrzedzialu-poczatekPrzedzialu)/2;
        if(a<0){a=a*(-1);}

        return a;


    }



}

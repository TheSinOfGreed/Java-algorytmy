package test;

public class Main {

    public static void main(String[] args) {


        double[] iksy3 = {-4.0,-2.0,0.0,2.0,4.0};
        double[] igreki3 = {-1011.0,-73.0,1.0,-21.0,-523.0};


        //System.out.println(Statyczne.Lagrange(iksy3,igreki3,5,1.0));
        //System.out.println(Statyczne.NewtonInterpulation(iksy3,igreki3,4,1.0));
        //System.out.println(Statyczne.funkcje_sklejane(iksy3,igreki3,957.0,-579.0,1.0));
        System.out.println(Statyczne.NewtonInterpulationRP(iksy3,igreki3,5,1.0));


    }
}

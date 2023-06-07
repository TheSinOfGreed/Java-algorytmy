package test;

public class Main {

    public static void main(String[] args) throws Exception {
        //przykład
//	 Newton.Newton(10,12,3);
        //jarka
    // Newton.Newton(1,1,0.0000001);

	    //moj przyklad
    System.out.println("Newton:");
    Newton.Newton(1,1,0.0001);
    System.out.println("Szybki spadek:");
   Newton.NajszybszySpadek(1,1,0.0001);



        System.out.println("Gauss-Seidler");
   Newton.Gaussa_Seidla(1,1, 0.0001);

    }
}

package pl.Laboratorium1;

public class Punkt {
     double x;
     double y;

    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Punkt()
    {
        this(0,0);


    }
    @Override
    public String toString() {
        return "(" + x + ","+ y+")";

    }
    public int sumaWspolrzednych()
    {
        int suma;
        suma = (int) (x+y);
        return suma;
    }
    public double odlegloscOdSrodka()
    {

        return Math.sqrt(x*x + y*y);
    }
    public double odlegloscOdPktu(Punkt punkt2)
    {
        return Math.sqrt((x- punkt2.x)*(x- punkt2.x) + (y- punkt2.y) * (y- punkt2.y));

    }


}

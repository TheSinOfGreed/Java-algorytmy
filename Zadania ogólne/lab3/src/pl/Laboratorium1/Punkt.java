package pl.Laboratorium1;

public class Punkt {

    private double x;
    private double y;

    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Punkt()
    {
        this(0,0);
    }

    public double getOdleglosc(Punkt punkt2)
    {
        return Math.sqrt((x- punkt2.x)*(x- punkt2.x) + (y- punkt2.y) * (y- punkt2.y));

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean equals(Object p)
    {
        if(!(p instanceof Punkt))
            return false;
        Punkt p1=(Punkt)p;
        return p1.x ==this.x  &&  p1.y==this.y;
    }
    @Override
    public String toString() {
        return  "("+this.x + ","+ this.y+")";

    }




}

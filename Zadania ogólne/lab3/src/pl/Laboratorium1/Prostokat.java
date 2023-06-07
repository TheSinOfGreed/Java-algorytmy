package pl.Laboratorium1;

public class Prostokat extends Wielokat{

    public Prostokat(Punkt a,Punkt b,Punkt c,Punkt d)
    {
        super(4);
        wierzcholki[0] = a;
        wierzcholki[1] = b;
        wierzcholki[2] = c;
        wierzcholki[3] = d;
    }

    @Override
    public String toString() {
        return "Prostokat:["+wierzcholki[0]+","+wierzcholki[1]+","+wierzcholki[2]+","+wierzcholki[3]+"]";
    }


    @Override
    public double getPole() {
        double bok1 = wierzcholki[0].getOdleglosc(wierzcholki[1]);
        double bok2 = wierzcholki[0].getOdleglosc(wierzcholki[3]);
        return bok1*bok2;
    }

    @Override
    public double getObwod() {
        double bok1 = wierzcholki[0].getOdleglosc(wierzcholki[1]);
        double bok2 = wierzcholki[1].getOdleglosc(wierzcholki[2]);
        double bok3 = wierzcholki[2].getOdleglosc(wierzcholki[3]);
        double bok4 = wierzcholki[3].getOdleglosc(wierzcholki[0]);
        return bok1+bok2+bok3+bok4;
    }
}

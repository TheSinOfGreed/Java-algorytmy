package pl.Laboratorium1;

public class Trojkat extends Wielokat {

    public Trojkat(Punkt a,Punkt b,Punkt c)
    {
        super(3);
        wierzcholki[0] = a;
        wierzcholki[1] = b;
        wierzcholki[2] = c;

    }

    @Override
    public String toString() {
        return "Trojkat:["+wierzcholki[0]+","+wierzcholki[1]+","+wierzcholki[2]+"]";
    }

    @Override
    public double getPole() {
        double bok1 = wierzcholki[0].getOdleglosc(wierzcholki[1]);
        double bok2 = wierzcholki[1].getOdleglosc(wierzcholki[2]);
        double bok3 = wierzcholki[2].getOdleglosc(wierzcholki[0]);
        double w = (bok1 + bok2 + bok3) / 2;
        return Math.sqrt( w*(w-bok1)*(w-bok2)*(w-bok3) ); // wzór Herona
    }

    @Override
    public double getObwod() {
        double bok1 = wierzcholki[0].getOdleglosc(wierzcholki[1]);
        double bok2 = wierzcholki[1].getOdleglosc(wierzcholki[2]);
        double bok3 = wierzcholki[2].getOdleglosc(wierzcholki[0]);
        return bok1+bok2+bok3;
    }
    public double getWysokosc()
    {
        double bok1 = wierzcholki[0].getOdleglosc(wierzcholki[1]);
        double Pole_w = this.getPole();
        double Pod_w = bok1 / 2;
        return Pole_w / Pod_w;
    }
}

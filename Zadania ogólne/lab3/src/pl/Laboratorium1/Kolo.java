package pl.Laboratorium1;

public class Kolo implements Figura {

    private Punkt srodek;
    private double promien;

    public Kolo(Punkt srodek, double promien) {
        this.srodek = srodek;
        this.promien = promien;
    }

    public Punkt getSrodek() {
        return srodek;
    }

    public double getPromien() {
        return promien;
    }

    public void setSrodek(Punkt srodek) {
        this.srodek = srodek;
    }

    public void setPromien(double promien) {
        if(promien >= 0)
        {this.promien = promien;}
    }

    public boolean equals(Object p)
    {
        if(!(p instanceof Kolo))
            return false;
        Kolo kolo=(Kolo)p;
        return kolo.promien==this.promien &&kolo.srodek.equals(this.srodek);
    }

    @Override
    public String toString() {
        return "Kolo:(" + this.srodek + " , "+ this.promien+")";

    }

    @Override
    public double getPole() {
        return Math.PI * Math.pow(promien,2);
    }

    @Override
    public double getObwod() {
        return 2*Math.PI* promien;
    }
}

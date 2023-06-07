package pl.Laboratorium1;

abstract public class Wielokat implements Figura {
    protected Punkt[] wierzcholki;

    public Wielokat(int ilosc_wieszcholkow) {
    this.wierzcholki = new Punkt[ilosc_wieszcholkow];
    }
    public Punkt getWierzcholki(int a){return this.wierzcholki[a];}
    public void setWierzcholki(int a,Punkt p){wierzcholki[a]=p;}
    @Override
    public boolean equals(Object p)
    {
        if(!(p instanceof Wielokat))
            return false;
        Wielokat w = (Wielokat)p;

        if(this.wierzcholki.length == w.wierzcholki.length)
        {
            for(int i=0;i<wierzcholki.length;i++)
            {
                if(!(wierzcholki[i].equals(w.wierzcholki[i]))) {return false;}
                break;
            }

        }
        return true;
    }


}

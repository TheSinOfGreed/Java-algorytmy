package pl.Laboratorium1;

public class LiczbyWymierne {

    private int licznik;
    private int mianownik;


    public LiczbyWymierne(int licznik, int mianownik) {
        this.licznik = licznik;
        this.mianownik = mianownik;
        if(this.mianownik == 0)
        {
            throw new IllegalArgumentException("W mianowniku nie moze byc zera");
        }

        if((this.mianownik < 0 && this.licznik <0) || (this.mianownik < 0 && this.licznik >0) )
        {
            this.licznik = -this.licznik;
            this.mianownik= -this.mianownik;
        }

    }

    public int getLicznik() {
        return licznik;
    }

    public int getMianownik() {
        return mianownik;
    }

    public void setLicznik(int licznik) {
        this.licznik = licznik;
    }

    public void setMianownik(int mianownik) {
        if(mianownik != 0 )
        {this.mianownik = mianownik;}
        else
        {
            throw new IllegalArgumentException("W mianowniku nie moze byc zera");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  Number)
        {
            if(this.mianownik==1)
            {
                Number n = (Number)obj;
                return n.intValue()==this.licznik;
            }
            if(licznik%mianownik==0)
            {
                Number n =(Number)obj;
                return n.intValue()==this.licznik/this.mianownik;
            }
            else
            {
                Number n=(Number)obj;
                return n.floatValue()==licznik/mianownik || n.doubleValue()==(double)licznik/mianownik;
            }

        }
        if(obj instanceof LiczbyWymierne)
        {
            LiczbyWymierne z =(LiczbyWymierne)obj;
            z.skroc();
            this.skroc();
            return this.licznik==z.licznik&&this.mianownik==z.mianownik;
        }

        return false;
    }



    @Override
    public String toString()
    {

        if(this.licznik==0 && this.mianownik==0)
            return 0+" ";
        if(this.licznik==0 && this.mianownik!=0)
            return 0+" ";
//        if(this.licznik!=0 && this.mianownik==0)
//            return this.licznik+" ";
        if(this.licznik%this.mianownik==0 )
        {
            return this.licznik/this.mianownik +" ";
        }
        if(this.licznik > this.mianownik || this.licznik*(-1) >this.mianownik)
        {
            int cz_calkowita = this.licznik/this.mianownik;
            int nowy_licznik = this.licznik%this.mianownik;
            if(nowy_licznik<0)
                nowy_licznik=-nowy_licznik;

            return "   "+nowy_licznik+"\n"+cz_calkowita +" --"+"\n"+"   "+this.mianownik;
        }
        if(this.licznik<0)
            return "  "+Math.abs(this.licznik)+"\n"+"- -"+"\n"+"  "+ this.mianownik;
        return " "+this.licznik+"\n"+" -"+"\n"+" "+ this.mianownik;

    }
    public LiczbyWymierne skroc()
    {
        int d;
        d = NWD(this.licznik, this.mianownik);
        this.licznik = this.licznik / d;
        this.mianownik = this.mianownik / d;

        return this;

    }

    public int NWD(int a, int b)
    {
        if(a<0)
            a=-a;
        if (b == 0)
            return a;
        return NWD(b, a % b);
    }



    public LiczbyWymierne dodaj(LiczbyWymierne w)
    {

        if(this.mianownik == w.mianownik)
        {
            LiczbyWymierne wynik = new LiczbyWymierne(this.licznik+w.licznik,this.mianownik);
            wynik.skroc();
            return wynik;
        }
        else
        {
            LiczbyWymierne wynik = new LiczbyWymierne((this.licznik * w.mianownik) + (w.licznik * this.mianownik),
                    this.mianownik * w.mianownik);
            wynik.skroc();
            return wynik;
        }
    }
    public LiczbyWymierne odejmij(LiczbyWymierne w)
    {

        if(this.mianownik == w.mianownik)
        {
            LiczbyWymierne wynik = new LiczbyWymierne(this.licznik-w.licznik,1);
            wynik.skroc();
            return wynik;
        }
        else
        {
            LiczbyWymierne wynik = new LiczbyWymierne((this.licznik * w.mianownik) - (w.licznik * this.mianownik),
                    this.mianownik * w.mianownik);
            wynik.skroc();
            return wynik;
        }
    }
    public LiczbyWymierne pomnoz(LiczbyWymierne w)
    {
        LiczbyWymierne wynik = new LiczbyWymierne(this.licznik*w.licznik,this.mianownik*w.mianownik);
        wynik.skroc();
        return wynik;
    }
    public LiczbyWymierne podziel(LiczbyWymierne w)
    {
        LiczbyWymierne wynik = new LiczbyWymierne(this.licznik*w.mianownik,this.mianownik*w.licznik);
        wynik.skroc();
        return wynik;
    }
    public LiczbyWymierne Odwroc() throws ArithmeticException
    {
        if(this.licznik==0)
            throw new IllegalArgumentException("Licznik jest rowny 0, po odwroceniu mianownik bedzie 0 co jest bledem !");
        if(this.licznik < 0 ) {
            int a = this.licznik;
            int b = this.mianownik;
            this.licznik = b*(-1);
            this.mianownik = a*(-1);
            return this;
        }
        int a = this.licznik;
        int b = this.mianownik;
        this.licznik = b;
        this.mianownik = a;
        return this;
    }















}

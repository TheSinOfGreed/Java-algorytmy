public class Osobnik {

    double wartosc;
    String wartoscLancuch;
    double prawdopodobienstwo;
    double kwartyl;
    int index; //Przydatne jak trzeba znać początkowy index
    int poczatkowaPozycja; //Do krzyżowania dla sukcesji

    public Osobnik(double wartosc, String wartoscLancuch) {
        this.wartosc = wartosc;
        this.wartoscLancuch = wartoscLancuch;
    }

    public double getWartosc() {
        return wartosc;
    }

    public double getPrawdopodobienstwo() {
        return prawdopodobienstwo;
    }

    public double getKwartyl() {
        return kwartyl;
    }

    public void setPrawdopodobienstwo(double prawdopodobienstwo) {
        this.prawdopodobienstwo = prawdopodobienstwo;
    }

    public void setKwartyl(double kwartyl) {
        this.kwartyl = kwartyl;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPoczatkowaPozycja() {
        return poczatkowaPozycja;
    }

    public void setPoczatkowaPozycja(int poczatkowaPozycja) {
        this.poczatkowaPozycja = poczatkowaPozycja;
    }

    @Override
    public String toString() {
        return wartoscLancuch + " " + wartosc;
    }
}

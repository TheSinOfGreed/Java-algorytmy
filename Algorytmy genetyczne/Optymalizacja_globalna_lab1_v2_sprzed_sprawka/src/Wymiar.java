public class Wymiar {

    double a;
    double b;

    public Wymiar(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "["+a + " " + b + "]";
    }
}

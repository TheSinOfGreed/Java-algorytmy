public class ParaOsobnikow {

    Osobnik rodzic1;
    Osobnik rodzic2;

    public ParaOsobnikow(Osobnik rodzic1, Osobnik rodzic2) {
        this.rodzic1 = rodzic1;
        this.rodzic2 = rodzic2;
    }

    @Override
    public String toString() {
        return "ParaOsobnikow{" +
                "tata =" + "[" + rodzic1.getIndex() + "]" + rodzic1 +
                ", mama =" + "[" + rodzic2.getIndex() + "]" + rodzic2 +
                '}';
    }


}

public class Mode_Normalny implements State{
    @Override
    public void move(Enemy e) {
        e.setDistance(e.getDistance()-3);
        System.out.println("ucieka " +e.getDistance());
    }

    @Override
    public void atakuj(Enemy e) {
        //System.out.println("Atakuje");
    }
}

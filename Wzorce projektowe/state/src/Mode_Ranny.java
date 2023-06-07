public class Mode_Ranny implements State{
    @Override
    public void move(Enemy e) {
        e.setDistance(e.getDistance()+2);
        System.out.println("ucieka "+e.getDistance());
    }

    @Override
    public void atakuj(Enemy e) {
        e.setHp(e.getHp()-1);
        System.out.println("atak "+e.getHp());

    }
}

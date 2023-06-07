public class Mode_Berserk implements State {
    @Override
    public void move(Enemy e) {
        e.setDistance(e.getDistance() - 4);
        System.out.println("ucieka "+e.getDistance());

    }
    @Override
    public void atakuj(Enemy e) {
        e.setHp(e.getHp() - 4);
        System.out.println("atak "+e.getHp());
    }
}

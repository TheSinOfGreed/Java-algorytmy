public class Enemy {
    public static final State Normalny = new Mode_Normalny();
    public static final State Agresywny = new Mode_Agresywny();
    public static final State Ranny = new Mode_Ranny();
    public static final State Szalu = new Mode_Berserk();


    private int zdrowie = 10;
    private State state = Enemy.Normalny;
    private String nazwa;
    private static int dystans = 10;

    public Enemy(String nazwa_wroga){

        this.nazwa=nazwa_wroga;
    }

    public void makeMove(String a,Enemy e) {
        if (a.equals("1")) {
            this.state.atakuj(e);
        }
        else if(a.equals("2")){
            this.state.move(e);
        }

        if(this.getHp()<=5){
            this.state=Enemy.Ranny;
            System.out.println(this.nazwa + " jest w stanie rannym");
        }
        if(this.zdrowie>5&&Enemy.dystans<=10){
            this.state=Enemy.Agresywny;
            System.out.println(this.nazwa + " jest w stanie agresywnym");
        }
        if(this.zdrowie<=3){
            this.setState(Enemy.Szalu);
            System.out.println(this.nazwa + " jest w stanie berserka");
        }


    }

    public int getDistance() {
        return dystans;
    }
    public void setDistance(int distance) {
        Enemy.dystans = distance;
    }
    public int getHp() {
        return zdrowie;
    }
    public void setHp(int hp) {
        this.zdrowie = hp;
    }
    public void setState(State state) {
        this.state = state;
    }
    public String getName() {
        return nazwa;
    }


}

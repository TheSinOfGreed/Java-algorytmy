import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Enemy jeden = new Enemy("Sukkub");
        Enemy dwa = new Enemy("Wilkołak");
        Enemy trzy = new Enemy("Wampir");
        Enemy cztery = new Enemy("Golem");
        Scanner input = new Scanner(System.in);

        while (true){
            System.out.println("Ruch "+jeden.getName());
            jeden.makeMove(input.next(),dwa);
            System.out.println("Ruch "+dwa.getName());
            dwa.makeMove(input.next(), jeden);

            if(jeden.getHp()<=0||dwa.getHp()<=0){
                break;
            }
        }
    }
}

import java.util.Random;

public class Mutacja {
    public Mutacja(Osobnik[] osobniki, int n) {

        double prawdopodobienstwoMutacji =  0.2;

        System.out.println("*PRZED*");
        for(int i =0; i < n; i++){
            System.out.println(osobniki[i].wartoscLancuch);
        }
        System.out.println("*WYLOSOWANE*");
        for(int i =0; i < n; i++){
            char[] charArray = osobniki[i].wartoscLancuch.toCharArray();
            for(int j=0; j < charArray.length; j++){
                double wylosowanaLiczba = Losuj();

                if(wylosowanaLiczba < prawdopodobienstwoMutacji){
                    System.out.print(" ("+ (Math.round(wylosowanaLiczba * 100.0) / 100.0) + ") ");
                    if(charArray[j] == '0'){
                        charArray[j] = '1';
                    }else{
                        charArray[j] = '0';
                    }
                }else{
                    System.out.print(" "+ (Math.round(wylosowanaLiczba * 100.0) / 100.0) + " ");
                }
            }
            osobniki[i].wartoscLancuch = new String(charArray);
            System.out.println();
        }
        System.out.println("*PO*");
        for(int i =0; i < n; i++){
            System.out.println(osobniki[i].wartoscLancuch);
        }
    }

    public double Losuj() {
        Random random = new Random();
        return random.nextDouble(1.0 - 0.0 + 0.0) + 0.0;
    }
}

package test;

public class Statyczne {

    public static int DwumianNewtona(int n, int k) {

        if (k != 0)
            return silnia(n) / (silnia(k) * silnia(n - k));
        else {
            return 1;
        }
    }
    public static int silnia(int x){
        if(x<1){
            return 1;
        }
        else{
            return x * silnia(x-1);
        }
    }

}

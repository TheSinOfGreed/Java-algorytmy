package test;

abstract class Game {
    public final void run() {
        initialize();
        while(!gameOver()) {
            makeMoves();
            paintScreen();
        }
        onEnd();
    }

    abstract void initialize();
    abstract boolean gameOver();
    abstract void paintScreen();
    abstract  void onEnd();
    abstract void makeMoves();

}

package gameapp;

public class GameApp {
    public static void main(String[] args) {
        Game guessGame = new GuessingGame(100);

        guessGame.play();
    }
}

package gameapp;

import java.util.Scanner;

/**
 * The type Guessing game.
 */
public class GuessingGame implements Game {

    private int randNumber;
    private int guessCount;

    /**
     * Instantiates a new Guessing game.
     *
     * @param range the range
     */
    public GuessingGame (int range) {
        this.randNumber = getRandNumber(range);
        this.guessCount = 0;
    }

    /**
     * Get rand number int.
     *
     * @param range the range
     * @return the int
     */
    public int getRandNumber(int range){
        return (int) (Math.random() * range);
    }


    @Override
    public void play() {
        Scanner in = new Scanner(System.in);
        int guess;
        do {
            System.out.println("\nEnter a number to make a guess: ");
            guess = in.nextInt();
            guessCount++;

            if (guess > randNumber) {
                System.out.printf("\n%d is greater than the number:\n", guess);
            } else if (guess < randNumber){
                System.out.printf("\n%d is less than the number:\n", guess);
            }

        } while (guess != randNumber);

        System.out.println("CONGRATS!!! You managed to get the correct number with the guess " + guess + ", the " +
                           "random number was: " + randNumber + ", you manged to get this number with " + guessCount + " amounts of guesses.");

        if (playAgain()) play();
    }

    @Override
    public boolean playAgain() {
        Scanner in = new Scanner(System.in);
        System.out.println("""
                ------------------------------
                Do you want to play again?:\s
                1) yes
                2) no
                Enter a number:\s""");
        int response = in.nextInt();
        if (response == 1) {
            System.out.flush();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets rand number.
     *
     * @return the rand number
     */
    public int getRandNumber() {
        return randNumber;
    }

    /**
     * Gets guess count.
     *
     * @return the guess count
     */
    public int getGuessCount() {
        return guessCount;
    }

    /**
     * Sets rand number.
     *
     * @param randNumber the rand number
     */
    public void setRandNumber(int randNumber) {
        this.randNumber = randNumber;
    }

    /**
     * Regen rand number.
     *
     * @param range the range
     */
    public void regenRandNumber(int range) {
        this.randNumber = getRandNumber(range);
    }

    /**
     * Sets guess count.
     *
     * @param guessCount the guess count
     */
    public void setGuessCount(int guessCount) {
        this.guessCount = guessCount;
    }
}

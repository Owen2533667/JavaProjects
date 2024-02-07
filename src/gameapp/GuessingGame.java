package gameapp;

import java.util.Scanner;


/**
 * A guessing game where the user attempts to guess a randomly generated number within a specified range. The game
 * initialises with the range provided to the constructor and sets the guess count to 0. To play the game, instantiate
 * a GuessingGame object and use the play() method. The game continues until the correct number is guessed, displaying
 * the results and prompting the user to play again.
 * <p>
 * This class implements the Game interface and provides implementations for the play() and playAgain() methods.
 *
 * @author owenhughes
 * @version 0.1
 * @see gameapp.Game
 */
public class GuessingGame implements Game {

    private int randNumber;
    private int guessCount;
    private Scanner scanner;

    /**
     * Instantiates a new Guessing game. accepts one parameter  called range, this will be used to create a
     * random number between 0 and range and stored in the attribute randNumber. Guess count will be 0.
     *
     * @param range the range which a random number will be generated (0 to range)
     */
    public GuessingGame (int range) {
        this.randNumber = getRandNumber(range);
        this.guessCount = 0;
        this.scanner = new Scanner(System.in);
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

    /**
     *The `Play` method, an implementation of the `Game` interface, prompts the user to enter a number as a guess.
     * After entered, the guess counter is incremented by 1 and the guess is then evaluated against the actual
     * number, if this evaluates to false the player will have to continue to enter until the evaluation is true. To
     * help the player, the evaluate method will output whether the guess if greater or less than the actual value.
     *
     * <p>
     *     When the user enters a guess that passed as an argument to evaluateGuess, along with the actual number,
     *     returns true, the user gets the results of the game and is prompted to whether they would like to play again.
     * </p>
     * @implNote This implementation of the `play` method adheres to the `Game` interface
     */
    @Override
    public void play() {
        int guess;
        do {
            System.out.println("\nEnter a number to make a guess: ");
            guess = readIntegerInput();
            guessCount++;
            if(evaluateGuess(guess, randNumber)) {
                System.out.println("CONGRATS!!! You managed to get the correct number with the guess " + guess + ", the " +
                                   "random number was: " + randNumber + ", you manged to get this number with " + guessCount + " amounts of guesses.");
            }
        } while (guess != randNumber);

        if (playAgain()) play();
    }

    /**
     * The `playAgain` method, an implementation of the `Game` interface, prompts the user to decide whether they want to play again.
     * If the user enters '1', indicating their desire to play again, the method generates a new random number using `regenRandNumber()`
     * and resets the guess count to zero using `resetCount()`.
     *
     * <p>Depending on the user's response, the method returns `true` (if the player wants to play again) or `false` (if not).</p>
     *
     * @return `true` if the player input is '1', otherwise `false`
     * @implNote This implementation of the `playAgain` method adheres to the `Game` interface.
     */
    @Override
    public boolean playAgain() {
        System.out.println("""
                ------------------------------
                Do you want to play again?:\s
                1) yes
                2) no
                Enter a number:\s""");
        int response = readIntegerInput();
        if (response == 1) {
            System.out.flush();
            regenRandNumber(100); //regenerate random number.
            resetCount(); // reset the guess count.
            return true;
        } else {
            return false;
        }
    }

    /**
     * Evaluates the guess against the correct number and provides feedback.
     *
     * @param guess      the guess made by the user
     * @param correctNum the correct number to be guessed
     * @return true if the guess is correct, false otherwise
     */
    public boolean evaluateGuess(int guess, int correctNum){
        if (guess > correctNum) {
            System.out.printf("\n%d is greater than the number:\n", guess);
        } else if (guess < correctNum){
            System.out.printf("\n%d is less than the number:\n", guess);
        }
        return guess == correctNum;
    }

    /**
     * Reads integer input from the user
     * @return int the number typed from the user.
     */
    private int readIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }

    /**
     * Gets the randomly generated number.
     *
     * @return the random number
     */
    public int getRandNumber() {
        return randNumber;
    }

    /**
     * Gets the count of guesses made.
     *
     * @return the guess count
     */
    public int getGuessCount() {
        return guessCount;
    }

    /**
     * Sets the random number.
     *
     * @param randNumber the random number to be set
     */
    public void setRandNumber(int randNumber) {
        this.randNumber = randNumber;
    }

    /**
     * Regenerates a new random number within the specified range.
     *
     * @param range the range for the new random number
     */
    public void regenRandNumber(int range) {
        this.randNumber = getRandNumber(range);
    }

    /**
     * Sets the count of guesses made.
     *
     * @param guessCount the guess count to be set
     */
    public void setGuessCount(int guessCount) {
        this.guessCount = guessCount;
    }

    /**
     * Resets the count of guesses made to 0.
     */
    public void resetCount() {
        this.guessCount = 0;
    }
}

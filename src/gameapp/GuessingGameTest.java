package gameapp;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessingGameTest {
    @Test
    public void testPlay() {
        GuessingGame game = new GuessingGame(100);
        game.setRandNumber(50); // Set a fixed random number for testing
        assertEquals(0, game.getGuessCount()); // Player default guess count should be 0
        assertEquals(50, game.getRandNumber()); // Ensure the random number is set correctly
        assertTrue(game.evaluateGuess(50, game.getRandNumber())); // Evaluates the players guess to the actual number
        assertFalse(game.evaluateGuess(25, game.getRandNumber())); // Evaluates the players guess to the actual number
    }

    @Test
    public void testPlayAgain() {
        GuessingGame game = new GuessingGame(100);
        game.setGuessCount(8); // Set guess count to possible end game state for testing
        game.setRandNumber(50); // Set a fixed random number for testing
        assertEquals(8, game.getGuessCount()); // After game has completed
        assertEquals(50, game.getRandNumber()); // Ensure the random number is set correctly
        game.resetCount(); // Once player choices play again guess count should reset to 0
        game.regenRandNumber(100); // Once player choices play again regenerate random number for new game.
        assertEquals(0, game.getGuessCount()); // Ensure that counter has reset to zero.
        assertNotEquals(50, game.getRandNumber()); // Ensure the random number is not the same as before
    }

    @Test
    public void testGetRandNumber() {
        GuessingGame game = new GuessingGame(100);
        int randNumber = game.getRandNumber(100);
        assertTrue(randNumber >= 0 && randNumber < 100); // Ensure that random number is in between range of 0 and 100
    }

    // tests to ensure that the method regenRandNumber() will regenerate a new number.
    @Test
    public void testRegenRandNumber() {
        GuessingGame game = new GuessingGame(100);
        int oldRandNumber = game.getRandNumber();
        game.regenRandNumber(100);
        int newRandNumber = game.getRandNumber();
        assertNotEquals(oldRandNumber, newRandNumber);
    }
}
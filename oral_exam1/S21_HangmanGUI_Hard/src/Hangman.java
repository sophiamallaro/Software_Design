/**
 * Hangman.java - This class runs the logic behind the hangman game.
 * @author Sophia Mallaro
 * @see Hangman
 */

import java.util.Arrays;

public class Hangman {
    private String word;
    private char[] progress;
    private String incorrect;
    private int guessesRemaining;

    /**
     * This constructor takes in a word to be guessed and checks it's validity. Only
     * letters are allowed. The game is case-insensitive so words are converted to all lower case.
     * The constructor creates a new progress array and enters asteriks for each value. It also sets
     * guesses remaining to six. If the word is invalid, an IllegalArgumentException is thrown.
     * @param word The word to be guessed
     */
    Hangman(String word) {
        if(checkValidity(word)) {
            this.word = word.toLowerCase();
            progress = new char[word.length()];
            Arrays.fill(progress, '*');
            incorrect = "";
            guessesRemaining = 6;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This is a private class used to check the validity of the inputted word
     * @param word The word to be guessed
     * @return Returns true if the word is valid, false if it is not.
     */
    private boolean checkValidity(String word) {
        for(int i=0; i<word.length(); i++) {
            if(!Character.isLetter(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called to make a guess. If the guess is successful, it changes the progress array to contain the
     * now known letter. If not, it adds the letter to the list of incorrect letters and subtracts from the
     * number of guesses remaining.
     * @param letter The letter to be guessed
     * @return Returns true if the letter was a successful guess, false if not
     */
    public boolean guess(char letter) {
        boolean changed = false;
        for(int i=0; i<word.length(); i++) {
            if(word.charAt(i) == letter) {
                setProgressCharacters(i, letter);
                changed = true;
            }
        }
        if(changed) { return true; }
        else {
            incorrect += letter + " ";
            guessesRemaining--;
            return false;
        }
    }

    /**
     * This method is used by guess to add the successful guess to the progress array.
     * @param position Position in the progress array to add the letter.
     * @param letter The letter to be added.
     */
    private void setProgressCharacters (int position, char letter) {
        progress[position] = letter;
    }

    /**
     * This method returns the progress array, which displays the place of known letters.
     * @return The progress array
     */
    public String getProgress() {
        return (new String(progress));
    }

    /**
     * This method returns the letters that were incorrectly guessed
     * @return The string of incorrect letters
     */
    public String getIncorrect() {
        return incorrect;
    }

    /**
     * This method returns the word being guessed
     * @return The word being guessed
     */
    public String getWord() {
        return word;
    }

    /**
     * This method returns the number of guesses remaining
     * @return Number of guesses remaining
     */
    public int getGuessesRemaining() {
        return guessesRemaining;
    }

    /**
     * This method checks if the full word has been correctly guessed
     * @return Returns true if the full word is correct, else returns false
     */
    public boolean checkCorrect() {
        for(int i=0; i<progress.length; i++) {
            if(progress[i] == '*') return false;
        }
        return true;
    }

    /**
     * This method checks if a method is valid by checking if it is a letter and
     * whether it has already been guessed
     * @param c Character to be tested for validity
     * @return Returns true if it is a valid guess, else returns false
     */
    public boolean checkGuess(char c) {
        if(Character.isLetter(c)) {
            for(int i=0; i<incorrect.length(); i++) {
                if(c == incorrect.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
        else return false;
    }

}

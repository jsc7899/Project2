/*  * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data.
 * Jared Campbell
 * jsc3642
 * Slip days used: 0
 * Fall 2018
 */
package assignment2;

import java.util.ArrayList;

public class GameConfiguration {
    public static final int guessNumber = 12;
    public static final String[] colors = {"B","G","O","P","R","Y"};
    public static final int pegNumber = 4;
    public final String secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
    public int remainingGuesses = guessNumber;
    public int numWhitePegs = 0;
    public int numBlackPegs = 0;
    public ArrayList<String> history = new ArrayList<String>();
}

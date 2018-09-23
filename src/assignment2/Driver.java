/*  * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data.
 * Jared Campbell
 * jsc3642
 * Slip days used: 0
 * Fall 2018
 */
package assignment2;

public class Driver {
    public static void main(String[] args) {
        Game game;
        if (args.length > 0 && args[0].equals("1")) {
            game = new Game(true);
        } else {
            game = new Game(false);
        }
        game.initializeGame();
    }
}

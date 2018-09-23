/*  * EE422C Project 2 (Mastermind) submission by
 * Replace <...> with your actual data.
 * Jared Campbell
 * jsc3642
 * Slip days used: 0
 * Fall 2018
 */
package assignment2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    private boolean testing;
    private GameConfiguration aGame;
    private static Scanner scanner = new Scanner( System.in);
    Game(boolean arg) {
        testing = arg;
    }
    public void initializeGame() {
        System.out.println("Welcome to Mastermind.");
        while(true) {
            System.out.println("Do you want to play a new game? (Y/N):");
            String input = scanner.nextLine();
            aGame = new GameConfiguration();
            if (input.equals("Y") || input.equals("y")) {
                if (testing) {
                    System.out.println("Secret code: " + aGame.secretCode);
                    System.out.println();
                }
                if (runGame()) {
                    System.out.println("You win!");
                    System.out.println();
                } else {
                    System.out.println("You lose! The pattern was " + aGame.secretCode);
                    System.out.println();
                }
            } else {
                return;
            }
        }
    }
    private boolean runGame() {
        while(aGame.remainingGuesses > 0) {
            System.out.println("You have " + aGame.remainingGuesses + " guess(es) left.");
            System.out.println("Enter guess:");
            String input = scanner.nextLine();
            if(analyzeGuess(input)) {
                System.out.println(input + " -> " + aGame.numBlackPegs + "b_" + aGame.numWhitePegs + "w");
                aGame.history.add(input + " -> " + aGame.numBlackPegs + "b_" + aGame.numWhitePegs + "w");
                if(aGame.numBlackPegs == GameConfiguration.pegNumber) {
                    return true;
                }
                aGame.remainingGuesses--;
            }
        }
        return false;
    }
    private boolean analyzeGuess(String input) {
        if(!validateInput(input)) {
            System.out.println("INVALID_GUESS");
            System.out.println();
            return false;
        }
        if(input.equals("HISTORY")) return false;

        char[] inputArray = input.toCharArray();
        aGame.numBlackPegs = 0;
        aGame.numWhitePegs = 0;
        for(int i = 0; i < input.length(); i++) {
            if (aGame.secretCode.charAt(i) == inputArray[i]) {
                aGame.numBlackPegs++;
            } else if(aGame.secretCode.indexOf(inputArray[i]) > 0) {
                aGame.numWhitePegs++;
            }
        }
        return true;
    }
    private boolean validateInput(String input) {
        char[] inputArray = input.toCharArray();
        if (input.length() != GameConfiguration.pegNumber) { // check length of guess
            if(input.equals("HISTORY")) {
                for(int i = 0; i < aGame.history.size(); i++) {
                    System.out.println(aGame.history.get(i));
                }
                System.out.println();
                return true;
            }
            return false;
        }
        int flag = 0;
        for(int i = 0; i < input.length(); i++) {
            for (int j = 0; j < GameConfiguration.colors.length; j++) {
                if (GameConfiguration.colors[j].equals(String.valueOf(inputArray[i]))) {
                    flag++;
                }
            }
        }
        if(flag == input.length()) return true;
        else return false;
    }
}

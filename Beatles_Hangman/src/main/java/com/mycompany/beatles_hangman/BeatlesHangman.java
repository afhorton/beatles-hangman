/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hangman;

/**
 *
 * @author allenhorton
 */

import java.util.Scanner;
public class Hangman {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] words = {"John", "Paul", "Ringo", "George"};
        String wordToGuess = words[(int)(Math.random() * words.length)];
        String hiddenWord = new String(new char[wordToGuess.length()]).replace("\0","_");
        int wrongGuesses = 0;
        
        System.out.println("Welcome to Beatles Hangman!  Guess the "
                + "first name of the hidden Beatle and win!");
        
        while (wrongGuesses < 6) {
            System.out.println("Guess a letter in the name: " + hiddenWord);
            String guess = scanner.nextLine();
            
            if (wordToGuess.contains(guess)) {
                //update hideenWord to show the guessed letter(s)
                char[] hiddenWordChars = hiddenWord.toCharArray();
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess.charAt(0)) {
                        hiddenWordChars[i] = guess.charAt(0);
                    }
                }
                hiddenWord = new String(hiddenWordChars);
                if (hiddenWord.equals(wordToGuess)) {
                    System.out.println("Bingo!  You guessed the Beatle: "
                    + wordToGuess);
                    break;
                }
                } else {
                    wrongGuesses++;
                    System.out.println("Oops.  You have " + (6 - wrongGuesses) 
                    + " tries left.");
                }
                
                }
            if (wrongGuesses == 6) {
                System.out.println("Oof! Sorry, the Beatle was " + wordToGuess);
            }
           scanner.close();
        }
}

    

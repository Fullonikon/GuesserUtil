package ru.ncedu.guesser;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Guesser {

    public static void main(String[] args) {
        System.out.println();
        ArrayList<String> words = new ArrayList<String>();
        try {
            FileInputStream in = new FileInputStream("./src/ru/ncedu/guesser/words.txt");
            Scanner scr = new Scanner(in);
            while (scr.hasNext())words.add(scr.next());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




        int wnum = (int) (Math.random() * words.size()); // number of the word taken

        int guessnum = 1; // number of guesses
        Word word = new Word(words.get(wnum));
        while (!word.checkWhole()){
            System.out.print("Key in one character or your guess word: ");
            Scanner scn = new Scanner(System.in); // Ввод попытки
            String text = scn.nextLine().trim();
            if (text.length() == 1){ // check if only one character
                word.checkChar(text.charAt(0));
                System.out.println("Trial " + guessnum + ": " + word.print());
                guessnum++;
            }
            else {
                if(word.checkWord(text)){ // won because got the word
                    System.out.println("Congratulation!");
                    System.out.println("You got in " + guessnum + " trials");
                    break;
                }
                else { // Lost because didn't get the word
                    System.out.println("You've lost in " + guessnum + " trials");
                    break;
                }
            }
            if (word.checkWhole()){ // won if all characters are guessed
                System.out.println("Congratulation!");
                System.out.println("You got in " + guessnum + " trials");
            }
        }


    }
}

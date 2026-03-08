package com.Group1;
import com.Group1.dictionary.BookwormDictionary;
import com.Group1.dictionary.Dictionary;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static void main() {
        InputWord();
    }
    static void InputWord(){

        try {
            // Load sowpods.txt from the resources folder
            InputStream dictStream = Main.class.getResourceAsStream("/sowpods.txt");
            if (dictStream == null) {
                System.err.println("Dictionary file not found in resources!");
                return;
            }
            Dictionary dictionary = new BookwormDictionary(dictStream);


            // Simple game loop
            System.out.println("Enter a word (or '$quit'):");
            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("$quit")) break;

                if (dictionary.isValidWord(input)) {
                    int score = dictionary.getWordScore(input);
                    System.out.println("Valid! Score: " + score);



                } else {
                    System.out.println("Not a valid word.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading dictionary: " + e.getMessage());
        }
    }
}
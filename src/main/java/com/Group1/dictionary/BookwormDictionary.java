package com.Group1.dictionary;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class BookwormDictionary extends Dictionary {
    private static final int MIN_WORD_LENGTH = 3;
    private static final Map<Character, Integer> SCORES = new HashMap<>();

    static {
        // Set default score of 1 for all letters
        for (char c = 'a'; c <= 'z'; c++) {
            SCORES.put(c, 1);
        }
        // Override with higher scores
        SCORES.put('b', 3);SCORES.put('c', 3);SCORES.put('d', 2);SCORES.put('f', 4);SCORES.put('g', 2);SCORES.put('h', 4);
        SCORES.put('j', 8);SCORES.put('k', 5);SCORES.put('m', 3);SCORES.put('p', 3);SCORES.put('q', 10);SCORES.put('v', 4);
        SCORES.put('w', 4);SCORES.put('x', 8);SCORES.put('y', 4);SCORES.put('z', 10);
    }

    public BookwormDictionary(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    @Override
    public boolean isValidWord(String word) {
        if (word == null || word.length() < MIN_WORD_LENGTH) return false;
        return isWordInDictionary(word);
    }

    @Override
    public int getWordScore(String word) {
        if (!isValidWord(word)) return 0;
        int score = 0;
        for (char c : word.toLowerCase().toCharArray()) {
            score += SCORES.getOrDefault(c, 1);
        }
        // Bonus for longer words
        if (word.length() >= 6) score += 10;
        return score;
    }
}
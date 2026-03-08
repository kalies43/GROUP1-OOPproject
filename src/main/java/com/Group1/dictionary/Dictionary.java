package com.Group1.dictionary;

import java.io.*;
import java.util.*;

public abstract class Dictionary {
    protected final Set<String> wordSet;
    /**
     * Loads dictionary from an InputStream (e.g., from resources).
     */
    public Dictionary(InputStream inputStream) throws IOException {
        wordSet = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                String word = line.trim().toLowerCase();
                if (!word.isEmpty()) {
                    wordSet.add(word);
                }
            }
        }
    }

    public boolean isWordInDictionary(String word) {
        if (word == null) return false;
        return wordSet.contains(word.trim().toLowerCase());
    }




    // Abstract methods for game-specific logic
    public abstract boolean isValidWord(String word);
    public abstract int getWordScore(String word);
}
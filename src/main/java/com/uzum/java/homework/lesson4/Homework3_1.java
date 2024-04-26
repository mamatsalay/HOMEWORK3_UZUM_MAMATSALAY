package com.uzum.java.homework.lesson4;


import java.util.HashMap;
import java.util.Map;

public class Homework3_1 {
    public static Map<String, Integer> countWords(String text) {

        // method converts all words in to lower case for case-insensitivity
        text = text.toLowerCase();

        // method replaces all punctual characters with space
        text = text.replaceAll("\\p{Punct}", " ");

        // method splits the text into words based on whitespace
        String[] words = text.split("\\s+");

        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }

        return wordCounts;
    }
}


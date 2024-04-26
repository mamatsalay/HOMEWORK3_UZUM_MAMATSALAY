package com.uzum.java.homework.lesson4;


import com.uzum.java.homework.lesson4.resourceHomework3_1;
import java.util.HashMap;
import java.util.Map;

public class Homework3_1 {


    public static void main(String[] args) {
        String text = resourceHomework3_1.TEXT;

        Map<String, Integer> wordCounts = countWords(text);


        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    public static Map<String, Integer> countWords(String text) {

        text = text.toLowerCase();
        text = text.replaceAll("\\p{Punct}", "");
        text = text.replaceAll("—", "");
        String[] words = text.split("\\s+");

        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            int count = wordCounts.getOrDefault(word, 0);
            wordCounts.put(word, count + 1);
        }

        return wordCounts;
    }
}


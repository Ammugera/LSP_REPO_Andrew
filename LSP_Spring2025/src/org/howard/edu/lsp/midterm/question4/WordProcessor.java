package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * This class process a sentence and returns all longest words
 * It splits the sentence and finds words with maximum length
 */
public class WordProcessor {
    private String sentence;

    /**
     * Constructor to set the sentence
     * @param sentence the sentence to be processed
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds and returns a list of all longest words in the sentence
     * If the sentence is empty, it returns an empty list
     * @return list of longest words
     */
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        if(sentence == null || sentence.trim().isEmpty()){
            return longestWords;
        }
        // split sentence on one or more spaces
        String[] words = sentence.split("\\s+");
        int maxLength = 0;

        // find maximum length of words
        for(String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "");
            if(cleanWord.length() > maxLength){
                maxLength = cleanWord.length();
            }
        }

        // add all words with max length
        for(String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "");
            if(cleanWord.length() == maxLength && !cleanWord.isEmpty()){
                longestWords.add(cleanWord);
            }
        }
        return longestWords;
    }
}
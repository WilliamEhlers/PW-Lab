package main;

import java.io.*;
import java.util.*;

public class TextProcessor {
    private final Set<String> stopWords;

    // Constructor that receives the path of the stop words file
    public TextProcessor(String stopWordsFilePath) {
        this.stopWords = loadStopWords(stopWordsFilePath);
    }

    // Method to load stopwords
    private Set<String> loadStopWords(String stopWordsFilePath) {
        Set<String> stopWords = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(stopWordsFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                stopWords.add(line.trim().toLowerCase()); // Add each stop word to the set
            }
            System.out.println("Stop words correctly loaded from file");
        } catch (IOException e) {
            System.err.println("Error loading stop words: " + e.getMessage());
        }
        return stopWords;
    }

    // Method to process a file and return filtered words (ignores stopwords)
    public List<String> processFileForUnique(File file) {
        List<String> filteredWords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    word = word.toLowerCase();
                    if (!stopWords.contains(word) && !word.isEmpty()) {
                        filteredWords.add(word);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error processing file: " + file.getName());
        }
        return filteredWords;  // Return the filtered words
    }
}

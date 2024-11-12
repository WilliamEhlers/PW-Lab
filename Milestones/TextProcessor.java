package main;

import java.io.*;
import java.util.*;

public class TextProcessor {
    private final Set<String> stopWords;
    private final Set<String> positiveWords;
    private final Set<String> negativeWords;

    // Constructor that loads stopwords, positive, and negative words
    public TextProcessor(String stopWordsFilePath, String positiveWordsFilePath, String negativeWordsFilePath) {
        this.stopWords = loadWordsFromFile(stopWordsFilePath);
        this.positiveWords = loadWordsFromFile(positiveWordsFilePath);
        this.negativeWords = loadWordsFromFile(negativeWordsFilePath);
    }

    private Set<String> loadWordsFromFile(String filePath) {
        Set<String> words = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            System.err.println("Error loading words from " + filePath + ": " + e.getMessage());
        }
        return words;
    }

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
        return filteredWords;
    }

    public Map<String, Integer> analyzeTone(List<String> words) {
        int positiveCount = 0;
        int negativeCount = 0;

        for (String word : words) {
            if (positiveWords.contains(word)) {
                positiveCount++;
            } else if (negativeWords.contains(word)) {
                negativeCount++;
            }
        }

        Map<String, Integer> toneCounts = new HashMap<>();
        toneCounts.put("positive", positiveCount);
        toneCounts.put("negative", negativeCount);
        return toneCounts;
    }
}

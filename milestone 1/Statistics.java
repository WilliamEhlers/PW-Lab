import java.util.*;

public class Statistics {
    private final Map<String, Integer> wordFrequencies;

    // Constructor that receives the list of filtered words
    public Statistics(List<String> filteredWords) {
        wordFrequencies = new HashMap<>();
        calculateWordFrequencies(filteredWords);
    }

    // Method to calculate word frequencies
    private void calculateWordFrequencies(List<String> words) {
        for (String word : words) {
            wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
        }
    }

    // Method to display statistics with ranked words
    public void displayStatistics() {
        System.out.println("Word Frequencies (Ranked): ");

        // Create a list of word-frequency pairs and sort by frequency in descending order
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordFrequencies.entrySet());
        sortedWords.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Display the sorted word frequencies
        for (Map.Entry<String, Integer> entry : sortedWords) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Total Unique Words: " + getUniqueWordCount());
        System.out.println("Total Words in file : " + getTotalWordCount());
    }

    // Method to get total word count
    public int getTotalWordCount() {
        return wordFrequencies.values().stream().mapToInt(Integer::intValue).sum();
    }

    // Method to get unique word count
    public int getUniqueWordCount() {
        return wordFrequencies.size();
    }

    // Method to get the frequency of a specific word
    public int getWordFrequency(String word) {
        return wordFrequencies.getOrDefault(word, 0);
    }
}
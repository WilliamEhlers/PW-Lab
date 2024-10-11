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
            System.err.println("Error loading stop words: " + e.getMessage()); // Print error if any
        }
        return stopWords;
    }

    // Method to process all files in a directory
    public void processFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    processFile(file);
                }
            }
        }
    }

    // Method to process a single file
    public void processFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            List<String> filteredWords = new ArrayList<>();
            Set<String> foundStopWords = new HashSet<>();  // Set to store found stop words

            System.out.println("Processing file: " + file.getName());

            //method that prof. showed with for loop
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    word = word.toLowerCase();
                    if (!stopWords.contains(word)) {
                        filteredWords.add(word);
                    } else {
                        foundStopWords.add(word);
                    }
                }
            }

            // Display the number of unique stop words found in the file
            System.out.println("Number of  stop words found: " + foundStopWords.size());

            Statistics stats = new Statistics(filteredWords);
            stats.displayStatistics();

        } catch (IOException e) {
            System.err.println("Error processing file: " + file.getName());
        }
    }
}

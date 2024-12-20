package main;

import java.io.File;
import java.util.*;

public class unique {

   public static void main(String[] args) {
      String directoryPath = "C:\\Users\\savag\\Computer Science\\src\\Programming Workshop Lab\\environment";
      String stopWordsFilePath = "C:\\Users\\savag\\IdeaProjects\\ProjMilestone2\\src\\stopwords.txt";
      String positiveWordsFilePath = "C:\\Users\\savag\\IdeaProjects\\ProjMilestone2\\src\\positivewords.txt";
      String negativeWordsFilePath = "C:\\Users\\savag\\IdeaProjects\\ProjMilestone2\\src\\negativewords.txt";

      File directory = new File(directoryPath);

      if (directory.isDirectory()) {
         File[] files = directory.listFiles();

         if (files != null && files.length > 0) {
            TextProcessor processor = new TextProcessor(stopWordsFilePath, positiveWordsFilePath, negativeWordsFilePath);

            for (File file : files) {
               if (file.isFile()) {
                  System.out.println("Processing file: " + file.getName());
                  List<String> filteredWords = processor.processFileForUnique(file);
                  Statistics stats = new Statistics(filteredWords);

                  // Display most repeated words
                  System.out.println("Most Repeated Words in " + file.getName() + ":");
                  stats.displayStatistics();

                  // Analyze tone
                  Map<String, Integer> toneCounts = processor.analyzeTone(filteredWords);
                  int positiveCount = toneCounts.get("positive");
                  int negativeCount = toneCounts.get("negative");

                  System.out.println("Positive words count: " + positiveCount);
                  System.out.println("Negative words count: " + negativeCount);

                  String tone = positiveCount > negativeCount ? "Positive" : "Negative";
                  System.out.println("Overall tone for " + file.getName() + ": " + tone);
                  System.out.println();
               }
            }
         } else {
            System.out.println("No files found in the directory.");
         }
      } else {
         System.out.println("Invalid directory.");
      }
   }
}

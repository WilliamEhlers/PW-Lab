package main;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String directoryPath = "C:\\Users\\billy\\OneDrive\\Documents\\PW-Lab-main\\main\\files project";
        String stopWordsFilePath = "C:\\Users\\billy\\OneDrive\\Documents\\PW-Lab-main\\main\\stopwords.txt";
        String positiveWordsFilePath = "C:\\Users\\billy\\OneDrive\\Documents\\PW-Lab-main\\main\\positivewords.txt";
        String negativeWordsFilePath = "C:\\Users\\billy\\OneDrive\\Documents\\PW-Lab-main\\main\\negativewords.txt";
        
        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null && files.length > 0) {  
                System.out.println("Which file do you want to read?");
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isFile()) {
                        System.out.println((i + 1) + ": " + files[i].getName());
                    }
                }

                Scanner scanner = new Scanner(System.in);
                System.out.print("Please select the number of the file that you want to use: ");
                int choice = scanner.nextInt();

                if (choice > 0 && choice <= files.length && files[choice - 1].isFile()) {
                    File selectedFile = files[choice - 1];
                    System.out.println("You have selected: " + selectedFile.getName());

                    TextProcessor processor = new TextProcessor(stopWordsFilePath, positiveWordsFilePath, negativeWordsFilePath);
                    
                    List<String> filteredWords = processor.processFileForUnique(selectedFile);
                    Statistics stats = new Statistics(filteredWords);
                    stats.displayStatistics();

                    var toneCounts = processor.analyzeTone(filteredWords);
                    System.out.println("Positive words count: " + toneCounts.get("positive"));
                    System.out.println("Negative words count: " + toneCounts.get("negative"));
                    
                    String tone = toneCounts.get("positive") > toneCounts.get("negative") ? "Positive" : "Negative";
                    System.out.println("Overall tone for " + selectedFile.getName() + ": " + tone);

                } else {
                    System.out.println("Invalid selection.");
                }

                scanner.close();
            } else {
                System.out.println("There are no files in this folder.");
            }

        } else {
            System.out.println("That is not a valid directory.");
        }
    }
}

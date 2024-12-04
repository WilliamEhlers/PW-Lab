package main;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int y=0;
        Scanner sc=new Scanner(System.in);
        String directoryPath="";
        while(y>=0) {
            System.out.println("Select a topic that you would like to read articles for.");
            System.out.println("1. environment");
            System.out.println("2. science");
            System.out.println("3. social studies");
            y = sc.nextInt();
            if (y == 1) {
                directoryPath = "C:\\Users\\savag\\Computer Science\\src\\Programming Workshop Lab\\environment";
                break;
            } else if (y == 2) {
                directoryPath = "C:\\Users\\savag\\Computer Science\\src\\Programming Workshop Lab\\science";
                break;
            } else if (y == 3) {
                directoryPath = "C:\\Users\\savag\\Computer Science\\src\\Programming Workshop Lab\\social studies";
                break;
            } else {
                System.out.println("Please select a valid option!");
            }
        }
        String stopWordsFilePath = "C:\\Users\\savag\\IdeaProjects\\ProjMilestone2\\src\\stopwords.txt";
        String positiveWordsFilePath = "C:\\Users\\savag\\IdeaProjects\\ProjMilestone2\\src\\positivewords.txt";
        String negativeWordsFilePath = "C:\\Users\\savag\\IdeaProjects\\ProjMilestone2\\src\\negativewords.txt";

        System.out.println("Would you like to add a new file?(Please enter 'yes' or 'no')");
        String response = sc.next();
        if(response.equals("yes")) {
            System.out.println("Please enter the path to the folder of text files that you would like to add");
            String newFile = sc.next();
        }

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null && files.length > 0) {
                System.out.println("Available files:");
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isFile()) {
                        System.out.println((i + 1) + ": " + files[i].getName());
                    }
                }



                Scanner scanner = new Scanner(System.in);

                // Select two files for comparison
                System.out.print("Select the number of the first file to analyze: ");
                int choice1 = scanner.nextInt();
                System.out.print("Select the number of the second file to analyze: ");
                int choice2 = scanner.nextInt();

                if (choice1 > 0 && choice1 <= files.length && choice2 > 0 && choice2 <= files.length) {
                    File file1 = files[choice1 - 1];
                    File file2 = files[choice2 - 1];

                    TextProcessor processor = new TextProcessor(stopWordsFilePath, positiveWordsFilePath, negativeWordsFilePath);

                    // Process the first file with statistics
                    System.out.println("\nProcessing " + file1.getName());
                    List<String> words1 = processor.processFileForUnique(file1);
                    Statistics stats1 = new Statistics(words1);
                    stats1.displayStatistics();

                    var toneCounts1 = processor.analyzeTone(words1);
                    System.out.println("Positive words count for " + file1.getName() + ": " + toneCounts1.get("positive"));
                    System.out.println("Negative words count for " + file1.getName() + ": " + toneCounts1.get("negative"));

                    // Process the second file with statistics
                    System.out.println("\nProcessing " + file2.getName());
                    List<String> words2 = processor.processFileForUnique(file2);
                    Statistics stats2 = new Statistics(words2);
                    stats2.displayStatistics();

                    var toneCounts2 = processor.analyzeTone(words2);
                    System.out.println("Positive words count for " + file2.getName() + ": " + toneCounts2.get("positive"));
                    System.out.println("Negative words count for " + file2.getName() + ": " + toneCounts2.get("negative"));

                    // Compare the positive tone counts
                    String morePositiveFile = toneCounts1.get("positive") > toneCounts2.get("positive") ? file1.getName() : file2.getName();
                    System.out.println("\nThe file with a more positive attitude is: " + morePositiveFile);

                } else {
                    System.out.println("Invalid selection.");
                }
                scanner.close();
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory.");
        }
    }
}

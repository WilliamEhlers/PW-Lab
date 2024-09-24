import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        
        String directoryPath = "path";
        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            TextProcessor processor = new TextProcessor();
            processor.processFiles(directory);

        } else {
            System.out.println("No valid directory");
        }
    }
}

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Path a la carpeta con los archivos de texto y las stop words
        String directoryPath = "C:\\Users\\Viktor\\Desktop\\FAIRFIELD\\JUNIOR\\PRIMER TRIMESTTRE\\PROGRAMMING WORKSHOP LAB\\files project\\";
        String stopWordsFilePath = "C:\\Users\\Viktor\\Desktop\\FAIRFIELD\\JUNIOR\\PRIMER TRIMESTTRE\\PROGRAMMING WORKSHOP LAB\\stopwords.txt";  // Ajustar la ruta del archivo de stop words
        File directory = new File(directoryPath);

        // Checks directory
        if (directory.isDirectory()) {
            // shows all the files
            File[] files = directory.listFiles();
            if (files != null && files.length > 0) {  // check if there are files
                System.out.println("Which file do you want to read? :");
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
                    System.out.println("You have selected:  " + selectedFile.getName());


                    TextProcessor processor = new TextProcessor(stopWordsFilePath);
                    processor.processFile(selectedFile);  // only file that we selected

                } else {
                    System.out.println("Non-Valid selection.");
                }

                scanner.close();
            } else {
                System.out.println("There is no files in this folder: .");
            }

        } else {
            System.out.println("That is not a valid directory.");
        }
    }
}

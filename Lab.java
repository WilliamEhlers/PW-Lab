import java.io.*;
public class Lab {
    public static void main(String[] args) {
        File file = new File("wolf.txt");
        File file2 = new File("dino.txt");
        File file3 = new File("orcas.txt");
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String st;
            while ((st = br.readLine()) != null) {
                System.out.println(st);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}

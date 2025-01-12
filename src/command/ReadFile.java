package command;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile{

    public static List<String> readFile(String filePath){
        List<String> lines = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader( filePath));
            String line = null;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("ccat: " + filePath + ": No such file or directory");
        } catch (IOException e) {
            System.err.println("ccat: " + filePath + ": An error occurred while reading the file");
        }
            return lines;
    } 

    public static void readFromStdin()  {
        try {
            System.out.println("Reading from stdin. Type input and press Ctrl+D (Linux/Mac) or Ctrl+Z (Windows) to finish:");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                scanner.close();
            }
        } catch (Exception e) {
            System.err.println("Error reading from stdin: " + e.getMessage());
        }
    }

    public static void readFromFile(String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("ccat: " + fileName + ": No such file or directory");
        } catch (IOException e) {
            System.err.println("ccat: " + fileName + ": An error occurred while reading the file");
        }
    }
}
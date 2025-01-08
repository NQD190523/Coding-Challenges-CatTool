
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CCat {
    public static void main(String[] args) {
        if(args.length == 0){
            readFromStdin();
        } else {
            if(args[0].contains("-")){
                int lineNumber = Integer.parseInt(String.valueOf(args[0].charAt(2)));
                String fileName = args[1];
                readFirstLine(fileName,  lineNumber);
            } else if(args instanceof String[]){
                for(String fileName : args){
                    readFromFile(fileName);
                }
            } else {
                readFromFile(args[0]);
                }
            }
        }

    public static void readFromStdin(){
        System.out.println("Reading from stdin. Type input and press Ctrl+D (Linux/Mac) or Ctrl+Z (Windows) to finish:");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
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

    public static void readFirstLine(String fileName, Integer lineNumber) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
            int currentLine = 0;
            String line = null;
            while ((line = reader.readLine()) != null && currentLine <  lineNumber ){
                System.out.println(line);
                currentLine++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("ccat: " + fileName + ": No such file or directory");
        } catch (IOException e) {
            System.err.println("ccat: " + fileName + ": An error occurred while reading the file");
        }
    }
}

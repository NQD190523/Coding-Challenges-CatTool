package command;

import java.util.Scanner;

public class ReadFromStdin {
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
}

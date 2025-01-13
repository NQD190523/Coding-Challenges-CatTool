package command;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
}
package command;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFromStdin {
    public static List<String> readFromStdin()  {
        List<String> lines = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line ;
            while ((line = reader.readLine()) !=null) {
                lines.add(line);
            }
        } catch (Exception e) {
            System.err.println("Error reading from stdin: " + e.getMessage());
        }
        return lines;
    }
}

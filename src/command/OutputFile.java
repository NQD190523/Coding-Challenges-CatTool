package command;

import java.util.List;

public class OutputFile {

    public static void outputFile( List<String> lines) {
        for ( String line : lines) {
            System.out.println(line);
        }
    }
}

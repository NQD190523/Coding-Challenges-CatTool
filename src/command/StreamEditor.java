package command;

import java.util.ArrayList;
import java.util.List;

public class StreamEditor {
    public static List<String> commandG(List<String> lines) {
        List<String> newLines = new ArrayList<>();
        for (String line : lines) {
            newLines.add(line);
            newLines.add(" ");
        }
        return newLines;
    }
}

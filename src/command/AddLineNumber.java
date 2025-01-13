package command;

import java.util.ArrayList;
import java.util.List;

public class AddLineNumber {

    public static List<String> addLineNumber(List<String> lines, String option, int lineNumber){
        List<String> newLines = new ArrayList<String>();
        if(option.equals("n")){
            for( int i = 1; i <= lineNumber; i++){
                if(!lines.get(i-1).isEmpty()){
                    newLines.add(i + ". " + lines.get(i-1));
                }
            }
        } else if(option.equals("b")){
            int currentLineNumber = 1;
            for( int i = 0; i < lineNumber; i++){
                if(!lines.get(i).isEmpty() && !lines.get(i).startsWith(" ")){
                    newLines.add(currentLineNumber + ". " + lines.get(i));
                    currentLineNumber++;
                } else {
                    newLines.add(lines.get(i));
                }
            }
        }
        return newLines;
    }
}

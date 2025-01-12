package command;

import java.util.List;

public class AddLineNumber {

    public static void addLineNumber(List<String> lines, String option, int lineNumber){
        if(option.equals("n")){
            int currentLine = 1;
            while (currentLine <=  lineNumber ){
                for ( String line : lines ){
                    System.out.println(currentLine +". " + line);
                    currentLine++;
                }
            }
        } else if(option.equals("b")){
            int currentLine = 1;
            while (currentLine <=  lineNumber ){
                for ( String line : lines){
                    System.out.println("/n"+currentLine +". " + line);
                    currentLine++;
                }
            }
        }
    }
}

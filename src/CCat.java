
import java.io.IOException;
import java.util.List;

import command.AddLineNumber;
import command.ReadFile;
import command.ReadFromStdin;

public class CCat {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            ReadFromStdin.readFromStdin();
        } else {
            if(args[0].contains("-")){
                int lineNumber = Integer.parseInt(String.valueOf(args[0].charAt(2)));
                String option = String.valueOf(args[0].charAt(1));
                String fileName = args[1];
                List<String> lines = ReadFile.readFile(fileName);
                AddLineNumber.addLineNumber(lines, option, lineNumber);
            } else if(args instanceof String[]){
                for(String fileName : args){
                    ReadFile.readFile(fileName);
                }
            } else {
                ReadFile.readFile(args[0]);
                }
            }
        }
}

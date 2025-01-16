
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import command.AddLineNumber;
import command.OutputFile;
import command.ReadFile;
import command.ReadFromStdin;
import command.StreamEditor;

public class CCat {
    public static void main(String[] args) throws IOException {

        List<String> lines = new ArrayList<>();

        if(!args[0].contains(".txt")){
            lines = ReadFromStdin.readFromStdin();
        } else {
            if(args[0].contains("-")){
                List<String> requests = new ArrayList<>();
                for(String arg : args){
                    requests.add(arg);
                }
                System.out.println(requests);
                for (String request : requests) {
                    if (request.contains(".txt")) {
                        lines = ReadFile.readFile(request);
                    }
                }

                for (String request : requests) {
                    if(request.contains("sed-G")){
                        lines = StreamEditor.commandG(lines);
                    }
                }

                for (String request : requests) {
                    if(request.startsWith("-")){
                        int lineNumber = Integer.parseUnsignedInt(String.valueOf(request.charAt(2)));
                        String option = String.valueOf(request.charAt(1));
                        System.out.println(option);
                        lines = AddLineNumber.addLineNumber(lines, option, lineNumber);
                    }
                }
            } else if(args instanceof String[]){
                for(String fileName : args){
                    lines = ReadFile.readFile(fileName);
                }
            } else {
                lines = ReadFile.readFile(args[0]);
                }
            }
            OutputFile.outputFile(lines);
        }
}

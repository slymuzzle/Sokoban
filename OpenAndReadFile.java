import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class OpenAndReadFile {
    public static String readFile(String name) {
    String text = "";
        File fileName = new File(name);
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
        text = text + line + "\n"; 
            }
            fileReader.close();
        } catch(IOException ioe) {
            System.out.println("Error. " + ioe);
        }
    return text;
    }
}
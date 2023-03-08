import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {

    public static void main(String[] args) throws IOException {
        try(FileReader fr = new FileReader("xanadu.txt");
            FileWriter fw = new FileWriter("copia2.txt")) {

            int copia;
            while ((copia=fr.read()) != -1){
                fw.write(copia);
            }
        }
    }
}

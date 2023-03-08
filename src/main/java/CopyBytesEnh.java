import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytesEnh {

    public static void main(String[] args) throws IOException {

        try(FileInputStream in = new FileInputStream("xanadu.txt");
            FileOutputStream out = new FileOutputStream("copia.txt")) {
            int copia;
            while ((copia = in.read()) != -1) {
                out.write(copia);
            }
        }
    }
}

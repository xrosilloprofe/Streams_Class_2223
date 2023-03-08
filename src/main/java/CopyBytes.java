import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {

    public static void main(String[] args) throws IOException {
        FileInputStream input = null;
        FileOutputStream output = null;

        try {
            input = new FileInputStream("xanadu.txt");
            output = new FileOutputStream("copia.txt");

            int copia;
            while ((copia = input.read()) != -1) {
                output.write(copia);
            }

        } finally {
            if (input != null)
                input.close();
            if(output != null)
                output.close();
        }

    }

}

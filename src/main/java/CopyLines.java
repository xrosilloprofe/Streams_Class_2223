import java.io.*;

public class CopyLines {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("xanadu.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter("copia3.xml"))) {
            String l;
            while((l=br.readLine())!=null){
                pw.println(l);
            }
        }
    }
}

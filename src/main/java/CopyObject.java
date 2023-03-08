import java.io.*;
import java.math.BigDecimal;

public class CopyObject {
    static final String dataFile = "invoicedata";

    static final BigDecimal[] prices = {
            new BigDecimal("19.99"),
            new BigDecimal("9.99"),
            new BigDecimal("15.99"),
            new BigDecimal("3.99"),
            new BigDecimal("4.99")};
    static final Integer[] units = {12, 8, 13, 29, 50};
    static final String[] descs = {"Java T-shirt",
            "Java Mug",
            "Duke Juggling Dolls",
            "Java Pin",
            "Java Key Chain"};

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        save();
        load();
    }

    private static void save() throws IOException {
        try (ObjectOutputStream oOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (int i = 0; i < prices.length; i++) {
                oOut.writeObject(prices[i]);
                oOut.writeObject(units[i]);
                oOut.writeObject(descs[i]);
            }

        }
    }

    private static void load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream oIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
            BigDecimal price;
            Integer unit;
            String desc;


            while (true) {
                price = (BigDecimal) oIn.readObject();
                unit = (Integer) oIn.readObject();
                desc = (String) oIn.readObject();
                System.out.format("You ordered %d" + " units of %s at $%.2f%n",
                        unit, desc, price);

            }
        } catch (IOException e) {
            //throw new RuntimeException(e);
        }


    }

}



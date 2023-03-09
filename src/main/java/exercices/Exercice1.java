package exercices;

import java.io.IOException;
import java.util.*;

public class Exercice1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Gato> cats = new ArrayList<>();
        String nom;
        int edad;
        for (int i = 0; i < 1; i++) {
            try {
                System.out.print("Introduzca nombre del gato: ");
                nom = sc.next();
                System.out.print("Introduzca la edad del gato: ");
                edad = sc.nextInt();
                cats.add(new Gato(nom, edad));
            } catch (GatoException e) {
                System.err.println("Error gatuno: " + e.getMessage());
                i--;
            } catch (InputMismatchException e) {
                e.printStackTrace();
                sc.nextLine();
                i--;
            }
        }

        try{
            Gato.save(cats,"gatunos");
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Gato> stac = new LinkedList<>();
        try{
            stac = Gato.load("gatunos");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Gato cat:stac) {
            System.out.println(cat);
        }

    }
}

package exercices;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Gato implements Serializable {
    private String nombre;
    private int edad;

    public Gato(String nombre, int edad)  throws GatoException {
        if(nombre.length()<3)
            throw new GatoException("Nombre de gato incorrecto");
        if(edad<0)
            throw new GatoException("Edad del gato incorrecta");
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws GatoException {
        if(nombre.length()<3)
            throw new GatoException("Nombre de gato incorrecto");
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws GatoException {
        this.edad = edad;
        if(edad<0)
            throw new GatoException("Edad del gato incorrecta");
    }


    public static void save(List<Gato> cats, String file) throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(file)))){
            for(Gato cat:cats){
                out.writeObject(cat);
            }
        }
    }

    public static List<Gato> load(String file) throws IOException,ClassNotFoundException {
        try(ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(file)))) {
            List<Gato> cats = new ArrayList<>();
            Gato cat = (Gato) in.readObject();
            while(cat != null){
                cats.add(cat);
                try{
                    cat = (Gato) in.readObject();
                } catch (EOFException e){
                    break;
                }
            }
            return cats;
        }
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}

package Utils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RessorcesManager {
    public static void save(Serializable data, String fileName) throws IOException {
        ObjectOutputStream outputStream=new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
        outputStream.writeObject(data);
    }
    public static Object load(String fileName) throws IOException, ClassNotFoundException {

            ObjectInputStream  inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
            return inputStream.readObject();

    }
    public static void delete(String fileName) {
        try {
            Files.delete(Paths.get(fileName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

package org.example;

import org.example.entity.Item;

import java.io.*;
import java.util.List;

public class FileManager {
    public static void saveToFile(String filename, List<Item> library) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(library);
        } catch (IOException e) {
            System.out.println("Saving to file failed");
        }
    }

    public static List<Item> loadFromFile(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Item>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("InputError", e);
        }
    }
}

package org.example;

import java.util.List;

import static org.example.ScannerManager.scanInRange;

public class Utils {
    public static <T extends Nameable> void show(List<T> elements) {
        for (int i = 0; i < elements.size(); i++) {
            System.out.println((i + 1) + ") " + elements.get(i).getName());
        }
    }

    public static <T extends Nameable> T choose(List<T> elements) {
        show(elements);
        int chosenIndex = scanInRange(1, elements.size()) - 1;
        return elements.get(chosenIndex);
    }
}

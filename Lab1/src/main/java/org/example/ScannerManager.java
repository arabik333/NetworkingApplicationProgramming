package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerManager {
    private static final Logger logger = LogManager.getLogger(ScannerManager.class);
    private static final Scanner scanner = new Scanner(System.in);

    public static String scanString() {
        return scanner.nextLine();
    }

    public static int scanInt() {
        while (true) {
            try {
                String value = scanner.nextLine();
                return Integer.parseInt(value);
            } catch (InputMismatchException e) {
                logger.error("User is out of range");
                System.out.println("Invalid input");
            }
        }
    }

    public static int scanInRange(int min, int max) {
        while (true) {
            int n = scanInt();
            if (min <= n && n <= max) {
                return n;
            }
            System.out.println("Input is out of range scan");
        }
    }
}

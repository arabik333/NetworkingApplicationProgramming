package org.example;

import java.util.Scanner;

public class ScannerManager {
    private static final Scanner scan = new Scanner(System.in);

    public static int scanInt() {
        while (true) {
            try {
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid data type");
            }
        }
    }

    public static String scanString() {
        return scan.nextLine();
    }

    public static int scanInRange(int min, int max) {
        while (true) {
            int n = scanInt();
            if (min <= n && n < max) {
                return n;
            } else {
                System.out.println("Entered number is out of range! Try again");
            }
        }
    }

    public static int scanChosenIndex(int max) {
        return scanInRange(1, max + 1);
    }
}

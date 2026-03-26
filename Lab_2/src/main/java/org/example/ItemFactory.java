package org.example;

import org.example.entity.Book;
import org.example.entity.Journal;
import org.example.entity.Textbook;

import static org.example.ScannerManager.scanInRange;
import static org.example.ScannerManager.scanString;

public class ItemFactory {

    private static String addName() {
        System.out.println("Enter name:");
        return scanString();
    }

    private static int addYear() {
        System.out.println("Enter year of printing:");
        return scanInRange(1800, 2027);
    }

    private static String addAuthor() {
        System.out.println("Enter author:");
        return scanString();
    }

    public static Book createBook() {
        return new Book(addName(), addYear(), addAuthor());
    }

    public static Journal createJournal() {
        return new Journal(addName(), addYear(), addAuthor());
    }

    public static Textbook createTextbook() {
        return new Textbook(addName(), addYear(), addAuthor());
    }
}

package org.example;

import org.example.security.Security;
import org.example.service.impl.LibraryServiceImpl;

import java.util.List;

import static org.example.FileManager.loadFromFile;
import static org.example.FileManager.saveToFile;
import static org.example.ItemFactory.*;
import static org.example.ScannerManager.*;

public class Main {
    public static void main(String[] args) {
        LibraryServiceImpl library = new LibraryServiceImpl();
        String filename = "library.dat";

        while (true) {
            System.out.println("""
                    1)Add book
                    2)Add journal
                    3)Add Textbook
                    4)View all library
                    5)Delete publication(for admin)
                    6)Edit author(for admin)
                    7)Edit year of printing(for admin)
                    8)Search by name
                    9)Search by author
                    10)Filter by publication type
                    11)Filter by year of printing
                    12)Filter by year range
                    13)Sort by name
                    14)Sort by author
                    15)Statistics by type
                    16)Save to file
                    17)Load from file
                    18)Exit""");
            System.out.println("Choose method: ");
            int n = scanChosenIndex(18);
            switch (n) {
                case 1 -> library.add(createBook());
                case 2 -> library.add(createJournal());
                case 3 -> library.add(createTextbook());
                case 4 -> library.printAllLibrary();
                case 5 -> library.deleteItem();
                case 6 -> {
                    System.out.print("Enter the password: ");
                    if (!Security.checkPassword(scanString())) {
                        System.out.println("Incorrect password!");
                        break;
                    }
                    library.printAllLibrary();
                    System.out.print("Choose number and then enter new author's name: ");
                    library.getByIndex().setAuthor(scanString());
                }
                case 7 -> {
                    System.out.print("Enter the password: ");
                    if (!Security.checkPassword(scanString())) {
                        System.out.println("Incorrect password!");
                        break;
                    }
                    library.printAllLibrary();
                    System.out.print("Choose number and then enter new year of printing: ");
                    library.getByIndex().setYearOfPrinting(scanInRange(1800, 2027));
                }
                case 8 -> {
                    System.out.println("Enter name");
                    library.print(library.searchByName(scanString()));
                }
                case 9 -> {
                    System.out.println("Enter author's name");
                    library.print(library.searchByAuthor(scanString()));
                }
                case 10 -> library.filterByType(library.choose(List.of("Book", "Journal", "Textbook")));
                case 11 -> {
                    System.out.println("Enter year of printing: ");
                    library.filterByYear(scanInRange(1800, 2027));
                }
                case 12 -> {
                    System.out.println("Enter min and max year of printing");
                    library.filterByYearRange(scanInRange(1800, 2027), scanInRange(1800, 2027));
                }
                case 13 -> library.sortByName();
                case 14 -> library.sortByAuthor();
                case 15 -> library.printStatistics();
                case 16 -> saveToFile(filename, library.getLibrary());
                case 17 -> library.setLibrary(loadFromFile(filename));
                case 18 -> {
                    return;
                }
            }
        }
    }
}

package org.example.service.impl;

import org.example.entity.Item;
import org.example.security.Security;
import org.example.service.LibraryService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.example.ScannerManager.*;

public class LibraryServiceImpl implements LibraryService {
    private final List<Item> library = new ArrayList<>();

    public List<Item> getLibrary() {
        return library;
    }

    public void setLibrary(List<Item> lib) {
        library.clear();
        library.addAll(lib);
    }

    @Override
    public boolean add(Item item) {
        return library.add(item);
    }

    @Override
    public List<Item> searchByName(String name) {
        return library.stream()
                .filter(item -> name.equalsIgnoreCase(item.getName()))
                .toList();
    }

    @Override
    public List<Item> searchByAuthor(String author) {
        return library.stream().
                filter(item -> author.equalsIgnoreCase(item.getAuthor()))
                .toList();
    }

    @Override
    public void printAllLibrary() {
        if (library.isEmpty()) {
            System.out.println("Library is empty");
            return;
        }
        print(library);
    }

    @Override
    public void deleteItem() {
        System.out.println("Enter the password:");
        if (!Security.checkPassword(scanString())) {
            System.out.println("Incorrect password!");
            return;
        }
        printAllLibrary();
        System.out.println("Enter the number of the edition you want to delete:");
        library.remove(scanInRange(1, library.size()) - 1);
        System.out.println("Edition removed");
    }

    @Override
    public void sortByName() {
        print(library.stream().sorted(Comparator.comparing(Item::getName)).toList());
    }

    @Override
    public void sortByAuthor() {
        print(library.stream().sorted(Comparator.comparing(Item::getAuthor)).toList());
    }

    @Override
    public void filterByType(String type) {
        print(library.stream()
                .filter(item -> item.getClass().getSimpleName().equals(type))
                .toList());
    }

    @Override
    public void filterByYear(int year) {
        print(library.stream()
                .filter(item -> item.getYearOfPrinting() == year)
                .toList());
    }

    @Override
    public void filterByYearRange(int minYear, int maxYear) {
        if (minYear > maxYear) {
            System.out.println("The lower bound cannot be greater than the upper bound");
            return;
        }
        print(library.stream()
                .filter(item -> item.getYearOfPrinting() >= minYear && item.getYearOfPrinting() <= maxYear)
                .toList());
    }

    @Override
    public void printStatistics() {
        Map<String, List<Item>> a = library.stream()
                .collect(Collectors.groupingBy(item -> item.getClass().getSimpleName()));
        a.forEach((type, items) -> {
                    System.out.println("Type: " + type + " Count: " + items.size());
                }
        );
    }

    @Override
    public void print(List<Item> filteeredList) {
        if (filteeredList.isEmpty()) {
            System.out.println("Library is empty");
            return;
        }
        int i = 0;
        System.out.println("\n" + "=".repeat(80));
        System.out.printf("%-3s | %-30s | %-20s | %-8s%n",
                "№", "Name", "Author", "Year");
        System.out.println("-".repeat(80));
        for (var item : filteeredList) {
            System.out.printf("%-3d | %-30s | %-20s | %-8d%n",
                    ++i, item.getName(), item.getAuthor(), item.getYearOfPrinting());
        }
        System.out.println("-".repeat(80));
    }

    @Override
    public Item getByIndex() {
        return library.get(scanChosenIndex(library.size()) - 1);
    }

    public String choose(List<String> elements) {
        System.out.println("Choose element: ");
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(i + 1 + ") " + elements.get(i));
        }
        int index = scanChosenIndex(elements.size());
        return elements.get(index - 1);
    }

}

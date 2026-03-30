package org.example.service;

import org.example.entity.Item;

import java.util.List;

public interface LibraryService {

    void filterByYearRange(int minYear, int maxYear);

    void filterByYear(int year);

    void print(List<Item> filteredList);

    void filterByType(String type);

    boolean add(Item item);

    List<Item> searchByName(String name);

    List<Item> searchByAuthor(String author);

    void printAllLibrary();

    void deleteItem();

    void sortByName();

    void sortByAuthor();

    void printStatistics();

    Item getByIndex();
}

package org.example.entity;

import java.io.Serializable;

public abstract class Item implements Serializable {
    private String author;
    private int yearOfPrinting;
    private String name;


    public Item(String name, int yearOfPrinting, String author) {
        this.name = name;
        this.yearOfPrinting = yearOfPrinting;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfPrinting() {
        return yearOfPrinting;
    }

    public void setYearOfPrinting(int yearOfPrinting) {
        this.yearOfPrinting = yearOfPrinting;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

package org.example;

import java.util.List;

public enum Subject implements Nameable {
    MATH("Математика"),
    ALGEBRA("Алгебра"),
    GEOMETRY("Геометрия"),
    PHYSICS("Физика"),
    CHEMISTRY("Химия"),
    BIOLOGY("Биология"),
    RUSSIAN("Русский язык"),
    RUSSIAN_LITERATURE("Русская литература"),
    BELARUSIAN("Белоруссикй язык"),
    BELARUSIAN_LITERATURE("Белоруссикй литература"),
    ENGLISH("Английский язык"),
    HISTORY("История"),
    BELARUSIAN_HISTORY("История Беларуси"),
    COMPUTER_SCIENCE("Информатика"),
    GEOGRAPHY("География"),
    PE("Физкультура"),
    ASTRONOMY("Астрономия");

    private final String name;

    Subject(String name) {
        this.name = name;
    }

    public static Subject chooseSubject() {
        return Utils.choose(List.of(values()));
    }

    public String getName() {
        return name;
    }
}

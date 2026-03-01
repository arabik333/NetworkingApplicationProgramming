package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student implements Nameable {
    private static final Logger logger = LogManager.getLogger(Student.class);
    private static final Map<Subject, List<Integer>> grades = new HashMap<>();
    private final String name;

    public Student(String name) {
        this.name = name;
    }

    public static Subject chooseAvailableSubject() {
        return Utils.choose(new ArrayList<>(grades.keySet()));
    }

    @Override
    public String getName() {
        return name;
    }

    public void addGrade(Subject subject, int grade) {
        if (!grades.containsKey(subject)) {
            grades.put(subject, new ArrayList<>());
        }
        grades.get(subject).add(grade);
        logger.info("A new grade has been added in {}: {}", subject.getName(), grade);
    }

    public float getSubjectAverageGrade(Subject subject) {
        float averageGrade = 0;
        for (var grade : grades.get(subject)) {
            averageGrade += grade;
        }
        averageGrade = averageGrade / grades.get(subject).size();
        logger.info("Average grade in {} is {}", subject.getName(), averageGrade);
        return averageGrade;
    }

    public float getTotalGrade() {
        int averageGrade = 0;
        int count = 0;
        for (var entry : grades.entrySet()) {
            for (var grade : entry.getValue()) {
                averageGrade += grade;
                count++;
            }
        }
        logger.info("Average grade is {}", (float) averageGrade / count);
        return (float) averageGrade / count;
    }
}

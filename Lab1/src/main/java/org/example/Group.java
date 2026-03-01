package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private static final Logger logger = LogManager.getLogger(Group.class);

    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        logger.info("A new user {} has been created", student.getName());
    }

    public Student chooseStudent() {
        Student student = Utils.choose(students);
        logger.info("Logged in under {}'s profile", student.getName());
        return student;
    }
}

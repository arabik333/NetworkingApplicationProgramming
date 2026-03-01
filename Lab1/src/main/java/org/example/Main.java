package org.example;

import static org.example.ScannerManager.*;

public class Main {
    public static void main(String[] args) {
        Group group = new Group();
        while (true) {
            System.out.println("""
                    1)Add student
                    2)Add grade
                    3)Calculate average garde of subject
                    4)Calculate overall GPA
                    5)Exit""");
            int n = scanInRange(1, 5);
            switch (n) {
                case 1 -> {
                    System.out.println("Enter student's surname:");
                    group.addStudent(new Student(scanString()));
                    System.out.println();
                }
                case 2 -> {
                    System.out.println("Choose student");
                    Student student = group.chooseStudent();
                    System.out.println("Choose subject");
                    Subject subject = Subject.chooseSubject();
                    System.out.println("Enter number of grades");
                    int quantity = scanInt();
                    if (quantity > 0) {
                        for (int i = 0; i < n; i++) {
                            student.addGrade(subject, scanInRange(0, 11));
                            System.out.println();
                        }
                    } else {
                        System.out.println("The number of grades must be natural");
                    }
                }
                case 3 -> {
                    System.out.println("Choose student");
                    Student student = group.chooseStudent();
                    System.out.println("Choose subject");
                    Subject subject = Student.chooseAvailableSubject();
                    System.out.println("Average grade in " + subject.getName() + " " + student.getSubjectAverageGrade(subject));
                }
                case 4 -> {
                    System.out.println("Choose student");
                    Student student = group.chooseStudent();
                    System.out.println(student.getName() + "'s overall GPA is " + student.getTotalGrade());
                }
                case 5 -> {
                    return;
                }
                default -> System.out.println("Incorrect choice");
            }
        }
    }
}

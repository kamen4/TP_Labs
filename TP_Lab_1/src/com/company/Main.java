package com.company;

import java.util.Arrays;

/**
 * Main class to demonstrate the functionality of the Student class
 * and sorting by various attributes.
 *
 * @author Vladimir Gorbach
 * @version 1.0
 */
public class Main {

    /**
     * Main method to run the application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        //Initialize
        Student student1 = new Student("John", 20, "Male", 70.5, "Computer Science", 2, 8);
        Student student2 = new Student("Alice", 22, "Female", 65.2, "Mathematics", 3, 7);
        Student student3 = new Student("Bob", 19, "Male", 75.0, "Physics", 1, 1);

        Student[] students = {student1, student2, student3};

        // Sorting by name
        for (Student student : students) {
            student.setCompare(0);
        }
        Arrays.sort(students);
        System.out.println("Sorted by name:");
        for (Student student : students) {
            System.out.println("\t" + student.toString());
        }

        // Sorting by course
        for (Student student : students) {
            student.setCompare(5);
        }
        Arrays.sort(students);
        System.out.println("\nSorted by course:");
        for (Student student : students) {
            System.out.println("\t" + student.toString());
        }

        // Demonstrating object copying
        System.out.println("\nStart object:");
        System.out.println("\t" + students[0].toString());
        System.out.println("\nCopied with toString() object:");
        System.out.println("\t" + new Student(students[0].toString()).toString());

        // Demonstrating object iteration
        System.out.println("\nIterating object:");
        for (Object o : students[1]) {
            System.out.println("\t" + o.toString());
        }
    }
}
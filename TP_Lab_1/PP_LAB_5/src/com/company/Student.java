package com.company;

import java.util.*;

/**
 * Represents a student, inheriting attributes from the Man class.
 * It includes additional attributes like faculty, course, and group,
 * and implements methods for comparison and iteration.
 *
 * @author Gorbach Vladimir
 * @version 1.0
 */
public class Student extends Man implements Comparable<Student>, Iterable<Object> {
    private String faculty;
    private int course;
    private int group;
    private int compare_idx;

    /**
     * Constructs a Student object with specified attributes.
     *
     * @param name   the name of the student
     * @param age    the age of the student
     * @param gender the gender of the student
     * @param weight the weight of the student
     * @param faculty the faculty of the student
     * @param course the course of the student
     * @param group  the group of the student
     */
    public Student(String name, int age, String gender, double weight, String faculty, int course, int group) {
        super(name, age, gender, weight);
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    /**
     * Constructs a Student object from a formatted string.
     *
     * @param student the string representing a student
     */
    public Student(String student) {
        super(student);
        StringTokenizer studTok = new StringTokenizer(student, ":, ");
        studTok.nextToken(); // Skip label
        setName(studTok.nextToken());
        studTok.nextToken(); // Skip label
        setAge(Integer.parseInt(studTok.nextToken()));
        studTok.nextToken(); // Skip label
        setGender(studTok.nextToken());
        studTok.nextToken(); // Skip label
        setWeight(Double.parseDouble(studTok.nextToken()));
        studTok.nextToken(); // Skip label
        this.faculty = studTok.nextToken();
        studTok.nextToken(); // Skip label
        this.course = Integer.parseInt(studTok.nextToken());
        studTok.nextToken(); // Skip label
        this.group = Integer.parseInt(studTok.nextToken());
    }

    /**
     * Age setter
     * @param age age to set
     */
    public void setAge(int age) {
        super.setAge(age);
    }

    /**
     * Weight setter
     * @param weight weight to set
     */
    public void setWeight(double weight) {
        super.setWeight(weight);
    }

    /**
     * Increments the student's course by one.
     */
    public void nextCourse() {
        course++;
    }

    /**
     * Changes the group of the student.
     *
     * @param group the new group number
     */
    public void changeGroup(int group) {
        this.group = group;
    }

    /**
     * Sets the index for comparison.
     *
     * @param idx the index to set for comparison
     */
    public void setCompare(int idx) {
        compare_idx = idx;
    }

    @Override
    public int compareTo(Student student) {
        switch (compare_idx) {
            case 0:
                return CharSequence.compare(getName(), student.getName());
            case 1:
                return Integer.compare(getAge(), student.getAge());
            case 2:
                return CharSequence.compare(getGender(), student.getGender());
            case 3:
                return Double.compare(getWeight(), student.getWeight());
            case 4:
                return CharSequence.compare(faculty, student.faculty);
            case 5:
                return Integer.compare(course, student.course);
            case 6:
                return Integer.compare(group, student.group);
        }
        throw new NoSuchElementException("Invalid comparison index.");
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
                ", Age: " + getAge() +
                ", Gender: " + getGender() +
                ", Weight: " + getWeight() +
                ", Faculty: " + faculty +
                ", Course: " + course +
                ", Group: " + group;
    }

    private int iter_idx;

    @Override
    public Iterator<Object> iterator() {
        iter_idx = -1;
        return new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                return iter_idx < 6;
            }

            @Override
            public Object next() {
                switch (++iter_idx) {
                    case 0:
                        return getName();
                    case 1:
                        return getAge();
                    case 2:
                        return getGender();
                    case 3:
                        return getWeight();
                    case 4:
                        return faculty;
                    case 5:
                        return course;
                    case 6:
                        return group;
                }
                throw new NoSuchElementException();
            }
        };
    }
}
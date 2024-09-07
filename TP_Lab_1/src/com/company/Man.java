package com.company;

import java.util.StringTokenizer;

/**
 * Represents a man with basic attributes such as name, age, gender, and weight.
 *
 * @author Gorbach Vladimir
 * @version 1.0
 */
public class Man {
    private String name;
    private int age;
    private String gender;
    private double weight;

    /**
     * Constructs a Man object with specified attributes.
     *
     * @param name   the name of the man
     * @param age    the age of the man
     * @param gender the gender of the man
     * @param weight the weight of the man
     */
    public Man(String name, int age, String gender, double weight) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
    }

    /**
     * Constructs a Man object from a formatted string.
     *
     * @param str the string representing a man (not implemented)
     */
    public Man(String str) {
        // Implementation needed
    }

    /**
     * Name setter
     * @param name name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Age setter
     * @param age age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Weight setter
     * @param weight weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Gender setter
     * @param gender gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Name getter
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Age getter
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Gender getter
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Weight getter
     * @return weight
     */
    public double getWeight() {
        return weight;
    }
}
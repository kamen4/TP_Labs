package unitTests;

import com.company.Man;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManTest {

    @Test
    void setName() {
        Man man = new Man("John", 30, "Male", 70.0);
        man.setName("Doe");
        assertEquals("Doe", man.getName());

        // Negative test: setting name to null
        man.setName(null);
        assertNotEquals(null, man.getName()); // Name should not be null
    }

    @Test
    void setAge() {
        Man man = new Man("John", 30, "Male", 70.0);
        man.setAge(35);
        assertEquals(35, man.getAge());

        // Negative test: setting a negative age
        man.setAge(-5);
        assertNotEquals(-5, man.getAge()); // Age should not accept negative values
    }

    @Test
    void setWeight() {
        Man man = new Man("John", 30, "Male", 70.0);
        man.setWeight(75.0);
        assertEquals(75.0, man.getWeight());

        // Negative test: setting a negative weight
        man.setWeight(-10.0);
        assertNotEquals(-10.0, man.getWeight()); // Weight should not accept negative values
    }

    @Test
    void setGender() {
        Man man = new Man("John", 30, "Male", 70.0);
        man.setGender("Female");
        assertEquals("Female", man.getGender());

        // Negative test: setting gender to an invalid value
        man.setGender(""); // Empty string as invalid input
        assertNotEquals("", man.getGender()); // Gender should not accept empty values
    }

    @Test
    void getName() {
        Man man = new Man("John", 30, "Male", 70.0);
        assertEquals("John", man.getName());

        // Negative test: ensure name is not empty or null
        man.setName(null);
        assertNotEquals("John", man.getName());
    }

    @Test
    void getAge() {
        Man man = new Man("John", 30, "Male", 70.0);
        assertEquals(30, man.getAge());

        // Negative test: ensure age is not negative
        man.setAge(-1);
        assertNotEquals(-1, man.getAge());
    }

    @Test
    void getGender() {
        Man man = new Man("John", 30, "Male", 70.0);
        assertEquals("Male", man.getGender());

        // Negative test: ensure gender is not empty
        man.setGender("");
        assertNotEquals("", man.getGender());
    }

    @Test
    void getWeight() {
        Man man = new Man("John", 30, "Male", 70.0);
        assertEquals(70.0, man.getWeight());

        // Negative test: ensure weight is not negative
        man.setWeight(-1.0);
        assertNotEquals(-1.0, man.getWeight());
    }
}
package unitTests;

import com.company.Student;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void setAge() {
        Student student = new Student("John", 20, "Male", 70.0, "Engineering", 1, 101);
        student.setAge(21);
        assertEquals(21, student.getAge());

        // Negative test: setting a negative age
        student.setAge(-5);
        assertNotEquals(-5, student.getAge()); // Age should not accept negative values
    }

    @Test
    void setWeight() {
        Student student = new Student("John", 20, "Male", 70.0, "Engineering", 1, 101);
        student.setWeight(75.0);
        assertEquals(75.0, student.getWeight());

        // Negative test: setting a negative weight
        student.setWeight(-10.0);
        assertNotEquals(-10.0, student.getWeight()); // Weight should not accept negative values
    }

    @Test
    void setCompare() {
        Student student = new Student("John", 20, "Male", 70.0, "Engineering", 1, 101);
        Student student2 = new Student("", 0, "Male", 0, "", 0, 0);
        student.setCompare(2);
        assertEquals(0, student.compareTo(student2));

        // Negative test: invalid comparison index
        student.setCompare(10); // Out of valid range
        assertThrows(NoSuchElementException.class, () -> {
            student.compareTo(student2);
        });
    }

    @Test
    void compareTo() {
        Student student1 = new Student("Alice", 20, "Female", 65.0, "Engineering", 1, 101);
        Student student2 = new Student("Bob", 22, "Male", 75.0, "Science", 2, 102);
        student1.setCompare(0); // Compare by name
        assertTrue(student1.compareTo(student2) < 0); // Alice comes before Bob

        // Negative test: comparison with an invalid index
        student1.setCompare(10); // Invalid index
        assertThrows(NoSuchElementException.class, () -> {
            student1.compareTo(student2);
        });
    }

    @Test
    void testToString() {
        Student student = new Student("John", 20, "Male", 70.0, "Engineering", 1, 101);
        String expected = "Name: John, Age: 20, Gender: Male, Weight: 70.0, Faculty: Engineering, Course: 1, Group: 101";
        assertEquals(expected, student.toString());

        // Negative test: ensuring incorrect formatting is not accepted
        student.setName(null);
        assertNotEquals(expected, student.toString()); // Name should not be null in the output
    }

    @Test
    void iterator() {
        Student student = new Student("John", 20, "Male", 70.0, "Engineering", 1, 101);
        Iterator<Object> it = student.iterator();

        assertTrue(it.hasNext());
        assertEquals("John", it.next());
        assertEquals(20, it.next());
        assertEquals("Male", it.next());
        assertEquals(70.0, it.next());
        assertEquals("Engineering", it.next());
        assertEquals(1, it.next());
        assertEquals(101, it.next());
        assertFalse(it.hasNext());

        // Negative test: ensure iterator does not allow next on exhausted iterator
        assertThrows(NoSuchElementException.class, () -> {
            it.next();
        });
    }
}
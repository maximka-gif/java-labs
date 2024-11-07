package lab1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void testEquals() {
        Student student1 = new Student("Ivan", "Petrenko", LocalDate.of(2001, 5, 15), "AB12345");
        Student student2 = new Student("Ivan", "Petrenko", LocalDate.of(2001, 5, 15), "AB12345");

        assertEquals(student1, student2);  // Перевірка на рівність об'єктів
    }

    @Test
    public void testHashCode() {
        Student student1 = new Student("Ivan", "Petrenko", LocalDate.of(2001, 5, 15), "AB12345");
        Student student2 = new Student("Ivan", "Petrenko", LocalDate.of(2001, 5, 15), "AB12345");

        assertEquals(student1.hashCode(), student2.hashCode());  // Перевірка на рівність хеш-кодів
    }

    @Test
    public void testToString() {
        Student student = new Student("Ivan", "Petrenko", LocalDate.of(2001, 5, 15), "AB12345");

        String expectedString = "Student{firstName='Ivan', lastName='Petrenko', birthDate='2001-05-15', recordBookNumber='AB12345'}";
        assertEquals(expectedString, student.toString());  // Перевірка методу toString
    }
}

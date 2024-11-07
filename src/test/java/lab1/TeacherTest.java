package lab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TeacherTest {

    @Test
    public void testEquals() {
        Teacher teacher1 = new Teacher("Maria", "Kravchuk", "Mathematics");
        Teacher teacher2 = new Teacher("Maria", "Kravchuk", "Mathematics");

        assertEquals(teacher1, teacher2);  // Перевірка на рівність об'єктів
    }

    @Test
    public void testHashCode() {
        Teacher teacher1 = new Teacher("Maria", "Kravchuk", "Mathematics");
        Teacher teacher2 = new Teacher("Maria", "Kravchuk", "Mathematics");

        assertEquals(teacher1.hashCode(), teacher2.hashCode());  // Перевірка на рівність хеш-кодів
    }

    @Test
    public void testToString() {
        Teacher teacher = new Teacher("Maria", "Kravchuk", "Mathematics");

        String expectedString = "Teacher{firstName='Maria', lastName='Kravchuk', subject='Mathematics'}";
        assertEquals(expectedString, teacher.toString());  // Перевірка методу toString
    }
}

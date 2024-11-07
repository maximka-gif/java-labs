package lab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class GroupTest {

    @Test
    public void testEquals() {
        Teacher teacher = new Teacher("Maria", "Kravchuk", "Mathematics");
        Student student1 = new Student("Ivan", "Petrenko", LocalDate.of(2001, 5, 15), "AB12345");
        Student student2 = new Student("Oksana", "Shevchenko", LocalDate.of(2000, 9, 20), "CD67890");
        List<Student> students = Arrays.asList(student1, student2);

        Group group1 = new Group("CS-101", "Computer Science", LocalDate.of(2018, 5, 12), teacher, students);
        Group group2 = new Group("CS-101", "Computer Science", LocalDate.of(2018, 5, 12), teacher, students);

        assertEquals(true, group1.equals(group2));  // Перевірка на рівність об'єктів
    }

    @Test
    public void testHashCode() {
        Teacher teacher = new Teacher("Maria", "Kravchuk", "Mathematics");
        Student student1 = new Student("Ivan", "Petrenko", LocalDate.of(2001, 5, 15), "AB12345");
        Student student2 = new Student("Oksana", "Shevchenko", LocalDate.of(2000, 9, 20), "CD67890");
        List<Student> students = Arrays.asList(student1, student2);

        Group group1 = new Group("CS-101", "Computer Science", LocalDate.of(2018, 5, 12), teacher, students);
        Group group2 = new Group("CS-101", "Computer Science", LocalDate.of(2018, 5, 12), teacher, students);

        assertEquals(group1.hashCode(), group2.hashCode());  // Перевірка на рівність хеш-кодів
    }

    @Test
    public void testToString() {
        Teacher teacher = new Teacher("Maria", "Kravchuk", "Mathematics");
        Student student1 = new Student("Ivan", "Petrenko", LocalDate.of(2001, 5, 15), "AB12345");
        Student student2 = new Student("Oksana", "Shevchenko", LocalDate.of(2000, 9, 20), "CD67890");
        List<Student> students = Arrays.asList(student1, student2);

        Group group = new Group("CS-101", "Computer Science", LocalDate.of(2018, 5, 12), teacher, students);

        String expectedString = "Group{groupNumber='CS-101', yearCreated=2018-05-12, department='Computer Science', " +
                "curator=Teacher{firstName='Maria', lastName='Kravchuk', subject='Mathematics'}, " +
                "students=[Student{firstName='Ivan', lastName='Petrenko', birthDate='2001-05-15', recordBookNumber='AB12345'}, " +
                "Student{firstName='Oksana', lastName='Shevchenko', birthDate='2000-09-20', recordBookNumber='CD67890'}]}";
        assertEquals(expectedString, group.toString());  // Перевірка методу toString
    }
}

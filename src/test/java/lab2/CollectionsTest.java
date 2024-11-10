package lab2;

import lab1.Group;
import lab1.Student;
import lab1.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CollectionsTest {
    private GroupServices collections;
    private List<Student> students;
    private List<Group> groups;

    @BeforeEach
    void setUp() {
        // Створюємо список студентів
        students = Arrays.asList(
                new Student("John", "Doe", LocalDate.of(2000, 1, 1), "123456"),
                new Student("Jane", "Smith", LocalDate.of(1999, 5, 15), "654321"),
                new Student("Jim", "Brown", LocalDate.of(2001, 8, 20), "111213")
        );

        // Створюємо список викладачів
        Teacher teacher1 = new Teacher("Maria", "Kravchuk", "Mathematics");
        Teacher teacher2 = new Teacher("Maria", "Kravchuk", "Mathematics");
        Teacher teacher3 = new Teacher("Maria", "Kravchuk", "Mathematics");

        // Створюємо список груп
        groups = Arrays.asList(
                new Group("CS101", "Computer Science", LocalDate.of(2019, 5, 10), teacher1, students),
                new Group("EE202", "Electrical Engineering", LocalDate.of(2020, 8, 20), teacher2, students),
                new Group("ME303", "Mechanical Engineering", LocalDate.of(2021, 2, 15), teacher3, students)
        );

        // Створюємо об'єкт GroupServices, передаючи списки студентів і груп
        collections = new GroupServices(students, groups);
    }

    @Test
    void testSortStudentsByLastName() {
        // Викликаємо метод без передачі списку студентів
        List<Student> sortedStudents = collections.sortStudentsByLastName();
        assertEquals("Smith", sortedStudents.get(0).getLastName());  // Перевіряємо, що перший студент — "Smith"
        assertEquals("Doe", sortedStudents.get(1).getLastName());    // Перевіряємо, що другий студент — "Doe"
        assertEquals("Brown", sortedStudents.get(2).getLastName());  // Перевіряємо, що третій студент — "Brown"
    }

    @Test
    void testSortStudentsByBirthDate() {
        // Викликаємо метод без передачі списку студентів
        List<Student> sortedStudents = collections.sortStudentsByBirthDate();
        assertEquals("Jane", sortedStudents.get(0).getFirstName());
        assertEquals("John", sortedStudents.get(1).getFirstName());
        assertEquals("Jim", sortedStudents.get(2).getFirstName());
    }

    @Test
    void testFindStudentByRecordBookNumber() {
        // Викликаємо метод без передачі списку студентів
        Optional<Student> student = collections.findStudentByRecordBookNumber("123456");
        assertTrue(student.isPresent());
        assertEquals("John", student.get().getFirstName());
    }

    @Test
    void testFilterStudentsByLastName() {
        // Викликаємо метод без передачі списку студентів
        List<Student> filteredStudents = collections.filterStudentsByLastName("Doe");
        assertEquals(1, filteredStudents.size());
        assertEquals("John", filteredStudents.get(0).getFirstName());
    }

    @Test
    void testSortGroupsByYearCreated() {
        List<Group> sortedGroups = collections.sortGroupsByYearCreated();
        assertEquals(2019, sortedGroups.get(0).getYearCreated().getYear());
        assertEquals(2020, sortedGroups.get(1).getYearCreated().getYear());
        assertEquals(2021, sortedGroups.get(2).getYearCreated().getYear());
    }

    @Test
    void testFindGroupByGroupNumber() {
        Optional<Group> group = collections.findGroupByGroupNumber("CS101");
        assertTrue(group.isPresent());
        assertEquals("Computer Science", group.get().getDepartment());
    }

    @Test
    void testFilterGroupsByDepartment() {
        List<Group> filteredGroups = collections.filterGroupsByDepartment("Electrical Engineering");
        assertEquals(1, filteredGroups.size());
        assertEquals("EE202", filteredGroups.get(0).getGroupNumber());
    }
}

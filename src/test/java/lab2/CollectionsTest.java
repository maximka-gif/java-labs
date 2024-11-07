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
    private Collections collections;
    private List<Student> students;
    private List<Group> groups;

    @BeforeEach
    void setUp() {
        collections = new Collections();

        students = Arrays.asList(
                new Student("John", "Doe", LocalDate.of(2000, 1, 1), "123456"),
                new Student("Jane", "Smith", LocalDate.of(1999, 5, 15), "654321"),
                new Student("Jim", "Brown", LocalDate.of(2001, 8, 20), "111213")
        );

        Teacher teacher1 = new Teacher("Maria", "Kravchuk", "Mathematics");
        Teacher teacher2 = new Teacher("Maria", "Kravchuk", "Mathematics");
        Teacher teacher3 = new Teacher("Maria", "Kravchuk", "Mathematics");

        groups = Arrays.asList(
                new Group("CS101", "Computer Science", LocalDate.of(2019, 5, 10), teacher1, students),
                new Group("EE202", "Electrical Engineering", LocalDate.of(2020, 8, 20), teacher2, students),
                new Group("ME303", "Mechanical Engineering", LocalDate.of(2021, 2, 15), teacher3, students)
        );
    }

    @Test
    void testSortStudentsByLastName() {
        List<Student> sortedStudents = collections.sortStudentsByLastName(students);
        assertEquals("Doe", sortedStudents.get(0).getLastName());
        assertEquals("Brown", sortedStudents.get(1).getLastName());
        assertEquals("Smith", sortedStudents.get(2).getLastName());
    }

    @Test
    void testSortStudentsByBirthDate() {
        List<Student> sortedStudents = collections.sortStudentsByBirthDate(students);
        assertEquals("Jane", sortedStudents.get(0).getFirstName());
        assertEquals("John", sortedStudents.get(1).getFirstName());
        assertEquals("Jim", sortedStudents.get(2).getFirstName());
    }

    @Test
    void testFindStudentByRecordBookNumber() {
        Optional<Student> student = collections.findStudentByRecordBookNumber(students, "123456");
        assertTrue(student.isPresent());
        assertEquals("John", student.get().getFirstName());
    }

    @Test
    void testFilterStudentsByLastName() {
        List<Student> filteredStudents = collections.filterStudentsByLastName(students, "Doe");
        assertEquals(1, filteredStudents.size());
        assertEquals("John", filteredStudents.get(0).getFirstName());
    }

    @Test
    void testSortGroupsByYearCreated() {
        List<Group> sortedGroups = collections.sortGroupsByYearCreated(groups);
        assertEquals(2019, sortedGroups.get(0).getYearCreated().getYear());
        assertEquals(2020, sortedGroups.get(1).getYearCreated().getYear());
        assertEquals(2021, sortedGroups.get(2).getYearCreated().getYear());
    }

    @Test
    void testFindGroupByGroupNumber() {
        Optional<Group> group = collections.findGroupByGroupNumber(groups, "CS101");
        assertTrue(group.isPresent());
        assertEquals("Computer Science", group.get().getDepartment());
    }

    @Test
    void testFilterGroupsByDepartment() {
        List<Group> filteredGroups = collections.filterGroupsByDepartment(groups, "Electrical Engineering");
        assertEquals(1, filteredGroups.size());
        assertEquals("EE202", filteredGroups.get(0).getGroupNumber());
    }
}

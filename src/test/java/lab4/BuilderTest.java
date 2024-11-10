package lab4;

import lab1.Group;
import lab1.Student;
import lab1.Teacher;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

public class BuilderTest {

    @Test
    public void testStudentBuilder() {
        // Create StudentBuilder and fill fields
        StudentBuilder studentBuilder = new StudentBuilder()
                .firstName("John")
                .lastName("Doe")
                .birthDate(LocalDate.parse("2000-01-01"))
                .recordBookNumber("RB12345");

        // Create student
        Student student = studentBuilder.build();

        // Verify that the data was assigned correctly
        assertEquals("John", student.getFirstName());
        assertEquals("Doe", student.getLastName());
        assertEquals(LocalDate.parse("2000-01-01"), student.getBirthDate());
        assertEquals("RB12345", student.getRecordBookNumber());
    }

    @Test
    public void testInvalidStudentBuilder() {
        // Will throw exception as the required fields are missing
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new StudentBuilder().build());

        // Check for error messages related to missing fields
        assertTrue(exception.getMessage().contains("Invalid first name"));
        assertTrue(exception.getMessage().contains("Invalid last name"));
        assertTrue(exception.getMessage().contains("Invalid record book number"));
    }

    @Test
    public void testTeacherBuilder() {
        // Create TeacherBuilder and fill fields
        TeacherBuilder teacherBuilder = new TeacherBuilder()
                .firstName("Jane")
                .lastName("Smith")
                .subject("Mathematics");

        // Create teacher
        Teacher teacher = teacherBuilder.build();

        // Verify that the data was assigned correctly
        assertEquals("Jane", teacher.getFirstName());
        assertEquals("Smith", teacher.getLastName());
        assertEquals("Mathematics", teacher.getSubject());
    }

    @Test
    public void testInvalidTeacherBuilder() {
        // Will throw exception as the required fields are missing
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new TeacherBuilder().build());

        // Check for error messages related to missing fields
        assertTrue(exception.getMessage().contains("Invalid first name"));
        assertTrue(exception.getMessage().contains("Invalid last name"));
        assertTrue(exception.getMessage().contains("Subject must not be empty"));
    }

    @Test
    public void testGroupBuilder() {
        // Create curator
        Teacher curator = new TeacherBuilder()
                .firstName("Dr.White")
                .lastName("White")
                .subject("Group Curator")
                .build();

        // Create students
        Student student1 = new StudentBuilder()
                .firstName("Tom")
                .lastName("Hanks")
                .birthDate(LocalDate.parse("1998-08-20"))
                .recordBookNumber("RB10001")
                .build();

        Student student2 = new StudentBuilder()
                .firstName("Emma")
                .lastName("Stone")
                .birthDate(LocalDate.parse("1997-04-10"))
                .recordBookNumber("RB10002")
                .build();

        // Create group using the builder
        GroupBuilder groupBuilder = new GroupBuilder()
                .groupNumber("G1")
                .yearCreated(LocalDate.of(2022, 1, 1))
                .department("Computer Science")
                .curator(curator)
                .students(List.of(student1, student2));

        Group group = groupBuilder.build();

        // Verify that the group data was assigned correctly
        assertEquals("G1", group.getGroupNumber());
        assertEquals(LocalDate.of(2022, 1, 1), group.getYearCreated());
        assertEquals("Computer Science", group.getDepartment());
        assertEquals(curator, group.getTeacher());
        assertEquals(2, group.getStudents().size());
    }

    @Test
    public void testInvalidGroupBuilder() {
        // Will throw exception as the required fields are missing
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new GroupBuilder().build());

        // Check for error messages related to missing fields
        assertTrue(exception.getMessage().contains("Invalid group number"));
        assertTrue(exception.getMessage().contains("Department cannot be empty"));
        assertTrue(exception.getMessage().contains("Year must be between"));
        assertTrue(exception.getMessage().contains("Curator cannot be null"));
        assertTrue(exception.getMessage().contains("Group must have at least one student"));
    }
}

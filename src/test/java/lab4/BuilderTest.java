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
    public void testValidStudent() {
        Student student = new StudentBuilder()
                .firstName("John")
                .lastName("Doe")
                .birthDate(LocalDate.parse("2000-01-01"))
                .recordBookNumber("RB12345")
                .build();

        assertEquals("John", student.getFirstName());
        assertEquals("Doe", student.getLastName());
        assertEquals(LocalDate.parse("2000-01-01"), student.getBirthDate());
        assertEquals("RB12345", student.getRecordBookNumber());
    }

    @Test
    public void testInvalidStudentFirstName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new StudentBuilder()
                    .firstName("ma@ks") // Некоректне ім'я
                    .lastName("Doe")
                    .birthDate(LocalDate.parse("2000-01-01"))
                    .recordBookNumber("RB1234556389")
                    .build();
        });
        assertTrue(exception.getMessage().contains("Invalid first name"));
        assertTrue(exception.getMessage().contains("Invalid record book number"),"error message " + exception.getMessage());
    }

    @Test
    public void testInvalidStudentLastName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new StudentBuilder()
                    .firstName("John")
                    .lastName("D oe") // Некоректне прізвище
                    .birthDate(LocalDate.parse("2000-01-01"))
                    .recordBookNumber("RB12345")
                    .build();
        });
        System.out.println("Validation error: " + exception.getMessage());
        assertTrue(exception.getMessage().contains("Invalid last name"));
    }

    @Test
    public void testInvalidStudentRecordBookNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new StudentBuilder()
                    .firstName("John")
                    .lastName("Doe")
                    .birthDate(LocalDate.parse("2000-01-01"))
                    .recordBookNumber("") // Некоректний номер залікової книжки
                    .build();
        });
        System.out.println("Validation error: " + exception.getMessage());
        assertTrue(exception.getMessage().contains("Invalid record book number"));
    }

    @Test
    public void testValidTeacher() {
        Teacher teacher = new TeacherBuilder()
                .firstName("Jane")
                .lastName("Smith")
                .subject("Mathematics")
                .build();

        assertEquals("Jane", teacher.getFirstName());
        assertEquals("Smith", teacher.getLastName());
        assertEquals("Mathematics", teacher.getSubject());
    }

    @Test
    public void testInvalidTeacherSubject() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new TeacherBuilder()
                    .firstName("Jane")
                    .lastName("Smith")
                    .subject("") // Некоректний предмет
                    .build();
        });
        System.out.println("Validation error: " + exception.getMessage());
        assertTrue(exception.getMessage().contains("Subject must not be empty"));
    }

    @Test
    public void testValidGroup() {
        Teacher curator = new TeacherBuilder()
                .firstName("Dr.White")
                .lastName("White")
                .subject("Group Curator")
                .build();

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

        Group group = new GroupBuilder()
                .groupNumber("G1")
                .yearCreated(LocalDate.of(2022, 1, 1))
                .department("Computer Science")
                .curator(curator)
                .students(List.of(student1, student2))
                .build();

        assertEquals("G1", group.getGroupNumber());
        assertEquals(LocalDate.of(2022, 1, 1), group.getYearCreated());
        assertEquals("Computer Science", group.getDepartment());
        assertEquals(curator, group.getTeacher());
        assertEquals(2, group.getStudents().size());
    }

    @Test
    public void testInvalidGroupNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new GroupBuilder()
                    .groupNumber("") // Некоректний номер групи
                    .yearCreated(LocalDate.of(2022, 1, 1))
                    .department("Computer Science")
                    .curator(new Teacher("Dr.White", "White", "Group Curator"))
                    .students(List.of(new Student("Tom", "Hanks", LocalDate.parse("1998-08-20"), "RB10001")))
                    .build();
        });
        System.out.println("Validation error: " + exception.getMessage());
        assertTrue(exception.getMessage().contains("Invalid group number"));
    }

    @Test
    public void testInvalidGroupDepartment() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new GroupBuilder()
                    .groupNumber("G1")
                    .yearCreated(LocalDate.of(2022, 1, 1))
                    .department("") // Некоректний департамент
                    .curator(new Teacher("Dr.White", "White", "Group Curator"))
                    .students(List.of(new Student("Tom", "Hanks", LocalDate.parse("1998-08-20"), "RB10001")))
                    .build();
        });
        System.out.println("Validation error: " + exception.getMessage());
        assertTrue(exception.getMessage().contains("Department cannot be empty"));
    }

    @Test
    public void testInvalidGroupCurator() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new GroupBuilder()
                    .groupNumber("G1")
                    .yearCreated(LocalDate.of(2022, 1, 1))
                    .department("Computer Science")
                    .curator(null) // Некоректний куратор
                    .students(List.of(new Student("Tom", "Hanks", LocalDate.parse("1998-08-20"), "RB10001")))
                    .build();
        });
        System.out.println("Validation error: " + exception.getMessage());
        assertTrue(exception.getMessage().contains("Curator cannot be null"));
    }

    @Test
    public void testInvalidGroupStudents() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new GroupBuilder()
                    .groupNumber("G1")
                    .yearCreated(LocalDate.of(2022, 1, 1))
                    .department("Computer Science")
                    .curator(new Teacher("Dr.White", "White", "Group Curator"))
                    .students(List.of()) // Некоректний список студентів
                    .build();
        });
        System.out.println("Validation error: " + exception.getMessage());
        assertTrue(exception.getMessage().contains("Group must have at least one student"));
    }
}

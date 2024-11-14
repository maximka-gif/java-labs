package lab4;

import lab1.Student;
import lab1.Teacher;
import lab1.Group;
import java.time.LocalDate;
import java.util.Arrays;

public class Mainlab4 {
    public static void main(String[] args) {
        // Створення викладача
        Teacher teacher = new TeacherBuilder()
                .firstName("John")
                .lastName("Doe")
                .subject("Mathematics")
                .build();

        // Створення студентів
        try {
            Student student1 = new StudentBuilder()
                    .firstName("Alice")
                    .lastName("Smith")
                    .birthDate(LocalDate.of(2000, 5, 10))
                    .recordBookNumber("AB12345")
                    .build();
            System.out.println("Student added successfully: " + student1);

            Student student2 = new StudentBuilder()
                    .firstName("Bob")
                    .lastName("Johnson")
                    .birthDate(LocalDate.of(2002, 7, 25))
                    .recordBookNumber("XYZ67890")
                    .build();
            System.out.println("Student added successfully: " + student2);

            // Невірний студент (ім'я з цифрами)
            Student student3 = new StudentBuilder()
                    .firstName("M@rk")
                    .lastName("Twain")
                    .birthDate(LocalDate.of(1995, 1, 1))
                    .recordBookNumber("MK123")
                    .build();

        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }

        // Створення групи
        try {
            Group group1 = new GroupBuilder()
                    .groupNumber("G123")
                    .department("Computer Science")
                    .yearCreated(LocalDate.of(2020, 9, 1))
                    .curator(teacher)
                    .students(Arrays.asList(new Student("Alice", "Smith", LocalDate.of(2000, 5, 10), "AB12345")))
                    .build();
            System.out.println("Group created successfully: " + group1);

            // Невірна група (відсутність кураторів)
            Group group2 = new GroupBuilder()
                    .groupNumber("G456")
                    .department("Physics")
                    .yearCreated(LocalDate.of(2022, 9, 1))
                    .curator(null) // Невірний куратор
                    .students(Arrays.asList(new Student("Bob", "Johnson", LocalDate.of(2002, 7, 25), "XYZ67890")))
                    .build();

        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}

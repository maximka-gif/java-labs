package lab1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створюємо студентів
        Student student1 = new Student(
                "Ivan",
                "Petrenko",
                LocalDate.of(2005, 1, 15),
                "AB12345"
        );
        Student student2 = new Student("Oksana", "Shevchenko", LocalDate.of(2000, 9, 20), "CD67890");
        Student student3 = new Student("Oleg", "Kovalenko", LocalDate.of(1999, 11, 15), "EF24680");

        // Створюємо викладача
        Teacher teacher = new Teacher("Maria", "Kravchuk", "Mathematics");

        // Створюємо групу
        List<Student> students = Arrays.asList(student1, student2, student3);
        Group group = new Group("CS-101", "Computer Science",LocalDate.of(2018, 5,27), teacher, students);

        // Виводимо інформацію про групу
        System.out.println(group);
    }
}


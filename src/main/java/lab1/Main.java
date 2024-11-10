package lab1;

import lab2.GroupServices;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створюємо студентів
        Student student1 = new Student("Ivan", "Petrenko", LocalDate.of(2005, 1, 15), "AB12345");
        Student student2 = new Student("Oksana", "Shevchenko", LocalDate.of(2000, 9, 20), "CD67890");
        Student student3 = new Student("Oleg", "Kovalenko", LocalDate.of(1999, 11, 15), "EF24680");

        // Створюємо викладача
        Teacher teacher = new Teacher("Maria", "Kravchuk", "Mathematics");

        // Створюємо групу
        List<Student> students = Arrays.asList(student1, student2, student3);
        Group group = new Group("CS-101", "Computer Science", LocalDate.of(2018, 5, 27), teacher, students);

        // Виводимо інформацію про групу
        System.out.println("Група:");
        System.out.println(group);

        // Використання класу Collections
        // Передаємо список студентів і список груп до GroupServices
        GroupServices collections = new GroupServices(students, Arrays.asList(group));


        // Сортування студентів за прізвищем у зворотному порядку
        List<Student> sortedByLastName = collections.sortStudentsByLastName();  // Не потрібно передавати 'students'
        System.out.println("\nСтуденти, відсортовані за прізвищем у зворотному порядку:");
        sortedByLastName.forEach(System.out::println);

        // Пошук студента за номером залікової книжки
        String recordBookNumber = "AB12345";
        collections.findStudentByRecordBookNumber(recordBookNumber)  // Не потрібно передавати 'students'
                .ifPresentOrElse(
                        student -> System.out.println("\nЗнайдений студент з номером залікової книжки " + recordBookNumber + ": " + student),
                        () -> System.out.println("\nСтудент з номером залікової книжки " + recordBookNumber + " не знайдений")
                );

        // Фільтрація студентів за прізвищем
        String lastName = "Shevchenko";
        List<Student> filteredByLastName = collections.filterStudentsByLastName(lastName);  // Не потрібно передавати 'students'
        System.out.println("\nСтуденти з прізвищем " + lastName + ":");
        filteredByLastName.forEach(System.out::println);
    }
}

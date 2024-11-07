package lab2;

import lab1.Group;
import lab1.Student;

import java.util.*;
import java.util.stream.Collectors;

public class Collections {
    // Сортування студентів за прізвищем
    public List<Student> sortStudentsByLastName(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getLastName))
                .collect(Collectors.toList());
    }

    // Сортування студентів за датою народження
    public List<Student> sortStudentsByBirthDate(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getBirthDate))
                .collect(Collectors.toList());
    }

    // Пошук студента за номером залікової книжки
    public Optional<Student> findStudentByRecordBookNumber(List<Student> students, String recordBookNumber) {
        return students.stream()
                .filter(student -> student.getRecordBookNumber().equals(recordBookNumber))
                .findFirst();
    }

    // Фільтрація студентів за прізвищем
    public List<Student> filterStudentsByLastName(List<Student> students, String lastName) {
        return students.stream()
                .filter(student -> student.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    // Сортування груп за роком створення
    public List<Group> sortGroupsByYearCreated(List<Group> groups) {
        return groups.stream()
                .sorted(Comparator.comparing(Group::getYearCreated))
                .collect(Collectors.toList());
    }

    // Пошук групи за номером групи
    public Optional<Group> findGroupByGroupNumber(List<Group> groups, String groupNumber) {
        return groups.stream()
                .filter(group -> group.getGroupNumber().equals(groupNumber))
                .findFirst();
    }

    // Фільтрація груп за кафедрою
    public List<Group> filterGroupsByDepartment(List<Group> groups, String department) {
        return groups.stream()
                .filter(group -> group.getDepartment().equals(department))
                .collect(Collectors.toList());
    }
}

package lab2;

import lab1.Group;
import lab1.Student;

import java.util.*;
import java.util.stream.Collectors;

public class GroupServices {
    private List<Student> students;
    private List<Group> groups;

    public GroupServices(List<Student> students, List<Group> groups) {
        this.students = students;
        this.groups = groups;
    }

    // Сортування студентів за прізвищем у зворотному порядку
    public List<Student> sortStudentsByLastName() {
        if (students == null) {
            return Collections.emptyList();
        }
        return students.stream()
                .sorted(Comparator.comparing(Student::getLastName).reversed())
                .collect(Collectors.toList());
    }

    // Сортування студентів за датою народження
    public List<Student> sortStudentsByBirthDate() {
        if (students == null) {
            return Collections.emptyList();
        }
        return students.stream()
                .sorted(Comparator.comparing(Student::getBirthDate))
                .collect(Collectors.toList());
    }

    // Пошук студента за номером залікової книжки
    public Optional<Student> findStudentByRecordBookNumber(String recordBookNumber) {
        if (students == null || recordBookNumber == null) {
            return Optional.empty();
        }
        return students.stream()
                .filter(student -> student.getRecordBookNumber().equals(recordBookNumber))
                .findFirst();
    }

    // Фільтрація студентів за прізвищем
    public List<Student> filterStudentsByLastName(String lastName) {
        if (students == null || lastName == null) {
            return Collections.emptyList();
        }
        return students.stream()
                .filter(student -> student.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    // Сортування груп за роком створення
    public List<Group> sortGroupsByYearCreated() {
        if (groups == null) {
            return Collections.emptyList();
        }
        return groups.stream()
                .sorted(Comparator.comparing(Group::getYearCreated))
                .collect(Collectors.toList());
    }

    // Пошук групи за номером групи
    public Optional<Group> findGroupByGroupNumber(String groupNumber) {
        if (groups == null || groupNumber == null) {
            return Optional.empty();
        }
        return groups.stream()
                .filter(group -> group.getGroupNumber().equals(groupNumber))
                .findFirst();
    }

    // Фільтрація груп за кафедрою
    public List<Group> filterGroupsByDepartment(String department) {
        if (groups == null || department == null) {
            return Collections.emptyList();
        }
        return groups.stream()
                .filter(group -> group.getDepartment().equals(department))
                .collect(Collectors.toList());
    }
}

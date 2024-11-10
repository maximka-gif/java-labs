package lab1;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;


public class Group {
    private String groupNumber;
    private String department;
    private LocalDate yearCreated;
    private Teacher teacher;
    private List<Student> students;

    // Статичний список для зберігання всіх груп
    private static List<Group> allGroups = new ArrayList<>();

    // Оновлений конструктор
    public Group(String groupNumber, String department, LocalDate yearCreated, Teacher teacher, List<Student> students) {
        this.groupNumber = groupNumber;
        this.department = department;
        this.yearCreated = yearCreated;
        this.teacher = teacher;
        this.students = students;
        allGroups.add(this); // Додаємо групу до списку під час створення
    }

    // Геттери
    public String getGroupNumber() {
        return groupNumber;
    }

    public String getDepartment() {
        return department;
    }

    public LocalDate getYearCreated() {
        return yearCreated;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public static List<Group> getAllGroups() {
        return allGroups;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupNumber='" + groupNumber + '\'' +
                ", department='" + department + '\'' +
                ", yearCreated=" + yearCreated +
                ", teacher=" + teacher +
                ", students=" + students +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(groupNumber, group.groupNumber) &&
                Objects.equals(department, group.department) &&
                Objects.equals(yearCreated, group.yearCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupNumber, department, yearCreated);
    }
}

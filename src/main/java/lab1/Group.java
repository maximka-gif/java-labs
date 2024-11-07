package lab1;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Group {
    private String groupNumber;
    private LocalDate yearCreated;
    private String department;
    private Teacher curator;
    private List<Student> students;

    public Group(String groupNumber, String department, LocalDate yearCreated, Teacher curator, List<Student> students) {
        this.groupNumber = groupNumber; // Використовуйте правильний параметр
        this.yearCreated = yearCreated;
        this.department = department;
        this.curator = curator;
        this.students = students;
    }

    // Геттери
    public String getGroupNumber() {
        return groupNumber;
    }

    public LocalDate getYearCreated() {
        return yearCreated;
    }

    public String getDepartment() {
        return department;
    }

    public Teacher getCurator() {
        return curator;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupNumber='" + groupNumber + '\'' +
                ", yearCreated=" + yearCreated +
                ", department='" + department + '\'' +
                ", curator=" + curator +
                ", students=" + students +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return yearCreated.equals(group.yearCreated) &&
                Objects.equals(groupNumber, group.groupNumber) &&
                Objects.equals(department, group.department) &&
                Objects.equals(curator, group.curator) &&
                Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupNumber, yearCreated, department, curator, students);
    }
}

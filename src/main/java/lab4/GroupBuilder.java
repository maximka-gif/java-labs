package lab4;

import lab1.Group;
import lab1.Teacher;
import lab1.Student;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class GroupBuilder {
    private String groupNumber;
    private String department;
    private LocalDate yearCreated;
    private Teacher curator;
    private List<Student> students;

    private static final String GROUP_NUMBER_REGEX = "^[A-Za-z0-9]+$"; // регулярний вираз для groupNumber

    public GroupBuilder groupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
        return this;
    }

    public GroupBuilder department(String department) {
        this.department = department;
        return this;
    }

    public GroupBuilder yearCreated(LocalDate yearCreated) {
        this.yearCreated = yearCreated;
        return this;
    }

    public GroupBuilder curator(Teacher curator) {
        this.curator = curator;
        return this;
    }

    public GroupBuilder students(List<Student> students) {
        this.students = students;
        return this;
    }

    private List<String> validate() {
        List<String> errors = new ArrayList<>();

        if (groupNumber == null || !groupNumber.matches(GROUP_NUMBER_REGEX)) {
            errors.add("Invalid group number: " + groupNumber);
        }
        if (department == null || department.isEmpty()) {
            errors.add("Department cannot be empty");
        }
        if (yearCreated == null || yearCreated.isBefore(LocalDate.of(1900, 1, 1)) || yearCreated.isAfter(LocalDate.now())) {
            errors.add("Year must be between 1900 and the current year");
        }
        if (curator == null) {
            errors.add("Curator cannot be null");
        }
        if (students == null || students.isEmpty()) {
            errors.add("Group must have at least one student");
        }

        return errors;
    }

    public Group build() {
        List<String> errors = validate();

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields:\n" + String.join("\n", errors));
        }

        return new Group(groupNumber, department, yearCreated, curator, students);
    }
}

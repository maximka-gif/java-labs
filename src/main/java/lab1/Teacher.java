package lab1;

import java.util.Objects;

public class Teacher {
    private String firstName;
    private String lastName;
    private String subject;

    // Конструктор з трьома параметрами
    public Teacher(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    // Конструктор з двома параметрами
    public Teacher(String firstName, String lastName) {
        this(firstName, lastName, "Unknown"); // Встановлюємо значення за замовчуванням для subject
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(firstName, teacher.firstName) &&
                Objects.equals(lastName, teacher.lastName) &&
                Objects.equals(subject, teacher.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, subject);
    }
}

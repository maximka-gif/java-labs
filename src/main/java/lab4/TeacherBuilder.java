package lab4;

import lab1.Teacher;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class TeacherBuilder {
    private String firstName;
    private String lastName;
    private String subject;

    private static final String NAME_REGEX = "^[A-Za-z\\.]+$"; // регулярний вираз для імені та прізвища, що підтримує точку

    public TeacherBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public TeacherBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public TeacherBuilder subject(String subject) {
        this.subject = subject;
        return this;
    }

    // Метод валідації
    private List<String> validate() {
        List<String> errors = new ArrayList<>();

        // Перевірка імені
        if (firstName == null || !Pattern.matches(NAME_REGEX, firstName)) {
            errors.add("Invalid first name: " + firstName);
        }
        // Перевірка прізвища
        if (lastName == null || !Pattern.matches(NAME_REGEX, lastName)) {
            errors.add("Invalid last name: " + lastName);
        }
        // Перевірка предмету
        if (subject == null || subject.isEmpty()) {
            errors.add("Subject must not be empty");
        }

        return errors;
    }

    public Teacher build() {
        List<String> errors = validate();

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields:\n" + String.join("\n", errors));
        }

        return new Teacher(firstName, lastName, subject);
    }
}

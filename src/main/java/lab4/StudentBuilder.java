package lab4;

import lab1.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class StudentBuilder {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String recordBookNumber;

    private static final String NAME_REGEX = "^[A-Za-zÀ-ÿ]+(?:['-][A-Za-zÀ-ÿ]+)*$";
    private static final String RECORD_BOOK_REGEX = "^[A-Za-z0-9]{4,10}$"; // регулярний вираз для номера заліковки
    private static final LocalDate MIN_BIRTH_DATE = LocalDate.of(1900, 1, 1);
    private static final LocalDate MAX_BIRTH_DATE = LocalDate.now();

    public StudentBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public StudentBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public StudentBuilder birthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public StudentBuilder recordBookNumber(String recordBookNumber) {
        this.recordBookNumber = recordBookNumber;
        return this;
    }

    public Student build() {
        List<String> errors = new ArrayList<>();

        // Перевірка імені
        if (firstName == null || !Pattern.matches(NAME_REGEX, firstName)) {
            errors.add("Invalid first name: " + firstName);
        }

        // Перевірка прізвища
        if (lastName == null || !Pattern.matches(NAME_REGEX, lastName)) {
            errors.add("Invalid last name: " + lastName);
        }

        // Перевірка дати народження
        if (birthDate == null || birthDate.isBefore(MIN_BIRTH_DATE) || birthDate.isAfter(MAX_BIRTH_DATE)) {
            errors.add("Birth date must be between " + MIN_BIRTH_DATE + " and " + MAX_BIRTH_DATE);
        }

        // Перевірка номера заліковки
        if (recordBookNumber == null || !Pattern.matches(RECORD_BOOK_REGEX, recordBookNumber)) {
            errors.add("Invalid record book number: " + recordBookNumber);
        }

        // Якщо є помилки, кидаємо виключення
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields:\n" + String.join("\n", errors));
        }

        // Повертаємо створеного студента
        return new Student(firstName, lastName, birthDate, recordBookNumber);
    }
}

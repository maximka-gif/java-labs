package lab1.builders;

import lab1.Student;
import java.time.LocalDate;

public class StudentBuilder {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String recordBookNumber;

    public StudentBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public StudentBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public StudentBuilder setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public StudentBuilder setRecordBookNumber(String recordBookNumber) {
        this.recordBookNumber = recordBookNumber;
        return this;
    }

    public Student build() {
        return new Student(firstName, lastName, birthDate, recordBookNumber);
    }
}

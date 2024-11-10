package lab1.builders;

import lab1.Teacher;

public class TeacherBuilder {
    private String firstName;
    private String lastName;
    private String subject;

    public TeacherBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public TeacherBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public TeacherBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Teacher build() {
        return new Teacher(firstName, lastName, subject);
    }
}
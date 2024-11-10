package lab3;

import lab1.Student;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class MainLab3 {
    public static void main(String[] args) {
        // Створення об'єкта Student
        Student student = new Student("Ivan", "Ivanov", LocalDate.of(2000, 1, 1), "123456");

        // Ініціалізація серіалізаторів
        JsonSerializer<Student> jsonSerializer = new JsonSerializer<>(Student.class);
        XmlSerializer<Student> xmlSerializer = new XmlSerializer<>(Student.class);
        YamlSerializer<Student> yamlSerializer = new YamlSerializer<>(Student.class);

        try {
//            // Закоментовано серіалізацію та запис у JSON
//            // String json = jsonSerializer.serialize(student);
//            // System.out.println("Serialized JSON: " + json);
//            // jsonSerializer.writeToFile(student, new File("student.json"));
//
//            // Читання з файлу JSON
//            Student studentFromJson = jsonSerializer.readFromFile(new File("student.json"));
//            System.out.println("Deserialized from JSON file: " + studentFromJson);
//
//            // Закоментовано серіалізацію та запис у XML
//            // String xml = xmlSerializer.serialize(student);
//            // System.out.println("Serialized XML: " + xml);
//            // xmlSerializer.writeToFile(student, new File("student.xml"));
//
//            // Читання з файлу XML
//            Student studentFromXml = xmlSerializer.readFromFile(new File("student.xml"));
//            System.out.println("Deserialized from XML file: " + studentFromXml);
//
//            // Закоментовано серіалізацію та запис у YAML
//            // String yaml = yamlSerializer.serialize(student);
//            // System.out.println("Serialized YAML: " + yaml);
//            // yamlSerializer.writeToFile(student, new File("student.yaml"));

            // Читання з файлу YAML
            Student studentFromYaml = yamlSerializer.readFromFile(new File("student.yaml"));
            System.out.println("Deserialized from YAML file: " + studentFromYaml);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

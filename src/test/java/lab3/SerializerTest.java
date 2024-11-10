package lab3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import lab1.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class SerializerTest {

    private final ObjectMapper jsonMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private final ObjectMapper xmlMapper = new XmlMapper().registerModule(new JavaTimeModule());
    private final ObjectMapper yamlMapper = new YAMLMapper().registerModule(new JavaTimeModule());

    @Test
    public void testSerializeDeserializeJson() throws IOException {
        // Створюємо студента для тесту
        Student student = createStudent();

        // Серіалізація в JSON
        String json = jsonMapper.writeValueAsString(student);
        System.out.println("Serialized JSON: " + json);

        // Запис JSON у файл
        String jsonFilePath = "data/student.json";
        writeToFile(json, jsonFilePath);

        // Десеріалізація з JSON
        Student deserializedStudent = jsonMapper.readValue(json, Student.class);
        Assertions.assertEquals(student, deserializedStudent);
    }

    @Test
    public void testSerializeDeserializeXml() throws IOException {
        // Створюємо студента для тесту
        Student student = createStudent();

        // Серіалізація в XML
        String xml = xmlMapper.writeValueAsString(student);
        System.out.println("Serialized XML: " + xml);

        // Запис XML у файл
        String xmlFilePath = "data/student.xml";
        writeToFile(xml, xmlFilePath);

        // Десеріалізація з XML
        Student deserializedStudent = xmlMapper.readValue(xml, Student.class);
        Assertions.assertEquals(student, deserializedStudent);
    }

    @Test
    public void testSerializeDeserializeYaml() throws IOException {
        // Створюємо студента для тесту
        Student student = createStudent();

        // Серіалізація в YAML
        String yaml = yamlMapper.writeValueAsString(student);
        System.out.println("Serialized YAML: " + yaml);

        // Запис YAML у файл
        String yamlFilePath = "data/student.yaml";
        writeToFile(yaml, yamlFilePath);

        // Десеріалізація з YAML
        Student deserializedStudent = yamlMapper.readValue(yaml, Student.class);
        Assertions.assertEquals(student, deserializedStudent);
    }

    // Метод для створення студента
    private Student createStudent() {
        return new Student("Ivan", "Ivanov", LocalDate.of(2000, 1, 1), "123456");
    }

    // Метод для запису в файл
    private void writeToFile(String content, String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.createDirectories(path.getParent());
            Files.write(path, content.getBytes());
            System.out.println("Файл успішно створено: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

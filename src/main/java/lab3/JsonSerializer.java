package lab3;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonSerializer<T> implements Serializer<T> {
    private final ObjectMapper objectMapper;
    private final Class<T> clazz; // Додано поле clazz

    public JsonSerializer(Class<T> clazz) {
        this.clazz = clazz;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule()); // Реєстрація модуля для підтримки LocalDate
    }

    @Override
    public String serialize(T entity) throws IOException {
        return objectMapper.writeValueAsString(entity);
    }

    @Override
    public T deserialize(String data) throws IOException {
        return objectMapper.readValue(data, clazz);
    }

    @Override
    public void writeToFile(T entity, File file) throws IOException {
        objectMapper.writeValue(file, entity);
    }

    @Override
    public T readFromFile(File file) throws IOException {
        return objectMapper.readValue(file, clazz);
    }
}

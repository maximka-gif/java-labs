plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.8.0")
    // Залежності для серіалізації
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2") // JSON
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.15.2") // XML
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.15.2") // YAML

    // Залежності для JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.0")  // Для параметризованих тестів
}

tasks.test {
    useJUnitPlatform()  // Використовуємо платформу JUnit 5 для тестів
}

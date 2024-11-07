plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Залежності для серіалізації
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2") // JSON
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.15.2") // XML
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.15.2") // YAML

    // Залежності для тестування (TestNG)
    testImplementation("org.testng:testng:7.4.0")

    // Залежності для JUnit (необхідні для запуску тестів у тестовій платформі JUnit)
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
}

tasks.test {
    useJUnitPlatform()
}

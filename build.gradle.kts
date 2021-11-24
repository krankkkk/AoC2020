plugins {
    java
}

group = "de.aoc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")

    // https://mvnrepository.com/artifact/org.openjdk.jmh/jmh-core-benchmarks
    testImplementation("org.openjdk.jmh:jmh-core-benchmarks:1.33")

}

tasks.test {
    useJUnitPlatform()
}
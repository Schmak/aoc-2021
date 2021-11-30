plugins {
    kotlin("jvm") version "1.6.0"
}

repositories {
    mavenCentral()
}

val jUnitVersion by extra("5.8.1")
val assertjVersion by extra("3.21.0")

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:$jUnitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$jUnitVersion")
    testImplementation("org.assertj:assertj-core:$assertjVersion")
}
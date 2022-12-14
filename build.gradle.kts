plugins {
    kotlin("jvm") version "1.7.20"
    `maven-publish`
}

group = "com.ldhdev"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    testImplementation(kotlin("test"))
}

tasks {
    test {
        useJUnitPlatform()
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

}

java {
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {

            groupId = "com.github.ldhdev916"

            from(components["java"])
        }
    }
}
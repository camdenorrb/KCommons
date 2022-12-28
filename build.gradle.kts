plugins {
    `maven-publish`
    kotlin("jvm") version "1.7.22"
}

group = "me.camdenorrb"
version = "1.3.0"

repositories {
    mavenCentral()
}

dependencies {

    // Runtime

    compileOnly(kotlin("stdlib-jdk8"))
    compileOnly(kotlin("reflect"))

    //compile("com.google.guava:guava:+")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    // Test
    testImplementation(kotlin("test-junit"))
}

tasks {
    compileKotlin {
        kotlinOptions.freeCompilerArgs = listOf("-Xjvm-default=compatibility")
    }
    compileTestKotlin {
        kotlinOptions.freeCompilerArgs = listOf("-Xjvm-default=compatibility")
    }
}

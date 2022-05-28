plugins {
    `maven-publish`
    kotlin("jvm") version "1.4.10"
}

group = "me.camdenorrb"
version = "1.2.1"

repositories {
    mavenCentral()
}

dependencies {

    // Runtime

    compileOnly(kotlin("stdlib-jdk8"))
    compileOnly(kotlin("reflect"))

    //compile("com.google.guava:guava:+")
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")

    // Test

    testImplementation(kotlin("test-junit"))

    testImplementation(kotlin("stdlib-jdk8"))
    testImplementation(kotlin("reflect"))
}

tasks {
    compileKotlin {
        kotlinOptions.freeCompilerArgs = listOf("-Xjvm-default=compatibility")
    }
    compileTestKotlin {
        kotlinOptions.freeCompilerArgs = listOf("-Xjvm-default=compatibility")
    }
}

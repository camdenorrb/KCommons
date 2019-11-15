import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    maven
    kotlin("jvm") version "1.3.50"
}

group = "me.camdenorrb"
version = "1.1.0"

repositories {
    mavenCentral()
}

dependencies {

    // Runtime

    compileOnly(kotlin("stdlib"))
    compileOnly(kotlin("reflect"))

    compile("com.google.guava:guava:+")
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.2")

    // Test

    testImplementation(kotlin("test-junit"))

    testImplementation(kotlin("stdlib"))
    testImplementation(kotlin("reflect"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.freeCompilerArgs = listOf("-Xjvm-default=compatibility")
}
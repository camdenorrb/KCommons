import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    maven
    kotlin("jvm") version "1.3.40"
}

group = "me.camdenorrb"
version = "1.0.4"

repositories {
    mavenCentral()
}

dependencies {

    compileOnly(kotlin("stdlib"))
    compileOnly(kotlin("reflect"))

    implementation("com.google.guava:guava:+")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.freeCompilerArgs = listOf("-Xjvm-default=compatibility")
}
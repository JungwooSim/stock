import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "3.1.4"
  id("io.spring.dependency-management") version "1.1.3"
  kotlin("jvm") version "1.8.22"
  kotlin("plugin.spring") version "1.8.22"
}

//group = "com.stock"
//version = "0.0.1-SNAPSHOT"

java {
  sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
//  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("io.asyncer:r2dbc-mysql:1.0.3")
  implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
  implementation("org.springframework.kafka:spring-kafka")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("io.projectreactor:reactor-test")
  testImplementation("org.springframework.kafka:spring-kafka-test")
  testImplementation("io.github.serpro69:kotlin-faker:1.14.0")

  testImplementation("org.testcontainers:testcontainers:1.19.0")
  testImplementation("org.testcontainers:r2dbc:1.19.0")
  testImplementation("org.testcontainers:mysql:1.19.0")
  testImplementation("org.testcontainers:junit-jupiter:1.19.0")

  implementation(project(":common"))
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs += "-Xjsr305=strict"
    jvmTarget = "17"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}

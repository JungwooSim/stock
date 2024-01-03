plugins {
  kotlin("plugin.serialization") version "1.6.0"
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
  implementation("org.springframework.boot:spring-boot-starter-webflux")
  implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
  implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
  implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.2.0")

  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("io.projectreactor:reactor-test")

  implementation(project(":infrastructure"))
  implementation(project(":common"))
}

tasks.withType<Test> {
  useJUnitPlatform()
}
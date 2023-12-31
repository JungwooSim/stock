dependencies {
  implementation("org.springframework.boot:spring-boot-starter-webflux")
  implementation("org.springframework.kafka:spring-kafka")
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
  testImplementation("org.springframework.boot:spring-boot-starter-test")

  implementation(project(":common"))
//  implementation(project(":infrastructure"))
}

tasks.withType<Test> {
  useJUnitPlatform()
}

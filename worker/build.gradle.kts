dependencies {
  implementation("org.springframework.boot:spring-boot-starter-webflux")
  implementation("org.springframework.kafka:spring-kafka")
  testImplementation("org.springframework.boot:spring-boot-starter-test")

  implementation(project(":common"))
  implementation(project(":infrastructure"))
}

tasks.withType<Test> {
  useJUnitPlatform()
}

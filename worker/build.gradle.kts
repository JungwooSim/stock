dependencies {
  implementation("org.springframework.boot:spring-boot-starter-webflux")
  implementation("org.springframework.boot:spring-boot-starter-batch")
  implementation("org.springframework.kafka:spring-kafka")
  testImplementation("org.springframework.boot:spring-boot-starter-test")

  api(project(":infrastructure"))
  implementation(project(":common"))
}

tasks.withType<Test> {
  useJUnitPlatform()
}
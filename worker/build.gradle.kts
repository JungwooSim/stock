dependencies {
  implementation("org.springframework.boot:spring-boot-starter-webflux")
  implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
  implementation("org.springframework.boot:spring-boot-starter-batch")
  implementation("org.springframework.kafka:spring-kafka")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  
  implementation(project(":infra"))
  implementation(project(":common"))
}

tasks.withType<Test> {
  useJUnitPlatform()
}
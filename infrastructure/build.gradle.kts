dependencies {
  implementation("org.springframework.boot:spring-boot-starter-webflux")
  implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
  implementation("io.asyncer:r2dbc-mysql:1.0.3")
  implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
  implementation("org.springframework.kafka:spring-kafka")
  implementation("org.springframework.boot:spring-boot-starter-aop")

  // resilience4j
  implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-reactor-resilience4j:3.1.0")

  // test
  testImplementation("io.r2dbc:r2dbc-h2")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("io.projectreactor:reactor-test")
  testImplementation("org.springframework.kafka:spring-kafka-test")
  testImplementation("io.github.serpro69:kotlin-faker:1.14.0")
  testImplementation("com.squareup.okhttp3:mockwebserver:4.9.1")
  runtimeOnly("com.h2database:h2")

  implementation(project(":common"))
}

tasks.withType<Test> {
  useJUnitPlatform()
}
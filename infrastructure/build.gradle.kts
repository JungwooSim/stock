dependencies {
  implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
//  implementation("io.asyncer:r2dbc-mysql:1.0.3")
  implementation("io.r2dbc:r2dbc-h2")
  implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
  implementation("org.springframework.kafka:spring-kafka")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("io.projectreactor:reactor-test")
  testImplementation("org.springframework.kafka:spring-kafka-test")
  testImplementation("io.github.serpro69:kotlin-faker:1.14.0")

//  testImplementation("org.testcontainers:testcontainers:1.19.0")
//  testImplementation("org.testcontainers:r2dbc:1.19.0")
//  testImplementation("org.testcontainers:mysql:1.19.0")
//  testImplementation("org.testcontainers:junit-jupiter:1.19.0")
  runtimeOnly("com.h2database:h2")


  implementation(project(":common"))
}

tasks.withType<Test> {
  useJUnitPlatform()
}

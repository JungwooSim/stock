package com.stock.infrastructure

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest

@SpringBootApplication(
  scanBasePackages = ["com.stock.infrastructure"],
)
class InfrastructureApplication

@SpringBootTest
class InfrastructureApplicationTest
package com.stock.worker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
  scanBasePackages = ["com.stock.infrastructure"],
)
class WorkerApplication

fun main(args: Array<String>) {
  runApplication<WorkerApplication>(*args)
}
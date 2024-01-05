package com.future.stock

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
  scanBasePackages = ["com.future.stock"]
)
class WorkerApplication

fun main(args: Array<String>) {
  runApplication<WorkerApplication>(*args)
}
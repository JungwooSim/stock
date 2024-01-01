package com.stock.worker.interfaces

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class OrderListener {
  @KafkaListener(
    topics = ["order"],
    groupId = "Stock-worker",
  )
  fun orderListener(message: String) {
    println(message)
  }
}
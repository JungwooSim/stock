package com.stock.worker.application.order

import java.time.LocalDateTime

class KafkaOrderPayload(
  val quantity: Int,
  val price: Long,
  val stockId: Long,
  val userId: Long,
  val modifiedAt: LocalDateTime,
  val createdAt: LocalDateTime,
)
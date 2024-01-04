package com.stock.worker.domain.order

import java.time.LocalDateTime

class KafkaOrderPayload(
  val quantity: Int,
  val price: Long,
  val stockId: Long,
  val userId: Long,
  val modifiedAt: LocalDateTime,
  val createdAt: LocalDateTime,
)
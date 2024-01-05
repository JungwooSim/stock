package com.future.stock.app.interfaces.order

import java.math.BigDecimal
import java.time.LocalDateTime

class OrderResponse(
  val id: Long?,
  val quantity: Long,
  val price: BigDecimal,
  val stockId: Long,
  val userId: Long,
  // 최초에는 0, 연동사를 통해 갱신
  val orderNo: Long = 0,
  // TODO : Spring Data 에서 auditing 적용하기
  val modifiedAt: LocalDateTime = LocalDateTime.now(),
  // TODO : Spring Data 에서 auditing 적용하기
  val createdAt: LocalDateTime = LocalDateTime.now(),
)
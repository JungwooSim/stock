package com.stock.interfaces.order

import java.math.BigDecimal

class OrderRequest(
  // 주문 수량
  val quantity: Long,
  // 주문 가격
  val price: BigDecimal,
  // 종목
  val stockId: Long,
)
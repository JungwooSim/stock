package com.stock.domain.order

import com.stock.common.enums.TransactionKindEnum
import com.stock.common.enums.TransactionStateEnum
import com.stock.interfaces.order.OrderResponse
import java.math.BigDecimal
import java.time.LocalDateTime

class Order(
  val id: Long? = null,
  val kind: TransactionKindEnum = TransactionKindEnum.BUY,
  val state: TransactionStateEnum = TransactionStateEnum.WAITING,
  val quantity: Long,
  val price: BigDecimal,
  val stockId: Long,
  val userId: Long,
  val orderNo: Long = 0, // 최초에는 0, 연동사를 통해 갱신
  val modifiedAt: LocalDateTime = LocalDateTime.now(), // TODO : Spring Data 에서 auditing 적용하기
  val createdAt: LocalDateTime = LocalDateTime.now(), // TODO : Spring Data 에서 auditing 적용하기
) {

  fun toOrderResponse(): OrderResponse {
    return OrderResponse(
      id = this.id,
      quantity = this.quantity,
      price = this.price,
      stockId = this.stockId,
      userId = this.userId,
      orderNo = this.orderNo,
      modifiedAt = this.modifiedAt,
      createdAt = this.createdAt,
    )
  }
}
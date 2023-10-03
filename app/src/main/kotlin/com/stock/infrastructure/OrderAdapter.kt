package com.stock.infrastructure

import com.stock.domain.order.Order
import com.stock.infrastructure.db.TransactionEntity
import com.stock.infrastructure.db.TransactionRepository
import org.springframework.stereotype.Component

@Component
class OrderAdapter(
  private val transactionRepository: TransactionRepository,
) : OrderPort {
  override suspend fun saveDb(order: Order): Order {
    val savedOrder = transactionRepository.save(
      TransactionEntity(
        kind = order.kind,
        state = order.state,
        quantity = order.quantity,
        price = order.price,
        userId = order.userId,
        stockId = order.stockId,
        orderNo = order.orderNo,
        modifiedAt = order.modifiedAt,
        createdAt = order.createdAt,
      )
    )

    return Order(
      id = savedOrder.id,
      kind = savedOrder.kind,
      state = savedOrder.state,
      quantity = savedOrder.quantity,
      price = savedOrder.price,
      stockId = savedOrder.stockId,
      userId = savedOrder.userId,
      orderNo = savedOrder.orderNo,
      modifiedAt = savedOrder.modifiedAt,
      createdAt = savedOrder.createdAt,
    )
  }

  override fun saveMessage() {
    TODO("Not yet implemented")
  }
}
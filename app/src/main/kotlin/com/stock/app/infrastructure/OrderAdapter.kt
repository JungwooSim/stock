package com.stock.app.infrastructure

import com.stock.common.enums.TopicEnum
import com.stock.app.domain.order.Order
import com.stock.infrastructure.db.TransactionEntity
import com.stock.infrastructure.db.TransactionRepository
import com.stock.infrastructure.kafka.KafkaPublisher
import org.springframework.stereotype.Component

@Component
class OrderAdapter(
  private val transactionRepository: TransactionRepository,
  private val kafkaPublisher: KafkaPublisher,
) : OrderPort {
  override suspend fun saveDb(order: Order): Order {
    val savedOrder =
      transactionRepository.save(
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
        ),
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

  override fun saveMessage(
    topicEnum: TopicEnum,
    payload: String,
  ) {
    kafkaPublisher.sendMessage(
      topicName = topicEnum,
      payLoad = payload,
    )
  }
}
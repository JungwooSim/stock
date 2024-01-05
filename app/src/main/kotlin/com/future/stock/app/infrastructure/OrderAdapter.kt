package com.future.stock.app.infrastructure

import com.future.stock.common.enums.TopicEnum
import com.future.stock.app.domain.order.Order
import com.future.stock.infra.db.TransactionEntity
import com.future.stock.infra.db.TransactionRepository
import com.future.stock.infra.kafka.KafkaPublisher
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
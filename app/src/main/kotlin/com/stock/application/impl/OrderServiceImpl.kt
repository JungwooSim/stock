package com.stock.application.impl

import com.stock.application.OrderService
import com.stock.common.enums.TopicEnum
import com.stock.domain.order.Order
import com.stock.infrastructure.OrderPort
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderServiceImpl(
  private val orderPort: OrderPort,
) : OrderService {
  @Transactional
  override suspend fun order(order: Order): Order {
    orderPort.saveDb(order = order)

    orderPort.saveMessage(
      topicEnum = TopicEnum.ORDER,
      payload = Json.encodeToString(order),
    )

    return order
  }
}
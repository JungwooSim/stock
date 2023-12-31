package com.future.stock.app.application.impl

import com.future.stock.app.application.OrderService
import com.future.stock.common.enums.TopicEnum
import com.future.stock.app.domain.order.Order
import com.future.stock.app.infrastructure.OrderPort
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
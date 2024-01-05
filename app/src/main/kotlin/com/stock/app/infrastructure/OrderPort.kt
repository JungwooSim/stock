package com.stock.app.infrastructure

import com.stock.common.enums.TopicEnum
import com.stock.app.domain.order.Order

interface OrderPort {
  suspend fun saveDb(order: Order): Order

  fun saveMessage(
    topicEnum: TopicEnum,
    payload: String,
  )
}
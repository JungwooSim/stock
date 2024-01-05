package com.future.stock.app.infrastructure

import com.future.stock.common.enums.TopicEnum
import com.future.stock.app.domain.order.Order

interface OrderPort {
  suspend fun saveDb(order: Order): Order

  fun saveMessage(
    topicEnum: TopicEnum,
    payload: String,
  )
}
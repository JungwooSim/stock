package com.stock.infrastructure

import com.stock.common.enums.TopicEnum
import com.stock.domain.order.Order

interface OrderPort {
  suspend fun saveDb(order: Order): Order

  fun saveMessage(
    topicEnum: TopicEnum,
    payload: String,
  )
}
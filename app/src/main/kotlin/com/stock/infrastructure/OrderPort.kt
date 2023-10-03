package com.stock.infrastructure

import com.stock.domain.order.Order

interface OrderPort {

  suspend fun saveDb(order: Order): Order

  fun saveMessage()
}
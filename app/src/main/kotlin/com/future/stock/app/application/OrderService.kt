package com.future.stock.app.application

import com.future.stock.app.domain.order.Order

interface OrderService {
  suspend fun order(order: Order): Order
}
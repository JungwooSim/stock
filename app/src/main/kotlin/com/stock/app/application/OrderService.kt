package com.stock.app.application

import com.stock.app.domain.order.Order

interface OrderService {
  suspend fun order(order: Order): Order
}
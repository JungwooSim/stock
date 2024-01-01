package com.stock.application

import com.stock.domain.order.Order

interface OrderService {
  suspend fun order(order: Order): Order
}
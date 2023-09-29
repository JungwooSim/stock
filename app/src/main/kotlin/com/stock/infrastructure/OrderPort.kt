package com.stock.infrastructure

import com.stock.domain.order.Order

interface OrderPort {

  fun saveDb(): Order

  fun saveMessage()
}
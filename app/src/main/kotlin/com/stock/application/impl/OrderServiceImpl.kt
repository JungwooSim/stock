package com.stock.application.impl

import com.stock.application.OrderService
import com.stock.domain.order.Order
import com.stock.infrastructure.OrderPort
import com.stock.interfaces.order.OrderRequest
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderServiceImpl(
  private val orderPort: OrderPort,
) : OrderService {
  @Transactional
  override suspend fun order(order: Order): Order {
//    orderPort.saveMessage()

    return orderPort.saveDb(order = order)
  }
}
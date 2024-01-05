package com.future.stock.app.interfaces.order

import com.future.stock.app.application.OrderService
import com.future.stock.app.domain.order.Order
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
  private val orderService: OrderService,
) {
  @PostMapping("/order")
  suspend fun order(
    @RequestBody orderRequest: OrderRequest,
  ): OrderResponse {
    return orderService.order(
      Order(
        quantity = orderRequest.quantity,
        price = orderRequest.price,
        stockId = orderRequest.stockId,
        // TODO : 유저값 셋팅 필요
        userId = 1,
      ),
    ).toOrderResponse()
  }
}
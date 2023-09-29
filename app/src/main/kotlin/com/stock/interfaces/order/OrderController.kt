package com.stock.interfaces.order

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController {

  @PostMapping("/order")
  fun order(@RequestBody orderRequest: OrderRequest): OrderResponse {
    return OrderResponse()
  }
}
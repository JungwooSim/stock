package com.future.stock.worker.interfaces

import com.future.stock.worker.application.StockService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StockInterface(
  private val stockService: StockService,
) {

  @PutMapping("/stock")
  suspend fun patchStockList(): com.future.stock.worker.global.dto.BaseResponse<String> {
    stockService.saveStockAtCSV()
    
    return com.future.stock.worker.global.dto.BaseResponse(
      data = "OK"
    )
  }
}
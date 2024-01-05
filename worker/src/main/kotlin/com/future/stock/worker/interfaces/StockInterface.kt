package com.future.stock.worker.interfaces

import com.future.stock.worker.application.StockService
import com.future.stock.worker.global.dto.BaseResponse
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StockInterface(
  private val stockService: StockService,
) {

  @PutMapping("/stock")
  suspend fun patchStockList(): BaseResponse<Int> {
    
    return BaseResponse(
      data = stockService.saveStockAtCSV()
    )
  }
}
package com.stock.worker.interfaces

import com.stock.worker.application.StockService
import com.stock.worker.global.dto.BaseResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StockInterface(
  private val stockService: StockService,
) {

  @PostMapping("/stock/test")
  suspend fun patchStockList(): BaseResponse<String> {
    stockService.saveStockAtCSV()
    
    return BaseResponse(
      data = "OK"
    )
  }
}
package com.future.stock.app.interfaces.view

import com.future.stock.app.application.StockService
import com.future.stock.app.interfaces.view.dto.PaginationRequest
import com.future.stock.app.interfaces.view.dto.StockResponse
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ViewController(
  private val stockService: StockService,
) {

  @GetMapping("/view/index")
  suspend fun index(): String {
    return "html/index"
  }

  @GetMapping("/view/stock")
  suspend fun stockList(
    paginationRequest: PaginationRequest,
    model: Model,
  ): String {
    // TODO(중) : 페이징 추가
    println("pagesize : ${paginationRequest.pageSize}")
    println("pageToken : ${paginationRequest.pageToken}")
    model.addAttribute("stocks", stockService.getStocks(paginationRequest).map { StockResponse.of(it) })
    return "stock-list"
  }
}
package com.future.stock.app.interfaces.view

import com.future.stock.app.application.StockService
import com.future.stock.app.interfaces.view.dto.StockResponse
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import reactor.core.publisher.Mono

@Controller
class ViewController(
  private val stockService: StockService,
) {

  @GetMapping("/view/index")
  suspend fun index(): String {
    return "html/index"
  }

  @GetMapping("/view/stock")
  suspend fun stockList(model: Model): String {
    // TOOD(중) : 페이징 추가 
    val a = stockService.getStocks().map { StockResponse.of(it) }.toList()
    model.addAttribute("stocks", stockService.getStocks().map { StockResponse.of(it) })
    return "stock-list"
  }
}
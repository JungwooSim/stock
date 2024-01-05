package com.stock.worker.infrastructure

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest

@SpringBootApplication(
  exclude = [R2dbcAutoConfiguration::class]
)
class StockPortTestApplication

@SpringBootTest
class StockPortTest @Autowired constructor(
  private val stockPort: com.future.stock.worker.infrastructure.StockPort,
) : StockPortTestApplication() {

  @Test
  fun getStockAtCSV() {
    // when
    val stocks = stockPort.getStockAtCSV()

    // then
    stocks.size
  }
}
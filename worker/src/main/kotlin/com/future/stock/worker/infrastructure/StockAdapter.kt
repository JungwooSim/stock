package com.future.stock.worker.infrastructure

import com.future.stock.worker.domain.stock.Stock
import java.io.BufferedReader
import java.io.FileReader
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component

@Component
class StockAdapter : StockPort {
  
  // TODO : Spring Batch 로 변경하기
  override fun getStockAtCSV(): List<Stock> {
    val resource = ClassPathResource("csv/stock-list.csv")
    
    val bufferedReader = BufferedReader(FileReader(resource.file, Charsets.UTF_8))

    val stocks = mutableListOf<Stock>()
    var i = 0
    bufferedReader.readLines().forEach {
      if (i != 0) {
        val data = it.replace("\"", "").split(",")
        stocks.add(
          Stock(
            nameKrAbbreviation = data[3],
            nameKr = data[2],
            nameEn = data[4],
            code = data[1],
            standardCode = data[0],
            market = data[6],
            country = data[7],
          )
        )
      }
      i++
    }
  
    return stocks
  }
}


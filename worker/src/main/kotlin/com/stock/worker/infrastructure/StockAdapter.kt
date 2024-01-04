package com.stock.worker.infrastructure

import com.stock.worker.domain.stock.Stock
import java.io.BufferedReader
import java.io.FileReader
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component

@Component
class StockAdapter : StockPort {
  
  override fun getStockAtCSV(): List<Stock> {
    val resource = ClassPathResource("csv/stock-list.csv")
    
//    val reader = FlatFileItemReaderBuilder<Stock>()
//      .resource(resource)
//      .delimited()
//      .names("standardCode", "code", "nameKrAbbreviation", "nameKr", "nameEn", "day", "market", "kind1", "group", "kind2", "price", "count")
//      .targetType(Stock::class.java)
//      .linesToSkip(1)
//      .build()

  
    val bufferedReader = BufferedReader(FileReader(resource.file, Charsets.UTF_8))

    val stocks = mutableListOf<Stock>()
    var i = 0
    bufferedReader.readLines().forEach {
      println(it.split(","))
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

package com.future.stock.app.application.impl

import com.future.stock.app.application.StockService
import com.future.stock.app.domain.stock.Stock
import com.future.stock.app.interfaces.view.dto.PaginationRequest
import com.future.stock.infra.db.StockRepository
import java.time.LocalDateTime
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service

@Service
class StockServiceImpl(
  private val stockRepository: StockRepository,
) : StockService {
//  override fun getStocks(): Flow<Stock> {
//    return stockRepository.findAll().map {
//      Stock.ofStockEntity(it)
//    }
//  }

  override fun getStocks(paginationRequest: PaginationRequest): Flow<Stock> {
    return (1..5).map {
      Stock(
        id = it.toLong(),
        nameKrAbbreviation = "신영스팩9호${it}",
        nameKr = "신영스팩8호${it}",
        nameEn = "Shinyoung HappyTomorrow No.8 Special Purpose Acquisition Company${it}",
        code = "445970",
        standardCode = "KR7445970007",
        market = "KOSDAQ",
        country = "KR",
        modifiedAt = LocalDateTime.now(),
        createdAt = LocalDateTime.now(),
      )
    }.asFlow()
  }
}
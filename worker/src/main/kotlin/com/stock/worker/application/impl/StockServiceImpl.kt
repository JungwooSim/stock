package com.stock.worker.application.impl

import com.stock.infrastructure.db.StockRepository
import com.stock.worker.application.StockService
import com.stock.worker.infrastructure.StockPort
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StockServiceImpl(
  private val stockRepository: StockRepository,
  private val stockPort: StockPort,
) : StockService {
  
  @Transactional
  override suspend fun saveStockAtCSV(): Unit = runBlocking {

    val stocks = stockPort.getStockAtCSV()

    val stockEntities = stocks.map { 
      it.toDocument()
    }

    stockRepository.saveAll(
      stockEntities
    )
  }
}
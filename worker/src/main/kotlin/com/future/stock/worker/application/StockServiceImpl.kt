package com.future.stock.worker.application

import com.future.stock.infra.db.StockRepository
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StockServiceImpl (
  private val stockRepository: StockRepository,
  private val stockPort: com.future.stock.worker.infrastructure.StockPort,
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
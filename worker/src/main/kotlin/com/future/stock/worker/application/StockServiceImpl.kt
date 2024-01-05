package com.future.stock.worker.application

import com.future.stock.infra.db.StockRepository
import com.future.stock.worker.infrastructure.StockPort
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StockServiceImpl (
  private val stockRepository: StockRepository,
  private val stockPort: StockPort,
) : StockService {
  
  @Transactional
  override suspend fun saveStockAtCSV(): Int = runBlocking {
    // TODO : 중복 insert 안되도록 select 후 update 하도록 수정 필요
    val stocks = stockPort.getStockAtCSV()

    val stockEntities = stocks.map { 
      it.toDocument()
    }

    stockRepository.saveAll(
      stockEntities
    ).toList().size
  }
}
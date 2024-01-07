package com.future.stock.app.application

import com.future.stock.app.domain.stock.Stock
import kotlinx.coroutines.flow.Flow

interface StockService {
  
  fun getStocks(): Flow<Stock>
}
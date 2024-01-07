package com.future.stock.app.application

import com.future.stock.app.domain.stock.Stock
import com.future.stock.app.interfaces.view.dto.PaginationRequest
import kotlinx.coroutines.flow.Flow

interface StockService {
  
  fun getStocks(paginationRequest: PaginationRequest): Flow<Stock>
}
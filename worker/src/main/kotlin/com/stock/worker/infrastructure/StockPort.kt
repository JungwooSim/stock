package com.stock.worker.infrastructure

import com.stock.worker.domain.stock.Stock

interface StockPort {
  fun getStockAtCSV(): List<Stock>
}
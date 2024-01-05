package com.future.stock.worker.infrastructure

import com.future.stock.worker.domain.stock.Stock

interface StockPort {
  fun getStockAtCSV(): List<com.future.stock.worker.domain.stock.Stock>
}
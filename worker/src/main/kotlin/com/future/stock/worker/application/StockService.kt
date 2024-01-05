package com.future.stock.worker.application

interface StockService {

  suspend fun saveStockAtCSV()
}
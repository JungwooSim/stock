package com.stock.worker.application

interface StockService {

  suspend fun saveStockAtCSV()
}
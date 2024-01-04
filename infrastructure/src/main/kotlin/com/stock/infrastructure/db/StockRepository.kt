package com.stock.infrastructure.db

import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface StockRepository : CoroutineCrudRepository<StockEntity, Long>
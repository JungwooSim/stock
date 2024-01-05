package com.future.stock.infra.db

import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface StockRepository : CoroutineCrudRepository<StockEntity, Long>
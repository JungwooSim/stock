package com.stock.infrastructure.db

import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface TransactionRepository : CoroutineCrudRepository<TransactionEntity, Long>
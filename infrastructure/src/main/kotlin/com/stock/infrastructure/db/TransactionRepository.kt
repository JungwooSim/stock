package com.stock.infrastructure.db

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface TransactionRepository : ReactiveCrudRepository<TransactionEntity, Long>
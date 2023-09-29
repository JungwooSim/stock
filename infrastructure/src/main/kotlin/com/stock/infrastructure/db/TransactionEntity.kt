package com.stock.infrastructure.db

import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Table("transaction")
class TransactionEntity(
  val id: Long? = null,
  val kind: TransactionKindEnum,
  val state: TransactionStateEnum,
  val quantity: Long,
  val price: BigDecimal,
  val userId: Long,
  val stockId: Long,
  val orderNo: Long,
  val modifiedAt: LocalDateTime,
  val createdAt: LocalDateTime
)
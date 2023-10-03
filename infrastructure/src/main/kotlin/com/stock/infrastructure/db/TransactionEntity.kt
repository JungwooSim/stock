package com.stock.infrastructure.db

import com.stock.common.enums.TransactionKindEnum
import com.stock.common.enums.TransactionStateEnum
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
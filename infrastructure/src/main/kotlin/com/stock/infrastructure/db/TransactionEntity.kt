package com.stock.infrastructure.db

import com.stock.common.enums.TransactionKindEnum
import com.stock.common.enums.TransactionStateEnum
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDateTime

// TODO : 환경별 DB 설정 파일 추가하기
@Table("transaction")
class TransactionEntity constructor(
  val id: Long? = null,
  val kind: TransactionKindEnum,
  val state: TransactionStateEnum,
  val quantity: Long,
  val price: BigDecimal,
  val userId: Long,
  val stockId: Long,
  val orderNo: Long,

  @Column("modified_at")
  val modifiedAt: LocalDateTime,

  @Column("created_at")
  val createdAt: LocalDateTime
)
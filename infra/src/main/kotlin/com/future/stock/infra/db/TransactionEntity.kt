package com.future.stock.infra.db

import com.future.stock.common.enums.TransactionKindEnum
import com.future.stock.common.enums.TransactionStateEnum
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDateTime

// TODO : 환경별 DB 설정 파일 추가하기
@Table(name = "transaction")
class TransactionEntity constructor(
  @Id
  val id: Long? = null,
  val kind: TransactionKindEnum,
  val state: TransactionStateEnum,
  val quantity: Long,
  val price: BigDecimal,
  val userId: Long,
  val stockId: Long,
  val orderNo: Long,
  @Column("modified_at")
  @LastModifiedDate
  val modifiedAt: LocalDateTime,
  @Column("created_at")
  @CreatedDate
  val createdAt: LocalDateTime,
)
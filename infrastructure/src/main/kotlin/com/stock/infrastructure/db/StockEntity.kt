package com.stock.infrastructure.db

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "stock")
class StockEntity constructor(

  @Id
  val id: Long?,

  /**
   * 한글 종목명
   */
  @JsonProperty("name_kr_abbreviation")
  val nameKrAbbreviation: String,

  /**
   * 한글 종목명
   */
  @JsonProperty("name_kr")
  val nameKr: String,

  /**
   * 영문 종목명
   */
  @JsonProperty("name_en")
  val nameEn: String,

  /**
   * 단축 코드
   */
  val code: String,

  /**
   * 표준 코드
   */
  @JsonProperty("standard_code")
  val standardCode: String,

  /**
   * 시장(KOSPI, KOSDAQ)
   */
  val market: String,

  /**
   * 표준 코드
   */
  val country: String,

  @Column("modified_at")
  @LastModifiedDate
  val modifiedAt: LocalDateTime?,
  
  @Column("created_at")
  @CreatedDate
  val createdAt: LocalDateTime?,
)
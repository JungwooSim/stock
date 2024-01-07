package com.future.stock.app.domain.stock

import com.future.stock.infra.db.StockEntity
import java.time.LocalDateTime

class Stock(

  val id: Long,

  /**
   * 한글 종목명 (약어)
   */
  val nameKrAbbreviation: String,

  /**
   * 한글 종목명
   */
  val nameKr: String,

  /**
   * 영문 종목명
   */
  val nameEn: String,

  /**
   * 단축 코드
   */
  val code: String,

  /**
   * 표준 코드
   */
  val standardCode: String,

  /**
   * 시장(KOSPI, KOSDAQ)
   */
  val market: String,

  /**
   * 표준 코드
   */
  val country: String,

  val modifiedAt: LocalDateTime?,

  val createdAt: LocalDateTime?,
) {
  companion object {
    fun ofStockEntity(stockEntity: StockEntity): Stock {
      return Stock(
        id = stockEntity.id!!,
        nameKrAbbreviation = stockEntity.nameKrAbbreviation,
        nameKr = stockEntity.nameKr,
        nameEn = stockEntity.nameEn,
        code = stockEntity.code,
        standardCode = stockEntity.standardCode,
        market = stockEntity.market,
        country = stockEntity.country,
        modifiedAt = stockEntity.modifiedAt,
        createdAt = stockEntity.createdAt,
      )
    }
  }
}
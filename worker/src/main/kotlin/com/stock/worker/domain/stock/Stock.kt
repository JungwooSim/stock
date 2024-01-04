package com.stock.worker.domain.stock

import com.stock.infrastructure.db.StockEntity

class Stock(
  /**
   * 한글 종목명
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
) {

  fun toDocument(): StockEntity {
    return StockEntity(
      id = null,
      nameKrAbbreviation = nameKrAbbreviation,
      nameKr = nameKr,
      nameEn = nameEn,
      code = code,
      standardCode = standardCode,
      market = market,
      country = country,
      createdAt = null,
      modifiedAt = null,
    )
  }
}
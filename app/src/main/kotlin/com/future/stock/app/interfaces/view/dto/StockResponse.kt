package com.future.stock.app.interfaces.view.dto

import com.future.stock.app.domain.stock.Stock
import java.time.LocalDateTime

class StockResponse(
  val id: Long,

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

  val modifiedAt: LocalDateTime?,
) {
  companion object {
    fun of(stock: Stock): StockResponse = StockResponse(
      id = stock.id,
      nameKrAbbreviation = stock.nameKrAbbreviation,
      nameKr = stock.nameKr,
      nameEn = stock.nameEn,
      code = stock.code,
      standardCode = stock.standardCode,
      market = stock.market,
      country = stock.country,
      modifiedAt = stock.modifiedAt,
    )
  }
}
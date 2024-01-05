package com.future.stock.infra.api.ebest

import com.future.stock.common.logger
import com.future.stock.infra.api.ebest.dto.EbestOrderRequest
import com.future.stock.infra.api.ebest.dto.EbestOrderResponse
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClientException
import org.springframework.web.reactive.function.client.awaitBody

@Component
class OrderApi(
  private val webclient: WebClient = WebClient.create("https://openapi.ebestsec.co.kr:8080"),
) {
  /**
   * 이베스트 증권 주문
   * API Document : https://openapi.ebestsec.co.kr/apiservice?group_id=73142d9f-1983-48d2-8543-89b75535d34c&api_id=d0e216e0-10d9-479f-8a4d-e175b8bae307
   */
  @CircuitBreaker(
    name = "ebest-order",
    fallbackMethod = "circuitBreakFallback",
  )
  suspend fun ebestOrder(ebestOrderRequest: EbestOrderRequest): EbestOrderResponse? {
    val headers = HttpHeaders()
    headers.set("content-type", "application/json;charset=utf-8") // 고정
    headers.set("authorization", "")
    headers.set("tr_cd", "")
    headers.set("tr_cont", "")
    headers.set("tr_cont_key", "")
    headers.set("mac_address", "")

    try {
      return webclient.post()
        .uri("/stock/order")
        .headers { it.addAll(headers) }
        .bodyValue(ebestOrderRequest)
        .retrieve()
        .awaitBody<EbestOrderResponse>()
    } catch (e: WebClientException) {
      logger.warn { e.message }
    }

    return null
  }

  fun circuitBreakFallback(throwable: Throwable) {
    logger.warn { "$throwable.message" }
  }
}
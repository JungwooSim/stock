package com.stock.infrastructure.api.ebest

import com.stock.infrastructure.api.ebest.dto.EbestOrderRequest
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry
import java.nio.charset.StandardCharsets
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.apache.commons.io.FileUtils
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.util.ResourceUtils
import org.springframework.web.reactive.function.client.WebClient

@SpringBootTest
class OrderApiTest @Autowired constructor(
  private val circuitBreakerRegistry: CircuitBreakerRegistry,
) {

  private lateinit var mockWebServer: MockWebServer
  private lateinit var orderApi: OrderApi

  @BeforeEach
  fun setUp() {
    mockWebServer = MockWebServer()

    mockWebServer.start()
    orderApi = OrderApi(
      webclient = WebClient.create(mockWebServer.url("/").toUrl().toString())
    )
  }

  @AfterEach
  fun tearDown() {
    mockWebServer.shutdown()
  }


  @Test
  fun successEbestOrder() {
    // given
    val responseBody = readFileToString("classpath:api-response/ebest-order-response.json")

    mockWebServer.enqueue(
      MockResponse()
        .setResponseCode(200)
        .setHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
        .setBody(responseBody)
    )

    // when
    val actual = runBlocking {
      orderApi.ebestOrder(
        EbestOrderRequest(
         cSPAT00601InBlock1 = EbestOrderRequest.CSPAT00601InBlock1(
           isuNo = "",
           ordQty = 1,
           ordPrc = 10000.0,
           bnsTpCode = "",
           ordprcPtnCode = "",
           mgntrnCode = "",
           loanDt = "",
           ordCndiTpCode = "",
         )
       )
      )
    }

    // then
    assertEquals("00040", actual?.rspCd)
  }

  // TODO : 서킷 open 확인하는 코드 완성하기
  @Disabled
  @Test
  fun circuitBreakerEbestOrder(): Unit = runBlocking {
    // given
//    val circuitBreakerRegistry = CircuitBreakerRegistry.ofDefaults()
//    val circuitBreaker = circuitBreakerRegistry.circuitBreaker("ebest-order")
    val responseBody = readFileToString("classpath:api-response/ebest-order-response.json")

    // when
    (0..100).forEach { _ ->
      mockWebServer.enqueue(MockResponse().setResponseCode(500))
      orderApi.ebestOrder(
        EbestOrderRequest(
          cSPAT00601InBlock1 = EbestOrderRequest.CSPAT00601InBlock1(
            isuNo = "",
            ordQty = 1,
            ordPrc = 10000.0,
            bnsTpCode = "",
            ordprcPtnCode = "",
            mgntrnCode = "",
            loanDt = "",
            ordCndiTpCode = "",
          )
        )
      )
      println(circuitBreakerRegistry.circuitBreaker("ebest-order").state)
    }

  }

  fun readFileToString(path: String): String {
    return FileUtils.readFileToString(ResourceUtils.getFile(path), StandardCharsets.UTF_8)
  }
}
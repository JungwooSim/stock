package com.future.stock.infra.db

import com.future.stock.infra.db.fixture.StockEntityFixture
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest

@DataR2dbcTest
class StockRepositoryTest @Autowired constructor(
  private val stockRepository: StockRepository,
) {
  @Test
  fun save() {
    // given
    val stockEntity = StockEntityFixture.create()

    // when
    val actual = runBlocking { stockRepository.save(stockEntity) }

    // then
    Assertions.assertThat(actual.id).isNotNull()
  }
}

package com.stock.infrastructure.db

import com.stock.infrastructure.db.fixture.TransactionEntityFixture
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest

@DataR2dbcTest
class TransactionRepositoryTest(
  @Autowired
  private val transactionRepository: TransactionRepository,
) {

  @Test
  fun save() {
    // given
    val transactionEntity = TransactionEntityFixture.create()

    // when
    val actual = runBlocking { transactionRepository.save(transactionEntity).block() }

    // then
    assertThat(actual?.id).isNotNull()
  }
}
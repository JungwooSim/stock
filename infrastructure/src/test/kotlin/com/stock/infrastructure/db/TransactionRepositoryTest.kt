package com.stock.infrastructure.db

import com.stock.infrastructure.db.fixture.TransactionEntityFixture
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import org.springframework.test.context.ActiveProfiles


@DataR2dbcTest
//@DataJpaTest
@ActiveProfiles("test")
class TransactionRepositoryTest(
//  @Autowired private val transactionRepository: TransactionRepository,
) {

  @Test
  fun save() {
    // given
    val transactionEntity = TransactionEntityFixture.create()

//    // when
//    val actual = runBlocking { transactionRepository.save(transactionEntity) }
//    // then
//    println(actual.id)
  }
}
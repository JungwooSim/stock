package com.stock.infrastructure.db.fixture

import com.stock.infrastructure.db.TransactionEntity
import com.stock.infrastructure.db.TransactionKindEnum
import com.stock.infrastructure.db.TransactionStateEnum
import io.github.serpro69.kfaker.Faker
import java.math.BigDecimal
import java.time.LocalDateTime

class TransactionEntityFixture {

  companion object {
    private val faker = Faker()

    fun create(
      kind: TransactionKindEnum = faker.random.nextEnum<TransactionKindEnum>(),
      state: TransactionStateEnum = faker.random.nextEnum<TransactionStateEnum>(),
      quantity: Long = faker.random.nextLong(),
      price: BigDecimal = BigDecimal(faker.random.nextDouble()),
      userId: Long = faker.random.nextLong(),
      stockId: Long = faker.random.nextLong(),
      orderNo: Long = faker.random.nextLong(),
      modifiedAt: LocalDateTime = LocalDateTime.now(),
      createdAt: LocalDateTime = LocalDateTime.now(),
    ): TransactionEntity {
      return TransactionEntity(
        kind = kind,
        state = state,
        quantity = quantity,
        price = price,
        userId = userId,
        stockId = stockId,
        orderNo = orderNo,
        modifiedAt = modifiedAt,
        createdAt = createdAt,
      )
    }
  }
}
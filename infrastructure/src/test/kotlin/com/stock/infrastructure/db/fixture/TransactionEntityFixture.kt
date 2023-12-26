package com.stock.infrastructure.db.fixture

import com.stock.infrastructure.db.TransactionEntity
import com.stock.common.enums.TransactionKindEnum
import com.stock.common.enums.TransactionStateEnum
import io.github.serpro69.kfaker.Faker
import java.math.BigDecimal
import java.time.LocalDateTime

class TransactionEntityFixture {

  companion object {
    private val faker = Faker()

    fun create(
      kind: TransactionKindEnum = faker.random.nextEnum<TransactionKindEnum>(),
      state: TransactionStateEnum = faker.random.nextEnum<TransactionStateEnum>(),
      quantity: Long = faker.random.nextLong(100000),
      price: BigDecimal = BigDecimal(faker.random.nextDouble()),
      userId: Long = faker.random.nextLong(100000),
      stockId: Long = faker.random.nextLong(100000),
      orderNo: Long = faker.random.nextLong(100000),
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
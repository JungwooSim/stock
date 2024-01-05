package com.future.stock.infra.db.fixture

import com.future.stock.infra.db.StockEntity
import io.github.serpro69.kfaker.Faker
import java.time.LocalDateTime

class StockEntityFixture {

  companion object {
    val faker = Faker()
    fun create(
      id: Long? = null,
      nameKrAbbreviation: String = faker.random.randomString(10),
      nameKr: String = faker.random.randomString(10),
      nameEn: String = faker.random.randomString(10),
      code: String = faker.random.randomString(10),
      standardCode: String = faker.random.randomString(10),
      market: String = faker.random.randomString(10),
      country: String = faker.random.randomString(10),
      modifiedAt: LocalDateTime? = null,
      createdAt: LocalDateTime? = null,
    ): StockEntity {
      return StockEntity(
        id = id,
        nameKrAbbreviation = nameKrAbbreviation,
        nameKr = nameKr,
        nameEn = nameEn,
        code = code,
        standardCode = standardCode,
        market = market,
        country = country,
        modifiedAt = modifiedAt,
        createdAt = createdAt,
      )
    }
  }
}
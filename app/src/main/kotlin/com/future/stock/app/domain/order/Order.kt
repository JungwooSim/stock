package com.future.stock.app.domain.order

import com.future.stock.common.enums.TransactionKindEnum
import com.future.stock.common.enums.TransactionStateEnum
import com.future.stock.app.interfaces.order.OrderResponse
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.math.BigDecimal
import java.time.LocalDateTime

@Serializable
data class Order(
  val id: Long? = null,
  val kind: TransactionKindEnum = TransactionKindEnum.BUY,
  val state: TransactionStateEnum = TransactionStateEnum.WAITING,
  val quantity: Long,
  @Serializable(with = BigDecimalSerializer::class) val price: BigDecimal,
  val stockId: Long,
  val userId: Long,
  // 최초에는 0, 연동사를 통해 갱신
  val orderNo: Long = 0,
  // TODO : Spring Data 에서 auditing 적용하기
  @Serializable(with = LocalDateTimeSerializer::class)
  val modifiedAt: LocalDateTime = LocalDateTime.now(),
  // TODO : Spring Data 에서 auditing 적용하기
  @Serializable(with = LocalDateTimeSerializer::class)
  val createdAt: LocalDateTime = LocalDateTime.now(),
) {
  fun toOrderResponse(): OrderResponse {
    return OrderResponse(
      id = this.id,
      quantity = this.quantity,
      price = this.price,
      stockId = this.stockId,
      userId = this.userId,
      orderNo = this.orderNo,
      modifiedAt = this.modifiedAt,
      createdAt = this.createdAt,
    )
  }
}

object BigDecimalSerializer : KSerializer<BigDecimal> {
  override fun deserialize(decoder: Decoder): BigDecimal {
    return decoder.decodeString().toBigDecimal()
  }

  override fun serialize(
    encoder: Encoder,
    value: BigDecimal,
  ) {
    encoder.encodeString(value.toPlainString())
  }

  override val descriptor: SerialDescriptor
    get() = PrimitiveSerialDescriptor("BigDecimal", PrimitiveKind.STRING)
}

object LocalDateTimeSerializer : KSerializer<LocalDateTime> {
  override fun serialize(
    encoder: Encoder,
    value: LocalDateTime,
  ) {
    encoder.encodeString(value.toString())
  }

  override fun deserialize(decoder: Decoder): LocalDateTime {
    return LocalDateTime.parse(decoder.decodeString())
  }

  override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("LocalDateTime", PrimitiveKind.STRING)
}
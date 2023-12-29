package com.stock.infrastructure.kafka

import com.stock.common.enums.TopicEnum
import com.stock.infrastructure.InfrastructureApplicationTest
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.test.context.EmbeddedKafka
import org.springframework.kafka.test.utils.KafkaTestUtils.getSingleRecord
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension


@EmbeddedKafka(
  partitions = 3,
  brokerProperties = [
    "listeners=PLAINTEXT://localhost:9092",
    "port=9092",
  ],
  topics = ["order"]
)
@ExtendWith(SpringExtension::class)
@SpringBootTest
class KafkaPublisherTest @Autowired constructor(
  private val kafkaTemplate: KafkaTemplate<String, String>,
  private val defaultKafkaConsumerFactory: DefaultKafkaConsumerFactory<String, String>,
  private val kafkaPublisher: KafkaPublisher = KafkaPublisher(kafkaTemplate),
) {

  @Test
  fun sendTest() {
    // Given
    val topicName = TopicEnum.ORDER
    val payload = "Hello, Kafka!"

    // When
    kafkaPublisher.sendMessage(topicName, payload)

    // Then
    // TODO : 여기 해결하기
//    val actualPayload = getSingleRecord(defaultKafkaConsumerFactory.createConsumer(), topicName.name).value()
//    assertEquals(payload, actualPayload)
  }
}
package com.stock.worker.global.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.TopicPartition
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.listener.ContainerProperties
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer
import org.springframework.kafka.listener.DefaultErrorHandler
import org.springframework.kafka.support.KafkaUtils
import org.springframework.util.backoff.FixedBackOff
import java.time.LocalDateTime

@EnableKafka
@Configuration
class KafkaConfig(
  @Value("\${spring.kafka.bootstrap-servers}")
  private val bootstrapServers: String,
//  @Value("\${spring.kafka.security.protocol}")
//  private val securityProtocol: String,
  @Value("\${kafka-dead-letter}")
  private val deadLetterTopic: String,
) {
  @Bean
  @DependsOn("kafkaTemplate", "consumerFactory")
  fun kafkaListenerContainerFactory(kafkaTemplate: KafkaTemplate<String, String>): ConcurrentKafkaListenerContainerFactory<String, String> {
    val factory = ConcurrentKafkaListenerContainerFactory<String, String>()

    val recoverer =
      DeadLetterPublishingRecoverer(kafkaTemplate) { record, exception ->
        record.headers()
          .add("originTopic", record.topic().toByteArray())
          .add("originPartition", record.partition().toString().toByteArray())
          .add("originOffset", record.offset().toString().toByteArray())
          .add("consumerGroupId", KafkaUtils.getConsumerGroupId().toByteArray())
          .add("deadLetterAt", LocalDateTime.now().toString().toByteArray())
          .add("errorMessage", exception.stackTraceToString().toByteArray())

        TopicPartition(deadLetterTopic, -1)
      }

    return factory.also {
      it.consumerFactory = consumerFactory()
      it.containerProperties.ackMode = ContainerProperties.AckMode.RECORD
      it.setCommonErrorHandler(DefaultErrorHandler(recoverer, FixedBackOff(10L, 0)))
    }
  }

  @Bean
  fun consumerFactory(): ConsumerFactory<String, String> {
    return DefaultKafkaConsumerFactory(
      mapOf(
        ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapServers,
//        CommonClientConfigs.SECURITY_PROTOCOL_CONFIG to securityProtocol,
        ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
        ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "earliest",
      ),
    )
  }

  @Bean
  fun producerFactory(): ProducerFactory<String, String> {
    return DefaultKafkaProducerFactory(
      mapOf(
        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to bootstrapServers,
//        CommonClientConfigs.SECURITY_PROTOCOL_CONFIG to securityProtocol,
        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
        ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG to true,
      ),
    )
  }

  @Bean
  @DependsOn("producerFactory")
  fun kafkaTemplate(): KafkaTemplate<String, String> = KafkaTemplate(producerFactory())
}
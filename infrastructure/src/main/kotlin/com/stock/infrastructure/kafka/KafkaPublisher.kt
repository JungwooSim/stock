package com.stock.infrastructure.kafka

import com.stock.common.enums.TopicEnum
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaPublisher(
  private val kafkaTemplate: KafkaTemplate<String, String>
) {

  fun sendMessage(topicName: TopicEnum, payLoad: String) {
    kafkaTemplate.send(topicName.topicName, payLoad)
  }
}
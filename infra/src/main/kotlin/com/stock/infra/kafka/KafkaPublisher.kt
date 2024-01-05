package com.stock.infra.kafka

import com.stock.common.enums.TopicEnum
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaPublisher(
  private val kafkaTemplate: KafkaTemplate<String, String>,
) {
  fun sendMessage(
    topicName: TopicEnum,
    payLoad: String,
  ) {
    println("topicEnum : ${topicName.topicName}, payload : $payLoad")
    kafkaTemplate.send(topicName.topicName, payLoad)
  }
}
package ru.demo.order.kafka.producer

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import ru.demo.order.controller.dto.Order

@Service
class KafkaProducer(val kafkaTemplate: KafkaTemplate<String, Order>) {
    fun sendMessage(content: Order, kafkaTopic: String) {
        kafkaTemplate.send(kafkaTopic, content)
    }
}
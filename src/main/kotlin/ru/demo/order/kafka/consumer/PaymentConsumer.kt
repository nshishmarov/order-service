package ru.demo.order.kafka.consumer

import mu.KotlinLogging
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
class PaymentConsumer {

    @KafkaListener(topics = ["payment-topic"], groupId = "order-group")
    fun consumeMessage(msg: String,
                       @Header headers: Map<String, String>) {
        logger.info { "Consumed Message: " + msg }
        processMessage(msg, headers)
    }

    fun processMessage(msg: String, header: Map<String, String>) {
        if (header.get("type").equals("1")) logger.info { "Hello" }
    }
}
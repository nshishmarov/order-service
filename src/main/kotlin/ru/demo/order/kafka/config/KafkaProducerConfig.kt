package ru.demo.order.kafka.config

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import ru.demo.order.controller.dto.Order
import ru.demo.order.kafka.serializer.OrderSerializer

@Configuration
class KafkaProducerConfig {

    @Autowired
    private lateinit var kafkaProperties: KafkaProperties

    @Bean
    fun producerFactory(): ProducerFactory<String, Order> {
        val config = kafkaProperties.buildProducerProperties()
        config[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProperties.bootstrapServers
        config[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        config[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = OrderSerializer::class.java
        return DefaultKafkaProducerFactory(config)
    }

    @Bean
    fun kafkaTemplate(
        producerFactory: ProducerFactory<String, Order>
    ) : KafkaTemplate<String, Order> {
        return KafkaTemplate(producerFactory)
    }
}
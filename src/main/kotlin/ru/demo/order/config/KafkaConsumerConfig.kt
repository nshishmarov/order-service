package ru.demo.order.config

import com.fasterxml.jackson.databind.JsonDeserializer
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import ru.demo.order.controller.dto.Order

@Configuration
class KafkaConsumerConfig {

    @Autowired
    private lateinit var kafkaProperties: KafkaProperties

    private fun consumerFactory(): ConsumerFactory<String, Order> {
        val config = kafkaProperties.buildConsumerProperties()
        config[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = kafkaProperties.bootstrapServers
        config[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        config[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserializer::class.java
        return DefaultKafkaConsumerFactory(config)
    }

    @Bean
    fun kafkaListenerContainerFactory(
        consumerFactory: ConsumerFactory<String, Order>
    ): ConcurrentKafkaListenerContainerFactory<String, Order>? {
        val factory = ConcurrentKafkaListenerContainerFactory<String, Order>()
        factory.consumerFactory = consumerFactory()
        return factory
    }
}
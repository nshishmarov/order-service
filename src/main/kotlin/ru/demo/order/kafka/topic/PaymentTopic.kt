package ru.demo.order.kafka.topic

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class PaymentTopic {

    @Bean
    fun paymentTopicCreate() : NewTopic = TopicBuilder.name("payment-topic").build()
}
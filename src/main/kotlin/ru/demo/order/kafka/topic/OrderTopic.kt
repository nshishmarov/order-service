package ru.demo.order.kafka.topic

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class OrderTopic {

    @Bean
    fun orderTopicCreate() : NewTopic = TopicBuilder.name("order-topic").build()
}
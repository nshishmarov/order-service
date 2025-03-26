package ru.demo.order.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.kafka.annotation.EnableKafka

@Configuration
@EnableKafka
@EnableJpaRepositories(basePackages = ["ru.demo.order.repository"])
class OrderConfig
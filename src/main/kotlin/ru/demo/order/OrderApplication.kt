package ru.demo.order

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["ru.demo.order.repository"])
@EnableKafka
class OrderApplication

fun main(args: Array<String>) {
	runApplication<OrderApplication>(*args)
}

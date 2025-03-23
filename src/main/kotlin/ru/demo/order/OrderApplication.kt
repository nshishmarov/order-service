package ru.demo.order

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = ["ru.demo.order"])
@EnableJpaRepositories(basePackages = ["ru.demo.order.repository"])
class OrderApplication

fun main(args: Array<String>) {
	runApplication<OrderApplication>(*args)
}

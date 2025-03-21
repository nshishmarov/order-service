package ru.demo.order.service

import org.springframework.stereotype.Service
import ru.demo.order.controller.dto.Order
import ru.demo.order.domain.OrderEntity
import ru.demo.order.repository.OrderJpaRepository
import kotlin.jvm.optionals.getOrNull

@Service
class OrderService(val orderJpaRepository: OrderJpaRepository){
    fun getAllOrders() : List<OrderEntity>? = orderJpaRepository.findAll().toList()

    fun getOrderById(orderId: String) : OrderEntity? = orderJpaRepository.findById(orderId).getOrNull()

    fun createOrder(order: Order) {
        val order = OrderEntity(1, order.orderName, order.orderDate)
        orderJpaRepository.save(order)
    }
}
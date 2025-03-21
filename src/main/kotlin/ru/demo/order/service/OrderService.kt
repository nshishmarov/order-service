package ru.demo.order.service

import org.springframework.stereotype.Service
import ru.demo.order.dto.Order
import ru.demo.order.dto.OrderCreate
import ru.demo.order.repository.OrderJpaRepository
import java.util.*
import kotlin.jvm.optionals.getOrNull

@Service
class OrderService(val orderJpaRepository: OrderJpaRepository){
    fun getAllOrders() : List<Order>? = orderJpaRepository.findAll().toList()

    fun getOrderById(orderId: String) : Order? = orderJpaRepository.findById(orderId).getOrNull()

    fun createOrder(order: Order) {
        val order = Order("1", Date())
        orderJpaRepository.save(order)
    }
}
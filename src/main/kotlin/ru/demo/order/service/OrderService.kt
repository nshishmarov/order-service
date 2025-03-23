package ru.demo.order.service

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import ru.demo.order.controller.dto.Order
import ru.demo.order.domain.OrderEntity
import ru.demo.order.mapper.OrderMapper
import ru.demo.order.repository.OrderJpaRepository
import kotlin.jvm.optionals.getOrNull

@Service
class OrderService(
    val orderJpaRepository: OrderJpaRepository,
    val orderMapper: OrderMapper
){
    fun getAllOrders() : List<OrderEntity>? = orderJpaRepository.findAll().toList()

    fun getOrderById(orderId: String) : OrderEntity? = orderJpaRepository.findById(orderId).getOrNull()

    @Transactional
    fun createOrder(order: Order) {
        val orderEntity = orderMapper.orderToOrderCreate(order)
        orderJpaRepository.save(orderEntity)
    }
}
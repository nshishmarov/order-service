package ru.demo.order.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.demo.order.controller.dto.Order
import ru.demo.order.domain.OrderEntity
import ru.demo.order.service.OrderService

@RestController
class OrderController(val orderService: OrderService) {

    @GetMapping("/orders")
    fun getOrders() : List<OrderEntity>? = orderService.getAllOrders()

    @GetMapping("/order/{id}")
    fun getOrderById(@PathVariable("id") orderId: String) = orderService.getOrderById(orderId)

    @PostMapping("/order")
    fun createOrder(@RequestBody order: Order) = orderService.createOrder(order)
}
package ru.demo.order.mapper

import org.mapstruct.Mapper
import ru.demo.order.controller.dto.Order
import ru.demo.order.domain.OrderEntity

@Mapper(componentModel = "spring")
interface OrderMapper {
    fun orderToOrderEntity(order: Order) : OrderEntity
}
package ru.demo.order.mapper

import org.mapstruct.Mapper
import ru.demo.order.dto.Order

@Mapper
interface OrderMapper {
    fun orderToOrderCreate(order: Order)
}
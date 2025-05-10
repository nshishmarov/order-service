package ru.demo.order.kafka.serde

import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.common.serialization.Serializer
import ru.demo.order.controller.dto.Order
import ru.demo.order.kafka.deserializer.OrderDeserializer
import ru.demo.order.kafka.serializer.OrderSerializer

class OrderSerde : Serde<Order> {
    private val orderSerializer = OrderSerializer()
    private val orderDeserializer = OrderDeserializer()

    override fun serializer() = orderSerializer
    override fun deserializer() = orderDeserializer
}
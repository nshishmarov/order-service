package ru.demo.order.kafka.deserializer

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Deserializer
import ru.demo.order.controller.dto.Order

class OrderDeserializer : Deserializer<Order> {
    private val objectMapper = ObjectMapper()

    override fun deserialize(kafkaTopic: String?, orderByte: ByteArray?): Order {
        return objectMapper.readValue(orderByte.toString(), Order::class.java)
    }
}
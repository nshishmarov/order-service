package ru.demo.order.kafka.serializer

import com.fasterxml.jackson.databind.ObjectMapper
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import org.apache.kafka.common.serialization.Serializer
import ru.demo.order.controller.dto.Order
import java.io.NotSerializableException

@AllArgsConstructor
@NoArgsConstructor
open class OrderSerializer : Serializer<Order> {
    private val objectMapper = ObjectMapper()

    override fun serialize(topic: String?, order: Order?): ByteArray =
        objectMapper.writeValueAsBytes(order ?:
        throw NotSerializableException("Error with serialization!"))
}
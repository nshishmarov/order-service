package ru.demo.order.kafka.deserializer

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Deserializer
import ru.demo.order.controller.dto.Payment

class PaymentDeserializer : Deserializer<Payment> {

    private val objectMapper = ObjectMapper()

    override fun deserialize(kafkaTopic: String?, paymentByte: ByteArray?): Payment =
        objectMapper.readValue(paymentByte.toString(), Payment::class.java)
}
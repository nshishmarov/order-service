package ru.demo.order.kafka.topology

import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Consumed
import org.springframework.stereotype.Component
import ru.demo.order.kafka.serde.OrderSerde

@Component
class KStreamsTopology {

    private val orderSerde = OrderSerde()

    fun processOrders(streamsBuilder: StreamsBuilder) {
        val orderStream = streamsBuilder.stream(
            "order-topic",
            Consumed.with(Serdes.String(), orderSerde)
        )
        val approvedOrders = orderStream
            .filter({key, value -> value.orderStatus.equals("Approved")}).to("order-topic")
    }
}
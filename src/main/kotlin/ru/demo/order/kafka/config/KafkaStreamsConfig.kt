package ru.demo.order.kafka.config

import org.apache.commons.lang3.stream.Streams
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.annotation.EnableKafkaStreams
import org.springframework.kafka.config.KafkaStreamsConfiguration
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@Configuration
@EnableKafka
@EnableKafkaStreams
class KafkaStreamsConfig(private val kafkaStreamsConfiguration: KafkaStreamsConfiguration) {

    @Value("${spring.kafka.bootstrap-servers}")
    private lateinit var kafkaBootstrapServers: String

    @Bean
    fun kafkaStreamsConfiguration() : KafkaStreamsConfiguration {
        val props = hashMapOf(
            StreamsConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaBootstrapServers,
            StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG to Serdes.String()::class.java.name,
            StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG to Serdes.String()::class.java.name
        )
        return KafkaStreamsConfiguration(props as Map<String, Any>)
    }
}
package ru.demo.order.config

import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.demo.order.mapper.OrderMapper

@Configuration
class MapperConfig {
    @Bean
    fun orderMapper(): OrderMapper {
        return Mappers.getMapper(OrderMapper::class.java)
    }
}
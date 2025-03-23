package ru.demo.order.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Data
import lombok.EqualsAndHashCode
import java.time.LocalDate

@Data
@EqualsAndHashCode
data class OrderCreate(
    @JsonProperty("orderId")
    val orderId: Long,
    @JsonProperty("orderName")
    val orderName: String,
    @JsonProperty("orderDate")
    val orderDate: LocalDate
)
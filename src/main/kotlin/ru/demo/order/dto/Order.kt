package ru.demo.order.dto

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Builder
import java.util.Date

@Builder
data class Order (
    @JsonProperty("orderName")
    val orderName: String,
    @JsonProperty("orderDate")
    val orderDate: Date
)
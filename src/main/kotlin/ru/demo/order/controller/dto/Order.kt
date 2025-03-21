package ru.demo.order.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Entity
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.NoArgsConstructor
import java.util.Date

@Builder
@AllArgsConstructor
@NoArgsConstructor
data class Order (
    @JsonProperty("orderName")
    val orderName: String,
    @JsonProperty("orderDate")
    val orderDate: Date
)
package ru.demo.order.controller.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.NoArgsConstructor
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

@Builder
@AllArgsConstructor
@NoArgsConstructor
data class Order (
    @JsonProperty("orderName")
    val orderName: String,
    @JsonProperty("orderDate")
    @JsonFormat(pattern = "dd.MM.yyyy", shape = JsonFormat.Shape.STRING)
    val orderDate: Date
)
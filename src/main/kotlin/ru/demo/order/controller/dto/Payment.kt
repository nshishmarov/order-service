package ru.demo.order.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class Payment (
    @JsonProperty("name")
    val paymentName: String,
    @JsonProperty("date")
    val paymentDate: Date
)
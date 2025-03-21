package ru.demo.order.domain

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.*

@Entity(name = "order")
data class OrderEntity (
    @Id
    @JsonProperty("orderId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val orderId: Long,
    @JsonProperty("orderName")
    val orderName: String,
    @JsonProperty("orderDate")
    val orderDate: Date
)
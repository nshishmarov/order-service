package ru.demo.order.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Data
import lombok.EqualsAndHashCode
import java.util.Date

@Data
@EqualsAndHashCode
data class OrderCreate(
    @Id
    @JsonProperty("orderId")
    //@GeneratedValue(strategy = GenerationType.UUID)
    val orderId: Long,
    @JsonProperty("orderName")
    val orderName: String,
    @JsonProperty("orderDate")
    val orderDate: Date
)
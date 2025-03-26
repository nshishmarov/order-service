package ru.demo.order.domain

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.EqualsAndHashCode
import lombok.ToString
import java.time.LocalDate
import java.util.Date

@Entity
@Table(name = "orders")
@EqualsAndHashCode
@ToString
data class OrderEntity (
    @Id
    @JsonProperty("orderId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "\"orderId\"", columnDefinition = "numeric(15,0)")
    val orderId: Long,
    @Column(name = "\"orderName\"", columnDefinition = "varchar(100)")
    @JsonProperty("orderName")
    val orderName: String,
    @JsonProperty("orderDate")
    @Column(name = "\"orderDate\"", columnDefinition = "datetime")
    val orderDate: Date
)
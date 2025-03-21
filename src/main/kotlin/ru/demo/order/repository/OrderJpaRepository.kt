package ru.demo.order.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.demo.order.domain.OrderEntity

@Repository
interface OrderJpaRepository : CrudRepository<OrderEntity, String>
package ru.demo.order.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.demo.order.dto.Order

@Repository
interface OrderJpaRepository : CrudRepository<Order, String>
package me.thejramon.onlinemerchstore.repository

import me.thejramon.onlinemerchstore.domain.Order
import me.thejramon.onlinemerchstore.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, Long> {
    fun findByUser(user: User): List<Order>
}

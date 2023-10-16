package me.thejramon.onlinemerchstore.repository

import me.thejramon.onlinemerchstore.domain.Order
import me.thejramon.onlinemerchstore.domain.OrderDetail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderDetailRepository : JpaRepository<OrderDetail, Long> {
    fun findByOrder(order: Order): List<OrderDetail>
}

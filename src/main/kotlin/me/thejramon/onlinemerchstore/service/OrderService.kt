package me.thejramon.onlinemerchstore.service

import me.thejramon.onlinemerchstore.domain.Order
import me.thejramon.onlinemerchstore.domain.User
import me.thejramon.onlinemerchstore.repository.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OrderService(private val orderRepository: OrderRepository) {

    fun findAll(): List<Order> = orderRepository.findAll()

    fun findByUser(user: User): List<Order> = orderRepository.findByUser(user)

    fun findById(id: Long): Order? = orderRepository.findById(id).orElse(null)

    fun save(order: Order): Order = orderRepository.save(order)

    fun deleteById(id: Long) = orderRepository.deleteById(id)
}

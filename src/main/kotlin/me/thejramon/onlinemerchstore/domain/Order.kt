package me.thejramon.onlinemerchstore.domain

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime


@Entity
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    val user: User,
    val orderDate: LocalDateTime = LocalDateTime.now(),
    val totalAmount: BigDecimal,
    val shippingAddress: String,
    val orderStatus: String
)

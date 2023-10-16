package me.thejramon.onlinemerchstore.domain

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class OrderDetail(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    val order: Order,
    @ManyToOne(fetch = FetchType.LAZY)
    val product: Product,
    val quantity: Int,
    val subTotal: BigDecimal
)

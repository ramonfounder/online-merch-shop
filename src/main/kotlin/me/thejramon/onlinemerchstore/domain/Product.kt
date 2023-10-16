package me.thejramon.onlinemerchstore.domain

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val productName: String,
    val description: String,
    val price: BigDecimal,
    val stockQuantity: Int,
    val imageUrl: String,
    @ManyToOne(fetch = FetchType.LAZY)
    val category: Category
)

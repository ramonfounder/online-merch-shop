package me.thejramon.onlinemerchstore.domain


import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Review(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    val product: Product,
    @ManyToOne(fetch = FetchType.LAZY)
    val user: User,
    val rating: Int,
    val comment: String,
    val reviewDate: LocalDateTime = LocalDateTime.now()
)

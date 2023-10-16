package me.thejramon.onlinemerchstore.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val username: String,
    val password: String, // Ideally, you should handle passwords more securely
    val email: String,
    val fullName: String,
    val address: String,
    val phone: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)


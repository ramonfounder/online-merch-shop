package me.thejramon.onlinemerchstore.repository

import me.thejramon.onlinemerchstore.domain.Product
import me.thejramon.onlinemerchstore.domain.Review
import me.thejramon.onlinemerchstore.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewRepository : JpaRepository<Review, Long> {
    fun findByProduct(product: Product): List<Review>
    fun findByUser(user: User): List<Review>
}

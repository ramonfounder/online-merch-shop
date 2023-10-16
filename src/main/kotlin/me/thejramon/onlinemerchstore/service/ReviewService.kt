package me.thejramon.onlinemerchstore.service

import me.thejramon.onlinemerchstore.domain.Product
import me.thejramon.onlinemerchstore.domain.Review
import me.thejramon.onlinemerchstore.domain.User
import me.thejramon.onlinemerchstore.repository.ReviewRepository
import org.springframework.stereotype.Service

@Service
class ReviewService(private val reviewRepository: ReviewRepository) {

    fun findAll(): List<Review> = reviewRepository.findAll()

    fun findByProduct(product: Product): List<Review> = reviewRepository.findByProduct(product)

    fun findByUser(user: User): List<Review> = reviewRepository.findByUser(user)

    fun findById(id: Long): Review? = reviewRepository.findById(id).orElse(null)

    fun save(review: Review): Review = reviewRepository.save(review)

    fun deleteById(id: Long) = reviewRepository.deleteById(id)
}

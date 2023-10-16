package me.thejramon.onlinemerchstore.repository

import me.thejramon.onlinemerchstore.domain.Category
import me.thejramon.onlinemerchstore.domain.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long> {
    fun findByCategory(category: Category): List<Product>
}

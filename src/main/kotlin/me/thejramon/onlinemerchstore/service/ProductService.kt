package me.thejramon.onlinemerchstore.service

import me.thejramon.onlinemerchstore.domain.Product
import me.thejramon.onlinemerchstore.repository.CategoryRepository
import me.thejramon.onlinemerchstore.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository
) {

    fun findAll(): List<Product> = productRepository.findAll()

    fun findByCategory(categoryId: Long): List<Product> {
        val category = categoryRepository.findById(categoryId).orElse(null)
        return category?.let { productRepository.findByCategory(it) } ?: emptyList()
    }

    fun findById(id: Long): Product? = productRepository.findById(id).orElse(null)

    fun save(product: Product): Product = productRepository.save(product)

    fun deleteById(id: Long) = productRepository.deleteById(id)
}
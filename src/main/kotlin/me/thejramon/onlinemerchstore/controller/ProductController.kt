package me.thejramon.onlinemerchstore.controller

import me.thejramon.onlinemerchstore.domain.Product
import me.thejramon.onlinemerchstore.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<Product>> = ResponseEntity.ok(productService.findAll())

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Product> =
        productService.findById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @GetMapping("/category/{categoryId}")
    fun findByCategory(@PathVariable categoryId: Long): ResponseEntity<List<Product>> =
        ResponseEntity.ok(productService.findByCategory(categoryId))

    @PostMapping
    fun createProduct(@RequestBody product: Product): ResponseEntity<Product> =
        ResponseEntity.ok(productService.save(product))

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable id: Long, @RequestBody product: Product): ResponseEntity<Product> {
        if (productService.findById(id) == null) {
            return ResponseEntity.notFound().build()
        }
        return ResponseEntity.ok(productService.save(product.copy(id = id)))
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Long): ResponseEntity<Void> {
        productService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}

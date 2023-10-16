package me.thejramon.onlinemerchstore.controller

import me.thejramon.onlinemerchstore.domain.Order
import me.thejramon.onlinemerchstore.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderController(private val orderService: OrderService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<Order>> = ResponseEntity.ok(orderService.findAll())

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Order> =
        orderService.findById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping
    fun createOrder(@RequestBody order: Order): ResponseEntity<Order> =
        ResponseEntity.ok(orderService.save(order))

    @PutMapping("/{id}")
    fun updateOrder(@PathVariable id: Long, @RequestBody order: Order): ResponseEntity<Order> {
        if (orderService.findById(id) == null) {
            return ResponseEntity.notFound().build()
        }
        return ResponseEntity.ok(orderService.save(order.copy(id = id)))
    }

    @DeleteMapping("/{id}")
    fun deleteOrder(@PathVariable id: Long): ResponseEntity<Void> {
        orderService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}

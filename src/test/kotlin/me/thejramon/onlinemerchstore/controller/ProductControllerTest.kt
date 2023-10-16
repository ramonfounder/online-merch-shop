package me.thejramon.onlinemerchstore.controller

import me.thejramon.onlinemerchstore.domain.Category
import me.thejramon.onlinemerchstore.domain.Product
import me.thejramon.onlinemerchstore.service.ProductService
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.math.BigDecimal


@SpringBootTest
@WebMvcTest(ProductController::class)
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var productService: ProductService

    @Test
    fun `GET product by id - main scenario`() {
        val product = Product(
            id = 1,
            productName = "Shirt",
            description = "Blue Shirt",
            price = BigDecimal(20),
            stockQuantity = 100,
            imageUrl = "url",
            Category(id = 1, categoryName = "Men")
        )

        `when`(productService.findById(1)).thenReturn(product)

        mockMvc.perform(get("/api/products/1"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.productName", `is`("Shirt")))
    }

    @Test
    fun `GET product by id - alternative scenario (not found)`() {
        `when`(productService.findById(99)).thenReturn(null)

        mockMvc.perform(get("/api/products/99"))
            .andExpect(status().isNotFound)
    }

}

package me.thejramon.onlinemerchstore.repository

import me.thejramon.onlinemerchstore.domain.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long>

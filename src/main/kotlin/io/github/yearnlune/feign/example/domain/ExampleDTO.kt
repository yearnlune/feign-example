package io.github.yearnlune.feign.example.domain

import java.time.LocalDateTime

class ExampleDTO(
    val id: String,
    val another: AnotherDTO,
    val updatedAt: LocalDateTime,
)
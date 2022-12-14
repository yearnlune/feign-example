package io.github.yearnlune.feign.example.controller

import io.github.yearnlune.feign.example.domain.ExampleDTO
import io.github.yearnlune.feign.example.feign.AnotherFeignClient
import io.github.yearnlune.feign.example.feign.UnavailableServiceException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.util.UUID

@RestController
class ExampleController(
    private val anotherFeignClient: AnotherFeignClient,
) {

    @GetMapping("/example/{anotherId}")
    fun getExample(@PathVariable anotherId: String): ResponseEntity<Any> {
        return runCatching {
            ExampleDTO(
                UUID.randomUUID().toString(),
                anotherFeignClient.findAnotherById(anotherId),
                LocalDateTime.now()
            )
        }.fold({
            ResponseEntity.ok(it)
        }, {
            when (it) {
                is UnavailableServiceException -> ResponseEntity.internalServerError().body(it.localizedMessage)
                else -> throw it
            }
        })
    }
}
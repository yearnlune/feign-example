package io.github.yearnlune.feign.example.account.controller

import io.github.yearnlune.feign.example.account.domain.Another
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AnotherController {

    @GetMapping("/another/{anotherId}")
    fun findAnotherById(@PathVariable("anotherId") anotherId: String): ResponseEntity<Another> {
        return if (anotherId == "E001") {
            ResponseEntity.ok(Another("E001", "홍길동"))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/another")
    fun findAnotherList(): ResponseEntity<List<Another>> = ResponseEntity.ok(listOf(Another("E001", "홍길동")))

    @PostMapping("/another")
    fun createAnother(another: Another): ResponseEntity<Another> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(another.apply { this.isActive = false })
    }

    @PutMapping("/another/{anotherId}")
    fun updateAnotherStatus(@PathVariable("anotherId") anotherId: String): ResponseEntity<Another> {
        return if (anotherId == "E001") {
            ResponseEntity.ok(Another("E001", "홍길동"))
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
package io.github.yearnlune.feign.example.account

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AnotherServiceApplication

fun main(args: Array<String>) {
    runApplication<AnotherServiceApplication>(*args)
}
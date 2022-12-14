package io.github.yearnlune.feign.example.feign

import io.github.yearnlune.feign.example.domain.AnotherDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(
    name = "another",
    url = "\${app.another-service}",
    configuration = [FeignConfig::class]
)
interface AnotherFeignClient {

    @GetMapping(
        "/another/{anotherId}",
        headers = ["x-custom-header=just-test"]
    )
    fun findAnotherById(@PathVariable("anotherId") anotherId: String): AnotherDTO

    @GetMapping("/another/{anotherId}")
    fun findAnotherByIdWithHeaders(
        @RequestHeader header: HttpHeaders,
        @PathVariable("anotherId") anotherId: String
    ): AnotherDTO

    @GetMapping("/another")
    fun findAnotherList(@RequestHeader header: HttpHeaders): List<AnotherDTO>

    @PostMapping("/another")
    fun createAnother(another: AnotherDTO): AnotherDTO

    @PutMapping("/another/{anotherId}")
    fun updateAnotherStatus(@PathVariable("anotherId") anotherId: String): AnotherDTO
}
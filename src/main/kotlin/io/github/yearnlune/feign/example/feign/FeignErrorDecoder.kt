package io.github.yearnlune.feign.example.feign

import feign.Response
import feign.codec.ErrorDecoder
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class FeignErrorDecoder : ErrorDecoder {

    override fun decode(methodKey: String, response: Response): Exception {
        when (response.status()) {
            in 400..499 -> throw ResponseStatusException(HttpStatus.valueOf(response.status()))
            in 500..599 -> throw UnavailableServiceException()
            else -> throw RuntimeException()
        }
    }
}
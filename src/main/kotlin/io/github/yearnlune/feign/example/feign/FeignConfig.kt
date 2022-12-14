package io.github.yearnlune.feign.example.feign

import feign.Logger
import feign.RequestInterceptor
import feign.codec.ErrorDecoder
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class FeignConfig {

    /**
     * 요청 헤더 삽입
     */
    @Bean
    fun clientHeaderInterceptor(): RequestInterceptor {
        return RequestInterceptor {
            it.header("x-custom-header", "just-test")
        }
    }

    /**
     * 에러 처리
     */
    @Bean
    fun errorDecoder(): ErrorDecoder {
        return ErrorDecoder { _, response ->
            when (response.status()) {
                in 400..499 -> throw ResponseStatusException(HttpStatus.valueOf(response.status()))
                in 500..599 -> throw UnavailableServiceException()
                else -> throw RuntimeException()
            }
        }
    }

    /**
     * Feign 로깅 레벨 설정
     *
     * @NOTE 디버깅 레벨에서 작동
     */
    @Bean
    fun loggerLevel(): Logger.Level = Logger.Level.HEADERS
}
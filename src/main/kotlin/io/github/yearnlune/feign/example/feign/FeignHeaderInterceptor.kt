package io.github.yearnlune.feign.example.feign

import feign.RequestInterceptor
import feign.RequestTemplate

class FeignHeaderInterceptor : RequestInterceptor {

    override fun apply(template: RequestTemplate) {
        template.header("x-custom-header", "just-test")
    }
}
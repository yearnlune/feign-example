package io.github.yearnlune.feign.example.feign

class UnavailableServiceException : RuntimeException("Unavailable internal service")
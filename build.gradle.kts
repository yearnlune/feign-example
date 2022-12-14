buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.KOTLIN}")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:${Version.KTLINT}")
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${Version.SPRING_BOOT}")
        classpath("org.jetbrains.kotlin:kotlin-allopen:${Version.KOTLIN}")
    }
}

plugins {
    kotlin("jvm") version Version.KOTLIN
}

dependencies {
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:${Version.SPRING_CLOUD}"))
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
}

allprojects {
    group = "io.github.yearnlune.feign"
    version = "1.0.0"

    repositories {
        mavenCentral()
        maven { url = uri("https://repo.spring.io/milestone") }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    apply(plugin = "kotlin")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    dependencies {
        implementation(Dependency.Spring.WEB)
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

        implementation(Dependency.Kotlin.REFLECT)
        implementation(Dependency.Kotlin.STDLIB)
        implementation(Dependency.Spring.VALIDATION)

        testImplementation(Dependency.Spring.TEST)
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
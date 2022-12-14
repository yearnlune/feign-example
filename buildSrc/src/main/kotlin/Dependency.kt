object Dependency {

    object Spring {
        val ACTUATOR by lazy { "org.springframework.boot:spring-boot-starter-actuator:${Version.SPRING_BOOT}" }
        val AMQP by lazy { "org.springframework.boot:spring-boot-starter-amqp:${Version.SPRING_BOOT}" }
        val JPA by lazy { "org.springframework.boot:spring-boot-starter-data-jpa:${Version.SPRING_BOOT}" }
        val MONGODB by lazy { "org.springframework.boot:spring-boot-starter-data-mongodb:${Version.SPRING_BOOT}" }
        val SECURITY by lazy { "org.springframework.boot:spring-boot-starter-security:${Version.SPRING_BOOT}" }
        val WEB by lazy { "org.springframework.boot:spring-boot-starter-web:${Version.SPRING_BOOT}" }
        val WEBFLUX by lazy { "org.springframework.boot:spring-boot-starter-webflux:${Version.SPRING_BOOT}" }
        val WEBSOCKET by lazy { "org.springframework.boot:spring-boot-starter-websocket:${Version.SPRING_BOOT}" }
        val WEBSOCKET_SECURITY_MESSAGING by lazy {"org.springframework.security:spring-security-messaging:${Version.SPRING_BOOT_STABLE}"}
        val GRAPHQL by lazy { "org.springframework.boot:spring-boot-starter-graphql:${Version.SPRING_BOOT}" }
        val VALIDATION by lazy { "org.springframework.boot:spring-boot-starter-validation:${Version.SPRING_BOOT}" }
        val DEVTOOLS by lazy { "org.springframework.boot:spring-boot-devtools:${Version.SPRING_BOOT}" }
        val AUTOCONFIGURE by lazy { "org.springframework.boot:spring-boot-autoconfigure:${Version.SPRING_BOOT}" }
        val CONFIGURATION_PROCESSOR by lazy { "org.springframework.boot:spring-boot-configuration-processor:${Version.SPRING_BOOT}" }
        val TEST by lazy { "org.springframework.boot:spring-boot-starter-test:${Version.SPRING_BOOT}" }
        val RABBIT_TEST by lazy { "org.springframework.amqp:spring-rabbit-test:${Version.SPRING_BOOT}" }
        val SECURITY_TEST by lazy { "org.springframework.security:spring-security-test:${Version.SPRING_BOOT}" }
    }

    object DB {
        val H2: String by lazy { "com.h2database:h2:${Version.H2}" }
        val MARIADB: String by lazy { "org.mariadb.jdbc:mariadb-java-client:${Version.MARIADB}" }
        val MONGO_DRIVER: String by lazy { "org.mongodb:mongo-java-driver:${Version.MONGODB_DRVIER}" }
        val EMBEDDED_MONGO: String by lazy { "de.flapdoodle.embed:de.flapdoodle.embed.mongo:${Version.EMBEDDED_MONGO}" }
    }

    object QueryDSL {
        val JPA by lazy { "com.querydsl:querydsl-jpa:${Version.QUERY_DSL}" }
        val APT by lazy { "com.querydsl:querydsl-apt:${Version.QUERY_DSL}" }
        val MONGODB by lazy { "com.querydsl:querydsl-mongodb:${Version.QUERY_DSL}" }
    }

    object Kotlin {
        val REFLECT by lazy { "org.jetbrains.kotlin:kotlin-reflect:${Version.KOTLIN}" }
        val STDLIB by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.KOTLIN}" }
    }
}

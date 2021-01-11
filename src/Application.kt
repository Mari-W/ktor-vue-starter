package com.example

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*




fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
fun Application.module() {

    install(AutoHeadResponse)

    install(CallLogging)

    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Get)
        method(HttpMethod.Post)

        allowNonSimpleContentTypes = true
        allowCredentials = true

        anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
    }

    install(CachingHeaders) {
        val noCache = CachingOptions(CacheControl.NoCache(CacheControl.Visibility.Public))
        val lazy = CachingOptions(CacheControl.MaxAge(maxAgeSeconds = 60 * 10)) // 10 minutes
        val superLazy = CachingOptions(CacheControl.MaxAge(maxAgeSeconds = 60 * 60)) // 1 hour
        options { outgoingContent ->
            when (outgoingContent.contentType?.withoutParameters()) {
                ContentType.Text.Html -> noCache
                ContentType.Text.CSS -> lazy
                ContentType.Text.JavaScript -> lazy

                ContentType.Image.SVG -> superLazy
                ContentType.Image.JPEG -> superLazy
                ContentType.Image.PNG -> superLazy
                ContentType("image", "fav") -> superLazy
                else -> null
            }
        }
    }

    install(ContentNegotiation) {
        gson {}
    }

    routing {
        when {
            isDev -> {
                // redirect to Vue dev server
                get("/") {
                    call.respondRedirect("http://localhost:8080")
                }
            }
            isProd -> {
                // serve Vue page with Ktor
                static("/") {
                    resources("dist")
                    resource("/", "dist/index.html")
                }
            }
        }

        // serve assets
        static("assets") {
            resources("assets")
        }

        // actual API code
        route("/api/") {
            get("/") {
                call.respond("Example API 0.0.1")
            }
        }
    }
}

val Application.envKind get() = environment.config.property("ktor.environment").getString()
val Application.isDev get() = envKind == "dev"
val Application.isProd get() = envKind != "dev"
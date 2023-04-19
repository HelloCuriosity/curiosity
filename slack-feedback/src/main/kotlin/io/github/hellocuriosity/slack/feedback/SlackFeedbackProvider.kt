package io.github.hellocuriosity.slack.feedback

import io.github.hellocuriosity.slack.feedback.repository.SlackCloud
import io.github.hellocuriosity.slack.feedback.repository.SlackRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.utils.buildHeaders
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import okhttp3.Interceptor

class SlackFeedbackProvider(
    private val bearerToken: String,
    private val contentType: String = "application/x-www-form-urlencoded",
    private val language: String = "en-US",
    private val interceptors: List<Interceptor> = emptyList()
) {

    val slackRepository: SlackRepository by lazy {
        SlackRepository(cloud = SlackCloud(service = service))
    }

    private val service: SlackService by lazy {
        SlackService(client = client)
    }

    private val client: HttpClient by lazy {
        HttpClient(OkHttp) {
            engine {
                interceptors.map(::addInterceptor)
            }
            install(ContentNegotiation) {
                json(json = Json { ignoreUnknownKeys = true })
            }
            buildHeaders {
                append(HttpHeaders.AcceptLanguage, language)
                append(HttpHeaders.Authorization, bearerToken)
                append(HttpHeaders.ContentType, contentType)
            }
        }
    }
}

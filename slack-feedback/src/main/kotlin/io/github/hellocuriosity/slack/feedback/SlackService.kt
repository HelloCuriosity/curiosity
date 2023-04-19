package io.github.hellocuriosity.slack.feedback

import io.github.hellocuriosity.slack.feedback.models.ApiResponse
import io.github.hellocuriosity.slack.feedback.models.ApiSlackMessage
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class SlackService(
    private val client: HttpClient,
) {
    suspend fun post(apiSlackMessage: ApiSlackMessage): ApiResponse =
        client.post(URL) {
            contentType(ContentType.Application.Json)
            setBody(apiSlackMessage)
        }.body()

    companion object {
        private const val URL: String = "https://slack.com/api/chat.postMessage"
    }
}

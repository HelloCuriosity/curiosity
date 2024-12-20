package io.github.hellocuriosity.slack.feedback

import io.github.hellocuriosity.slack.feedback.models.ApiAttachment
import io.github.hellocuriosity.slack.feedback.models.ApiMessage
import io.github.hellocuriosity.slack.feedback.models.ApiResponse
import io.github.hellocuriosity.slack.feedback.models.ApiSlackMessage
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

open class NetworkTest {
    val apiSlackMessage =
        ApiSlackMessage(
            channel = "test-channel-id",
            attachments =
                listOf(
                    ApiAttachment(
                        fallback = "fallback",
                        color = "#B562F2",
                        pretext = "pretext",
                        title = "title",
                        text = "text",
                    ),
                ),
        )

    val apiResponse =
        ApiResponse(
            isSuccessful = true,
            channel = "test-channel-id",
            timestamp = "1564436784",
            message =
                ApiMessage(
                    type = "message",
                    subtype = "bot_message",
                    text = "",
                    timestamp = "1564436784",
                    username = "name",
                    botId = "botid",
                    attachments =
                        listOf(
                            ApiAttachment(
                                fallback = "Required plain-text summary of the attachment.",
                                color = "FCD229",
                                pretext = "Optional text that appears above the attachment block",
                                title = "title",
                                text = "text",
                                footer = "Slack API",
                                icon = "https://platform.slack-edge.com/img/default_application_icon.png",
                                createdOn = 123456789,
                            ),
                        ),
                ),
        )

    private val responseBody =
        """
        {
  "ok": true,
  "channel": "test-channel-id",
  "ts": "1564436784",
  "message": {
    "type": "message",
    "subtype": "bot_message",
    "text": "",
    "ts": "1564436784",
    "username": "name",
    "bot_id": "botid",
    "attachments": [
      {
        "fallback": "Required plain-text summary of the attachment.",
        "text": "text",
        "pretext": "Optional text that appears above the attachment block",
        "title": "title",
        "footer": "Slack API",
        "id": 1,
        "footer_icon": "https://platform.slack-edge.com/img/default_application_icon.png",
        "ts": 123456789,
        "color": "FCD229"
      }
    ]
  },
  "warning": "missing_charset",
  "response_metadata": {
    "warnings": [
      "missing_charset"
    ]
  }
}
        """.trimIndent()

    private val engine: MockEngine =
        MockEngine {
            respond(
                content = responseBody,
                status = HttpStatusCode.OK,
                headers =
                    headersOf(
                        HttpHeaders.ContentType,
                        "application/json",
                    ),
            )
        }

    val client =
        HttpClient(engine) {
            install(ContentNegotiation) {
                json(json = Json { ignoreUnknownKeys = true })
            }
        }
}

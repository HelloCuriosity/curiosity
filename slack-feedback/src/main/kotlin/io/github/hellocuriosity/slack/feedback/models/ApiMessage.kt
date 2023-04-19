package io.github.hellocuriosity.slack.feedback.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiMessage(
    @SerialName("type")
    val type: String? = null,
    @SerialName("subtype")
    val subtype: String? = null,
    @SerialName("text")
    val text: String? = null,
    @SerialName("ts")
    val timestamp: String? = null,
    @SerialName("username")
    val username: String? = null,
    @SerialName("bot_id")
    val botId: String? = null,
    @SerialName("attachments")
    val attachments: List<ApiAttachment>? = null,
)

package io.github.hellocuriosity.slack.feedback.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    @SerialName("ok")
    val isSuccessful: Boolean? = null,
    @SerialName("channel")
    val channel: String? = null,
    @SerialName("ts")
    val timestamp: String? = null,
    @SerialName("message")
    val message: ApiMessage? = null,
)

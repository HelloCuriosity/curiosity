package io.github.hellocuriosity.slack.feedback.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiAttachment(
    @SerialName("fallback")
    val fallback: String? = null,
    @SerialName("color")
    val color: String? = null,
    @SerialName("pretext")
    val pretext: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("text")
    val text: String? = null,
    @SerialName("footer")
    val footer: String? = null,
    @SerialName("footer_icon")
    val icon: String? = null,
    @SerialName("ts")
    val createdOn: Long? = null,
)

package io.github.hellocuriosity.slack.feedback.models

import java.time.Instant

data class Feedback(
    val channel: String,
    val title: String? = null,
    val color: String? = null,
    val pretext: String? = null,
    val message: String? = null,
    val created: Instant? = null,
    val footer: String? = null,
    val icon: String = "https://platform.slack-edge.com/img/default_application_icon.png",
)

package io.github.hellocuriosity.slack.feedback.repository

import io.github.hellocuriosity.slack.feedback.models.Feedback
import io.github.hellocuriosity.slack.feedback.repository.SlackRepository.InstantTimeProvider
import java.time.Instant

class SlackRepository(
    private val cloud: SlackCloud,
    private val instantProvider: InstantTimeProvider = InstantTimeProvider { Instant.now() },
) {
    fun interface InstantTimeProvider {
        fun now(): Instant
    }

    suspend fun upload(value: Feedback): Feedback? = cloud.post(value.copy(created = instantProvider.now()))
}

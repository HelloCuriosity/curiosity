package io.github.hellocuriosity.slack.feedback.repository

import io.github.hellocuriosity.slack.feedback.SlackService
import io.github.hellocuriosity.slack.feedback.converters.Converter
import io.github.hellocuriosity.slack.feedback.converters.FeedbackConverter
import io.github.hellocuriosity.slack.feedback.models.ApiResponse
import io.github.hellocuriosity.slack.feedback.models.ApiSlackMessage
import io.github.hellocuriosity.slack.feedback.models.Feedback

class SlackCloud(
    private val service: SlackService,
    private val feedbackConverter: Converter<Feedback, ApiSlackMessage> = FeedbackConverter(),
) {

    suspend fun post(value: Feedback): Feedback? =
        service.post(feedbackConverter.from(value))
            .toValue(value)

    private fun <T : Any> ApiResponse.toValue(value: T): T? =
        this.let { responses ->
            responses.isSuccessful?.let { isSuccessful ->
                if (isSuccessful) value else null
            }
        }
}

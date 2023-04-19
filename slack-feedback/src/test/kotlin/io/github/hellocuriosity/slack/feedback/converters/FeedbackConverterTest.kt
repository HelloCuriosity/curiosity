package io.github.hellocuriosity.slack.feedback.converters

import io.github.hellocuriosity.forgery
import io.github.hellocuriosity.slack.feedback.models.ApiAttachment
import io.github.hellocuriosity.slack.feedback.models.ApiSlackMessage
import io.github.hellocuriosity.slack.feedback.models.Feedback
import org.junit.Assert.assertEquals
import org.junit.Test

class FeedbackConverterTest {

    private val converter = FeedbackConverter()

    @Test
    fun testFrom() {
        val feedback by forgery<Feedback>()
        val expected = ApiSlackMessage(
            channel = feedback.channel,
            attachments = listOf(
                ApiAttachment(
                    fallback = feedback.title,
                    color = feedback.color,
                    pretext = feedback.pretext,
                    title = feedback.title,
                    text = feedback.message,
                    footer = feedback.footer,
                    icon = feedback.icon,
                    createdOn = feedback.created?.toEpochMilli(),
                ),
            ),
        )
        assertEquals(expected, converter.from(feedback))
    }

    @Test(expected = NotImplementedError::class)
    fun testTo() {
        val value by forgery<ApiSlackMessage>()
        converter.to(value)
    }
}

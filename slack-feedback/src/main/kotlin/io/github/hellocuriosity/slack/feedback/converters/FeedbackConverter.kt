package io.github.hellocuriosity.slack.feedback.converters

import io.github.hellocuriosity.slack.feedback.models.ApiAttachment
import io.github.hellocuriosity.slack.feedback.models.ApiSlackMessage
import io.github.hellocuriosity.slack.feedback.models.Feedback

class FeedbackConverter : Converter<Feedback, ApiSlackMessage> {

    override fun from(value: Feedback): ApiSlackMessage = ApiSlackMessage(
        channel = value.channel,
        attachments = listOf(
            ApiAttachment(
                fallback = value.title,
                color = value.color,
                pretext = value.pretext,
                title = value.title,
                text = value.message,
                footer = value.footer,
                icon = value.icon,
                createdOn = value.created?.toEpochMilli(),
            ),
        ),
    )

    override fun to(value: ApiSlackMessage): Feedback =
        throw NotImplementedError("ApiSlackMessage is not meant to be converted back to Feedback")
}

package io.github.hellocuriosity.slack.feedback.repository

import io.github.hellocuriosity.forgery
import io.github.hellocuriosity.slack.feedback.SlackService
import io.github.hellocuriosity.slack.feedback.converters.FeedbackConverter
import io.github.hellocuriosity.slack.feedback.models.ApiResponse
import io.github.hellocuriosity.slack.feedback.models.Feedback
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class SlackCloudTest {
    private val service: SlackService = mockk()
    private val cloud = SlackCloud(service = service)
    private val feedback by forgery<Feedback>()
    private val apiResponse by forgery<ApiResponse>()
    private val apiSlackMessage = FeedbackConverter().from(feedback)

    @After
    fun teardown() {
        confirmVerified(service)
    }

    @Test
    fun testPostSuccess() = runBlocking {
        coEvery { service.post(any()) } returns apiResponse.copy(isSuccessful = true)

        assertEquals(feedback, cloud.post(feedback))

        coVerify { service.post(eq(apiSlackMessage)) }
    }

    @Test
    fun testPostFailure() = runBlocking {
        coEvery { service.post(any()) } returns apiResponse.copy(isSuccessful = false)

        assertNull(cloud.post(feedback))

        coVerify { service.post(eq(apiSlackMessage)) }
    }
}

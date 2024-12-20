package io.github.hellocuriosity.slack.feedback.repository

import io.github.hellocuriosity.forgery
import io.github.hellocuriosity.slack.feedback.models.Feedback
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Test

class SlackRepositoryTest {
    private val cloud: SlackCloud = mockk()
    private val instantProvider: SlackRepository.InstantTimeProvider = mockk()
    private val repository: SlackRepository = SlackRepository(cloud, instantProvider)

    @After
    fun teardown() {
        confirmVerified(cloud, instantProvider)
    }

    @Test
    fun testUpload() =
        runBlocking {
            val feedback by forgery<Feedback>()

            every { instantProvider.now() } returns feedback.created!!
            coEvery { cloud.post(any()) } returnsArgument 0

            assertEquals(feedback, repository.upload(feedback))

            coVerify { cloud.post(feedback) }
            verify { instantProvider.now() }
        }
}

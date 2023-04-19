package io.github.hellocuriosity.slack.feedback

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class SlackServiceTest : NetworkTest() {

    @Test
    fun testPost() = runBlocking {
        val service = SlackService(client = client)
        assertEquals(apiResponse, service.post(apiSlackMessage))
    }
}

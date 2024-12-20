package com.hello.curiosity.utils

import com.hello.curiosity.utils.ExternalIntentUtils.URL_GITHUB
import com.hello.curiosity.utils.ExternalIntentUtils.URL_PRIVACY_POLICY
import com.hello.curiosity.utils.ExternalIntentUtils.createGitHubIntent
import com.hello.curiosity.utils.ExternalIntentUtils.createPrivacyPolicyIntent
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [33])
class ExternalIntentUtilsTest {
    @Test
    fun `validate GitHub intent`() {
        val intent = createGitHubIntent()
        assertEquals(URL_GITHUB, intent.data.toString())
    }

    @Test
    fun `validate privacy policy intent`() {
        val intent = createPrivacyPolicyIntent()
        assertEquals(URL_PRIVACY_POLICY, intent.data.toString())
    }
}

package com.hello.curiosity.utils

import android.content.Intent
import android.net.Uri

object ExternalIntentUtils {
    const val URL_PRIVACY_POLICY = "https://sites.google.com/view/curiosity-privacy/privacy"
    const val URL_GITHUB = "https://github.com/HelloCuriosity/curiosity"

    fun createGitHubIntent(): Intent = urlIntent(URL_GITHUB)

    fun createPrivacyPolicyIntent(): Intent = urlIntent(URL_PRIVACY_POLICY)

    private fun urlIntent(url: String): Intent {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        return intent
    }
}

package com.hello.curiosity.ui.scenes

import android.content.Context
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.hello.curiosity.R
import com.hello.curiosity.compose.settings.ItemAction
import com.hello.curiosity.compose.settings.ItemDivider
import com.hello.curiosity.compose.settings.ItemInfo
import com.hello.curiosity.compose.settings.ItemSection
import com.hello.curiosity.ui.theme.AppTheme.lightCyan
import com.hello.curiosity.ui.theme.AppTheme.metallicSeaweed
import com.hello.curiosity.utils.ExternalIntentUtils.createGitHubIntent
import com.hello.curiosity.utils.ExternalIntentUtils.createPrivacyPolicyIntent

@Composable
fun SettingsScene() {
    val ctx: Context = LocalContext.current
    val tint = if (isSystemInDarkTheme()) Color.White else Color.Black
    val divider = if (isSystemInDarkTheme()) lightCyan else metallicSeaweed
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("settings-scene-test-tag")
    ) {
        item {
            ItemSection(text = R.string.settings_about)
        }
        item {
            ItemInfo(
                title = R.string.settings_info_title,
                content = R.string.settings_info_content,
            )
        }
        item {
            ItemDivider(color = divider)
        }
        item {
            ItemAction(
                title = R.string.settings_privacy_policy,
                icon = R.drawable.ic_arrow_forward,
                tint = tint,
                contentDescription = R.string.content_description_arrow_forward
            ) {
                ctx.startActivity(createPrivacyPolicyIntent())
            }
        }
        item {
            ItemDivider(color = divider)
        }
        item {
            ItemAction(
                title = R.string.settings_github,
                icon = R.drawable.ic_arrow_forward,
                tint = tint,
                contentDescription = R.string.content_description_arrow_forward
            ) {
                ctx.startActivity(createGitHubIntent())
            }
        }
        item {
            ItemDivider(color = divider)
        }
    }
}

@Preview
@Composable
fun SettingsScenePreview() {
    SettingsScene()
}

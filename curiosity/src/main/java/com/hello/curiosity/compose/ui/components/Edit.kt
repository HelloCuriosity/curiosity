package com.hello.curiosity.compose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hello.curiosity.compose.ui.components.text.LabelSmall

@Composable
fun InputTextField(
    label: String,
    labelColor: Color = Color.Unspecified,
    labelStyle: TextStyle = MaterialTheme.typography.h5.copy(fontSize = 18.sp),
    color: Color = Color.White,
    style: TextStyle = MaterialTheme.typography.h5.copy(
        fontSize = 18.sp,
        color = color,
    ),
    backgroundColor: Color = Color.Unspecified,
) = Card(
    modifier = Modifier
        .fillMaxWidth()
        .height(100.dp),
    backgroundColor = backgroundColor,
    shape = RoundedCornerShape(10.dp),
) {
    var text by remember { mutableStateOf("") }

    BasicTextField(
        value = text,
        onValueChange = { text = it },
//        label = {
//            LabelSmall(
//                text = label,
//                modifier = Modifier
//                    .padding(vertical = 18.dp, horizontal = 24.dp),
//                style = labelStyle,
//                color = labelColor,
//            )
//        }
    )
}

//    Box(
//    modifier = Modifier
//        .fillMaxWidth()
//        .background(
//            color = Color.Cyan,
//            shape = CircleShape,
//        )
//        .testTag("gradient-test-tag")
//
// ) {

// }

// @Composable
// fun InputTextField(
//    @StringRes label: Int,
//    labelColor: Color = Color.Unspecified,
//    labelStyle: TextStyle = MaterialTheme.typography.h5.copy(fontSize = 18.sp),
// ) = Box {
//    LabelSmall(
//        text = label,
//        color = labelColor,
//    )
// }

@Preview
@Composable
fun InputTextFieldPreview() {
    InputTextField(
        label = "Label"
    )
}

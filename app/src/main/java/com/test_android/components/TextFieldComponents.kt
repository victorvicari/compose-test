package com.gamexpert.test_android.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun PasswordTextField(
    value: String,
    modifier: Modifier = Modifier,
    onTextUpdate: (String) -> Unit
) {
    var typedText by remember { mutableStateOf("") }

    TextField(
        value = value,
        modifier = modifier,
        onValueChange = {
            typedText = it
            onTextUpdate(it)
        }
    )
}

@Composable
fun EmailTextField(
    value: String,
    isError: Boolean,
    modifier: Modifier = Modifier,
    onTextUpdate: (String) -> Unit
) {
    var typedText by remember { mutableStateOf("") }

    Column(modifier) {
        TextField(
            value = value,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {
                typedText = it
                onTextUpdate(it)
            }
        )
        if (isError) {
            Text(text = "email invalid", color = Color.Red)
        }
    }
}

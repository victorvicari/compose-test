package com.gamexpert.test_android.features.signin.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gamexpert.test_android.R
import com.gamexpert.test_android.components.EmailTextField
import com.gamexpert.test_android.components.PasswordTextField
import com.gamexpert.test_android.features.signin.model.LoginModel

@Composable
fun LoginView(
    uiModel: LoginModel,
    emailTyped: (String) -> Unit,
    passwordTyped: (String) -> Unit,
    loginTap: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        Arrangement.spacedBy(22.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        EmailTextField(
            value = uiModel.email,
            modifier = Modifier.fillMaxWidth(),
            isError = !uiModel.emailValid,
            onTextUpdate = emailTyped
        )
        PasswordTextField(
            value = uiModel.password,
            modifier = Modifier.fillMaxWidth(),
            onTextUpdate = passwordTyped
        )
        Button(
            onClick = loginTap,
            Modifier.fillMaxWidth(),
            enabled = uiModel.buttonEnabled,
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = Color.LightGray,
                disabledContentColor = Color.Black
            )
        ) { Text(text = stringResource(id = R.string.login_action), Modifier) }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun LoginView_Preview() {
    LoginView(
        uiModel = LoginModel(),
        emailTyped = {},
        passwordTyped = {},
        loginTap = {}
    )
}

package io.stupacki.kotestsample.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.stupacki.kotestsample.ui.theme.KotestSampleTheme
import io.stupacki.kotestsample.viewmodel.UserEmailValidationState
import io.stupacki.kotestsample.viewmodel.UserInputViewModel

@Composable
internal fun MainScreen(
    userInputViewModel: UserInputViewModel = UserInputViewModel(),
) {
    val userEmailState = userInputViewModel.userEmailState.collectAsStateWithLifecycle()

    Scaffold { paddingValues ->
        when (userEmailState.value) {
            is UserEmailValidationState.Submitted -> EmailSubmitted(
                modifier = Modifier.padding(paddingValues),
                startAgain = { userInputViewModel.updateUserEmail("") }
            )

            else -> EmailInput(
                userEmailState = userEmailState.value,
                updateUserEmail = userInputViewModel::updateUserEmail,
                submitUserEmail = userInputViewModel::submitUserEmail,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}

@Composable
private fun EmailInput(
    userEmailState: UserEmailValidationState,
    updateUserEmail: (String) -> Unit,
    submitUserEmail: () -> Unit,
    modifier: Modifier = Modifier
) {
    val statusText = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Text(text = "Enter your email:")

        TextField(
            value = statusText.value,
            onValueChange = {
                statusText.value = it
                updateUserEmail(it)
            },
            modifier = Modifier.fillMaxWidth(),
        )

        Text(text = getStatusText(userEmailState))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            onClick = submitUserEmail,
        ) {
            Text(text = "Submit")
        }
    }
}

@Composable
private fun EmailSubmitted(modifier: Modifier, startAgain: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Text(text = "Thanks for submitting your email!")

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            onClick = startAgain,
        ) {
            Text(text = "Submit another email")
        }
    }
}

private fun getStatusText(userEmailState: UserEmailValidationState): String = when (userEmailState) {
    is UserEmailValidationState.Valid -> "Email is valid"
    is UserEmailValidationState.Invalid -> "Email is invalid"
    is UserEmailValidationState.Empty -> "Email is empty"
    is UserEmailValidationState.Submitted -> "Email is submitted"
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    KotestSampleTheme {
        MainScreen()
    }
}

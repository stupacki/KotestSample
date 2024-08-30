package io.stupacki.kotestsample.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.Result.Companion.failure
import kotlin.Result.Companion.success
import kotlin.coroutines.CoroutineContext

internal class ValidateUserEmailUseCase(private val context: CoroutineContext = Dispatchers.IO) {

    suspend operator fun invoke(email: String): Result<String> =
        withContext(context) {
            if (EMAIL_REGEX.matches(email)) {
                success(email)
            } else {
                failure(IllegalArgumentException("Invalid email address"))
            }
        }

    private companion object {

        // K-9 Email Regex
        val EMAIL_REGEX: Regex =
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+".toRegex()
    }
}
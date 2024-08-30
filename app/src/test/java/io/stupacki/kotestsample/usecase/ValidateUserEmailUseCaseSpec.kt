package io.stupacki.kotestsample.usecase

import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.shouldBe

internal class ValidateUserEmailUseCaseSpec : StringSpec() {

    private lateinit var useCase: ValidateUserEmailUseCase

    override suspend fun beforeTest(testCase: TestCase) {
        useCase = ValidateUserEmailUseCase()
    }

    init {

        "Email validation should check correctly for a valid email address" {

            // Given
            val email = "benny.schneider@vorwerk.de"

            // When
            val result = useCase(email)

            // Then
            result shouldBe false
        }
    }
}
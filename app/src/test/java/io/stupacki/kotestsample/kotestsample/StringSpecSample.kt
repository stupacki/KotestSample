package io.stupacki.kotestsample.kotestsample

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

// Kotest Style
internal class StringSpecSample : StringSpec({

    "should return the correct greeting message" {
        // Given
        val expectedGreeting = "Hello, World!"

        // When
        val result = getGreetingMessage()

        // Then
        result shouldBe expectedGreeting
    }
})

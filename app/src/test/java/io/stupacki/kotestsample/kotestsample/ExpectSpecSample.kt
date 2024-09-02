package io.stupacki.kotestsample.kotestsample

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

// Kotest Style
internal class ExpectSpecSample : ExpectSpec({

    context("getGreetingMessage function") {
        expect("should return the correct greeting message") {
            // Given
            val expectedGreeting = "Hello, World!"

            // When
            val result = getGreetingMessage()

            // Then
            result shouldBe expectedGreeting
        }
    }
})

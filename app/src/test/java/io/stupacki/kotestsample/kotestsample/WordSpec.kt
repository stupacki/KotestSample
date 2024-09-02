package io.stupacki.kotestsample.kotestsample

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

// Scala Test Style
internal class WordSpecSample : WordSpec({

    "getGreetingMessage function" should {

        "return the correct greeting message" {

            // Given
            val expectedGreeting = "Hello, World!"

            // When
            val result = getGreetingMessage()

            // Then
            result shouldBe expectedGreeting
        }
    }
})

package io.stupacki.kotestsample.kotestsample

import io.kotest.core.spec.style.FeatureSpec
import io.kotest.matchers.shouldBe

// Cucumber Style
internal class FeatureSpecSample : FeatureSpec({

    feature("getGreetingMessage function") {

        scenario("should return the correct greeting message") {

            // Given
            val expectedGreeting = "Hello, World!"

            // When
            val result = getGreetingMessage()

            // Then
            result shouldBe expectedGreeting
        }
    }
})

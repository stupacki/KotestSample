package io.stupacki.kotestsample.kotestsample

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

// Java Script / RSpec Style
internal class DescribeSpecSample : DescribeSpec({

    describe("getGreetingMessage function") {

        it("should return the correct greeting message") {
            // Given
            val expectedGreeting = "Hello, World!"

            // When
            val result = getGreetingMessage()

            // Then
            result shouldBe expectedGreeting
        }
    }
})

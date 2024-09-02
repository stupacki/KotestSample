package io.stupacki.kotestsample.kotestsample

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

// Scala Test Style
internal class FunSpecSample : FunSpec() {

    init {

        test("should return the correct greeting message") {
            // Given
            val greeting = "Hello, World!"

            // When
            val result = getGreetingMessage()

            // Then
            result shouldBe greeting
        }
    }
}
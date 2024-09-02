package io.stupacki.kotestsample.kotestsample

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

// JUnit Style
internal class AnnotationSpecSample : AnnotationSpec() {

    @Test
    fun `getGreetingMessage should return the correct greeting message`() {
        // Given
        val expectedGreeting = "Hello, World!"

        // When
        val result = getGreetingMessage()

        // Then
        result shouldBe expectedGreeting
    }
}

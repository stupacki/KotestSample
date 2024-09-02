package io.stupacki.kotestsample.kotestsample

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

// BDD Style
internal class BehaviorSpecSample : BehaviorSpec({

    given("a greeting message function") {

        `when`("it is called") {

            then("it should return the correct greeting message") {

                // Given
                val expectedGreeting = "Hello, World!"

                // When
                val result = getGreetingMessage()

                // Then
                result shouldBe expectedGreeting
            }
        }
    }
})

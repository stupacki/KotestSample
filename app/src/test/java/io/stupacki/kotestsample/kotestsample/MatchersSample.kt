package io.stupacki.kotestsample.kotestsample

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.ints.shouldBeNegative
import io.kotest.matchers.ints.shouldBePositive
import io.kotest.matchers.ints.shouldBeZero
import io.kotest.matchers.longs.shouldBeNegative
import io.kotest.matchers.longs.shouldBePositive
import io.kotest.matchers.longs.shouldBeZero
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldContain
import io.kotest.matchers.string.shouldEndWith
import io.kotest.matchers.string.shouldHaveLength
import io.kotest.matchers.string.shouldNotContain
import io.kotest.matchers.string.shouldStartWith

// Core Matchers - More are available here https://kotest.io/docs/assertions/core-matchers.html
internal class MatchersSample : StringSpec({

    "should demonstrate various Kotest matchers" {
        // Equality matchers
        1 + 1 shouldBe 2
        "Hello" shouldBe "Hello"
        "Hello" shouldNotBe "World"

        // Null matchers
        val nullableString: String? = null
        nullableString.shouldBeNull()
        val nonNullableString: String? = "Kotlin"
        nonNullableString.shouldNotBeNull()

        // String matchers
        "Kotlin" shouldHaveLength 6
        "Kotlin" shouldStartWith "Kot"
        "Kotlin" shouldEndWith "lin"
        "Kotlin" shouldContain "otl"
        "Kotlin" shouldNotContain "Java"

        // Collection matchers
        val list = listOf(1, 2, 3)
        list shouldHaveSize 3
        list shouldContain 2
        list shouldNotContain 4
        list.shouldContainExactly(1, 2, 3)
        list.shouldContainInOrder(1, 2, 3)

        // Comparable matchers
        5 shouldBeGreaterThan 3
        5 shouldBeLessThan 10
        5 shouldBeGreaterThanOrEqual 5
        5 shouldBeLessThanOrEqual 5

        // Int matchers
        10.shouldBePositive()
        (-10).shouldBeNegative()
        0.shouldBeZero()

        // Long matchers
        10L.shouldBePositive()
        (-10L).shouldBeNegative()
        0L.shouldBeZero()
    }

    "should throw an IllegalArgumentException" {
        // When & Then
        shouldThrow<IllegalArgumentException> {
            throwException()
        }
    }
})

// Sample function to be tested
fun throwException() {
    throw IllegalArgumentException("This is an illegal argument exception")
}

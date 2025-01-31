package hu.obuda.devops.fibonaccirestapi.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FibonacciServiceTest {

    private val underTest = FibonacciService()

    @ParameterizedTest
    @CsvSource(
        "0,0",     // alapeset: 0 vagy negatív szám
        "1,1",     // első szám
        "2,1",     // második szám
        "3,2",     // harmadik szám
        "4,3",     // negyedik szám
        "5,5",     // ötödik szám
        "6,8",     // hatodik szám
        "7,13",    // hetedik szám
        "8,21",    // nyolcadik szám
        "9,34",    // kilencedik szám
        "10,55"    // tizedik szám
    )
    fun shouldReturnCorrectFibonacciNumber(input: Int, expected: Int) {
        val result = underTest.fibonacci(input)
        assertEquals(expected, result)
    }

    @Test
    fun shouldReturn0ForNegativeInput() {
        // given
        val input = -1
        // when
        val result = underTest.fibonacci(input)
        // then
        assertEquals(0, result)
    }

    @Test
    fun shouldReturnCorrectValueForLargeNumber() {
        // given
        val input = 20
        // when
        val result = underTest.fibonacci(input)
        // then
        assertEquals(6765, result)
    }

    @Test
    fun shouldHandle46AsMaxInput() {
        // given
        val input = 46
        // when
        val result = underTest.fibonacci(input)
        // then
        assertEquals(1836311903, result)
    }

    @Test
    fun shouldReturnCorrectSequenceForFirst5Numbers() {
        // given
        val expected = listOf(1, 1, 2, 3, 5)
        // when
        val result = (1..5).map { underTest.fibonacci(it) }
        // then
        assertEquals(expected, result)
    }

    @Test
    fun shouldReturn0ForZero() {
        // given
        val input = 0
        // when
        val result = underTest.fibonacci(input)
        // then
        assertEquals(0, result)
    }

    @Test
    fun shouldReturn1ForFirstNumber() {
        // given
        val input = 1
        // when
        val result = underTest.fibonacci(input)
        // then
        assertEquals(1, result)
    }
}
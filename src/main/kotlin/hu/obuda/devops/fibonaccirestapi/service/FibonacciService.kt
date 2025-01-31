package hu.obuda.devops.fibonaccirestapi.service

import org.springframework.stereotype.Service

@Service
class FibonacciService {
    fun fibonacci(n: Int): Int = when {
        n <= 0 -> 0
        n == 1 -> 1
        n == 2 -> 1
        else -> (3..n).fold(Pair(1, 1)) { (prev, curr), _ ->
            Pair(curr, prev + curr)
        }.second
    }
}
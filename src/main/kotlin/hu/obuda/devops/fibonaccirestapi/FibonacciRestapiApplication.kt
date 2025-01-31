package hu.obuda.devops.fibonaccirestapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FibonacciRestapiApplication

fun main(args: Array<String>) {
	runApplication<FibonacciRestapiApplication>(*args)
}

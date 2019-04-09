package com.github.isucon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IsuconApplication

fun main(args: Array<String>) {
	runApplication<IsuconApplication>(*args)
}

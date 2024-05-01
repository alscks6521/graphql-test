package com.daelim.springtest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.graphql.data.GraphQlRepository


@SpringBootApplication
@GraphQlRepository
class SpringTestApplication

fun main(args: Array<String>) {
	runApplication<SpringTestApplication>(*args)
}

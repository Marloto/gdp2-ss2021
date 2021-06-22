package de.thi.informatik.gdp2.simplewebserverkotlin

import de.thi.informatik.gdp2.simplewebserverkotlin.model.Message
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Server

fun main(args: Array<String>) {
	runApplication<Server>(*args)
}

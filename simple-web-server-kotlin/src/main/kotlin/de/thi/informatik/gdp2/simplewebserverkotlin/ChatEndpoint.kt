package de.thi.informatik.gdp2.simplewebserverkotlin

import de.thi.informatik.gdp2.simplewebserverkotlin.model.Rooms
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors

@RestController
class ChatEndpoint @Autowired constructor(private val rooms : Rooms) {
    @GetMapping("/hello")
    fun doSomething(): String = "Hello, World"

    @GetMapping("/rooms")
    fun listRooms(): Array<String> = rooms.getRooms().toTypedArray()

    @GetMapping("/room/{name}/{since}")
    fun listMessages(@PathVariable name: String, @PathVariable since: Long): Array<String> =
            rooms.getRoom(name)!!.getMessagesSince(since).stream().map { msg -> msg.toString() }
                    .collect(Collectors.toList()).toTypedArray()

    @PostMapping("/room/{name}/{user}")
    fun addMessage(@PathVariable name: String, @PathVariable user: String, @RequestBody message: String) =
            rooms.getRoom(name)!!.addMessage(user, message)
}
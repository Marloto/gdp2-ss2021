package de.thi.informatik.gdp2.simplewebserverkotlin.model

import java.util.stream.Collector
import java.util.stream.Collectors

class Room {
    val name: String
        get() = field
    private val list: MutableList<Message>

    constructor(name: String) {
        this.name = name
        this.list = ArrayList<Message>()
    }

    fun addMessage(user: String, message: String) =
        this.list.add(Message(user, message))

    fun getMessagesSince(time: Long): List<Message> =
        this.list.stream().filter { msg -> msg.time >= time }.collect(Collectors.toList())
}
package de.thi.informatik.gdp2.simplewebserverkotlin.model

import org.springframework.stereotype.Component

@Component
class Rooms() {
    private val map: MutableMap<String, Room> = HashMap<String, Room>()

    init {
        addRoom("Stuff")
        addRoom("Funny")
        addRoom("Awesome")
    }

    final fun addRoom(name: String) = map.put(name, Room(name))

    fun getRooms(): Set<String> = map.keys

    fun getRoom(name: String): Room? = map[name]
}
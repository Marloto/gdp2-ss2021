package de.thi.informatik.gdp2.simplewebserverkotlin.model

import java.text.SimpleDateFormat
import java.util.Date

class Message {
    val time: Long
        get() = field
    val user: String
        get() = field
    val message: String
        get() = field

    constructor(user: String, message: String) {
        this.time = System.currentTimeMillis()
        this.user = user
        this.message = message
    }

    private fun toFormattedTime(): String =
        SimpleDateFormat("hh:mm:ss").format(Date(time))

    override fun toString(): String =
        "${user} (${toFormattedTime()}: ${message}"
}
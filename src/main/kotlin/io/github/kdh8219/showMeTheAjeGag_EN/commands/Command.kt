package io.github.kdh8219.showMeTheAjeGag_EN.commands

import io.github.kdh8219.showMeTheAjeGag_EN.sendRandomMessage
import com.lambda.client.command.ClientCommand


object Command : ClientCommand(
    name = "ajen",
    description = "Show a random aje gag"
) {
    init {
        execute("Show a random aje gag") {
            sendRandomMessage()
        }
    }
}


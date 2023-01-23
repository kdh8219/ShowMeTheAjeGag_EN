package io.github.kdh8219.showMeTheAjeGag_EN

import com.google.gson.Gson
import com.lambda.client.plugin.api.Plugin
import io.github.kdh8219.showMeTheAjeGag_EN.commands.Command
import io.github.kdh8219.showMeTheAjeGag_EN.modules.Module
internal object Main : Plugin() {
    val gson = Gson()
    const val prefix = "[AJE]"
    var quizzes: Array<AjeGag>? = null
    override fun onLoad() {
        quizzes = gson.fromJson(
            readStringFromURL("https://raw.githubusercontent.com/mshwery/dad-jokes-api/master/jokes.json").toString(),
            Array<AjeGag>::class.java)
        commands.add(Command)
        modules.add(Module)
    }
}
package io.github.kdh8219.showMeTheAjeGag_EN

import com.lambda.client.util.text.MessageSendHelper
import io.github.kdh8219.showMeTheAjeGag_EN.modules.Module
import java.io.IOException
import java.net.URL
import java.nio.charset.StandardCharsets
import java.util.*


class AjeGag(val joke:String)

@Throws(IOException::class)
fun readStringFromURL(requestURL: String?): String? {
    Scanner(
        URL(requestURL).openStream(),
        StandardCharsets.UTF_8.toString()
    ).use { scanner ->
        scanner.useDelimiter("\\A")
        return if(scanner.hasNext()){scanner.next()}else{null}
    }
}
fun sendRandomMessage(){
    val quizzes = Main.quizzes
    val prefix = Main.prefix
    val color = colorToColorCode(Module.color)
    if(quizzes != null){
        val quiz = chooseRandomOne(quizzes)
        MessageSendHelper.sendChatMessage("$prefix ${color}${quiz.joke}")
    } else {
        MessageSendHelper.sendErrorMessage("$prefix quizzes is null: something wrong")
    }
}

fun chooseRandomOne(i:Array<AjeGag>):AjeGag{
    val rnd: Int = Random().nextInt(i.size)
    return i[rnd]
}
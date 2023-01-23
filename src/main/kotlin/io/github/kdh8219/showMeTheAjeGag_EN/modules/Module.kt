package io.github.kdh8219.showMeTheAjeGag_EN.modules

import com.lambda.client.module.Category
import com.lambda.client.plugin.api.PluginModule
import com.lambda.client.util.TickTimer
import com.lambda.client.util.TimeUnit
import com.lambda.client.util.threads.safeListener
import io.github.kdh8219.showMeTheAjeGag_EN.Main
import io.github.kdh8219.showMeTheAjeGag_EN.Colors
import io.github.kdh8219.showMeTheAjeGag_EN.sendRandomMessage
import net.minecraftforge.fml.common.gameevent.TickEvent

internal object Module : PluginModule(
    name = "ShowMeTheAjeGag_EN",
    category = Category.MISC,
    description = "Show a random aje gag",
    pluginMain = Main
) {
    val color by setting("Color", Colors.Gray)
    private val autoUseDelay by setting("Auto Use Delay(s)",10, 1..600, 1)

    private val timer = TickTimer(TimeUnit.SECONDS)

    init {
        safeListener<TickEvent.ClientTickEvent> {
            if (it.phase != TickEvent.Phase.START || !timer.tick(autoUseDelay.toLong())){return@safeListener}
            sendRandomMessage()
        }
    }
}
package PiBeat

import PiBeat.dto.EveryThing
import oshi.SystemInfo
import java.time.Instant
import java.util.*
import kotlin.concurrent.scheduleAtFixedRate

object Snapshooter : Runnable {
    var lastRecord = EveryThing(SystemInfo())
        private set

    var lastTime = Instant.now()!!
        private set

    private var timer = Timer()

    override fun run() {
        timer.scheduleAtFixedRate(0, 5000) {
            lastRecord = EveryThing(SystemInfo())
            lastTime = Instant.now()
        }
    }

    fun stop() {
        timer.cancel()
    }
}
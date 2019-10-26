package PiBeat

import PiBeat.dto.EveryThing
import org.slf4j.LoggerFactory
import oshi.SystemInfo
import java.time.Instant
import java.util.Timer
import kotlin.concurrent.scheduleAtFixedRate

object Snapshot : Runnable {
    val logger = LoggerFactory.getLogger(javaClass)
    var lastRecord = EveryThing(SystemInfo())
        private set

    var lastTime = Instant.now()!!
        private set

    private var timer = Timer()

    override fun run() {
        logger.info("Will capture snapshot at rate of {} ms", Config.snapshotInterval)
        timer.scheduleAtFixedRate(0, Config.snapshotInterval) {
            lastRecord = EveryThing(SystemInfo())
            lastTime = Instant.now()
        }
    }

    fun stop() {
        timer.cancel()
    }
}
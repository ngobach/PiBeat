package PiBeat

import PiBeat.dto.EveryThing
import org.slf4j.LoggerFactory
import oshi.SystemInfo
import java.time.Instant

object Snapshot : Runnable {
    private val logger = LoggerFactory.getLogger(javaClass)
    var current: EveryThing? = null
        private set
    var timestamp: Long = 0
        private set

    override fun run() {
        val si = SystemInfo()
        kotlin.concurrent.fixedRateTimer(period = Config.snapshotInterval) {
            current = EveryThing(si)
            timestamp = Instant.now().epochSecond
        }
    }
}
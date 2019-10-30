package PiBeat

import PiBeat.dto.EveryThing
import oshi.SystemInfo
import java.time.Instant

object Snapshot : Runnable {
    var current: EveryThing? = null
        private set
    var timestamp: Long = 0
        private set
    private val si = SystemInfo()

    private fun collect() {
        current = EveryThing(si)
        timestamp = Instant.now().epochSecond
    }

    override fun run() {
        kotlin.concurrent.fixedRateTimer(period = Config.snapshotInterval) {
            collect()
        }
    }
}
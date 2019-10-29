package PiBeat

import org.slf4j.LoggerFactory
import oshi.SystemInfo
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

object Snapshot : Runnable {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun run() {
        logger.info("Will capture snapshot at rate of {} ms", Config.snapshotInterval)
        val origin = Observable.interval(Config.snapshotInterval, TimeUnit.MILLISECONDS)
                .map { SystemInfo() as SystemInfo? }
        Observable.combineLatest(arrayOf(
                origin,
                origin.delay(5, TimeUnit.SECONDS).startWith(null as SystemInfo?),
                origin.delay(15, TimeUnit.SECONDS).startWith(null as SystemInfo?)
        )) {
            (x, y) ->
                println("$x $y")
        }.debounce(100, TimeUnit.MILLISECONDS).subscribe {

        }
    }
}
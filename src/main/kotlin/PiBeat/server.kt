package PiBeat

import PiBeat.dto.EveryThing
import PiBeat.extensions.json
import fi.iki.elonen.NanoHTTPD
import org.slf4j.LoggerFactory
import oshi.SystemInfo

class WebServer(port: Int) : NanoHTTPD(port) {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    override fun serve(session: IHTTPSession?): Response {
        logger.info("Processing request")
        if (session == null) {
            return newFixedLengthResponse("WELL WELL. WHO ARE YOU?")
        }
        return json(EveryThing(SystemInfo()))
    }

    override fun start() {
        this.start(NanoHTTPD.SOCKET_READ_TIMEOUT, false)
    }
}

fun startServer() {
}
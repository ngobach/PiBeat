package PiBeat

import PiBeat.handler.ApiHandler
import fi.iki.elonen.NanoHTTPD
import org.slf4j.LoggerFactory
import PiBeat.handler.ResourceHandler

interface Handler {
    operator fun invoke(session: NanoHTTPD.IHTTPSession): NanoHTTPD.Response?
}

class WebServer(port: Int) : NanoHTTPD(port) {
    private val logger = LoggerFactory.getLogger(this.javaClass)
    private val reqHandlers: List<Handler> = listOf(ResourceHandler(), ApiHandler())

    override fun serve(session: IHTTPSession?): Response {
        logger.info("Processing request")

        if (session == null) {
            return newFixedLengthResponse("WELL WELL. WHO ARE YOU?")
        }

        for (handler in reqHandlers) {
            handler(session)?.let {
                return it
            }
        }

        return newFixedLengthResponse(Response.Status.NOT_FOUND, "text/plain", "Content Not Found")
    }

    override fun start() {
        this.start(NanoHTTPD.SOCKET_READ_TIMEOUT, false)
    }
}

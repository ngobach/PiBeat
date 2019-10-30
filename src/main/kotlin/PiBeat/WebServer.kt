package PiBeat

import PiBeat.handler.ApiHandler
import fi.iki.elonen.NanoHTTPD
import org.slf4j.LoggerFactory
import PiBeat.handler.ResourceHandler

interface Handler {
    operator fun invoke(session: NanoHTTPD.IHTTPSession): NanoHTTPD.Response?
}

class WebServer(port: Int) : NanoHTTPD(port) {
    private val reqHandlers: List<Handler> = listOf(ApiHandler(), ResourceHandler())

    override fun serve(session: IHTTPSession): Response {
        for (handler in reqHandlers) {
            handler(session)?.let {
                return it
            }
        }

        return newFixedLengthResponse(Response.Status.NOT_FOUND, "text/plain", "Content Not Found")
    }

    override fun start() {
        this.start(SOCKET_READ_TIMEOUT, false)
    }
}

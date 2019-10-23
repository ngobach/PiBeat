package PiBeat

import PiBeat.dto.Greet
import com.fasterxml.jackson.databind.ObjectMapper
import fi.iki.elonen.NanoHTTPD
import org.slf4j.LoggerFactory

class WebServer(port: Int) : NanoHTTPD(port) {
    private val logger = LoggerFactory.getLogger(this.javaClass)
    override fun serve(session: IHTTPSession?): Response {
        logger.info("Processing the request")
        if (session == null) {
            return newFixedLengthResponse("WELL WELL")
        }
        val msg = Greet("""
            Hello ${session.headers.get("user-agent")?.split(" ")?.firstOrNull() ?: ""}
            Your IP address is ${session.remoteIpAddress}
        """.trimIndent())
        val resp = newFixedLengthResponse(ObjectMapper().writer().writeValueAsString(msg))
        resp.mimeType = "application/json"
        return resp
    }

    override fun start() {
        this.start(NanoHTTPD.SOCKET_READ_TIMEOUT, false)
    }
}

fun startServer() {
}
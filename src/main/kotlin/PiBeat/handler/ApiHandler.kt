package PiBeat.handler

import PiBeat.Handler
import PiBeat.dto.EveryThing
import fi.iki.elonen.NanoHTTPD
import org.slf4j.LoggerFactory
import oshi.SystemInfo

class ApiHandler : Handler {
    val logger = LoggerFactory.getLogger(javaClass)
    override fun invoke(session: NanoHTTPD.IHTTPSession): NanoHTTPD.Response? {
        val uri = session.uri
        if (uri.contentEquals("/api/get")) {
            return jsonResponse(EveryThing(SystemInfo()))
        }
        return null
    }
}
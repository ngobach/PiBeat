package PiBeat.handler

import PiBeat.Handler
import PiBeat.Snapshooter
import PiBeat.dto.EveryThing
import fi.iki.elonen.NanoHTTPD
import java.time.Instant

private data class Payload(val data: EveryThing, val ts: Long)

class ApiHandler : Handler {
    override fun invoke(session: NanoHTTPD.IHTTPSession): NanoHTTPD.Response? {
        val uri = session.uri!!
        if (uri.contentEquals("/api/get")) {
            return jsonResponse(Payload(Snapshooter.lastRecord, Snapshooter.lastTime.toEpochMilli()))
        }
        return null
    }
}
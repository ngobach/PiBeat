package PiBeat.handler

import PiBeat.Handler
import PiBeat.Snapshot
import PiBeat.dto.EveryThing
import fi.iki.elonen.NanoHTTPD

private data class Payload(val data: EveryThing, val ts: Long)

class ApiHandler : Handler {
    override fun invoke(session: NanoHTTPD.IHTTPSession): NanoHTTPD.Response? {
        val uri = session.uri!!
        if (uri.contentEquals("/api/get")) {
            return jsonResponse(Payload(Snapshot.lastRecord, Snapshot.lastTime.toEpochMilli()))
        }
        return null
    }
}